package id.co.icg.rosi.api.service.address;

import id.co.icg.rosi.api.domain.address.Address;
import id.co.icg.rosi.api.domain.address.IArea;

import java.util.List;

public interface AddressService {
    Address create(CreateAddressRequest request);

    List<IArea> findAllProvince();

    List<IArea> findCityByProvince(String provinceId);

    List<IArea> findDistrictByCity(String cityId);

    List<IArea> findVillageByDistrict(String districtId);
}
