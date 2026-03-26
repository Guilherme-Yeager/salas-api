package com.githubguilhermeyeager.salasapi.domain.models.enums;

import lombok.Getter;

@Getter
public enum Role {
    GESTOR(1),
    PARTICIPANTE(2);

    private final int numero;

    Role(int numero) {
        this.numero = numero;
    }

    public static Role fromNumero(int numero) {
        for(Role role : Role.values()){
            if(role.numero == numero){
                return role;
            }
        }

        throw new IllegalArgumentException("Perfil inválido.");
    }
}
