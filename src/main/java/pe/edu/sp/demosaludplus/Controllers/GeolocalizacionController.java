package pe.edu.sp.demosaludplus.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;
import pe.edu.sp.demosaludplus.dtos.GeolocalizacionDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IGeolocalizacionService;

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