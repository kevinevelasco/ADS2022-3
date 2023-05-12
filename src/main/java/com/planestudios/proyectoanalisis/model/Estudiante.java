package com.planestudios.proyectoanalisis.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String id;
    private String numeroDocumento;
    private Float promedio;
    private String estadoAcademico;
    private List<RegistroAcademico> registrosAcademicos = new ArrayList<>();

    public Estudiante(String nombre, String apellido, String id, String numeroDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.numeroDocumento = numeroDocumento;
    }

    public void addRegistroAcademico (List<RegistroAcademico> registroAcademicos){
        registrosAcademicos.addAll(registroAcademicos);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Float getPromedio() {
        return promedio;
    }

    public void setPromedio(Float promedio) {
        this.promedio = promedio;
    }

    public String getEstadoAcademico() {
        return estadoAcademico;
    }

    public void setEstadoAcademico(String estadoAcademico) {
        this.estadoAcademico = estadoAcademico;
    }

    public List<RegistroAcademico> getRegistrosAcademicos() {
        return registrosAcademicos;
    }

    public void setRegistrosAcademicos(List<RegistroAcademico> registrosAcademicos) {
        this.registrosAcademicos = registrosAcademicos;
    }

    public RegistroAcademico obtenerInfoClase(Asignatura asignatura) {
        for(Clase cl:asignatura.getClases()){
            for(RegistroAcademico reg:this.registrosAcademicos){
                if(cl.getCodigoClase().equals(reg.getClase().getCodigoClase())){
                    return reg;
                }
            }
        }
        return null;
    }
    public float obtenerPromedio(List<Asignatura> asignaturas_plan_estudios){
        Integer creditos = 0;
        Float promedio = 0F;
        Float promedio_general = 0F;
        ManejadorArchivos manejadorArchivos = new ManejadorArchivos();
        manejadorArchivos.leerAsignaturas();
        manejadorArchivos.leerClases();
        manejadorArchivos.leerProfesores();
        manejadorArchivos.leerRegistroAcademico();
        List<Asignatura> asignaturas = new ArrayList<> (asignaturas_plan_estudios);
        for(int i = 0; i < registrosAcademicos.size(); i++) {
            for(Asignatura asig:asignaturas) {
                for(Clase clase: asig.getClases()) {
                    if(clase.getCodigoClase() == registrosAcademicos.get(i).getClase().getCodigoClase()) {
                        creditos+=asig.getNumeroCreditos();
                        promedio+=registrosAcademicos.get(i).getNota()*asig.getNumeroCreditos();
                    }
                }
            }
        }
        promedio_general = promedio/creditos;
        return promedio_general;
    }
    public float obtenerUltimoPromedio(List<Asignatura> asignaturas_plan_estudios){
        List<Clase> clasesUltimoSemestre = new ArrayList<>();
        Integer anioMayor = 0;
        Integer periodoAcademicoMayor = 0;
        Integer creditos = 0;
        Float promedio = 0F;
        ManejadorArchivos manejadorArchivos = new ManejadorArchivos();
        manejadorArchivos.leerAsignaturas();
        manejadorArchivos.leerClases();
        manejadorArchivos.leerProfesores();
        manejadorArchivos.leerRegistroAcademico();
        List<Asignatura> asignaturas = new ArrayList<> (asignaturas_plan_estudios);
        for(int i = 0; i < registrosAcademicos.size() ; i++){ //todas las clases que tengan el periodo academico mayor.
            if((anioMayor<registrosAcademicos.get(i).getClase().getAnio()) || (anioMayor==registrosAcademicos.get(i).getClase().getAnio() && periodoAcademicoMayor<registrosAcademicos.get(i).getClase().getPeriodoAcademico())) {
                periodoAcademicoMayor = registrosAcademicos.get(i).getClase().getPeriodoAcademico();
                anioMayor = registrosAcademicos.get(i).getClase().getAnio();
            }
        }
        for (RegistroAcademico registrosAcademico : registrosAcademicos) {
            if ((Objects.equals(registrosAcademico.getClase().getAnio(), anioMayor)) && (Objects.equals(registrosAcademico.getClase().getPeriodoAcademico(), periodoAcademicoMayor))) {
                clasesUltimoSemestre.add(registrosAcademico.getClase());
            }
        }
        for (Clase clase : clasesUltimoSemestre) {
            for (int b = 0; b < asignaturas.size(); b++) {
                for (int c = 0; c < asignaturas.get(b).getClases().size(); c++) {
                    if (clase.getCodigoClase().equals(asignaturas.get(b).getClases().get(c).getCodigoClase()))
                        creditos += asignaturas.get(b).getNumeroCreditos();
                }
            }
        }
        for(int a = 0; a < registrosAcademicos.size(); a++) {
            for (Clase clase : clasesUltimoSemestre) {
                for (int b = 0; b < asignaturas.size(); b++) {
                    for (int c = 0; c < asignaturas.get(b).getClases().size(); c++) {
                        if (clase.getCodigoClase().equals(asignaturas.get(b).getClases().get(c).getCodigoClase())) {
                            if (registrosAcademicos.get(a).getClase().getCodigoClase().equals(clase.getCodigoClase())){
                                promedio += (registrosAcademicos.get(a).getNota() * asignaturas.get(b).getNumeroCreditos())/creditos;
                            }
                        }
                    }
                }
            }
        }
        return promedio;
    }
}
