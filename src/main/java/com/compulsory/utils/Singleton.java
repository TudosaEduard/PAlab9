package com.compulsory.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Singleton {

    private static EntityManagerFactory entityManagerFactory;

    private Singleton(){}
    public static EntityManagerFactory getEntityManagerFactory(){
        if(entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("Laborator9");
        return entityManagerFactory;
    }
}
