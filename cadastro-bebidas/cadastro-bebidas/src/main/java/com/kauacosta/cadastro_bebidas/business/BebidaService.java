package com.kauacosta.cadastro_bebidas.business;


import com.kauacosta.cadastro_bebidas.DTO.BebidaCreateDTO;
import com.kauacosta.cadastro_bebidas.DTO.BebidaResponseDTO;
import com.kauacosta.cadastro_bebidas.DTO.BebidaUpdateDTO;
import com.kauacosta.cadastro_bebidas.exception.ResourceNotFoundException;
import com.kauacosta.cadastro_bebidas.infrastructure.entitys.Bebida;
import com.kauacosta.cadastro_bebidas.infrastructure.repositorys.BebidaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
public class BebidaService {

    private final BebidaRepository repository;
    public BebidaService(BebidaRepository repository) {
        this.repository = repository;
    }


    // Método para converter para DTO
    private BebidaResponseDTO toResponseDTO(Bebida bebida) {
        BebidaResponseDTO dto = new BebidaResponseDTO();
        dto.setId(bebida.getId());
        dto.setNomeBebida(bebida.getNomeBebida());
        dto.setPrecoBebida(bebida.getPrecoBebida());
        dto.setDescricaoBebida(bebida.getDescricaoBebida());
        dto.setQuantidadeBebida(bebida.getQuantidadeBebida());

        return dto;
    }

    public BebidaResponseDTO salvarBebida(BebidaCreateDTO createDTO) {

        Bebida bebida = new Bebida();
        bebida.setNomeBebida(createDTO.getNomeBebida());
        bebida.setPrecoBebida(createDTO.getPrecoBebida());
        bebida.setDescricaoBebida(createDTO.getDescricaoBebida());
        bebida.setQuantidadeBebida(createDTO.getQuantidadeBebida());

        Bebida salva = repository.save(bebida);

        return toResponseDTO(salva);
    }


    public BebidaResponseDTO buscarBebidaPorId(Long id){
        Bebida buscarPorID =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("bebida com id " + id + " não encontrado")
        );

        return toResponseDTO(buscarPorID);
    }

    @Transactional
    public BebidaResponseDTO atualizarBebidaPorId(Long id, BebidaUpdateDTO bebidaUpdate){
        Bebida atualizarPorId = repository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("Bebida com ID " + id + " não encontrada")
        );

        if (bebidaUpdate.getNomeBebida() != null) {
            atualizarPorId.setNomeBebida(bebidaUpdate.getNomeBebida());
        }

        if (bebidaUpdate.getPrecoBebida() != null) {
            atualizarPorId.setPrecoBebida(bebidaUpdate.getPrecoBebida());
        }

        if (bebidaUpdate.getDescricaoBebida() != null) {
            atualizarPorId.setDescricaoBebida(bebidaUpdate.getDescricaoBebida());
        }

        if (bebidaUpdate.getQuantidadeBebida() != null) {
            atualizarPorId.setQuantidadeBebida(bebidaUpdate.getQuantidadeBebida());
        }


        return toResponseDTO(atualizarPorId);
    }

    public void deleteBebidaPorId(Long id){
        repository.deleteById(id);
    }
}
