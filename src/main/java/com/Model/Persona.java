package com.Model;


import java.time.LocalDate;

public class Persona {
   private String name;
    private String semestre;
   private String asignatura;
   private String sede;
   private String salon;
   private String hora;
    private LocalDate fecha;

    //hh

    public Persona(String name, String semestre, String asignatura, String sede, String salon, String hora, LocalDate fecha) {
        this.name = name;
        this.semestre = semestre;
        this.asignatura = asignatura;
        this.sede = sede;
        this.salon = salon;
        this.hora = hora;
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public String getSede() {
        return sede;
    }

    public String getSalon() {
        return salon;
    }

    public String getHora() {
        return hora;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
