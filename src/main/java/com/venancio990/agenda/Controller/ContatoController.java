package com.venancio990.agenda.Controller;

import com.venancio990.agenda.DTO.ContatoCadastroDTO;
import com.venancio990.agenda.DTO.ContatoResponseDTO;
import com.venancio990.agenda.model.Contato;
import com.venancio990.agenda.repository.ContatoRepository;
import com.venancio990.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @PostMapping("/contato")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoResponseDTO salvar(@RequestBody ContatoCadastroDTO contato){
        return service.salvarContato(contato);
    }

    @GetMapping("/contato")
    @ResponseStatus(HttpStatus.OK)
    public List<Contato> listarTodos(){
        return service.listarTodos();
    }

    @DeleteMapping("/contato/{contatoId}")
    public void excluir(@PathVariable Long contatoId){
        service.excluir(contatoId);
    }

    @GetMapping("/contato/{id}")
    public Contato buscaId(@PathVariable Long id){
        return service.buscarId(id);
    }



}
