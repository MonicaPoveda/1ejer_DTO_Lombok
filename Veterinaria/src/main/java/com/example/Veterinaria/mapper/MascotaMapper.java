package com.example.Veterinaria.mapper;

import com.example.Veterinaria.Entity.Mascota;
import com.example.Veterinaria.dto.MascotaRequestDTO;
import com.example.Veterinaria.dto.MascotaResponseDTO;
import org.springframework.stereotype.Component;

//“El mapper se encarga de transformar datos entre la entidad y el DTO.”
//
//     * DTO de entrada  →  Entidad JPA
//     * Se usa al crear o actualizar una mascota.
//
//“toDTO se usa para enviar datos al cliente,
// y toEntity para guardar datos en la base de datos.
@Component
public class MascotaMapper {


        // Convierte de RequestDTO a Entidad (para crear/actualizar)
        public static Mascota toEntity(MascotaRequestDTO dto) {
            if (dto == null) {
                return null;
            }
            return Mascota.builder()
                    .nombre(dto.getNombre())
                    .especie(dto.getEspecie())
                    .edad(dto.getEdad())
                    .nombreDueno(dto.getNombreDueno())
                    .build();
        }

        // Convierte de Entidad a responseDTO (para dar respuesta)
        public  MascotaResponseDTO toResponseDTO(Mascota mascota) {
            if (mascota == null) {
                return null;
            }
            return MascotaResponseDTO.builder()
            // No seteamos el ID porque la BD lo genera automáticamente (para creación)
            // Si fuera una actualización, podríamos recibir el ID en el DTO y asignarlo.
                    .idMascota(mascota.getIdMascota())
                    .nombre(mascota.getNombre())
                    .especie(mascota.getEspecie())
                    .edad(mascota.getEdad())
                    // nombreDueno intencionalmente omitido
                    .build();

        }


    }





