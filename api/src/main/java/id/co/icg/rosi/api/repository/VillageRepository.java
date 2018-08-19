package id.co.icg.rosi.api.repository;

import id.co.icg.rosi.api.domain.address.IArea;
import id.co.icg.rosi.api.domain.address.Village;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface VillageRepository extends JpaRepository<Village, String> {

    @Query("select v from Village v where v.district.districtId = :districtId")
    List<IArea> findVillageByDistrict(@Param("districtId") String districtId);
}
