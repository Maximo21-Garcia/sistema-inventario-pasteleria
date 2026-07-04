package inventario.Controller;

import inventario.Entity.Empleado;
import inventario.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/empleados")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService; // LLamamos al SERVICE

    //Ver todos los empleados
    @GetMapping
    public List<Empleado> listaEmpleados(){
        return empleadoService.obtenerTodosLosEmpleados();
    }
    //Registrar un nuevo empleado
    @PostMapping
    public Empleado registrarEmpleado(@RequestBody Empleado nuevoEmpleado){
        return empleadoService.guardarEmpleado(nuevoEmpleado);
    }
    //ELiminar Empleado
    @DeleteMapping ("/{id}")
    public String eliminarEmpleado(@PathVariable Long id){
        empleadoService.eliminarEmpleado(id);
        return "El empleado con Id: "+id+", fue eliminado de la base de datos";
    }
    //Editar Empleado
    @PutMapping ("/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Long id, @RequestBody Empleado empleadoDatosNuevos){
        try{
            Empleado empleadoModificado = empleadoService.editarEmpleado(id, empleadoDatosNuevos);
            return  ResponseEntity.ok(empleadoModificado);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}

//{
//        "nombre": "Maura",
//        "puesto": "Gerente",
//        "turno": "Matutino",
//        "horaEntrada": "08:00:00",
//        "sucursal": "universidad",
//        "sueldo": 2200
//        }