package model;

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
@Table(name="tarifa")
public class Tarifa {

    @Id
    @Column(name="idTarifa")
    private Integer idTarifa;

    @Column(name="precio")
    private Double precio;
}
