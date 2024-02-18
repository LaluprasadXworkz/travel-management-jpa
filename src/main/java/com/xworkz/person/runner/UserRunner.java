package com.xworkz.person.runner;

import com.xworkz.person.entity.PersonEntity;
import com.xworkz.person.repository.PersonRepository;

public class UserRunner {
    public static void main(String[] args) {
        PersonRepository repository = new PersonRepository();
//        PersonEntity person = repository.findPersonByPersonID(1);
//        System.out.println(person);
        repository.findPersonByPersonID(1);
    }
}
