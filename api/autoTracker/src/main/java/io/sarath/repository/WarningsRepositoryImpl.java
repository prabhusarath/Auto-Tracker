package io.sarath.repository;

import io.sarath.entity.Warnings;
import io.sarath.entity.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class WarningsRepositoryImpl implements WarningsRepository {

    @PersistenceContext
    private EntityManager em;

    public Data create(Data VehicleData, String priority, String alerts) {

        Warnings warningAlerts=new Warnings();
        warningAlerts.setVin(VehicleData.getVin());
        warningAlerts.setReadingId(VehicleData.getReadingId());
        warningAlerts.setAlert(alerts);
        warningAlerts.setPriority(priority);

        em.persist(warningAlerts);

        return VehicleData;
    }
}
