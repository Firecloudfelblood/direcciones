package com.erivalaxl.direcciones.controller;

import com.erivalaxl.direcciones.model.Datosparticulares;
import com.erivalaxl.direcciones.persistance.DatosparticularesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DireccionesController {

    @Autowired
    private DatosparticularesRepository datosparticularesRepo;

    @GetMapping("/direcciones")
    public ResponseEntity<List<Datosparticulares>> listarDirecciones(){
        List<Datosparticulares>  listDirecciones = datosparticularesRepo.findAll();
        return new ResponseEntity<List<Datosparticulares>>(listDirecciones, HttpStatus.OK);
    }

    @GetMapping("/direcciones/{id}")
    public ResponseEntity<Datosparticulares> obtenerDireccion(@PathVariable Integer id){
        Datosparticulares dp = datosparticularesRepo.findByIdusuario(id);
        return new ResponseEntity<Datosparticulares>(dp, HttpStatus.OK);

    }

    @PostMapping("/direcciones/agregar")
    public ResponseEntity<List<Datosparticulares>> agregarDireccion(@RequestBody Datosparticulares dp){
        Datosparticulares tempdp = datosparticularesRepo.save(dp);
        return new ResponseEntity<List<Datosparticulares>>(listarDirecciones().getBody(), HttpStatus.OK);
    }

    @PutMapping("/direcciones/actualizar/{id}")
    public ResponseEntity<Datosparticulares> actualizarDireccion(@PathVariable Integer id, @RequestBody Datosparticulares dp){
        dp.setIdusuario(id);
        datosparticularesRepo.save(dp);
        return new ResponseEntity<Datosparticulares>(obtenerDireccion(id).getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/direcciones/delete/{id}")
    public ResponseEntity<List<Datosparticulares>> borrarDireccion(@PathVariable Integer id){
        Datosparticulares datosparticulares = obtenerDireccion(id).getBody();
        datosparticularesRepo.deleteById(datosparticulares.getId());
        return new ResponseEntity<List<Datosparticulares>>(listarDirecciones().getBody(), HttpStatus.OK);
    }

    @DeleteMapping("/direcciones/delete2/{id}")
    public ResponseEntity<List<Datosparticulares>> borrarDireccion2(@PathVariable Integer id){
        datosparticularesRepo.deleteById(id);
        return new ResponseEntity<List<Datosparticulares>>(listarDirecciones().getBody(), HttpStatus.OK);
    }
}
