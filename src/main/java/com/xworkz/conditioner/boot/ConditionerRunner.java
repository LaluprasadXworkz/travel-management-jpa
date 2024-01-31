package com.xworkz.conditioner.boot;

import com.xworkz.conditioner.entity.ConditionerEntity;
import com.xworkz.conditioner.repository.ConditionerRepository;
import com.xworkz.conditioner.repository.impl.ConditionerRepositoryImpl;

import java.util.Arrays;
import java.util.List;

public class ConditionerRunner {
    public static void main(String[] args) {
        ConditionerEntity entity1=new ConditionerEntity("Dove","Liquid","Biodegradable",
                "All","Detangling","Adult","Hair","175.0 millilitre",1,"Sunflower");

        ConditionerEntity entity2=new ConditionerEntity("Clink plus ","Liquid-1","Biodegradable-1",
                "All-1","Detangling-1","Adult-1","Hair-1","800.0 millilitre",2,"Sunflower-1");

        ConditionerEntity entity3=new ConditionerEntity("L’Oréal Paris","Liquid-2","Biodegradable-2",
                "All-2","Detangling-2","Adult-2","Hair-2","200.0 millilitre",3,"Sunflower-2");

        ConditionerEntity entity4=new ConditionerEntity("Sebastian","Liquid-3","Biodegradable-3",
                "All-3","Detangling-3","Adult-3","Hair-3","500.0 millilitre",4,"Sunflower-3");

        List<ConditionerEntity> list= Arrays.asList(entity1,entity2,entity3,entity4);
        ConditionerRepository repository=new ConditionerRepositoryImpl();
//        repository.save(entity1);
//        repository.saveAll(list);
        System.out.println("-------------------------------------------------------------------------------");
        repository.updateNetQuantityByBrand("Dove",5);

        System.out.println("-------------------------------------------------------------------------------");
        repository.updateRecommendedForByBrand("Dove","Hair-5");

        System.out.println("-------------------------------------------------------------------------------");
        List<ConditionerEntity> list1=repository.findAllByBrand("Dove");
        list1.forEach(z-> System.out.println(z));

        System.out.println("-------------------------------------------------------------------------------");
        List<ConditionerEntity> list2=repository.findAllByHairType("All");
        list2.forEach(z-> System.out.println(z));

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println(repository.findScentById(1));

        System.out.println("-------------------------------------------------------------------------------");
        List<String> list3=repository.getAllBrand();
        list3.forEach(z-> System.out.println(z));

        System.out.println("-------------------------------------------------------------------------------");
        List<String> list4=repository.getAllSize();
        list4.forEach(z-> System.out.println(z));



    }

}
