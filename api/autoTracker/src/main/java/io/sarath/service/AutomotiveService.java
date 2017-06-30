package io.sarath.service;

import io.sarath.entity.Automotive;

import java.util.List;

public interface AutomotiveService {

    List<Automotive> findAll();

    Automotive findOne(String vin);

    Automotive create(Automotive VehicleData);

    Automotive update(String vin, Automotive VehicleData);

    List<Automotive> upsert(List<Automotive> VehicleData);

    void delete(String vin);
}
