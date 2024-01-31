package com.xworkz.temple.repository.impl;

import com.xworkz.temple.entity.TempleEntity;
import com.xworkz.temple.repository.TempleRepository;
import com.xworkz.util.EmfUtil;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class TempleRepositoryImpl implements TempleRepository {

    private EntityManagerFactory emf=EmfUtil.getManagerFactory();
    @Override
    public void save(TempleEntity temple) {
        System.out.println("Invoking save "+temple);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            System.out.println("Begin ET");
            em.persist(temple);
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
    public void saveAll(List<TempleEntity> entities) {
        System.out.println("Invoking saveAll "+entities);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            System.out.println("Begin ET");
            entities.forEach(d->em.persist(d));
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
    public List<TempleEntity> findAllByLocation(String location) {
        System.out.println("Invoking findAllByLocation "+location);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByLocation");
            query.setParameter("b",location);
            List<TempleEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByLocation "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<TempleEntity> findAllByEntryFeeGreaterThan(int fee) {
        System.out.println("Invoking findAllByEntryFeeGreaterThan "+fee);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByEntryFeeGreaterThan");
            query.setParameter("d",fee);
            List<TempleEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByEntryFeeGreaterThan "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<TempleEntity> findAllByEntryFeeBetween(int startFee, int endFee) {
        System.out.println("Invoking findAllByEntryFeeBetween "+startFee+ " and "+endFee);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByEntryFeeBetween");
            query.setParameter("f",startFee);
            query.setParameter("g",endFee);
            List<TempleEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByEntryFeeBetween "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<TempleEntity> findAllByInauguratedDateGreaterThan(LocalDate year) {
        System.out.println("Invoking findAllBYInauguratedDateGreaterThan "+year);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByInauguratedDateGreaterThan");
            query.setParameter("i",year);
            List<TempleEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllBYInauguratedDateGreaterThan "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();
    }

    @Override
    public List<TempleEntity> findAllByMainGodAndLocation(String god, String location) {

        System.out.println("Invoking findAllByMainGodAndLocation  "+god+" and "+location);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findAllByMainGodAndLocation");
            query.setParameter("k",god);
            query.setParameter("l",location);
            List<TempleEntity> list=query.getResultList();
            System.out.println("Data fetched ");
            return list;

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByMainGodAndLocation "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return Collections.emptyList();

    }

    @Override
    public TempleEntity findById(int id) {
        System.out.println("Invoking findById "+id);
        EntityManager em=this.emf.createEntityManager();

        try{
            TempleEntity temple=em.find(TempleEntity.class,id);
            return  temple;
        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByEntryFeeBetween "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return null;
    }

    @Override
    public TempleEntity findByIdAndMainGod(int id, String god) {
        System.out.println("Invoking findByIdAndMainGod "+ id+" and "+god);
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findByIdAndMainGod");
            query.setParameter("n",id);
            query.setParameter("o",god);
            return (TempleEntity) query.getSingleResult();


        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByMainGodAndLocation "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return null;
    }

    @Override
    public Long findTotal() {
        System.out.println("Invoking findTotal ");
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findTotal");
            return (Long) query.getSingleResult();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByMainGodAndLocation "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return null;
    }

    @Override
    public TempleEntity findTempleByMaxEntryFee() {
        System.out.println("Invoking findTempleByMaxEntryFee ");
        EntityManager em=this.emf.createEntityManager();

        try{
            Query query=em.createNamedQuery("findTempleByMaxEntryFee");
            Object result=query.getSingleResult();
            System.out.println(result);
        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByMainGodAndLocation "+e.getMessage());
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
        return null;
    }

    @Override
    public void updateLocationByName(String location, String name) {
        System.out.println("Invoking updateLocationByName "+location+ " and "+name);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateLocationByName");
            query.setParameter("n",location);
            query.setParameter("p",name);
            query.executeUpdate();
            System.out.println("Data Update ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  findAllByEntryFeeBetween "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
    }

    @Override
    public void updateEntryFeeByName(int fee, String name) {

        System.out.println("Invoking updateEntryFeeByName "+fee+ " and "+name);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateEntryFeeByName");
            query.setParameter("s",fee);
            query.setParameter("t",name);
            query.executeUpdate();
            System.out.println("Data updated ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  updateEntryFeeByName "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }

    }

    @Override
    public void updateLocationAndDimensionById(String loc, String dimension, int id) {

        System.out.println("Invoking updateLocationAndDimensionById "+loc+ ","+dimension+" using "+id);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateLocationAndDimensionById");
            query.setParameter("u",loc);
            query.setParameter("v",dimension);
            query.setParameter("w",id);
            query.executeUpdate();
            System.out.println("Data updated ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  updateLocationAndDimensionById "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
    }

    @Override
    public void updateAllVipEntry(boolean entry, List<Integer> ids) {
        System.out.println("Invoking updateAllVipEntry "+entry+" ,"+ids);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("updateAllVipEntry");
            query.setParameter("p",entry);
            query.setParameter("Tid",ids);
            query.executeUpdate();
            System.out.println("Data updated ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  updateAllVipEntry "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
    }

    @Override
    public void deleteByName(String name) {
        System.out.println("Invoking deleteByName "+name);
        EntityManager em=this.emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        try{
            et.begin();
            Query query=em.createNamedQuery("deleteByName");
            query.setParameter("tm",name);
            query.executeUpdate();
            System.out.println("Data deleted ");
            et.commit();

        }catch (PersistenceException e){
            System.out.println("PersistenceException in  deleteByName "+e.getMessage());
            et.rollback();
        }finally {
            System.out.println("Closing EntityManagerFactory ");
            em.close();
        }
    }
}
