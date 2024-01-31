package com.xworkz.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfUtil {
    private static EntityManagerFactory managerFactory;

    public static EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }
    static {
        System.out.println("Initializing EntityManagerFactory");
        managerFactory= Persistence.createEntityManagerFactory("fertilizer");

    }
}
