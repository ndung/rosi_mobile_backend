package id.co.icg.rosi.api.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provinces")
public class Province implements IArea {
    @Id
    @Column(name = "id")
    private String provinceId;

    @Column(name = "name")
    private String provinceName;

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }


    @Override
    public String getId() {
        return provinceId;
    }

    @Override
    public String getName() {
        return provinceName;
    }
}
