/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicio1ad2023;

/**
 *
 * @author LuisGutiérrezChamizo
 */


import controller.AlumnoDAO;
import model.Alumno;
public class Main {

public static void main(String[] args) {
    
    
    AlumnoDAO dao = new AlumnoDAO();
    
    Alumno alumno1 = new Alumno(null, "Juan", "111111111", "juan@email.com", 9.0, 8.0);
    dao.insertarAlumno(alumno1);
    
    Alumno alumno2 = new Alumno(null, "Ana", "222222222", "ana@email.com", 7.5, 6.0);
    dao.insertarAlumno(alumno2);
    
    Alumno alumno3 = new Alumno(null, "Pedro", "333333333", "pedro@email.com", 6.0, 5.5);
    dao.insertarAlumno(alumno3);
    
    Alumno alumno4 = new Alumno(null, "Sara", "444444444", "sara@email.com", 8.5, 4.0);
    dao.insertarAlumno(alumno4);
    
    Alumno alumno5 = new Alumno(null, "Marta", "555555555", "marta@email.com", 9.0, 9.5);
    dao.insertarAlumno(alumno5);
    
    dao.listarTodo();
    dao.listarSuspensos();
    
    dao.estadisticas();
    
    dao.closeEntityManager();
}
}