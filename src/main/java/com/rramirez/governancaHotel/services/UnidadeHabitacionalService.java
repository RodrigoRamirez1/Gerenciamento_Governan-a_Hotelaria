package com.rramirez.governancaHotel.services;

import com.rramirez.governancaHotel.domain.limpeza.SituacaoLimpeza;
import com.rramirez.governancaHotel.domain.uh.TipoUh;
import com.rramirez.governancaHotel.domain.uh.UnidHabitacionalRequestDTO;
import com.rramirez.governancaHotel.domain.uh.UnidadeHabitacional;
import com.rramirez.governancaHotel.repositories.UnidadeHabitacionalRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UnidadeHabitacionalService {

    @Autowired
    private UnidadeHabitacionalRepository repository;


    public UnidadeHabitacional cadastrar(UnidHabitacionalRequestDTO valor){
        UnidadeHabitacional uh = new UnidadeHabitacional();
        uh.setNumero(valor.numero());
        uh.setTipo(valor.tipo());
        uh.setAtivo(true);

        repository.save(uh);
        return uh;
    }

    public List<UnidadeHabitacional> listarTodos(){
        return this.repository.findAll();
    }

    @Transactional
    public UnidadeHabitacional atualizar(UUID id, UnidHabitacionalRequestDTO valor){
        Optional<UnidadeHabitacional> uh = repository.findById(id);
        if (uh.isPresent()){
            UnidadeHabitacional uhNovo = uh.get();
            uhNovo.setNumero(valor.numero());
            uhNovo.setTipo(valor.tipo());
            return repository.save(uhNovo);
        } else {
            throw new EntityNotFoundException();
        }

    }

    public UnidadeHabitacional excluir(UUID id){
        Optional<UnidadeHabitacional> uh = repository.findById(id);
        if(uh.isPresent()){
            UnidadeHabitacional uhDesativado = uh.get();
            uhDesativado.setAtivo(false);
            return repository.save(uhDesativado);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public List<UnidadeHabitacional> listarPorTipo(TipoUh tipo){
        return this.repository.findByTipo(tipo);
    }


}
