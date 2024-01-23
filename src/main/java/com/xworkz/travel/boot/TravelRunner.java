package com.xworkz.travel.boot;

import com.xworkz.travel.entity.TravelEntity;
import com.xworkz.travel.repository.impl.TravelReposistoryImpl;

import java.time.LocalDate;

public class TravelRunner {
    public static void main(String[] args) {
//        T_id, source, destination, budget, distanceinKm, purpose, duration, modetype, start_date, return_date
        TravelEntity travel=new TravelEntity(1,"Bengaluru","Basam circle",10,5,"X-workz","1-hour",
                "Bus", LocalDate.of(2024,01,24),LocalDate.of(2024,01,24));

        TravelReposistoryImpl travelReposistory=new TravelReposistoryImpl();
        travelReposistory.save(travel);

    }
}
