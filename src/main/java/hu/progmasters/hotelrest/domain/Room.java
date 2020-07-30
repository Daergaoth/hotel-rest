package hu.progmasters.hotelrest.domain;

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
}
