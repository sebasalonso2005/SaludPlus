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
import pe.edu.upc.demoSaludPlusNuevo.dtos.CitaVideollamadaDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.CitasVideollamadas;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.ICitasVideollamadasService;

@RestController
@RequestMapping("/citas-videollamadas")
public class CitasVideollamadasController {

    @Autowired
    private ICitasVideollamadasService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        CitasVideollamadas c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una videollamada con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(c, CitaVideollamadaDTO.class));
    }

    @GetMapping("/cita/{idCita}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorCita(@PathVariable Integer idCita) {
        CitasVideollamadas c = service.findByCita(idCita);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La cita " + idCita + " no tiene videollamada asociada.");
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(c, CitaVideollamadaDTO.class));
    }
}