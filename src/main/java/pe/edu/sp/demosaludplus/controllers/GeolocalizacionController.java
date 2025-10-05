package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.demoSaludPlusNuevo.dtos.GeolocalizacionDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.Geolocalizacion;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IGeolocalizacionService;

@RestController
@RequestMapping("/geolocalizacion")
public class GeolocalizacionController {

    @Autowired
    private IGeolocalizacionService service;

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> obtenerPorUsuario(@PathVariable Integer idUsuario) {
        Geolocalizacion g = service.findByUsuario(idUsuario);
        if (g == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario " + idUsuario + " no tiene geolocalización registrada.");
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(g, GeolocalizacionDTO.class));
    }
}