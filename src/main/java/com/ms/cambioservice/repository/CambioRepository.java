package com.ms.cambioservice.repository;

import com.ms.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CambioRepository extends JpaRepository<Cambio, Long> {

    Optional<Cambio> findByMoneyFromAndMoneyTo(String moneyFrom, String moneyTo);
}
