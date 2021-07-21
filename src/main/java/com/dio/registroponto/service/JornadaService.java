package com.dio.registroponto.service;

import com.dio.registroponto.model.JornadaTrabalho;
import com.dio.registroponto.repository.JornadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Classe para regra de negocio
@Service
public class JornadaService {

    JornadaRepository jornadaRepository;

    @Autowired //spring faz a inicialização dessa dependencia ( nao precisa dar new)
    public JornadaService(JornadaRepository jornadaRepository) {
        this.jornadaRepository = jornadaRepository;
    }

    //recebe do controller
    public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho); //cria ou atualiza
    }

    public List<JornadaTrabalho> findAll() {
        return jornadaRepository.findAll();
    }

    public Optional<JornadaTrabalho> getById(Long idJornada) {
        return jornadaRepository.findById(idJornada);
    }

    public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho){
        return jornadaRepository.save(jornadaTrabalho); //cria ou atualiza
    }

    public void deleteJornada(JornadaTrabalho jornadaTrabalho){
        jornadaRepository.delete(jornadaTrabalho); //cria ou atualiza
    }

//    public void deleteJornada(Long idJornada) {
//        jornadaRepository.deleteById(idJornada);
//    }
}
