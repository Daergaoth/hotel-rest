package hu.progmasters.hotelrest.controller;

import hu.progmasters.hotelrest.domain.dto.HotelListItem;
import hu.progmasters.hotelrest.service.HotelSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private HotelSerice hotelSerice;

    @Autowired
    public HotelController(HotelSerice hotelSerice) {
        this.hotelSerice = hotelSerice;
    }

    @GetMapping
    public ResponseEntity<List<HotelListItem>> listAll(){
        List<HotelListItem> hotelListItems = hotelSerice.findAll();
        try{
            return new ResponseEntity<>(hotelListItems, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>((HttpStatus.BAD_GATEWAY));
        }
    }
}
