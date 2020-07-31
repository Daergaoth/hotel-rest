package hu.progmasters.hotelrest.domain;

import hu.progmasters.hotelrest.domain.dto.RoomForm;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Room")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Hotel_ID")
    @NotNull
    private Hotel hotel;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "Room_Size")
    @NotNull
    private RoomSize roomSize;

    @Column(name = "Number")
    @Min(0)
    @Max(10_000)
    private Integer number;

    @Column(name = "is_reserved")
    private Boolean isReserved = false;

    @Column(name = "Price")
    @Min(0)
    private Double price;

    public Room(@NotNull Hotel hotel, @NotNull RoomSize roomSize, @Min(0) @Max(10_000) Integer number, Boolean isReserved, @Min(0) Double price) {
        this.hotel = hotel;
        this.roomSize = roomSize;
        this.number = number;
        this.isReserved = isReserved;
        this.price = price;
    }

    public Room() {
    }

    public Room(Hotel hotel, RoomForm roomForm) {
        this.hotel = hotel;
        this.number = roomForm.getNumber();
        this.price = roomForm.getPrice();
        this.roomSize = roomForm.getRoomSize();
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
