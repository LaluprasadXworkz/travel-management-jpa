package com.xworkz.conditioner.repository;

import com.xworkz.conditioner.entity.ConditionerEntity;

import java.util.List;

public interface ConditionerRepository {
    void save(ConditionerEntity entity);
    void saveAll(List<ConditionerEntity> entityList);
    void updateNetQuantityByBrand(String brand,int quantity);
    void updateRecommendedForByBrand(String brand,String rc);
    List<ConditionerEntity> findAllByBrand(String brand);
    List<ConditionerEntity> findAllByHairType(String type);
    List<ConditionerEntity>  findScentById(int id);

    List<String> getAllSize();
    List<String> getAllBrand();

}
