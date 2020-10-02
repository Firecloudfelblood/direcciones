package com.erivalaxl.direcciones.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Datosparticulares implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    private String calle;
    private int numext;
    private int numint;
    private String colonia;
    private int cp;
    private String tel;
    private String cel;
    private int idusuario;
}
