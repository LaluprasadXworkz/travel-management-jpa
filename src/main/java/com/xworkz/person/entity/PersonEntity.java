package com.xworkz.person.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "person_info")
@NoArgsConstructor
@RequiredArgsConstructor
@NamedQuery(name = "findPersonByPersonID", query = "SELECT p, a FROM PersonEntity p JOIN AddressEntity a on p.addressEntity = a.aId where p.addressEntity = :personId")

public class PersonEntity {
//  p_id, p_name, mailId, dob, Address
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int pId;

    @Column(name = "p_name")
    @NonNull
    private String personName;

    @Column(name = "mailId")
    @NonNull
    private String mailId;

    @Column(name = "dob")
    @NonNull
    private String doB;

    @Column(name = "Address")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aId", referencedColumnName = "Address")
    private AddressEntity addressEntity;

}
