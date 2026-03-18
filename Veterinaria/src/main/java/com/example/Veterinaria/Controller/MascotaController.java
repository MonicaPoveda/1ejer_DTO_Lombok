package com.example.Veterinaria.Controller;

import com.example.Veterinaria.Entity.Mascota;
import com.example.Veterinaria.Services.MascotaService;

import com.example.Veterinaria.dto.MascotaRequestDTO;
import com.example.Veterinaria.dto.MascotaResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api") //donde se va a mapear la ruta donde se va a
public class MascotaController {
    //inyeccion de service
    private final MascotaService mascotaService;

    // ── CREATE ────────────────────────────────────────────────────────────────
    @PostMapping("/guardarMascota")

    public ResponseEntity<MascotaResponseDTO> guardarMascota(@RequestBody MascotaRequestDTO dto) {
        MascotaResponseDTO guardar = mascotaService.guardarMascota(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardar);

    }//201 creado


    // ── READ ────────────────────────────────────────────────────────────────
    @GetMapping("/listarMascota")

    public ResponseEntity<List<MascotaResponseDTO>> listarMascotas() {
        List <MascotaResponseDTO> mascotas =mascotaService.listarMascotas();// va a serVicio busca y guarda en estudiantes
        return ResponseEntity.ok(mascotas) ;

    } //responde ok 200

    // ── UPDATE ────────────────────────────────────────────────────────────────
    @PatchMapping("/actualizarMascota/{id}")
    public ResponseEntity<MascotaResponseDTO> actualizarMascota(@PathVariable Long id, @RequestBody MascotaRequestDTO mascotaDTO) {
        MascotaResponseDTO mascotaActu = mascotaService.actualizarMascota(id, mascotaDTO);
        return ResponseEntity.ok(mascotaActu);
    }//responde ok 200

    // ── DELETE ────────────────────────────────────────────────────────────────
    @DeleteMapping("/eliminarMascota/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id) {
        mascotaService.EliminarMascota(id);
        return ResponseEntity.noContent().build();
    }//responde 204 eliminado

}











