package io.sarath.repository;

import io.sarath.entity.Automotive;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class AutomotiveRepositoryImpl implements AutomotiveRepository {

    @PersistenceContext
    private EntityManager em;


    public List<Automotive> findAll() {

        TypedQuery<Automotive> query = em.createNamedQuery("Automotive.findAll", Automotive.class);
        return query.getResultList();
    }


    public Automotive findOne(String vin) {
        return em.find(Automotive.class, vin);
    }


    public Automotive findByVin(String vin) {
        TypedQuery<Automotive> query = em.createNamedQuery("Automotive.findByVin", Automotive.class);
        query.setParameter("pVin", vin);
        List<Automotive> resultList = query.getResultList();

        if(resultList != null && resultList.size() == 1) {
            return resultList.get(0);
        } else {
            return null;
        }
    }


    public Automotive create(Automotive autodata) {
        em.persist(autodata);
        return autodata;
    }


    public Automotive update(Automotive autodata) {
        return em.merge(autodata);
    }


    public List<Automotive> upsert(List<Automotive> autodata) {

        for (Automotive vinids: autodata) {
            Automotive existing = findOne(vinids.getVin());
            if (existing == null) {
                em.persist(vinids);}
            else {
                em.merge(vinids);}
        }
        return autodata;
    }

    public void delete(Automotive autodata) {
        em.remove(autodata);
    }
}
