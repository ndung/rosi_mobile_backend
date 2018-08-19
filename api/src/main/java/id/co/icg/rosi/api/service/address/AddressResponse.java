package id.co.icg.rosi.api.service.address;


import id.co.icg.rosi.api.domain.address.Address;

public class AddressResponse {
    private String fullAddress;
    private String longitude;
    private String latitude;

    public AddressResponse(Address address) {
        this.fullAddress = address.getFullAddress();
        this.latitude = address.getLatitude();
        this.longitude = address.getLongitude();
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
