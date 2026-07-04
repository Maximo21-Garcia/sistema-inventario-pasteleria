package inventario.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity // Le decimos que esta clase va hacer un ENTITY o sea , se va a convertir una tabla en MYSQL
@Table(name = "Pastel") //La tabla se va a llamar "Pastel"

public class Pastel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoBarras;
    private String nombre;
    private LocalDate fechaFabricacion;
    private Integer diasVidaUtil;
    private LocalDate fechaCaducidad;
    private Double precio;
    private String medida;

    public Pastel(){
        // Este es un constructor vacio para que Spring funcione
    }
    //Contructor con parametros


    public Pastel(Long id, String codigoBarras, String nombre, LocalDate fechaFabricacion, Integer diasVidaUtil, LocalDate fechaCaducidad, Double precio, String medida) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.nombre = nombre;
        this.fechaFabricacion = fechaFabricacion;
        this.diasVidaUtil = diasVidaUtil;
        this.fechaCaducidad = fechaCaducidad;
        this.precio = precio;
        this.medida = medida;
    }

    //Getter y Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Integer getDiasVidaUtil() {
        return diasVidaUtil;
    }

    public void setDiasVidaUtil(Integer diasVidaUtil) {
        this.diasVidaUtil = diasVidaUtil;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
