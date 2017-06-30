package io.sarath.controller;

import io.sarath.entity.Automotive;
import io.sarath.service.AutomotiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class AutomotiveController {

    @Autowired
    private AutomotiveService autoservice;

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Automotive> findAll(){
        return autoservice.findAll();

    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Automotive findOne(@PathVariable("vin") String vin) {
        return autoservice.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Automotive create(@RequestBody Automotive autodata) {
        return autoservice.create(autodata);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Automotive update(@PathVariable("vin") String vin, @RequestBody Automotive autodata) {
        return autoservice.update(vin, autodata);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Automotive> upsert(@RequestBody List<Automotive> autodata) {
        autoservice.upsert(autodata);
        return autodata;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vin){
        autoservice.delete(vin);
    }
}
