package com.kauacosta.cadastro_bebidas.controller;


import com.kauacosta.cadastro_bebidas.DTO.BebidaCreateDTO;
import com.kauacosta.cadastro_bebidas.DTO.BebidaResponseDTO;
import com.kauacosta.cadastro_bebidas.DTO.BebidaUpdateDTO;
import com.kauacosta.cadastro_bebidas.business.BebidaService;
import com.kauacosta.cadastro_bebidas.infrastructure.entitys.Bebida;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bebida")
public class BebidaController {


    private final BebidaService bebidaService;
    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<BebidaResponseDTO> salvarBebida(@RequestBody @Valid BebidaCreateDTO createDTO) {
        BebidaResponseDTO responseDTO = bebidaService.salvarBebida(createDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BebidaResponseDTO> buscarBebidaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bebidaService.buscarBebidaPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BebidaResponseDTO> atualizarBebidaPorId(@PathVariable Long id, @RequestBody BebidaUpdateDTO bebidaUpdate) {
        bebidaService.atualizarBebidaPorId(id, bebidaUpdate);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deletarBebidaPorId(@PathVariable Long id) {
        bebidaService.deleteBebidaPorId(id);
        return ResponseEntity.ok().build();
    }
}
