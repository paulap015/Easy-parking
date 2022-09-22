package easyParking.dto;

import easyParking.model.Tarifa;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ZonaDTO {

    private String idZona;
    private String nombreZona;
    private String descripcion;
    private Integer espaciosLibres;
    private Tarifa tarifa;
}
