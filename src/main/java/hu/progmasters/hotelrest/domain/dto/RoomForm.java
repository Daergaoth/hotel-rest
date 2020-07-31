package hu.progmasters.hotelrest.domain.dto;

import hu.progmasters.hotelrest.domain.RoomSize;

public class RoomForm {

    private RoomSize roomSize;
    private Integer number;
    private Double price;
    private Long hotelID;

    public RoomForm(RoomSize roomSize, Integer number, Double price, Long hotelID) {
        this.roomSize = roomSize;
        this.number = number;
        this.price = price;
        this.hotelID = hotelID;
    }

    public RoomForm() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getHotelID() {
        return hotelID;
    }

    public void setHotelID(Long hotelID) {
        this.hotelID = hotelID;
    }
}
