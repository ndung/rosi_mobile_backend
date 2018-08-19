package id.co.icg.rosi.api.domain.address;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "regencies")
public class Regency implements IArea {
    @Id
    @Column(name = "id")
    private String regencyId;

    @Column(name = "name")
    private String regencyName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "province_id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Province province;


    public String getRegencyName() {
        return regencyName;
    }

    public void setRegencyName(String regencyName) {
        this.regencyName = regencyName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public String getRegencyId() {
        return regencyId;
    }

    public void setRegencyId(String regencyId) {
        this.regencyId = regencyId;
    }


    @Override
    public String getId() {
        return regencyId;
    }

    @Override
    public String getName() {
        return regencyName;
    }
}
