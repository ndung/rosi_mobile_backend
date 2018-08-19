package id.co.icg.rosi.api.controller;

import id.co.icg.rosi.api.ApiApplication;
import id.co.icg.rosi.api.domain.Response;
import id.co.icg.rosi.api.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ApiApplication.PATH + "/address")
public class AddressController extends BaseController{

    @Autowired
    private AddressService addressService;

    /**
     * @api {get} /address/regency/{provinceId} Get Regency
     * @apiName Get Regency
     * @apiDescription Get regency in one province
     * @apiGroup Address
     * @apiParam {String} provinceId
     *
     * @apiExample {json} Response
     * {
     *     data : [
     *          {"id" : "1001", "name"  : "Kota Bogor"},
     *          {"id" : "1002", "name"  : "Kota Bekasi"},
     *
     *      ],
     *      message : null
     * }
     *
     */
    @RequestMapping(value = "/regency/{provinceId}", method = RequestMethod.GET)
    public ResponseEntity<Response> getRegency(@PathVariable("provinceId") String provinceId) {

        Response r;
        try {
            r = new Response(addressService.findCityByProvince(provinceId));

        } catch (Exception e) {
            r = new Response(e.getMessage());
        }

        return getHttpStatus(r);

    }

    /**
     * @api {get} /address/district/{regencyId} Get District
     * @apiName Get District
     * @apiDescription Get district in one regency
     * @apiGroup Address
     * @apiParam {String} regencyId
     *
     * @apiExample {json} Response
     * {
     *     data : [
     *          {"id" : "1001", "name"  : "Kecamatan Bogor Barat"},
     *          {"id" : "1002", "name"  : "Kecamatan Bogor Timur"},
     *
     *      ],
     *      message : null
     * }
     *
     */
    @RequestMapping(value = "/district/{regencyId}", method = RequestMethod.GET)
    public ResponseEntity<Response> getDistrict(@PathVariable("regencyId") String regencyId) {

        Response r;
        try {
            r = new Response(addressService.findDistrictByCity(regencyId));

        } catch (Exception e) {
            r = new Response(e.getMessage());
        }

        return getHttpStatus(r);
    }

    /**
     * @api {get} /address/village/{districtId} Get Regency
     * @apiName Get Village
     * @apiDescription Get village in one district
     * @apiGroup Address
     * @apiParam {String} districtId
     *
     * @apiExample {json} Response
     * {
     *     data : [
     *          {"id" : "1001", "name"  : "Pasir Gombong"},
     *          {"id" : "1002", "name"  : "Mekarmukti"},
     *
     *      ],
     *      message : null
     * }
     *
     */
    @RequestMapping(value = "/village/{districtId}", method = RequestMethod.GET)
    public ResponseEntity<Response> getVillage(@PathVariable("districtId") String districtId) {

        Response r;
        try {
            r = new Response(addressService.findVillageByDistrict(districtId));

        } catch (Exception e) {
            r = new Response(e.getMessage());
        }

        return getHttpStatus(r);

    }

}
