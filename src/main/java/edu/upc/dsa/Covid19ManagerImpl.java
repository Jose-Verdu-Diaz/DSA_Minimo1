package edu.upc.dsa;

import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

import org.apache.log4j.Logger;

import java.util.*;

import static edu.upc.dsa.util.RandomUtils.getId;


public class Covid19ManagerImpl implements Covid19Manager {

    private static Covid19Manager instance;
    private static HashMap<String,Brote> hashMapBrotes;
    private static Logger log = Logger.getLogger(Covid19ManagerImpl.class);

    private Covid19ManagerImpl(){
        this.hashMapBrotes = new HashMap<>();
    }

    public static Covid19Manager getInstance(){
        if(instance == null) {instance = new Covid19ManagerImpl();}
        return instance;
    }

    @Override
    public HashMap<String, Brote> hashMapBrotes() {
        return null;
    }

    @Override
    public int getNumBrotes() {
        return this.hashMapBrotes.size();
    }

    @Override
    public int addBrote() {
        try{
            String id = getId(this.hashMapBrotes.keySet()); //Generate NEW id
            Brote newBrote = new Brote(id);
            hashMapBrotes.put(id,newBrote);

            log.info("Nuevo brote añadido exitosamente: "+ newBrote);
            return 201;//CREATED
        }
        catch(Exception e){
            log.error("Unexpected Exception: "+ e.getMessage());
            return 500;//INTERNAL SERVER ERROR
        }
    }

    @Override
    public Brote getBrote(String identificador) {
        return null;
    }

    @Override
    public int setBrote(String identificador, Brote brote) {
        return 0;
    }

    @Override
    public int addCaso(String identificadorBrote, String nombre, String apellidos, String fechaNacimiento, String fechaInforme, String nivel,
                       String genero, String correo, String telefono, String direccion, String clasificacion) {

        if(nivel!="alto" && nivel!= "medio" && nivel!= "medio"){
            log.error("El nivel del caso no es válido: " + nivel);
            return 400;//BAD REQUEST
        }
        else if(genero!="M" && genero!= "F"){
            log.error("El género del caso no es válido: " + genero);
            return 400;//BAD REQUEST
        }
        else if(clasificacion!="sospechoso" && clasificacion!= "confirmado" && clasificacion!= "falso"){
            log.error("La clasificación del caso no es válida: " + clasificacion);
            return 400;//BAD REQUEST
        }

        try{
            String id = getId(); //Generate id
            Caso newCaso = new Caso(nombre,apellidos,id,fechaNacimiento,fechaInforme,nivel,genero,correo,telefono,direccion,clasificacion);
            hashMapBrotes.get(identificadorBrote).getArrayListCasos().add(newCaso);

            log.info("Nuevo caso añadido exitosamente: "+ newCaso);
            return 201;//CREATED
        }
        catch(Exception e){
            log.error("Unexpected Exception: "+ e.getMessage());
            return 500;//INTERNAL SERVER ERROR
        }
    }

    @Override
    public Caso getCaso(String identificador) {
        return null;
    }

    @Override
    public int setCaso(String identificador, Caso caso) {
        return 0;
    }

    @Override
    public HashMap<String,Brote> getHashMapBrotes() {
        log.info("Lista de brotes enviada con éxito: " + hashMapBrotes);
        return this.hashMapBrotes;
    }

    @Override
    public ArrayList<Caso> getListaCasosOrdenados(String identificadorBrote) {
        List<Caso> casosSospechosos=new ArrayList<>();
        List<Caso> casosConfirmados=new ArrayList<>();
        List<Caso> casosFalsos=new ArrayList<>();

        for (Caso c:hashMapBrotes().get(identificadorBrote).getArrayListCasos()) {
            switch (c.getClasificacion()) {
                case "sospechoso":
                    casosSospechosos.add(c);
                    break;

                case "confirmado":
                    casosConfirmados.add(c);
                    break;

                case "falso":
                    casosFalsos.add(c);
                    break;
            }
        }

        Collections.sort(casosSospechosos, new Comparator<Caso>() {
            @Override
            public int compare(final Caso object1, final Caso object2) {
                return object1.getFechaInforme().compareTo(object2.getFechaInforme());
            }
        });

        Collections.sort(casosConfirmados, new Comparator<Caso>() {
            @Override
            public int compare(final Caso object1, final Caso object2) {
                return object1.getFechaInforme().compareTo(object2.getFechaInforme());
            }
        });

        Collections.sort(casosFalsos, new Comparator<Caso>() {
            @Override
            public int compare(final Caso object1, final Caso object2) {
                return object1.getFechaInforme().compareTo(object2.getFechaInforme());
            }
        });

        ArrayList<Caso> listaResultado = new ArrayList<Caso>();
        listaResultado.addAll(casosSospechosos);
        listaResultado.addAll(casosConfirmados);
        listaResultado.addAll(casosFalsos);

        //Código inecesario para pasar la lista a string en el que he perdido demasiado tiempo :)
        /*String respuesta = "{";
        for (Caso c:listaResultado) {
            respuesta+="{";
            respuesta+="Nombre: "+ c.getNombre() + " | ";
            respuesta+="Apellidos: "+ c.getApellidos() + " | ";
            respuesta+="Identificador: "+ c.getIdentificador() + " | ";
            respuesta+="Fecha de Nacimiento: "+ c.getFechaNacimiento() + " | ";
            respuesta+="Fecha de Informe: "+ c.getFechaInforme() + " | ";
            respuesta+="Nivel: "+ c.getNivel() + " | ";
            respuesta+="Género: "+ c.getGenero() + " | ";
            respuesta+="Correo: "+ c.getCorreo() + " | ";
            respuesta+="Teléfono: "+ c.getTelefono() + " | ";
            respuesta+="Dirección: "+ c.getDireccion() + " | ";
            respuesta+="Clasificación: "+ c.getClasificacion() + "}";

            //Caso NO final
            if(c.getIdentificador() != listaResultado.get(listaResultado.size()-1).getIdentificador()){
                respuesta+=" , ";
            }
        }
        respuesta+="}";
        return respuesta;*/

        return listaResultado;
    }

    @Override
    public void tearDown(){
        this.hashMapBrotes.clear();
    }
}
