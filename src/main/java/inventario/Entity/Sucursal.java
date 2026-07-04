package inventario.Entity;

import jakarta.persistence.*;

@Entity
@Table (name = "Sucursal")
public class Sucursal {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private Integer telefono;
    private Integer cantidadDePasteles;
    private Double renta;
    private Double gastoLuz;
    private Double gastoAgua;
    private Integer numeroDePersonal;

    //constructor vacio
    public Sucursal(){

    }
    // contructores

    public Sucursal(Long id, String nombre, String ubicacion, Integer telefono, Integer cantidadDePasteles, Double renta, Double gastoLuz, Double gastoAgua, Integer numeroDePersonal) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.cantidadDePasteles = cantidadDePasteles;
        this.renta = renta;
        this.gastoLuz = gastoLuz;
        this.gastoAgua = gastoAgua;
        this.numeroDePersonal = numeroDePersonal;
    }
    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Integer getCantidadDePasteles() {
        return cantidadDePasteles;
    }

    public void setCantidadDePasteles(Integer cantidadDePasteles) {
        this.cantidadDePasteles = cantidadDePasteles;
    }

    public Double getRenta() {
        return renta;
    }

    public void setRenta(Double renta) {
        this.renta = renta;
    }

    public Double getGastoLuz() {
        return gastoLuz;
    }

    public void setGastoLuz(Double gastoLuz) {
        this.gastoLuz = gastoLuz;
    }

    public Double getGastoAgua() {
        return gastoAgua;
    }

    public void setGastoAgua(Double gastoAgua) {
        this.gastoAgua = gastoAgua;
    }

    public Integer getNumeroDePersonal() {
        return numeroDePersonal;
    }

    public void setNumeroDePersonal(Integer numeroDePersonal) {
        this.numeroDePersonal = numeroDePersonal;
    }
}
