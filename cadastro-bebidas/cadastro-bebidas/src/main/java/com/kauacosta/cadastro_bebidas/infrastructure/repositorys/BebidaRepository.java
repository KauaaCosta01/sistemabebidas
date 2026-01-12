package com.kauacosta.cadastro_bebidas.infrastructure.repositorys;

import com.kauacosta.cadastro_bebidas.infrastructure.entitys.Bebida;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BebidaRepository extends JpaRepository<Bebida, Long> {

    Optional<Bebida> findById(Long id);

    @Transactional
    void deleteById(Long id);
}
