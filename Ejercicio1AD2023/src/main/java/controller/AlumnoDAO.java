/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author LuisGutiérrezChamizo
 * 
 * 
 * 
 */

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Alumno;

public class AlumnoDAO {

    private final EntityManagerFactory emf;
    private final EntityManager em;

    public AlumnoDAO() {
        this.emf = Persistence.createEntityManagerFactory("data1.odb");
        this.em = emf.createEntityManager();
    }

    public void insertarAlumno(Alumno alumno) {
        try {
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println(ex.getMessage());
        }
    }

    public void listarTodo() {
        Query query = em.createQuery("SELECT a FROM Alumno a");
        List<Alumno> alumnos = query.getResultList();
        System.out.println("Listado completo de alumnos:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }

    public void listarSuspensos() {
        Query query = em.createQuery("SELECT a FROM Alumno a WHERE a.NotaAD < 5 OR a.NotaDI < 5");
        List<Alumno> alumnos = query.getResultList();
        System.out.println("Listado de alumnos con al menos un módulo suspenso:");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
    }

    public void estadisticas() {
        Query queryAD = em.createQuery("SELECT AVG(a.NotaAD) FROM Alumno a");
        Query queryDI = em.createQuery("SELECT AVG(a.NotaDI) FROM Alumno a");
        Query queryAprobados = em.createQuery("SELECT COUNT(a) FROM Alumno a WHERE a.NotaAD >= 5 AND a.NotaDI >= 5");

        Double mediaAD = (Double) queryAD.getSingleResult();
        Double mediaDI = (Double) queryDI.getSingleResult();
        Long aprobados = (Long) queryAprobados.getSingleResult();
        Long totalAlumnos = (Long) em.createQuery("SELECT COUNT(a) FROM Alumno a").getSingleResult();
        Long suspensos = totalAlumnos - aprobados;

        System.out.println("Resumen estadístico del curso:");
        System.out.println("Nota media en Acceso a Datos: " + mediaAD);
        System.out.println("Nota media en Diseño de Interfaces: " + mediaDI);
        System.out.println("Ratio de aprobados: " + (double) aprobados / totalAlumnos);
        System.out.println("Número de suspensos: " + suspensos);
    }

    public void closeEntityManager() {
        em.close();
        emf.close();
    }
}