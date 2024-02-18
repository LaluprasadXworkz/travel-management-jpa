package com.xworkz.person.repository;

import com.xworkz.person.entity.PersonEntity;
import com.xworkz.util.EmfUtil;

import javax.persistence.*;


public class PersonRepository {
    EntityManagerFactory emf= EmfUtil.getManagerFactory();

    public PersonEntity findPersonByPersonID(int personId) {

        EntityManager em = this.emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("findPersonByPersonID", Object[].class);
            query.setParameter("personId", personId);
            Object resut=query.getResultList();
            System.out.println(resut);
        } catch (PersistenceException e) {
            return null;
        } finally {
            em.close();
        }
        return null;
    }



}
