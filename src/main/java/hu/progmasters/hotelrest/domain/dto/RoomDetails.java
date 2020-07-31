package hu.progmasters.hotelrest.domain.dto;

import hu.progmasters.hotelrest.domain.Hotel;
import hu.progmasters.hotelrest.domain.Room;
import hu.progmasters.hotelrest.domain.RoomSize;

public class RoomDetails {

    private Long id;

    private Hotel hotel;

    private RoomSize roomSize;

    private Integer number;

    private Boolean isReserved = false;

    private Double price;


    public RoomDetails(Room room) {
        this.id = room.getId();
        //this.hotel = room.getHotel();
        this.number = room.getNumber();
        this.price = room.getPrice();
        this.roomSize = room.getRoomSize();
        this.isReserved = room.getReserved();
    }

    public RoomDetails() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public RoomSize getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(RoomSize roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
