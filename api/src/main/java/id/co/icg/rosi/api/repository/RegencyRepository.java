package id.co.icg.rosi.api.repository;

import id.co.icg.rosi.api.domain.address.IArea;
import id.co.icg.rosi.api.domain.address.Regency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface RegencyRepository extends JpaRepository<Regency, String> {

    @Query("select c from Regency c where c.province.provinceId = :provinceId")
    List<IArea> findRegencyByProvince(@Param("provinceId") String provinceId);
}
