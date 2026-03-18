package com.example.Veterinaria.Services;

import com.example.Veterinaria.Entity.Mascota;
import com.example.Veterinaria.dto.MascotaRequestDTO;
import com.example.Veterinaria.dto.MascotaResponseDTO;

import java.util.List;

public interface MascotaService {
    //construir metodos

    //guardar Mascota ---CREATE
    MascotaResponseDTO guardarMascota(MascotaRequestDTO dto);

    //metodo listar Mascotas---READ
    List<MascotaResponseDTO> listarMascotas();

    //actualizar datos --UPDATE
    MascotaResponseDTO actualizarMascota (Long id, MascotaRequestDTO mascotaRequestDTO);

    //eliminar Mascota --DELETE
    void EliminarMascota(Long id);


}
