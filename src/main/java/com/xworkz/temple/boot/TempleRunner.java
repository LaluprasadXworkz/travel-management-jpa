package com.xworkz.temple.boot;

import com.xworkz.temple.entity.TempleEntity;
import com.xworkz.temple.repository.TempleRepository;
import com.xworkz.temple.repository.impl.TempleRepositoryImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempleRunner {
    public static void main(String[] args) {
        TempleEntity temple1=new TempleEntity("Tirupati","AP",500,true,
                LocalDate.of(1947,01,24), "Venkateswara","10.59 sq mi");

        TempleEntity temple2=new TempleEntity("Dharmasthala","Karnataka",500,false,
                LocalDate.of(2023,01,24), "Sri Manjunatha","20.59 sq mi");

        TempleEntity temple3=new TempleEntity("kukke subramanya","Uttara Kannada",500,true,
                LocalDate.of(2023,01,24), "Subramanya","30.59 sq mi");

        TempleEntity temple4=new TempleEntity("Murdeshwar","Karnataka",500,false,
                LocalDate.of(2023,01,24), "Shiva","40.59 sq mi");

        TempleEntity temple5=new TempleEntity("kanipakam","Andhra Pradesh",500,true,
                LocalDate.of(2023,01,24), "Varasidhi Vinayaka Swamy","50.59 sq mi");

        List<TempleEntity> list= Arrays.asList(temple1,temple2,temple3,temple4,temple5);

        TempleRepository templeRepository=new TempleRepositoryImpl();
/*
//        templeRepository.save(list);
//        templeRepository.saveAll(list);
        List<TempleEntity> location=templeRepository.findAllByLocation("Karnataka");
        location.forEach(z-> System.out.println(z));

        System.out.println("----------------------------------------------------------");
        List<TempleEntity> fee=templeRepository.findAllByEntryFeeGreaterThan(700);
        fee.forEach(x-> System.out.println(x));
        System.out.println("----------------------------------------------------------");
        List<TempleEntity> feeGrater=templeRepository.findAllByEntryFeeBetween(700,1000);
        feeGrater.forEach(y-> System.out.println(y));
        System.out.println("----------------------------------------------------------");
        List<TempleEntity> year=templeRepository.findAllByInauguratedDateGreaterThan(LocalDate.of(2000,01,24));
        year.forEach(y-> System.out.println(y));
        System.out.println("----------------------------------------------------------");
        List<TempleEntity> godAndLocation=templeRepository.findAllByMainGodAndLocation("Shiva","Karnataka");
        godAndLocation.forEach(w-> System.out.println(w));

        System.out.println("----------------------------------------------------------");
        TempleEntity temple=templeRepository.findById(2);
        System.out.println(temple);


        System.out.println("----------------------------------------------------------");
        TempleEntity idGod=templeRepository.findByIdAndMainGod(4,"Shiva");
        System.out.println(idGod);

        System.out.println("----------------------------------------------------------");
        Long total=templeRepository.findTotal();
        System.out.println(total);


        System.out.println("----------------------------------------------------------");
     templeRepository.findTempleByMaxEntryFee();
     */
//        templeRepository.updateLocationByName("Bengaluru","kanipakam");
//        templeRepository.updateEntryFeeByName(2500,"kanipakam");
//        templeRepository.updateLocationAndDimensionById("Basm Circle","100.59 sq mi",3);

//        List<Integer> tId=Arrays.asList(1,3,5);
//        templeRepository.updateAllVipEntry(true,tId);
        templeRepository.deleteByName("Dharmasthala");
    }
}
