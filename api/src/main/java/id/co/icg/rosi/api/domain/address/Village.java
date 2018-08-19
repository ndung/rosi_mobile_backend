package id.co.icg.rosi.api.domain.address;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "villages")
public class Village implements IArea {
    @Id
    @Column(name = "id")
    private String villageId;

    @Column(name = "name")
    private String villageName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "district_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private District district;

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public String getId() {
        return this.villageId;
    }

    @Override
    public String getName() {
        return this.villageName;
    }
}

