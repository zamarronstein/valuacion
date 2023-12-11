package nmp.com.mx.valuacion.repository;

import nmp.com.mx.valuacion.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio para obtener el material y el precio por gramo
 * */
@Repository
public interface IMaterialRepository extends MongoRepository<Material, String> {
    Optional<Material> findFirstByClave(String clave);
}
