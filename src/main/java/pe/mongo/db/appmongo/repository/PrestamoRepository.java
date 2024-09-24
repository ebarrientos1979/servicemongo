package pe.mongo.db.appmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import pe.mongo.db.appmongo.model.Prestamo;

public interface PrestamoRepository extends MongoRepository<Prestamo, String> {
}
