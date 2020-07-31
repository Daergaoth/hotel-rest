package hu.progmasters.hotelrest.service;

import hu.progmasters.hotelrest.domain.Hotel;
import hu.progmasters.hotelrest.domain.Room;
import hu.progmasters.hotelrest.domain.dto.RoomForm;
import hu.progmasters.hotelrest.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoomService {

    private HotelService hotelService;
    private RoomRepository roomRepository;

    @Autowired
    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }

    public void create(RoomForm roomForm) {
        Long hotelID = roomForm.getHotelID();
        Hotel hotel = hotelService.findByID(hotelID);
        Room room = new Room(hotel, roomForm);
        roomRepository.save(room);
    }
}
