package io.sarath.service;


import io.sarath.entity.Data;
import io.sarath.entity.Automotive;
import io.sarath.repository.WarningsRepository;
import io.sarath.repository.AutomotiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarningServiceImpl implements WarningService {

    @Autowired
    private WarningsRepository repo;

    @Autowired
    private AutomotiveRepository repository;

    @Transactional
    public Data create(Data autoData) {

        Automotive vinFind = repository.findOne(autoData.getVin());

        if (autoData.getEngineRpm() > vinFind.getReadlineRpm()) {
            repo.create(autoData,"High","Engine RPM High than Normal");
        }

        if (autoData.getFuelVolume() < (0.1* vinFind.getMaxFuelVolume())){
            repo.create(autoData,"Medium","Fuel level low, Refill Required");
        }

        if ((autoData.getTires().getFrontLeft()>32)||(autoData.getTires().getFrontLeft()<36)){
            repo.create(autoData,"Low","Check Front Left Tire");
        }
        if((autoData.getTires().getFrontRight()>32)||(autoData.getTires().getFrontRight()<36)){
            repo.create(autoData,"Low","Check Front Right Tire");
        }
        if((autoData.getTires().getRearLeft()>32)||(autoData.getTires().getRearLeft()<36)){
            repo.create(autoData,"Low","Check Rear Left Tire");
        }

        if((autoData.getTires().getRearRight()>32)||(autoData.getTires().getRearRight()<36)){
             repo.create(autoData,"Low","Check Rear Right Tire");
        }
        if (autoData.isEngineCoolantLow()||autoData.isCheckEngineLightOn()){
            repo.create(autoData,"Low","Engine Check Required ");
        }
        return autoData;
    }
}
