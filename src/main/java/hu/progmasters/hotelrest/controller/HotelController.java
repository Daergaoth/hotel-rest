package hu.progmasters.hotelrest.controller;

import hu.progmasters.hotelrest.domain.dto.HotelDetails;
import hu.progmasters.hotelrest.domain.dto.HotelForm;
import hu.progmasters.hotelrest.domain.dto.HotelListItem;
import hu.progmasters.hotelrest.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelListItem>> listAll() {
        List<HotelListItem> hotelListItems = hotelService.findAll();
        try {
            return new ResponseEntity<>(hotelListItems, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((HttpStatus.BAD_GATEWAY));
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody HotelForm hotelForm) {
        hotelService.create(hotelForm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{hotelID}")
    public ResponseEntity<HotelDetails> findHotel(@PathVariable Long hotelID) {
        HotelDetails hotelDetails = hotelService.findDetailsById(hotelID);
        return new ResponseEntity<>(hotelDetails, HttpStatus.OK);
    }
}
