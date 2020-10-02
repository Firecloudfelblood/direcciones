package com.erivalaxl.direcciones.persistance;

import com.erivalaxl.direcciones.model.Datosparticulares;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatosparticularesRepository extends JpaRepository<Datosparticulares, Integer> {
    public Datosparticulares findByIdusuario(int id);
    Long deleteByIdusuario(int id);
}
