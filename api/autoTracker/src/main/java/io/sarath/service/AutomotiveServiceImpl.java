package io.sarath.service;

import io.sarath.entity.Automotive;
import io.sarath.repository.AutomotiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutomotiveServiceImpl implements AutomotiveService {

    @Autowired
    private AutomotiveRepository repository;

    @Transactional(readOnly = true)
    public List<Automotive> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Automotive findOne(String vin) {
        Automotive VehicleData = repository.findOne(vin);
        if (VehicleData == null) {
            throw new io.sarath.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        return VehicleData;
    }

    @Transactional
    public Automotive create(Automotive VehicleData) {
        Automotive vinCreate = repository.findByVin(VehicleData.getVin());
        if (vinCreate != null) {
            throw new io.sarath.Exception.BadRequestException("Employee with email=" + VehicleData.getVin() + " already exist");
        }
        return repository.create(VehicleData);
    }

    @Transactional
    public Automotive update(String vin, Automotive VehicleData) {
        Automotive vinUpdate = repository.findOne(vin);
        if (vinUpdate == null) {
            throw new io.sarath.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        return repository.update(VehicleData);
    }


    @Transactional
    public List<Automotive> upsert(List<Automotive> VehicleData) {
        return repository.upsert(VehicleData);
    }


    @Transactional
    public void delete(String vin) {
        Automotive vinRemove = repository.findOne(vin);
        if (vinRemove == null) {
            throw new io.sarath.Exception.NotFoundException("Employee with id=" + vin + " not found");
        }
        repository.delete(vinRemove);
    }
}
