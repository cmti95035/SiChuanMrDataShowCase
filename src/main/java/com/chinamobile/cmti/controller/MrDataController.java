package com.chinamobile.cmti.controller;

import com.chinamobile.cmti.editors.DepartmentEditor;
import com.chinamobile.cmti.model.*;
import com.chinamobile.cmti.service.MrDataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/mrdata/showdetails")
@SessionAttributes("mrdata")
public class MrDataController {
    @Autowired
    MrDataManager manager;

//    private Validator validator;
//
//    public MrDataController()
//    {
//        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
//        validator = validatorFactory.getValidator();
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(DepartmentVO.class, new DepartmentEditor());
//    }

    @ModelAttribute("allProvinces")
    public List<ProvinceVO> populateProvinces()
    {
        ArrayList<ProvinceVO> Provinces = new ArrayList<ProvinceVO>();
        List<MrDataVO> mrs = manager.getAllMrData();
        HashSet<String> provinceSet = new HashSet<String>();
        for(MrDataVO mr : mrs){
            provinceSet.add(mr.getProvince());
        }
        Provinces.add(new ProvinceVO(-1, "选择省份"));

        int i = 0;
        for(String province : provinceSet){
            Provinces.add(new ProvinceVO(++i, province));
        }
        return Provinces;
    }

    @ModelAttribute("allCities")
    public List<CityVO> populateCities()
    {
        ArrayList<CityVO> Cities = new ArrayList<CityVO>();
        List<MrDataVO> mrs = manager.getAllMrData();
        HashSet<String> CitySet = new HashSet<String>();
        for(MrDataVO mr : mrs){
            CitySet.add(mr.getCity());
        }
        Cities.add(new CityVO(-1, "选择市/地区"));

        int i = 0;
        for(String City : CitySet){
            Cities.add(new CityVO(++i, City));
        }
        return Cities;
    }

    @ModelAttribute("allRoadNames")
    public List<RoadNameVO> populateRoadNames()
    {
        ArrayList<RoadNameVO> RoadNames = new ArrayList<RoadNameVO>();
        List<MrDataVO> mrs = manager.getAllMrData();
        HashSet<String> RoadNameSet = new HashSet<String>();
        for(MrDataVO mr : mrs){
            RoadNameSet.add(mr.getRoadName());
        }
        RoadNames.add(new RoadNameVO(-1, "选择路名"));

        int i = 0;
        for(String RoadName : RoadNameSet){
            RoadNames.add(new RoadNameVO(++i, RoadName));
        }
        return RoadNames;
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(Model model) {
        MrDataVO mrDataVO = new MrDataVO("四川", "成都", "三环");
        model.addAttribute("mrdata", mrDataVO);
        return "showMrData";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("mrdata") MrDataVO mrDataVO,
                             BindingResult result, SessionStatus status) {

//        Set<ConstraintViolation<EmployeeVO>> violations = validator.validate(employeeVO);
//
//        for (ConstraintViolation<EmployeeVO> violation : violations)
//        {
//            String propertyPath = violation.getPropertyPath().toString();
//            String message = violation.getMessage();
//            // Add JSR-303 errors to BindingResult
//            // This allows Spring to display them in view via a FieldError
//            result.addError(new FieldError("employee", propertyPath, "Invalid "+ propertyPath + "(" + message + ")"));
//        }

        if (result.hasErrors()) {
            return "showMrData";
        }

        // Mark Session Complete
        status.setComplete();
        return "redirect:showdetails/showmap";
//        return "showMrData";
    }

    @RequestMapping(value = "/showmap", method = RequestMethod.GET)
    public String showmap(Model model) {
        return "showInMap";
    }
}
