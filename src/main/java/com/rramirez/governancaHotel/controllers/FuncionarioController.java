package com.rramirez.governancaHotel.controllers;

import com.rramirez.governancaHotel.domain.funcionario.Funcionario;
import com.rramirez.governancaHotel.domain.funcionario.FuncionarioRequestDTO;
import com.rramirez.governancaHotel.domain.funcionario.TipoCargo;
import com.rramirez.governancaHotel.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody @Validated FuncionarioRequestDTO funcionarioRequestDTO){
        Funcionario funcionario = this.service.cadastrar(funcionarioRequestDTO);
        return ResponseEntity.ok(funcionario);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listrarFuncionario(){
        List<Funcionario> funcionarios = this.service.listarTodos();
        return ResponseEntity.ok(funcionarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable UUID id, @RequestBody @Validated FuncionarioRequestDTO funcionarioRequestDTO){
        Funcionario funcionario = this.service.atualizar(id, funcionarioRequestDTO);
        return ResponseEntity.ok(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Funcionario> excluirFuncionario(@PathVariable UUID id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{cargo}")
    public ResponseEntity<List<Funcionario>> listarPorCargoFuncionario(@PathVariable TipoCargo cargo){
        List<Funcionario> funcionarios = this.service.listarPorCargo(cargo);
        return ResponseEntity.ok(funcionarios);
    }


}
