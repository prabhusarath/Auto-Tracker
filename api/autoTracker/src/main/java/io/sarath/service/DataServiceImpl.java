package io.sarath.service;

import io.sarath.entity.Data;
import io.sarath.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository datarepository;

    @Transactional
    public Data create(Data autoData) {
        return datarepository.create(autoData);
    }
}
