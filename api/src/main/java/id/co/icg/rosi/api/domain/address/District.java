package id.co.icg.rosi.api.domain.address;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "districts")
public class District implements IArea {

    @Id
    @Column(name = "id")
    private String districtId;

    public String getDistrictId() {
        return districtId;
    }

    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Regency getRegency() {
        return regency;
    }

    public void setRegency(Regency regency) {
        this.regency = regency;
    }

    @Column(name = "name")
    private String districtName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "regency_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Regency regency;


    @Override
    public String getId() {
        return districtId;
    }

    @Override
    public String getName() {
        return districtName;
    }
}
