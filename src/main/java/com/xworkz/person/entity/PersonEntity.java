package com.xworkz.person.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "person_name")
    private String name;

    private int age;

    @ManyToOne
    @JoinColumn(name = "residence_id")
    private PlaceEntity residence;
}
