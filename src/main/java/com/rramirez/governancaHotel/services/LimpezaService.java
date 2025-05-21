package com.rramirez.governancaHotel.services;

import com.rramirez.governancaHotel.domain.funcionario.Funcionario;
import com.rramirez.governancaHotel.domain.funcionario.TipoCargo;
import com.rramirez.governancaHotel.domain.limpeza.Limpeza;
import com.rramirez.governancaHotel.domain.limpeza.LimpezaRequestDTO;
import com.rramirez.governancaHotel.domain.limpeza.SituacaoLimpeza;
import com.rramirez.governancaHotel.domain.limpeza.TipoLimpeza;
import com.rramirez.governancaHotel.domain.uh.UnidadeHabitacional;
import com.rramirez.governancaHotel.repositories.FuncionarioRepository;
import com.rramirez.governancaHotel.repositories.LimpezaRepository;
import com.rramirez.governancaHotel.repositories.UnidadeHabitacionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LimpezaService {

    private final UUID idGovernanta = UUID.fromString("46f7ce43-4198-4840-8d23-7083d19ae8a8");

    @Autowired
    private LimpezaRepository limpezaRepository;

    @Autowired
    private UnidadeHabitacionalRepository unidadeHabitacionalRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;


    public Limpeza criar(LimpezaRequestDTO valor, SituacaoLimpeza situacaoLimpeza){
        UnidadeHabitacional uh = unidadeHabitacionalRepository.findById(valor.uh())
                .orElseThrow(() -> new IllegalArgumentException("UH não existe"));

        Funcionario camareira = funcionarioRepository.findById(valor.camareira())
                .orElseThrow(() -> new IllegalArgumentException("Camareira não encontrada"));
        if (camareira.getCargo() != TipoCargo.CAMAREIRA){
            throw new IllegalArgumentException("O funcionário registrado para a limpeza deve ser do cargo CAMAREIRA");
        }


        Limpeza limpeza = new Limpeza();
        limpeza.setUh(uh);
        limpeza.setCamareira(camareira);
        limpeza.setTipo(valor.tipo());
        limpeza.setSituacao(situacaoLimpeza);
        limpeza.setData(Timestamp.valueOf(LocalDateTime.now()));
        return limpezaRepository.save(limpeza);

    }

    private Funcionario buscaGovernanta( UUID idGovernanta ){
        Funcionario governanta = funcionarioRepository.findById(idGovernanta)
                .orElseThrow(() -> new IllegalArgumentException("Governanta não encontrada"));

        if(governanta.getCargo() != TipoCargo.GOVERNANTA){
            throw new IllegalArgumentException("Somente Governanta pode registrar a limpeza no sistema");
        }
        return governanta;
    }

    public List<Limpeza>  listar() {
        return this.limpezaRepository.findAll();
    }
    
//    public List<Limpeza> listarDoDia(){
//        return this.limpezaRepository.findAllByData(Timestamp.valueOf(LocalDateTime.now().withHour(0).withMinute(0)));
//    }

    public List<Limpeza> listarDoDia() {
        LocalDateTime inicioDoDia = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        LocalDateTime fimDoDia = LocalDateTime.now().withHour(23).withMinute(59).withSecond(59);
        return this.limpezaRepository.findAllByDataBetween(Timestamp.valueOf(inicioDoDia), Timestamp.valueOf(fimDoDia));
    }

}
