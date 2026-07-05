package inventario.Service;

import com.fasterxml.jackson.annotation.OptBoolean;
import inventario.Entity.Sucursal;
import inventario.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository; //Llamamos al repository

        //Traer todas las sucursales

    public List<Sucursal> obtenerTodasLasSucursales(){
        return sucursalRepository.findAll();
    }
    //Mostrar Sucursal
    public Optional<Sucursal> buscarPorId(Long id){
        return sucursalRepository.findById(id);
    }

    //Guardar una sucursal
    public Sucursal guardarSucursal (Sucursal sucursal){
        return sucursalRepository.save(sucursal);
    }
    //Eliminar Sucursal
    public Sucursal eliminarSucursal(Long id){
        sucursalRepository.deleteById(id);
        return null;
    }
    //Editar informacion de una Sucursal
    public Sucursal editarSucursal(Long id, Sucursal sucursalActualizada){
        return sucursalRepository.findById(id).map(sucursalExistente ->{
            sucursalExistente.setNombre(sucursalActualizada.getNombre());
            sucursalExistente.setUbicacion(sucursalActualizada.getUbicacion());
            sucursalExistente.setTelefono(sucursalActualizada.getTelefono());
            sucursalExistente.setCantidadDePasteles(sucursalActualizada.getCantidadDePasteles());
            sucursalExistente.setRenta(sucursalActualizada.getRenta());
            sucursalExistente.setGastoLuz(sucursalActualizada.getGastoLuz());
            sucursalExistente.setGastoAgua(sucursalActualizada.getGastoAgua());
            sucursalExistente.setNumeroDePersonal(sucursalActualizada.getNumeroDePersonal());
            return sucursalRepository.save(sucursalExistente);
        }).orElseThrow(()-> new RuntimeException("No se encontro la sucursal ID: "+id));
    }
}
