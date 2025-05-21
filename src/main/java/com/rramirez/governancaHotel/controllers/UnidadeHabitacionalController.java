package com.rramirez.governancaHotel.controllers;

import com.rramirez.governancaHotel.domain.limpeza.SituacaoLimpeza;
import com.rramirez.governancaHotel.domain.uh.TipoUh;
import com.rramirez.governancaHotel.domain.uh.UnidHabitacionalRequestDTO;
import com.rramirez.governancaHotel.domain.uh.UnidadeHabitacional;
import com.rramirez.governancaHotel.services.UnidadeHabitacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/uh")
public class UnidadeHabitacionalController {

    @Autowired
    private UnidadeHabitacionalService service;

    @PostMapping
    public ResponseEntity<UnidadeHabitacional> cadastrarUh(@RequestBody @Validated UnidHabitacionalRequestDTO unidHabitacionalRequestDTO){
        UnidadeHabitacional uh = this.service.cadastrar(unidHabitacionalRequestDTO);
        return ResponseEntity.ok(uh);
    }

    @GetMapping
    public ResponseEntity<List<UnidadeHabitacional>> listarUhs(){
        List<UnidadeHabitacional> uhs = this.service.listarTodos();
        return ResponseEntity.ok(uhs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadeHabitacional> atualizarUh(@PathVariable UUID id, @RequestBody @Validated UnidHabitacionalRequestDTO unidHabitacionalRequestDTO){
        UnidadeHabitacional uh = this.service.atualizar(id, unidHabitacionalRequestDTO);
        return ResponseEntity.ok(uh);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UnidadeHabitacional> excluirUh(@PathVariable UUID id){
        this.service.excluir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<UnidadeHabitacional>> listarPorTipoUh(@PathVariable TipoUh tipo){
        List<UnidadeHabitacional> uhs = this.service.listarPorTipo(tipo);
        return ResponseEntity.ok(uhs);
    }


}
