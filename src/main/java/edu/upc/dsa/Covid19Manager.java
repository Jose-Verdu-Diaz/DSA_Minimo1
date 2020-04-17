package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import java.util.ArrayList;
import java.util.HashMap;

public interface Covid19Manager {
    HashMap<String,Brote> hashMapBrotes();

    int getNumBrotes();

    int addBrote();
    Brote getBrote(String identificador);
    int setBrote(String identificador,Brote brote);

    int addCaso(String identificadorBrote, String nombre, String apellidos, String fechaNacimiento, String fechaInforme, String nivel,
                String genero, String correo, String telefono, String direccion, String clasificacion);
    Caso getCaso(String identificador);
    int setCaso(String identificador,Caso caso);

    HashMap<String,Brote> getHashMapBrotes();

    ArrayList<Caso> getListaCasosOrdenados(String identificadorBrote);

    void tearDown();
}
