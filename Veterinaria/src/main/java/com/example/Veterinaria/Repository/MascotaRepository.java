package com.example.Veterinaria.Repository;

import com.example.Veterinaria.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository <Mascota,Long> {
//consultas a las bases de datos
}
