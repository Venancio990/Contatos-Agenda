package com.venancio990.agenda.DTO;

import com.venancio990.agenda.model.Contato;

public record ContatoResponseDTO(
    Long id,
    String nome,
    String email,
    String telefone

) {
    public ContatoResponseDTO(Contato contato){
        this(
                contato.getId(),
                contato.getNome(),
                contato.getEmail(),
                contato.getTelefone()
        );
    }

}
