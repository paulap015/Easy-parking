package easyParking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="rol")
public class Rol {

    @Id
    @Column(name="idRol")
    private Integer idRol;

    @Column(name="nombreRol")
    private String nombreRol;
}
