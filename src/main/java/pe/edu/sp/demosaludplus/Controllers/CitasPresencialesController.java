package pe.edu.sp.demosaludplus.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.CitasPresenciales;
import pe.edu.sp.demosaludplus.dtos.CitaPresencialDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasPresencialesService;

@RestController
@RequestMapping("/citas-presenciales")
public class CitasPresencialesController {

    @Autowired
    private ICitasPresencialesService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        CitasPresenciales c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una cita presencial con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(c, CitaPresencialDTO.class));
    }

    @GetMapping("/cita/{idCita}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorCita(@PathVariable Integer idCita) {
        CitasPresenciales c = service.findByCita(idCita);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La cita " + idCita + " no tiene datos presenciales.");
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(c, CitaPresencialDTO.class));
    }
}