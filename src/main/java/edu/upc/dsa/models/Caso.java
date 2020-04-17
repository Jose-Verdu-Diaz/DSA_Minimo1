package edu.upc.dsa.models;

public class Caso {
    private String nombre;
    private String apellidos;
    private String identificador;
    private String fechaNacimiento;
    private String fechaInforme;
    private String nivel;//Alto, medio o bajo
    private String genero;//M o F
    private String correo;
    private String telefono;
    private String direccion;
    private String clasificacion;//sospechoso, confirmado o falso

    public Caso(){
        this.nombre=null;
        this.apellidos=null;
        this.identificador=null;
        this.fechaNacimiento=null;
        this.fechaInforme=null;
        this.nivel=null;
        this.genero=null;
        this.correo=null;
        this.telefono=null;
        this.direccion=null;
        this.clasificacion=null;
    }

    public Caso(String nombre, String apellidos, String identificador, String fechaNacimiento, String fechaInforme, String nivel,
                String genero, String correo, String telefono, String direccion, String clasificacion){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.identificador=identificador;
        this.fechaNacimiento=fechaNacimiento;
        this.fechaInforme=fechaInforme;
        this.nivel=nivel;
        this.genero=genero;
        this.correo=correo;
        this.telefono=telefono;
        this.direccion=direccion;
        this.clasificacion=clasificacion;
    }

    public String getNombre(){return this.nombre;}
    public void setNombre(String nombre){this.nombre=nombre;}

    public String getApellidos(){return this.apellidos;}
    public void setApellidos(String apellidos){this.apellidos=apellidos;}

    public String getIdentificador(){return this.identificador;}
    public void setIdentificador(String id){this.identificador=id;}

    public String getFechaNacimiento(){return this.fechaNacimiento;}
    public void setFechaNacimiento(String fechaNacimiento){this.fechaNacimiento=fechaNacimiento;}

    public String getFechaInforme(){return this.fechaInforme;}
    public void setFechaInforme(String fechaInforme){this.fechaInforme=fechaInforme;}

    public String getNivel(){return this.nivel;}
    public void setNivel(String nivel){this.nivel=nivel;}

    public String getGenero(){return this.genero;}
    public void setGenero(String genero){this.genero=genero;}

    public String getCorreo(){return this.correo;}
    public void setCorreo(String correo){this.correo=correo;}

    public String getTelefono(){return this.telefono;}
    public void setTelefono(String telefono){this.telefono=telefono;}

    public String getDireccion(){return this.direccion;}
    public void setDireccion(String direccion){this.direccion=direccion;}

    public String getClasificacion(){return this.clasificacion;}
    public void setClasificacion(String clasificacion){this.clasificacion=clasificacion;}
}
