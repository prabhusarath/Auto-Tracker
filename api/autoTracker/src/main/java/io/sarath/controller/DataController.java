package io.sarath.controller;

import io.sarath.entity.Data;
import io.sarath.service.WarningService;
import io.sarath.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "readings")
public class DataController {

    @Autowired
    private DataService dataservice;
    @Autowired
    private WarningService warnservices;

    @RequestMapping(method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
                    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Data create(@RequestBody Data VehicleReadings) {
        dataservice.create(VehicleReadings);
        warnservices.create(VehicleReadings);
        return VehicleReadings;
    }
}
