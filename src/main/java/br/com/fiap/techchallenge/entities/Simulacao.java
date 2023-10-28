package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_simulacoes")
public class Simulacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSimulacao;

    private String descricaoSimulacao;

    @Enumerated(EnumType.STRING)
    private PerfilInvestidor perfilInvestidor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private LocalDate dataGeracaoSimulacao;

    @ManyToMany
    @JoinTable(
            name = "simulacao_produto",
            joinColumns = @JoinColumn(name = "simulacao_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private Set<Produto> produtos;

    @PrePersist
    protected void onCreate(){
        dataGeracaoSimulacao = LocalDate.now();
    }

}
