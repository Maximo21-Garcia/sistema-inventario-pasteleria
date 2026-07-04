package inventario.Controller;

import inventario.Entity.Sucursal;
import inventario.Service.SucursalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/sucursal")
public class SucursalController {
    @Autowired
    private SucursalService sucursalService;

    //Ver las lista de sucursales
    @GetMapping
    public List<Sucursal> listaSucursales(){
        return sucursalService.obtenerTodasLasSucursales();
    }

    //Registrar una Sucursal
    @PostMapping
    public Sucursal crearSucursal(@RequestBody Sucursal nuevaSucursal){
        return sucursalService.guardarSucursal(nuevaSucursal);
    }

    //Eliminar Sucursal
    @DeleteMapping ("/{id}")
    public String eliminarSucursal(@PathVariable Long id){
        sucursalService.eliminarSucursal(id);
        return "La sucursal ID: "+ id +" fue eliminada";
    }

    //Editar Inforacion de Sucursal
    @PutMapping ("/{id}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Long id, @RequestBody Sucursal sucursalDatosNuevos){
        try{
            Sucursal sucursalModificado = sucursalService.editarSucursal(id, sucursalDatosNuevos);
            return  ResponseEntity.ok(sucursalModificado);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
