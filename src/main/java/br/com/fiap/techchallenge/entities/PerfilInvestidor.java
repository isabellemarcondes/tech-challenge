package br.com.fiap.techchallenge.entities;

import lombok.Getter;

@Getter
public enum PerfilInvestidor {

    CONSERVADOR(1, "Conservador"),
    MODERADO(2, "Moderado"),
    AGRESSIVO(3, "Agressivo");

    private final int id;
    private final String descricao;

    PerfilInvestidor(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public static PerfilInvestidor fromId(int id) {
        for (PerfilInvestidor perfil : values()) {
            if (perfil.getId() == id) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil investidor inválido para o ID " + id);
    }

}
