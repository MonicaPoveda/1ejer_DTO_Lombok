package com.example.Veterinaria.dto;
import lombok.*;
/**
 * DTO de entrada: define exactamente qué campos acepta la API.
 * Las validaciones se activan con @Valid en el controller.
 */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    @Builder
    public class MascotaRequestDTO {

        private String nombre;
        private String especie;
        private Long edad;
        private String nombreDueno;

    }

