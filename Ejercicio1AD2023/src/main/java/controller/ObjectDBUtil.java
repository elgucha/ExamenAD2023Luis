/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {
    
    private static EntityManagerFactory entityManagerFactory;
    static{
        try{
            entityManagerFactory = Persistence.createEntityManagerFactory("data1.odb");
            System.out.println("Conexión realizada con exito");
        }catch(Exception ex){
            System.out.println("Hubo error al iniciar en entityManager");
            System.out.println(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
