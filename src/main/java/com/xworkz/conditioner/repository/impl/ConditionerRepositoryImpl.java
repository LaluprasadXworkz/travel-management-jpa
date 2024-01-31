package com.xworkz.conditioner.repository.impl;

import com.xworkz.conditioner.entity.ConditionerEntity;
import com.xworkz.conditioner.repository.ConditionerRepository;
import com.xworkz.util.EmfUtil;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

public class ConditionerRepositoryImpl implements ConditionerRepository {
    private EntityManagerFactory emf= EmfUtil.getManagerFactory();
    @Override
    public void save(ConditionerEntity entity) {
        System.out.println("Invoking save "+entity);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            System.out.println("Begin ET");
            em.persist(entity);
            et.commit();
            System.out.println("Data inserted");

        }catch (PersistenceException e){
            System.out.println("PersistenceException ");
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
    }

    @Override
    public void saveAll(List<ConditionerEntity> entityList) {
        System.out.println("Invoking saveAll "+entityList);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            System.out.println("Begin ET");
            entityList.forEach(d->em.persist(d));
            et.commit();
            System.out.println("Data inserted");


        }catch (PersistenceException e){
            System.out.println("PersistenceException in  saveAll"+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }

    }

    @Override
    public void updateNetQuantityByBrand(String brand, int quantity) {

        System.out.println("Invoking updateNetQuantityByBrand "+brand+ " and "+quantity);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateNetQuantityByBrand");
            query.setParameter("b",quantity);
            query.setParameter("c",brand);
            query.executeUpdate();
            System.out.println("Data Update ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  updateNetQuantityByBrand "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }

    }

    @Override
    public void updateRecommendedForByBrand(String brand, String rc) {

        System.out.println("Invoking updateNetQuantityByBrand "+brand+ " and "+rc);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateRecommendedForByBrand");
            query.setParameter("e",rc);
            query.setParameter("f",brand);
            query.executeUpdate();
            System.out.println("Data Update ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  updateRecommendedForByBrand "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }

    }

    @Override
    public List<ConditionerEntity> findAllByBrand(String brand) {
        System.out.println("Invoking findAllByBrand  "+brand);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByBrand");
            query.setParameter("h",brand);
            List<ConditionerEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByBrand "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<ConditionerEntity> findAllByHairType(String type) {
        System.out.println("Invoking findAllByHairType  "+type);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByHairType");
            query.setParameter("j",type);
            List<ConditionerEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByHairType "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<ConditionerEntity> findScentById(int id) {
        System.out.println("Invoking findScentById  "+id);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findScentById");
            query.setParameter("l",id);
            List<ConditionerEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findScentById "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getAllSize() {
        System.out.println("Invoking getAllSize  ");
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("getAllSize");
            List<String> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  getAllSize "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> getAllBrand() {
        System.out.println("Invoking getAllBrand  ");
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("getAllBrand");
            List<String> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  getAllBrand "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }
}
