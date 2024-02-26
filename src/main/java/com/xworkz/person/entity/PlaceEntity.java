package com.xworkz.person.entity;


import com.xworkz.person.entity.PersonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "place")
public class PlaceEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    @Column(name = "place_name")
    private String name;

    @OneToMany(mappedBy = "residence")
    private List<PersonEntity> residents;


}
