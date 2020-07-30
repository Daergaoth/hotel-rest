package hu.progmasters.hotelrest.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable//engedi a hotel entity-nek az EMBEDDED annatáció hasnálatát.
public class Address {

    @Column(name = "City")
    private String city;

    @Column(name = "Zip_Code")
    private String zipCode;

    @Column(name = "Street")
    private String street;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
