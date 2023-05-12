package com.planestudios.proyectoanalisis.model;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ManejadorArchivos {

    private List<Asignatura> asignaturasPlanEstudios = new ArrayList<>();
    private List<Asignatura> electivas = new ArrayList<>();
    private List<Profesor> profesores = new ArrayList<>();

    private List<RegistroAcademico> registroAcademicos = new ArrayList<>();
    public void leerAsignaturas(){
        try{

            FileReader fr = new FileReader("src\\main\\resources\\com\\planestudios\\proyectoanalisis\\csv_files\\asignaturas.csv");
            CSVFormat csvFormat = CSVFormat.newFormat(';');
            CSVParser entrada = new CSVParser(fr, csvFormat.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> filas = entrada.getRecords();
            for (CSVRecord f: filas) {
                String codigoAsignatura = f.get("codigoAsignatura");
                String nombre = f.get("nombre");
                String tipoDeArea = f.get("tipoDeArea");
                String numeroCreditos = f.get("numeroCreditos");
                String prereq = f.get("prereq");
                String coreq = f.get("coreq");

                if(prereq.isEmpty() && coreq.isEmpty()){
                    Asignatura asignatura = new Asignatura(codigoAsignatura, nombre, tipoDeArea, Integer.parseInt(numeroCreditos));
                    asignaturasPlanEstudios.add(asignatura);
                } else if(prereq.length() > 0 && coreq.isEmpty()){
                String[] prereqSeparados = prereq.split("-");
                    Asignatura asignatura = new Asignatura(codigoAsignatura, nombre, tipoDeArea, Integer.parseInt(numeroCreditos));
                for(int i = 0; i < prereqSeparados.length; i++){
                    for(int j = 0; j < asignaturasPlanEstudios.size(); j++) {
                        if (prereqSeparados[i].equals(asignaturasPlanEstudios.get(j).getCodigoAsignatura())){
                            asignatura.prerequerimientos(asignaturasPlanEstudios.get(j));
                            break;
                        }
                    }
                }
                asignaturasPlanEstudios.add(asignatura);
                } else if (prereq.length() > 0 && coreq.length() > 0){
                    String[] prereqSeparados = prereq.split("-");
                    String[] coreqSeparados = coreq.split("-");
                    Asignatura asignatura = new Asignatura(codigoAsignatura, nombre, tipoDeArea, Integer.parseInt(numeroCreditos));
                    for(int i = 0; i < prereqSeparados.length; i++){
                        for(int j = 0; j < asignaturasPlanEstudios.size(); j++) {
                            if (prereqSeparados[i].equals(asignaturasPlanEstudios.get(j).getCodigoAsignatura())){
                                asignatura.prerequerimientos(asignaturasPlanEstudios.get(j));
                                break;
                            }
                        }
                    }
                    for(int a = 0; a < coreqSeparados.length; a++){
                        for(int b = 0; b < asignaturasPlanEstudios.size(); b++) {
                            if (coreqSeparados[a].equals(asignaturasPlanEstudios.get(b).getCodigoAsignatura())){
                                asignatura.coprerequerimientos(asignaturasPlanEstudios.get(b));
                                break;
                            }
                        }
                    }
                    asignaturasPlanEstudios.add(asignatura);
                }
            }
    entrada.close();
            leerElectivas();
    } catch(IOException e){
            System.out.println("Error al leer el archivo .csv:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void leerClases(){
        try {
            FileReader fr = new FileReader("src\\main\\resources\\com\\planestudios\\proyectoanalisis\\csv_files\\clases.csv");
            CSVFormat csvFormat = CSVFormat.newFormat(';');
            CSVParser entrada = new CSVParser(fr, csvFormat.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> filas = entrada.getRecords();
            System.out.println("\n\n\n");
            for (CSVRecord f: filas) {
                String codigoAsignatura = f.get("codigoAsignatura");
                String codigoClase = f.get("codigoClase");
                String cupo = f.get("cupo");
                String anio = f.get("anio");
                String periodoAcademico = f.get("periodoAcademico");
                String nombre = f.get("nombre");
                Clase clase = new Clase(codigoClase, nombre, Integer.parseInt(cupo), Integer.parseInt(anio), Integer.parseInt(periodoAcademico));
                    for(int i = 0; i < asignaturasPlanEstudios.size(); i++){
                            if (codigoAsignatura.equals(asignaturasPlanEstudios.get(i).getCodigoAsignatura())) { //si en las clases que vi está el código de la Asignatura, pues que le agregue al objeto Asignatura su clase
                                asignaturasPlanEstudios.get(i).agregarClase(clase);
                                break;
                            } else {
                             for (int j = 0; j < electivas.size(); j++) { //si el código de Asignatura que está ahí no está en el plan de estudios, que revise en las materias que son electivas
                                    for(Asignatura asignaturasPlanEstudios: asignaturasPlanEstudios){
                                        if(asignaturasPlanEstudios.getTipoDeArea().equals("Electiva") && asignaturasPlanEstudios.getNombre().equals("null")){
                                            asignaturasPlanEstudios.setCodigoAsignatura(electivas.get(j).getCodigoAsignatura()); //estos if lo que hacen es cambiar el null de las electivas del plan
                                            asignaturasPlanEstudios.setNombre(electivas.get(j).getNombre());                     //de estudios principal, poniendole sus correspondientes atributos, pues
                                            asignaturasPlanEstudios.setNumeroCreditos(electivas.get(j).getNumeroCreditos());    // las características deben ser según las electivas.
                                            asignaturasPlanEstudios.agregarClase(clase);
                                            break;
                                        }
                                    }
                            }
                       }
                }
                System.out.println("Clase{" +
                        "codigoAsignatura='" + codigoAsignatura + '\'' +
                        ", codigoClase='" + codigoClase + '\'' +
                        ", nombre='" + nombre+ '\'' +
                        ", cupo=" + cupo + '\'' +
                        ", anio=" + anio + '\'' +
                        ", periodoAcademico=" + periodoAcademico +
                        '}');
            }



        }catch(IOException e){
            System.out.println("Error al leer el archivo .csv:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void leerElectivas(){
        try{
            FileReader f = new FileReader("src\\main\\resources\\com\\planestudios\\proyectoanalisis\\csv_files\\electivas.csv");
            CSVFormat csvFormat = CSVFormat.newFormat(';');
            CSVParser in =  new CSVParser(f, csvFormat.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> filasElectivas = in.getRecords();
            for (CSVRecord csvRecord: filasElectivas) {
                String codigoAsignatura = csvRecord.get("codigoAsignatura");
                String nombre = csvRecord.get("nombre");
                String tipoDeArea = csvRecord.get("tipoDeArea");
                String numeroCreditos = csvRecord.get("numeroCreditos");
                String prereq = csvRecord.get("prereq");
                String coreq = csvRecord.get("coreq");
                Asignatura electiva = new Asignatura(codigoAsignatura, nombre, tipoDeArea, Integer.parseInt(numeroCreditos));
                electivas.add(electiva);

                System.out.println("Electivas{" +
                        "codigoAsignatura='" + codigoAsignatura + '\'' +
                        ", nombre='" + nombre + '\'' +
                        ", tipoDeArea='" + tipoDeArea+ '\'' +
                        ", numeroCreditos=" + numeroCreditos + '\'' +
                        ", prereq=" + prereq + '\'' +
                        ", coreq=" + coreq +
                        '}');
            }
        }catch(IOException e){
            System.out.println("Error al leer el archivo .csv:" + e.getMessage());
            e.printStackTrace();
        }
    }
    public void imprimirEnPantalla(){
        System.out.println("\n\n\n");
        for (int i =0; i< asignaturasPlanEstudios.size(); i++) {
          //  for (int a = 0; a < asignaturasPlanEstudios.get(i).getClases().size(); a++) {
                if (asignaturasPlanEstudios.get(i).getPrerequisitos().size() == 0 && asignaturasPlanEstudios.get(i).getCorequisitos().size() == 0) {
                    System.out.println("Asignatura{" +
                            "codigoAsignatura='" + asignaturasPlanEstudios.get(i).getCodigoAsignatura() + '\'' +
                            ", nombre='" + asignaturasPlanEstudios.get(i).getNombre() + '\'' +
                            ", tipoDeArea='" + asignaturasPlanEstudios.get(i).getTipoDeCredito() + '\'' +
                            ", numeroCreditos=" + asignaturasPlanEstudios.get(i).getNumeroCreditos() + '\'' +
                            //", clases=" + asignaturasPlanEstudios.get(i).getClases().get(a).getCodigoClase() + '\'' +
                            ", prerequisitos=" + asignaturasPlanEstudios.get(i).getPrerequisitos().size() + '\'' +
                            ", corequisitos=" + asignaturasPlanEstudios.get(i).getCorequisitos().size() +
                            '}');
                } else if (asignaturasPlanEstudios.get(i).getPrerequisitos().size() > 0 && asignaturasPlanEstudios.get(i).getCorequisitos().size() == 0) {
                    for (int j = 0; j < asignaturasPlanEstudios.get(i).getPrerequisitos().size(); j++) {
                        System.out.println("Asignatura{" +
                                "codigoAsignatura='" + asignaturasPlanEstudios.get(i).getCodigoAsignatura() + '\'' +
                                ", nombre='" + asignaturasPlanEstudios.get(i).getNombre() + '\'' +
                                ", tipoDeArea='" + asignaturasPlanEstudios.get(i).getTipoDeCredito() + '\'' +
                                ", numeroCreditos=" + asignaturasPlanEstudios.get(i).getNumeroCreditos() + '\'' +
                               // ", clases=" + asignaturasPlanEstudios.get(i).getClases().get(a).getCodigoClase() + '\'' +
                                ", prerequisitos=" + asignaturasPlanEstudios.get(i).getPrerequisitos().get(j).getCodigoAsignatura() + '\'' +
                                ", corequisitos=" + asignaturasPlanEstudios.get(i).getCorequisitos().size() +
                                '}');
                    }
                } else if (asignaturasPlanEstudios.get(i).getPrerequisitos().size() > 0 && asignaturasPlanEstudios.get(i).getCorequisitos().size() > 0) {
                    for (int j = 0; j < asignaturasPlanEstudios.get(i).getPrerequisitos().size(); j++) {
                        for (int k = 0; k < asignaturasPlanEstudios.get(i).getCorequisitos().size(); k++) {
                            System.out.println("Asignatura{" +
                                    "codigoAsignatura='" + asignaturasPlanEstudios.get(i).getCodigoAsignatura() + '\'' +
                                    ", nombre='" + asignaturasPlanEstudios.get(i).getNombre() + '\'' +
                                    ", tipoDeArea='" + asignaturasPlanEstudios.get(i).getTipoDeCredito() + '\'' +
                                    ", numeroCreditos=" + asignaturasPlanEstudios.get(i).getNumeroCreditos() + '\'' +
                                    //", clases=" + asignaturasPlanEstudios.get(i).getClases().get(a).getCodigoClase() + '\'' +
                                    ", prerequisitos=" + asignaturasPlanEstudios.get(i).getPrerequisitos().get(j).getCodigoAsignatura() + '\'' +
                                    ", corequisitos=" + asignaturasPlanEstudios.get(i).getCorequisitos().get(k).getCodigoAsignatura() +
                                    '}');
                        }
                    }
                }
           // }
        }
    }

    public void leerProfesores(){
        try{
            FileReader f = new FileReader("src\\main\\resources\\com\\planestudios\\proyectoanalisis\\csv_files\\profesores.csv");
            CSVFormat csvFormat = CSVFormat.newFormat(';');
            CSVParser in =  new CSVParser(f, csvFormat.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> filas = in.getRecords();
            System.out.println("\n\n\n");
            for (CSVRecord csvRecord: filas) {
                String nombre = csvRecord.get("nombre");
                String apellido = csvRecord.get("apellido");
                String id = csvRecord.get("id");
                String numeroDocumento = csvRecord.get("numeroDocumento");
                String tipoProfesor = csvRecord.get("tipoProfesor");
                String codigoClase = csvRecord.get("codigoClase");
                Profesor profesor = new Profesor(nombre, apellido, id, numeroDocumento, tipoProfesor);
                    for (int i = 0; i < asignaturasPlanEstudios.size(); i++) {
                        for (int j = 0; j < asignaturasPlanEstudios.get(i).getClases().size(); j++) {
                            if(codigoClase.equals(asignaturasPlanEstudios.get(i).getClases().get(j).getCodigoClase())){
                                profesor.agregarClase(asignaturasPlanEstudios.get(i).getClases().get(j)); //agregarle la clase al profesor
                                asignaturasPlanEstudios.get(i).getClases().get(j).agregarProfesor(profesor); //agregarle el profesor a la clase
                                break;
                            }
                        }
                    }
                profesores.add(profesor);
                System.out.println("Profesores{" +
                        "nombre='" + nombre + '\'' +
                        ", apellido='" + apellido + '\'' +
                        ", id='" + id+ '\'' +
                        ", numeroDocumento=" + numeroDocumento + '\'' +
                        ", tipoProfesor=" + tipoProfesor + '\'' +
                        ", codigoClase=" + codigoClase +
                        '}');
            }

        }catch(IOException e){
            System.out.println("Error al leer el archivo .csv:" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void leerRegistroAcademico(){
        try{
            FileReader f = new FileReader("src\\main\\resources\\com\\planestudios\\proyectoanalisis\\csv_files\\registro.csv");
            CSVFormat csvFormat = CSVFormat.newFormat(';');
            CSVParser in =  new CSVParser(f, csvFormat.withFirstRecordAsHeader().withIgnoreHeaderCase());
            List<CSVRecord> filas = in.getRecords();
            System.out.println("\n\n\n");
            for (CSVRecord csvRecord: filas) {
                String codigoAsignatura = csvRecord.get("codigoAsignatura");
                String codigoClase = csvRecord.get("codigoClase");
                String nota = csvRecord.get("nota");
                for (int i = 0; i < asignaturasPlanEstudios.size(); i++) {
                    for (int j = 0; j < asignaturasPlanEstudios.get(i).getClases().size(); j++) {
                        if(codigoClase.equals(asignaturasPlanEstudios.get(i).getClases().get(j).getCodigoClase())){
                            RegistroAcademico registroAcademico = new RegistroAcademico(Float.parseFloat(nota), asignaturasPlanEstudios.get(i).getClases().get(j));
                            registroAcademicos.add(registroAcademico);
                            break;
                        }
                    }
                }

                System.out.println("RegistroAcademico{" +
                        "codigoAsignatura='" + codigoAsignatura + '\'' +
                        ", codigoClase='" + codigoClase + '\'' +
                        ", nota" + nota +
                        '}');
            }

        }catch(IOException e){
            System.out.println("Error al leer el archivo .csv:" + e.getMessage());
            e.printStackTrace();
        }
    }
    public Estudiante asignarRegistro(){
        Estudiante estudiante = new Estudiante("Kevin", "Velasco", "0027", "1011");
        estudiante.addRegistroAcademico(registroAcademicos);
        estudiante.toString();
        return estudiante;
    }
    public List<Asignatura> getAsignaturas(){
        return this.asignaturasPlanEstudios;
    }
    public List<Asignatura> getElectivas(){
        return this.electivas;
    }
    public List<Profesor> getProfesores(){
        return this.profesores;
    }
    public List<RegistroAcademico> getRegistro(){
        return this.registroAcademicos;
    }
    }


