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
    
    Alumno alumno1 = new Alumno(null, "Pepita", "111111111", "pepita@email.com", 9.0, 8.0);
    dao.insertarAlumno(alumno1);
    
    Alumno alumno2 = new Alumno(null, "Rosita", "222222222", "rosita@email.com", 7.5, 6.0);
    dao.insertarAlumno(alumno2);
    
    Alumno alumno3 = new Alumno(null, "Hermina", "333333333", "hermina@email.com", 6.0, 5.5);
    dao.insertarAlumno(alumno3);
    
    Alumno alumno4 = new Alumno(null, "Aurelia", "444444444", "aurelia@email.com", 8.5, 4.0);
    dao.insertarAlumno(alumno4);
    
    Alumno alumno5 = new Alumno(null, "Anastasia", "555555555", "anastasia@email.com", 9.0, 9.5);
    dao.insertarAlumno(alumno5);
    
    dao.listarTodo();
    dao.listarSuspensos();
    
    dao.estadisticas();
    
    dao.closeEntityManager();
}
}
