package com.example.Veterinaria.dto;

import lombok.*;

/**
 * DTO de salida: define exactamente que devuelve la API. q va a ver el usuario
 * Aqui se puede exponer el id y omitir campos sensibles si los hubiera
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MascotaResponseDTO {

    private Long idMascota;
    private String nombre;
    private String especie;
    private Long edad;
}
