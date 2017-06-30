package io.sarath.repository;

import io.sarath.entity.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DataRepositoryImpl implements DataRepository {

    @PersistenceContext
    private EntityManager em;

    public Data create(Data VehicleData) {
        em.persist(VehicleData);
        return VehicleData;
    }
}
