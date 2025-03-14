package com.venancio990.agenda.service;

import com.venancio990.agenda.DTO.ContatoCadastroDTO;
import com.venancio990.agenda.DTO.ContatoResponseDTO;
import com.venancio990.agenda.model.Contato;
import com.venancio990.agenda.repository.ContatoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    //Injecao do repositorio
    @Autowired
    private ContatoRepository repository;


    //Metodo para salvar contato, recebe objeto do contato para salvar no banco
    public ContatoResponseDTO salvarContato(ContatoCadastroDTO contato) {
        Contato contatosalvo = new Contato();
        BeanUtils.copyProperties(contato, contatosalvo);

        Contato contato1 = repository.save(contatosalvo);
        return new ContatoResponseDTO(contato1);
    }


    //Metodo para listar todos os contatos salvos no banco
    public List<Contato> listarTodos(){
        return repository.findAll().stream().toList();
    }
    //metodo para excluir contatos por Id
    public void excluir(Long id){
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()){
            repository.delete(contatoOptional.get());
        }else {
            throw new RuntimeException("Contato nao encontrado");
        }
    }

    //Metodo de busca via ID de contatos
    public Contato buscarId(Long id){
        Optional<Contato> contatoOptional = repository.findById(id);
        if (contatoOptional.isPresent()){
            return new Contato();
        }else {
            throw new RuntimeException("Nao encontrado");
        }
    }
}
