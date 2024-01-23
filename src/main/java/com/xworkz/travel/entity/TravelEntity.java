package com.xworkz.travel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "travel_info")
@AllArgsConstructor
@NoArgsConstructor
public class TravelEntity {
//    T_id, source, destination, budget, distanceinKm, purpose, duration, modetype, start_date, return_date
    @Id
    @Column(name = "T_id")
    private int id;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Column(name = "budget")
    private int budget;

    @Column(name = "distanceinKm")
    private int distanceInKm;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "duration")
    private String duration;

    @Column(name = "modetype")
    private String modeType;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Override
    public String toString() {
        return "TravelEntity -" +
                "------------------------"+
                "\nid :" + id +
                "\nsource :" + source +
                "\ndestination:" + destination +
                "\nbudget  :" + budget +
                "\ndistance In Km :" + distanceInKm +
                "\npurpose :" + purpose +
                "\nduration :" + duration +
                "\nmodeType :" + modeType +
                "\nstartDate :" + startDate +
                "\nreturnDate :" + returnDate;
    }
}
