package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_proposta")
public class Proposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProposta;

    private String descricaoProposta;

    @Temporal(TemporalType.DATE)
    private LocalDate dataGeracaoProposta;

    @OneToMany
    private List<Produto> produtos = new ArrayList<>();

    @PrePersist
    protected void onCreate(){
        dataGeracaoProposta = LocalDate.now();
    }

}
