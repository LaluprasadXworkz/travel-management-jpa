package com.xworkz.person.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "addres_info")
@NoArgsConstructor
@RequiredArgsConstructor

public class AddressEntity {
//    A_id, PName, State, Pincode
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "A_id")
    private int aId;
    @Column(name = "PName")
    @NonNull
    private String placeName;

    @Column(name = "State")
    @NonNull
    private String state;

    @Column(name = "Pincode")
    @NonNull
    private int pinCode;

}
