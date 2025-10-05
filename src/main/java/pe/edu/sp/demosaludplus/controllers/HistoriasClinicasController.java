package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.dtos.HistoriaClinicaCrearDTO;
import pe.edu.sp.demosaludplus.dtos.HistoriaClinicaDTO;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;
import pe.edu.sp.demosaludplus.servicesinterfaces.IHistoriasClinicasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historias")
public class HistoriasClinicasController {

    @Autowired
    private IHistoriasClinicasService service;

    @GetMapping
    public List<HistoriaClinicaDTO> listar() {
        return service.list().stream().map(h -> {
            ModelMapper m = new ModelMapper();
            return m.map(h, HistoriaClinicaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public void registrar(@RequestBody HistoriaClinicaCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        HistoriasClinicas h = m.map(dto, HistoriasClinicas.class);
        service.insert(h);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        HistoriasClinicas h = service.listId(id);
        if (h == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una historia clínica con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(h, HistoriaClinicaDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody HistoriaClinicaDTO dto) {
        ModelMapper m = new ModelMapper();
        HistoriasClinicas h = m.map(dto, HistoriasClinicas.class);
        HistoriasClinicas existente = service.listId(h.getIdHistoria());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una historia clínica con ID: " + h.getIdHistoria());
        }
        service.update(h);
        return ResponseEntity.ok("Historia clínica " + h.getIdHistoria() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        HistoriasClinicas h = service.listId(id);
        if (h == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una historia clínica con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Historia clínica con ID " + id + " eliminada correctamente.");
    }

    @GetMapping("/cita/{idCita}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorCita(@PathVariable Integer idCita) {
        HistoriasClinicas h = service.findByCita(idCita);
        if (h == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La cita " + idCita + " no tiene historia clínica.");
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(h, HistoriaClinicaDTO.class));
    }
}