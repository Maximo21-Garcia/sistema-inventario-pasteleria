package inventario.Service;

import inventario.Entity.Pastel;
import inventario.Repository.PastelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PastelService {

    @Autowired
    private PastelRepository pastelRepository; // llamamos a nuestro REPOSITORY

    //regla 1: Trae todos los pasteles

    public List<Pastel> obtenerTodosLosPasteles(){
        return pastelRepository.findAll();//Le damos el "comando" al REPOSITORY para que nos de una lista
    }

    //Regla 2: Gaurda un pastel
    public Pastel guardaPastel (Pastel pastel){
        //Aqui se calcula automaticamente la fecha de caducidad antes de guardar
        if (pastel.getFechaCaducidad() == null && pastel.getDiasVidaUtil() != null){
            pastel.setFechaCaducidad(LocalDate.now().plusDays(pastel.getDiasVidaUtil()));
        }
        // Logica de generar codigo de barras
        if(pastel.getCodigoBarras() == null || pastel.getCodigoBarras().trim().isEmpty()){
            String codigoGenerado = generarCodigoBarrasAleatorio();
            pastel.setCodigoBarras(codigoGenerado);
        }
        return pastelRepository.save(pastel); //le decimos que guarde el pastel
    }
    //Inventar un codigo de barras de 12 digitos
    private String generarCodigoBarrasAleatorio(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 12; i++){
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
    //REgla 3: Filtrar solo los pasteles vencidos

    public List<Pastel> obtenerPastelesVencidos(){
            List<Pastel> todos = pastelRepository.findAll(); //Lista de todos los pasteles
            List<Pastel> vencidos = new ArrayList<>(); // crea una nueva Lista de los pasteles vencidos
            LocalDate hoy = LocalDate.now(); //Miramos la fecha de hoy

    for (Pastel pastel : todos) {
            // Si la fecha de caducidad es ANTES (.isBefore) que hoy... ¡está vencido!
            if(pastel.getFechaCaducidad()!= null && pastel.getFechaCaducidad().isBefore(hoy)){
                vencidos.add(pastel);
            }
        }
        return vencidos; //devolvemos la nueva lista de los pasteles vencidos
    }
    // Regla 4: Eliminar pasteles
    public Pastel eliminarPastel (Long id) {
        pastelRepository.deleteById(id);
        return null;
    }
    // Regla 5: Editar un pastel

    public Pastel editarPastel (Long id, Pastel pastelActualizado){
        //buscamos el pastel si existe en la base de datos
        return pastelRepository.findById(id).map(pastelExistente ->{
            pastelExistente.setNombre(pastelActualizado.getNombre());
            pastelExistente.setDiasVidaUtil(pastelActualizado.getDiasVidaUtil());
            pastelExistente.setFechaCaducidad(pastelActualizado.getFechaCaducidad());
            pastelExistente.setMedida(pastelActualizado.getMedida());
            return pastelRepository.save(pastelExistente);
        }).orElseThrow(()-> new RuntimeException("No se encontro el pastel con Id "+id));
    }
    // Regla 6: metodo para buscar por codigo de barras
    public Optional<Pastel> buscarPorCodigo(String codigo){
        return pastelRepository.findByCodigoBarras(codigo);
    }

}
