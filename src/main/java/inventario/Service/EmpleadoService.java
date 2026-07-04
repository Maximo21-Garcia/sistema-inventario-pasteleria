package inventario.Service;

import inventario.Entity.Empleado;
import inventario.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
     private EmpleadoRepository empleadoRepository; //llamamos al repositorio

    // Todos los empleados
    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoRepository.findAll();
    }
    //Registrar Empleado
    public Empleado guardarEmpleado(Empleado empleado){
        //aqui va la logica de la hora de entrada y la hora de salida turno = 8hrs
        if(empleado.getHoraEntrada() != null && empleado.getHoraSalida() == null){
            LocalTime  calculoSalida = empleado.getHoraEntrada().plusHours(8);
            empleado.setHoraSalida(calculoSalida);
        }
        return empleadoRepository.save(empleado);
    }
    //ELiminar Empleado
    public Empleado eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
        return null;
    }
    //Editar Empleado
    public Empleado editarEmpleado(Long id, Empleado empleadoActualizado){
        return empleadoRepository.findById(id).map(empleadoExistente ->{
            empleadoExistente.setNombre(empleadoActualizado.getNombre());
            empleadoExistente.setPuesto(empleadoActualizado.getPuesto());
            empleadoExistente.setTurno(empleadoActualizado.getTurno());
            empleadoExistente.setHoraEntrada(empleadoActualizado.getHoraEntrada());
            empleadoExistente.setHoraSalida(empleadoActualizado.getHoraSalida());
            empleadoExistente.setSucursal(empleadoActualizado.getSucursal());
            empleadoExistente.setSueldo(empleadoActualizado.getSueldo());
            return empleadoRepository.save(empleadoExistente);
        }).orElseThrow(()-> new RuntimeException("No se encontro el Empleado con el ID: "+id));
    }
}
