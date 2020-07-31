package hu.progmasters.hotelrest.domain.dto;

import hu.progmasters.hotelrest.domain.HotelRating;

public class HotelForm {

    private String name;

    private String description;

    private AddressForm addressForm;

    private HotelRating stars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AddressForm getAddressForm() {
        return addressForm;
    }

    public void setAddressForm(AddressForm addressForm) {
        this.addressForm = addressForm;
    }

    public HotelRating getStars() {
        return stars;
    }

    public void setStars(HotelRating stars) {
        this.stars = stars;
    }
}
