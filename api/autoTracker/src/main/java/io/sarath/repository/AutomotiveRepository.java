package io.sarath.repository;

import io.sarath.entity.Automotive;

import java.util.List;

public interface AutomotiveRepository {

    List<Automotive> findAll();

    Automotive findOne(String vin);

    Automotive findByVin(String vin);

    Automotive create(Automotive autodata);

    Automotive update(Automotive autodata);

    List<Automotive> upsert(List<Automotive> autodata);

    void delete(Automotive autodata);
}
