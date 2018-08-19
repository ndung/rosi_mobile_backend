package id.co.icg.rosi.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseDomain {

    @Temporal(TemporalType.TIMESTAMP)
    protected Date createAt;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date updateAt;

    @JsonIgnore
    @Column(columnDefinition = "TINYINT(1)")
    protected int isDeleted;


    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @PrePersist
    protected void onCreate() {
        isDeleted = 0;
        createAt = updateAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateAt = new Date();
    }

    public boolean isDeleted() {
        return isDeleted == 1;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted? 1 : 0;
    }


}
