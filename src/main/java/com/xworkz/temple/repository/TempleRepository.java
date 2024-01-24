package com.xworkz.temple.repository;

import com.xworkz.temple.entity.TempleEntity;

import java.time.LocalDate;
import java.util.List;

public interface TempleRepository {

    void save(TempleEntity temple);
    void saveAll(List<TempleEntity> entities);

    List<TempleEntity> findAllByLocation(String location);

    List<TempleEntity> findAllByEntryFeeGreaterThan(int fee);
    List<TempleEntity>    findAllByEntryFeeBetween(int startFee,int endFee);
    List<TempleEntity> findAllByInauguratedDateGreaterThan(LocalDate year);
    List<TempleEntity> findAllByMainGodAndLocation(String god,String location);
    TempleEntity findById(int id);
    TempleEntity findByIdAndMainGod(int id,String god);
    Long findTotal();
    TempleEntity findTempleByMaxEntryFee();
    void updateLocationByName(String location,String name);
    void updateEntryFeeByName(int fee,String name);
    void updateLocationAndDimensionById(String loc,String dimension,int id);
    void updateAllVipEntry(boolean entry,List<Integer> ids);
    void deleteByName(String name);

}
