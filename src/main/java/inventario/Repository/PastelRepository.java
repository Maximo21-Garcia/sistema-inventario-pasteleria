package inventario.Repository;

import inventario.Entity.Pastel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // es la anotacion "etiqueta" donde decimos que esta interfas es un REPOSITORY
public interface PastelRepository extends JpaRepository<Pastel,Long> {

    Optional<Pastel> findByCodigoBarras(String codigoBaras);
}
