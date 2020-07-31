package hu.progmasters.hotelrest.service;

import hu.progmasters.hotelrest.domain.Hotel;
import hu.progmasters.hotelrest.domain.dto.HotelDetails;
import hu.progmasters.hotelrest.domain.dto.HotelForm;
import hu.progmasters.hotelrest.domain.dto.HotelListItem;
import hu.progmasters.hotelrest.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelListItem> findAll() {
//        List<Hotel> all = hotelRepository.findAll();
//        List<HotelListItem> hotelListItems = new ArrayList<>();
//        for (Hotel hotel : all) {
//            HotelListItem hotelListItem = new HotelListItem(hotel);
//            hotelListItems.add(hotelListItem);
//        }
//        return hotelListItems;

        return hotelRepository.findAll()
                .parallelStream().
                //több szállasítja a streamet nagy adatmennyiség feldolgoásánál előny DE so energiát fogyaszt
                // és nem tartja meg a lista sorrendjét sem!!!
                        map(HotelListItem::new).
                        collect(Collectors.toList());
    }

    public void create(HotelForm hotelForm) {
        Hotel hotel = new Hotel(hotelForm);
        hotelRepository.save(hotel);
    }

    public Hotel findByID(Long hotelID) {
        return hotelRepository
                .findById(hotelID)
                .orElseThrow(() -> new EntityNotFoundException("Cannot find hotel with such ID: " + hotelID));
    }

    public HotelDetails findDetailsById(Long hotelID) {
        Hotel hotel = findByID(hotelID);
        HotelDetails hotelDetails = new HotelDetails(hotel);

        return hotelDetails;
    }
}
