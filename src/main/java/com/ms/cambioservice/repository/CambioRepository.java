package com.ms.cambioservice.repository;

import com.ms.cambioservice.model.Cambio;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioRepository extends MongoRepository<Cambio, ObjectId> {
}
