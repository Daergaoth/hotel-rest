package hu.progmasters.hotelrest.domain.dto;

import hu.progmasters.hotelrest.domain.Hotel;
import hu.progmasters.hotelrest.domain.HotelRating;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelDetails {

    private Long id;

    private AddressDetails addressDetails;

    private String name;

    private HotelRating stars;

    private String description;

    private List<RoomDetails> roomDetails = new ArrayList<>();


    public HotelDetails(Hotel hotel) {
        this.stars = hotel.getStars();
        this.id = hotel.getId();
        this.description = hotel.getDescription();
        this.addressDetails = new AddressDetails(hotel.getAddress());
        this.name = hotel.getName();
        this.roomDetails = hotel.getRoomList()
                .stream()
                .map(room -> new RoomDetails(room))
                .collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HotelRating getStars() {
        return stars;
    }

    public void setStars(HotelRating stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoomDetails> getRoomDetails() {
        return roomDetails;
    }

    public void setRoomDetails(List<RoomDetails> roomDetails) {
        this.roomDetails = roomDetails;
    }
}
