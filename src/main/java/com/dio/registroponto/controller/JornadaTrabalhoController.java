package com.dio.registroponto.controller;

import com.dio.registroponto.model.JornadaTrabalho;
import com.dio.registroponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

//Classe que recebe as requisições
@RestController
@RequestMapping("/jornada") //mapeia o caminho do endpoint para o cliente
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService; //deixa as responsabilidades divididas

    //recebe o corpo do post via parametro como objeto JornadaTrabalho
    @PostMapping //qdo faz uma requisição post, chama esse método
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @GetMapping
    public List<JornadaTrabalho> getJornadaList(){
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaById(@PathVariable("idJornada") Long idJornada) throws Exception{
        return ResponseEntity.ok(jornadaService.getById(idJornada).orElseThrow(()-> new NoSuchElementException(("Jornada nao encontrada"))));
    }

    @DeleteMapping
    public void deleteJornada(@RequestBody JornadaTrabalho jornadaTrabalho){
        jornadaService.deleteJornada(jornadaTrabalho);
    }

//    @DeleteMapping
//    public ResponseEntity<JornadaTrabalho> deleteById(@PathVariable("idJornada") Long idJornada) throws Exception{
//        try{
//            jornadaService.deleteJornada(idJornada);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
//    }
}
