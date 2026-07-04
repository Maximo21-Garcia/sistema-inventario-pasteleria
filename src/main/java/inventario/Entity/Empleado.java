package inventario.Entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String puesto;
    private String turno;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private String sucursal;
    private Double sueldo;

    public Empleado(){
        // constructor vacio para que SpringBoot funcione
    }

    // Constructores

    public Empleado(Long id, String nombre, String puesto, String turno, LocalTime horaEntrada, LocalTime horaSalida, String sucursal, Double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.turno = turno;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.sucursal = sucursal;
        this.sueldo = sueldo;
    }
    // Getters and Setters


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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }
}
