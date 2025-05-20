package com.rramirez.governancaHotel.services;

import com.rramirez.governancaHotel.domain.funcionario.Funcionario;
import com.rramirez.governancaHotel.domain.funcionario.FuncionarioRequestDTO;
import com.rramirez.governancaHotel.domain.funcionario.TipoCargo;
import com.rramirez.governancaHotel.repositories.FuncionarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public Funcionario cadastrar(FuncionarioRequestDTO valor){
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(valor.nome());
        funcionario.setIdade(valor.idade());
        funcionario.setCpf(valor.cpf());
        funcionario.setCargo(valor.cargo());
        funcionario.setTelefone(valor.telefone());
        funcionario.setAtivo(true);

        repository.save(funcionario);
        return funcionario;
    }

    public List<Funcionario> listarTodos(){
        return this.repository.findAll();
    }

    @Transactional
    public Funcionario atualizar(UUID id, FuncionarioRequestDTO valor){
        Optional<Funcionario> funcionario = this.repository.findById(id);
        if (funcionario.isPresent()){
            Funcionario novoFuncionario = funcionario.get();
            novoFuncionario.setNome(valor.nome());
            novoFuncionario.setIdade(valor.idade());
            novoFuncionario.setCpf(valor.cpf());
            novoFuncionario.setCargo(valor.cargo());
            novoFuncionario.setTelefone(valor.telefone());

            return repository.save(novoFuncionario);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public Funcionario excluir(UUID id){
        Optional<Funcionario> funcionario = this.repository.findById(id);
        if (funcionario.isPresent()){
            Funcionario funcionarioDesativado = funcionario.get();
            funcionarioDesativado.setAtivo(false);
            return repository.save(funcionarioDesativado);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<Funcionario> listarPorCargo(TipoCargo cargo){
        return this.repository.findByCargo(cargo);

    }
}
