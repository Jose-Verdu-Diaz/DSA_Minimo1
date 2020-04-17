package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.HashMap;

public class Brote {
    private String identificador;
    private ArrayList<Caso> arrayListCasos;

    public Brote(){
        this.identificador=null;
        this.arrayListCasos=new ArrayList<>();
    }

    public Brote(String identificador,  ArrayList<Caso> arrayListCasos){
        this.identificador=identificador;
        this.arrayListCasos=arrayListCasos;
    }

    public Brote(String identificador){
        this.identificador=identificador;
        this.arrayListCasos=new ArrayList<>();
    }

    public String getIdentificador(){return this.identificador;}
    public void setIdentificador(String identificador){this.identificador=identificador;}

    public ArrayList<Caso> getArrayListCasos(){return this.arrayListCasos;}
    public void setArrayListCasos(ArrayList<Caso> arrayListCasos){this.arrayListCasos=arrayListCasos;}
}
