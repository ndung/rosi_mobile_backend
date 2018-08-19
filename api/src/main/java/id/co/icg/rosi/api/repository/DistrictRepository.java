package id.co.icg.rosi.api.repository;

import id.co.icg.rosi.api.domain.address.District;
import id.co.icg.rosi.api.domain.address.IArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DistrictRepository extends JpaRepository<District, String> {

    @Query("select d from District d where d.regency.regencyId = :regencyId ")
    List<IArea> findDistrictByRegency(@Param("regencyId") String regencyId);
}
