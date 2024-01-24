package com.xworkz.travel.repository.impl;

import com.xworkz.travel.entity.TravelEntity;
import com.xworkz.travel.repository.TravelReposistory;

import javax.persistence.*;

public class TravelReposistoryImpl implements TravelReposistory {

    private EntityManagerFactory emf= Persistence.createEntityManagerFactory("fertilizer");
    @Override
    public Integer save(TravelEntity travel) {
        System.out.println("Starting save of TravelEntity :"+travel);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            System.out.println("Starting ET");
            et.begin();
            System.out.println("Starting persist");
            em.persist(travel);
            System.out.println("persist success");
            et.commit();
            return travel.getId();

        }catch (PersistenceException pe){
            System.err.println("Persistence in save method of Travel :"+pe.getMessage());
            et.rollback();
        }finally {
            System.out.println("Persistence closing");
            em.close();
        }

        return null;
    }
}
