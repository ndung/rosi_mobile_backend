package id.co.icg.rosi.api.service.address;

import id.co.icg.rosi.api.domain.address.Address;
import id.co.icg.rosi.api.domain.address.IArea;
import id.co.icg.rosi.api.domain.address.Village;
import id.co.icg.rosi.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements  AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private VillageRepository villageRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RegencyRepository regencyRepository;

    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    public Address create(CreateAddressRequest request) {
        Address address = new Address();
        address.setStreet(request.getStreet());
        address.setVillage(villageRepository.getOne(request.getVillageId()));
        address.setLongitude(request.getLongitude());
        address.setLatitude(request.getLatitude());

        return addressRepository.saveAndFlush(address);
    }

    @Override
    public List<IArea> findAllProvince() {
        return provinceRepository.findAllProvince();
    }

    @Override
    public List<IArea> findCityByProvince(String provinceId) {
        return regencyRepository.findRegencyByProvince(provinceId);
    }

    @Override
    public List<IArea> findDistrictByCity(String regencyId) {
        return districtRepository.findDistrictByRegency(regencyId);
    }

    @Override
    public List<IArea> findVillageByDistrict(String districtId) {
        return villageRepository.findVillageByDistrict(districtId);
    }
}
