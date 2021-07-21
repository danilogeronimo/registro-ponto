package com.dio.registroponto.repository;

import com.dio.registroponto.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//Classe para persistir os dados depois que a Service tratou

@Repository
public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {
}
