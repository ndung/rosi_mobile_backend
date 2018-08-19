package id.co.icg.rosi.api.domain.address;

import id.co.icg.rosi.api.domain.BaseDomain;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;

@SQLDelete(sql = "UPDATE address SET deleted = 1 WHERE address_id = ?")
@Entity
public class Address extends BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long addressId;

    private String street;

    private String longitude;

    private String latitude;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "villageId")
    @NotFound(action = NotFoundAction.IGNORE)
    private Village village;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Village getVillage() {
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public String getFullAddress() {
        return String.format("%s %s %s %s %s - Indonesia", street, village.getVillageName(),
                village.getDistrict().getDistrictName(), village.getDistrict().getRegency().getRegencyName(),
                village.getDistrict().getRegency().getProvince().getProvinceName());
    }

    public String getShortAddress() {
        return String.format("%s %s  %s - Indonesia", street, village.getDistrict().getRegency().getRegencyName(),
                village.getDistrict().getRegency().getProvince().getProvinceName());
    }
}
