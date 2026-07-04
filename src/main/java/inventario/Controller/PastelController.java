package inventario.Controller;

import inventario.Entity.Pastel;
import inventario.Service.PastelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // indicamos que este es el CONTROLLER
@RequestMapping ("/api/pasteles") // La dirección base en internet: http://localhost:8080/api/pasteles
public class PastelController {

    @Autowired
    private PastelService pastelService; // El CONTROLLER llama al SERVICE

    //Endpoint 1: ver todo el inventario (para esto se usa la peticion GET)

    @GetMapping
    public List<Pastel> listarPasteles(){
        return pastelService.obtenerTodosLosPasteles();
    }

    // Endpoint 2: Ver solo lo que ya caducó (Petición GET a /vencidos)
    @GetMapping ("/vencidos")
    public List<Pastel> listarVencidos(){
        return pastelService.obtenerPastelesVencidos();
    }

    // Endpoint 3: Cocinar/Crear un nuevo pastel (Petición POST)
    @PostMapping
    public Pastel crearPastel(@RequestBody Pastel nuevoPastel){
        return pastelService.guardaPastel(nuevoPastel);
    }

    //Endpoint 4: Eliminar pasteles
    @DeleteMapping ("/{id}")
    public String eliminarPastel(@PathVariable Long id){
        pastelService.eliminarPastel(id);
        return "El pastel con ID " + id + " fue eliminado correctamente";
    }
    //Endpoint 5: Edicio de pasteles
    @PutMapping ("/{id}")
    public ResponseEntity<Pastel> actualizarPastel(@PathVariable Long id, @RequestBody Pastel pastelDatosNuevos){
    try{
        Pastel pastelModificado = pastelService.editarPastel(id, pastelDatosNuevos);
        return ResponseEntity.ok(pastelModificado);
    }catch (RuntimeException e){
        return ResponseEntity.notFound().build();
    }
    }
    @GetMapping ("/buscar/{codigo}")
    public ResponseEntity<Pastel> obtenerPorCodigo(@PathVariable String codigo){
        Optional<Pastel> pastel = pastelService.buscarPorCodigo(codigo);
        return pastel.map(ResponseEntity :: ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
}

//{
//		"medida": "mediano",
//		"precio": 380.00,
//		"diasVidaUtil": 6,
//		"nombre": "Pastel de Chocolate Alemán",
//		"fechaFabricacion": "2026-07-03",
//		"codigoBarras": "7501234567890"
//		}