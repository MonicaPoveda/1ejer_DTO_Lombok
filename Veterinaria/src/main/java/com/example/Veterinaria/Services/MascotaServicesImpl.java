package com.example.Veterinaria.Services;

import com.example.Veterinaria.Entity.Mascota;
import com.example.Veterinaria.Repository.MascotaRepository;
import com.example.Veterinaria.dto.MascotaRequestDTO;
import com.example.Veterinaria.dto.MascotaResponseDTO;
import com.example.Veterinaria.mapper.MascotaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
//inyeccion de dependencias por constructor
@RequiredArgsConstructor //→  inyecta dependencias sin @Autowired

public class MascotaServicesImpl implements MascotaService {
    private final MascotaMapper mascotaMapper;
    private final MascotaRepository mascotaRepository;

    // ── CREATE ────────────────────────────────────────────────────────────────
    @Override
    public MascotaResponseDTO guardarMascota(MascotaRequestDTO dto) {
        Mascota mascota  = MascotaMapper.toEntity(dto);
        Mascota mascotaGuardada = mascotaRepository.save(mascota);
        return mascotaMapper.toResponseDTO(mascotaGuardada);

    }
    // ── READ ────────────────────────────────────────────────────────────────
    @Override
    public List<MascotaResponseDTO> listarMascotas() {
         return mascotaRepository.findAll()//Va a la base de datos y trae todas las mascotas
                 .stream()      //Convierte la lista en un flujo de datos (Stream) para poder transformarla
                                 //“voy a recorrer cada mascota una por una”
                 .map(mascotaMapper::toResponseDTO)   //A cada objeto Mascota le aplica el mapper
                 .toList();                           //Convierte el stream nuevamente en una lista:

    }
    // ── UPDATE ────────────────────────────────────────────────────────────────
    @Override
    public MascotaResponseDTO actualizarMascota(Long id, MascotaRequestDTO dto) {
        Mascota existente =mascotaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"Mascota no encontrada"));

        // Actualizar los campos con los nuevos valores del DTO
        existente.setNombre(dto.getNombre());
        existente.setEspecie(dto.getEspecie());
        existente.setEdad(dto.getEdad());
        existente.setNombreDueno(dto.getNombreDueno());

        Mascota Mascotaactualizada = mascotaRepository.save(existente);

        return mascotaMapper.toResponseDTO(Mascotaactualizada);

     // Categoria existente = categoriaRepository.findById(id).orElseThrow(()->
   // new ResponseStatusException(HttpStatus.NOT_FOUND,"Categoria no encontrada"));

    }
    // ── DELETE ────────────────────────────────────────────────────────────────
    @Override
    public void EliminarMascota(Long id) {
        Mascota existente = mascotaRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"La mascota con ID:" +id+" NO EXISTE"));
        mascotaRepository.deleteById(id);



    }
}
