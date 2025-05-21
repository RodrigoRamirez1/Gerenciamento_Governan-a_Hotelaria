package com.rramirez.governancaHotel.controllers;

import com.rramirez.governancaHotel.domain.limpeza.Limpeza;
import com.rramirez.governancaHotel.domain.limpeza.LimpezaRequestDTO;
import com.rramirez.governancaHotel.domain.limpeza.SituacaoLimpeza;
import com.rramirez.governancaHotel.services.LimpezaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class LimpezaController {

    @Autowired
    private LimpezaService limpezaService;

    @PostMapping("/limpeza_novo")
    public ResponseEntity<Limpeza> registrarLimpezaNovo(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.AGUARDANDO_LIMPEZA);
        return  ResponseEntity.ok(limpeza);
    }

    @PostMapping("/limpeza_andamento")
    public ResponseEntity<Limpeza> atualizarParaAndamento(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.EM_ANDAMENTO);
        return ResponseEntity.ok(limpeza);
    }

    @PostMapping("/vistoriar")
    public ResponseEntity<Limpeza> atualizarParaVistoriar(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.AGUARDANDO_VISTORIA);
        return ResponseEntity.ok(limpeza);
    }

    @PostMapping("/vistoriando")
    public ResponseEntity<Limpeza> atualizarParaVistoriando(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.EM_VISTORIA);
        return ResponseEntity.ok(limpeza);
    }

    @PostMapping("/limpo")
    public ResponseEntity<Limpeza> atualizarParaLimpo(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.LIMPO);
        return ResponseEntity.ok(limpeza);
    }

    @PostMapping("/pausa")
    public ResponseEntity<Limpeza> atualizarParaPausa(@RequestBody @Validated LimpezaRequestDTO valor){
        Limpeza limpeza = limpezaService.criar(valor, SituacaoLimpeza.EM_PAUSA);
        return ResponseEntity.ok(limpeza);
    }

    @GetMapping
    public ResponseEntity<List<Limpeza>> listarLimpezas(){
        List<Limpeza> limpezas = this.limpezaService.listar();
        return ResponseEntity.ok(limpezas);
    }

    @GetMapping("/limpezadodia")
    public ResponseEntity<List<Limpeza>> listarLimpezaDoDia(){
        List<Limpeza> limpezasDia = this.limpezaService.listarDoDia();
        return ResponseEntity.ok(limpezasDia);
    }


}
