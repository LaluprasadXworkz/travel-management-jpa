package com.xworkz.temple.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "temple_info")
@NamedQuery(name = "findAllByLocation",query = "select a from TempleEntity a where a.location=:b")
@NamedQuery(name = "findAllByEntryFeeGreaterThan",query = "select c from TempleEntity c where c.entryFee<:d")
@NamedQuery(name = "findAllByEntryFeeBetween",query = "select e from TempleEntity e where e.entryFee between :f and :g")
@NamedQuery(name = "findAllByInauguratedDateGreaterThan",query = "select h from TempleEntity h where h.inaugurationDate>:i")
@NamedQuery(name = "findAllByMainGodAndLocation",query = "select j from TempleEntity j where j.mainGodName=:k and j.location=:l")
@NamedQuery(name = "findByIdAndMainGod",query = "select m from TempleEntity m where m.id=:n and m.mainGodName=:o")
@NamedQuery(name ="findTotal",query = "select count(p) from TempleEntity p")
@NamedQuery(name = "findTempleByMaxEntryFee",query = "select max(q.entryFee) from TempleEntity q")
@NamedQuery(name = "updateLocationByName",query = "update TempleEntity m set m.location=:n where m.templeName=:p")
@NamedQuery(name = "updateEntryFeeByName",query = "update TempleEntity r set r.entryFee=:s where r.templeName=:t")
@NamedQuery(name = "updateLocationAndDimensionById",query = "update TempleEntity t set t.location=:u,t.dimension=:v where t.id=:w")
@NamedQuery(name = "updateAllVipEntry",query = "update TempleEntity n set n.vipEntry=:p where n.id in :Tid ")
@NamedQuery(name = "deleteByName",query = "delete from TempleEntity h  where h.templeName=:tm")
public class TempleEntity {
//    T_id, T_name, Location, Entry_Fee, VIP_Entry, Inauguration_Date, Main_God, Dimension
    @Id
    @Column(name = "T_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "T_name")
    @NotNull
    private String templeName;

    @Column(name = "Location")
    @NotNull
    private String location;

    @Column(name = "Entry_Fee")
    @NotNull
    private int entryFee;

    @Column(name = "VIP_Entry")
    @NotNull
    private boolean vipEntry;

    @Column(name = "Inauguration_Date")
    @NotNull
    private LocalDate inaugurationDate;

    @Column(name = "Main_God")
    @NotNull
    private String mainGodName;

    @Column(name = "Dimension")
    @NotNull
    private String dimension;

    @Override
    public String toString() {
        return "TempleEntity -" +
                "\n------------------------"+
                "\nid :" + id +
                "\ntemple_Name :" + templeName +
                "\nlocation :" + location +
                "\nentryFee :" + entryFee +
                "\nvipEntryFee :" + vipEntry +
                "\ninaugurationDate :" + inaugurationDate +
                "\nmainGodName :" + mainGodName +
                "\ndimension :" + dimension ;
    }
}
