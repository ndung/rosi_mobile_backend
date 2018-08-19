package id.co.icg.rosi.api.repository;

import id.co.icg.rosi.api.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface AddressRepository extends JpaRepository<Address, Long> {

}
