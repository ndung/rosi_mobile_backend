package id.co.icg.rosi.api.repository;

import id.co.icg.rosi.api.domain.address.IArea;
import id.co.icg.rosi.api.domain.address.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ProvinceRepository extends JpaRepository<Province, String> {

    @Query("select p from Province p")
    List<IArea> findAllProvince();
}
