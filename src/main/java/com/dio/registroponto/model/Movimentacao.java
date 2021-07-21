package com.dio.registroponto.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao {

    //quando há chaves primárias compostas, cria se uma classe implementando Serielizable (?) e use se a notação Embeddable para referenciar as  chaves na classe principal "Movimentacao" usando @EmbeddedId teste
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public class MovimentacaoId implements Serializable{
        private Long idMovimento;
        private Long idUsuario;
    }

    @EmbeddedId
    private MovimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;
    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;

}
