/*Se creo la entidad Mascota usando JPA para generar la tabla automaticamente,
aplicando Lombok con @Data para reducir código, y definiendo restricciones con
@Column como nullable y length.”*/

package com.example.Veterinaria.Entity;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name="mascotas")
@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Mascota {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idMascota;

@Column (nullable = false,length = 40)
    private String nombre;

@Column (nullable = false,length = 40)
    private String especie;

@Column (nullable = false,length = 40)
    private Long edad;

@Column (nullable = false,length = 80)
    private String nombreDueno;
}
