package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Caso;
import edu.upc.dsa.models.Brote;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

@Api(value = "/game", description = "Endpoint to Game Service")
@Path("/game")
public class Covid19Service {

    static final Logger logger = Logger.getLogger(Covid19Manager.class);
    private Covid19Manager manager;

    public Covid19Service() {
        PropertyConfigurator.configure("src/main/resources/log4j.properties");

        this.manager = Covid19ManagerImpl.getInstance();

        if (this.manager.getNumBrotes() == 0) {
         //Do Something
        }
    }

    @POST
    @ApiOperation(value = "Crear Nuevo Brote", notes = "Add a new user providing and id and a name")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "brote añadido exitosamente", response= Brote.class),
            @ApiResponse(code = 500, message = "Error inesperado en el servidor")
    })
    @Path("/addBrote")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newBrote() {
        this.manager.addBrote();
        return Response.status(201).build();
    }

    @GET
    @ApiOperation(value = "Obtener Brotes", notes = "Obtener  una lista de los brotes")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful", response = Brote.class),
            @ApiResponse(code = 500, message = "Error interno en el servidor")
    })
    @Path("/getHashMapBrotes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHashMapBrotes() {

        HashMap<String,Brote> hashMapBrotes= this.manager.getHashMapBrotes();

        //Código inecesario para pasar el hash map a string en el que he perdido demasiado tiempo :)
        /*
        String respuesta="{";
        for (Brote b: hashMapBrotes.values()) {
            respuesta+="{Brote: " + b.getIdentificador() + " | Casos: {";
            for (Caso c:b.getArrayListCasos()) {
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
                if(c.getIdentificador() != b.getArrayListCasos().get(b.getArrayListCasos().size()-1).getIdentificador()){
                    respuesta+=" , ";
                }
            }
            respuesta+="}}";

            //Caso NO final
            if(b.getIdentificador() != hashMapBrotes.get(hashMapBrotes.size()-1).getIdentificador()){
                respuesta+=" , ";
            }
        }
        respuesta+="}";*/

        return Response.status(201).entity(hashMapBrotes).build();
    }

    @POST
    @ApiOperation(value = "Crear Nuevo Caso", notes = "nivel:(Alto, medio o bajo), genero:(M o F), clasificacion:(sospechoso, confirmado o falso)")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Caso añadido exitosamente", response= Caso.class),
            @ApiResponse(code = 500, message = "Error inesperado en el servidor")
    })
    @Path("/addBrote/identificadorBrote/nombre/apellidos/fechaNacimiento/fechaInforme/nivel/genero/correo/telefono/direccion/clasificacion")
    @Produces(MediaType.APPLICATION_JSON)
    public Response newCaso(@PathParam("identificadorBrote") String identificadorBrote,@PathParam("nombre") String nombre,@PathParam("apellidos") String apellidos,
                            @PathParam("fechaNacimiento") String fechaNacimiento,@PathParam("fechaInforme") String fechaInforme,
                            @PathParam("nivel") String nivel, @PathParam("genero") String genero,
                            @PathParam("correo") String correo,@PathParam("telefono") String telefono,
                            @PathParam("direccion") String direccion,@PathParam("clasificacion") String clasificacion) {
        this.manager.addCaso(identificadorBrote,nombre,apellidos,fechaNacimiento,fechaInforme,nivel,genero,correo,telefono,direccion,clasificacion);
        return Response.status(201).build();
    }
}
