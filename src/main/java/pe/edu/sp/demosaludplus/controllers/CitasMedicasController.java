package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.dtos.*;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasMedicasService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/citas")
public class CitasMedicasController {

    @Autowired
    private ICitasMedicasService service;

    @GetMapping
    public List<CitaListaDTO> listar() {
        return service.list().stream().map(c -> {
            ModelMapper m = new ModelMapper();
            return m.map(c, CitaListaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody CitaCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        CitasMedicas c = m.map(dto, CitasMedicas.class);
        service.insert(c);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        CitasMedicas c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una cita con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(c, CitaDetalleDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody CitaDetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        CitasMedicas c = m.map(dto, CitasMedicas.class);
        CitasMedicas existente = service.listId(c.getId_cita());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una cita con ID: " + c.getId_cita());
        }
        service.update(c);
        return ResponseEntity.ok("Cita " + c.getId_cita() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        CitasMedicas c = service.listId(id);
        if (c == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una cita con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Cita con ID " + id + " eliminada correctamente.");
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorUsuario(@PathVariable Integer idUsuario) {
        List<CitasMedicas> lista = service.listByUsuario(idUsuario);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario " + idUsuario + " no tiene citas registradas.");
        }
        List<CitaListaDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaListaDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorUsuarioYFechas(@RequestParam Integer idUsuario,
                                                     @RequestParam LocalDate desde,
                                                     @RequestParam LocalDate hasta) {
        List<CitasMedicas> lista = service.searchByUsuarioAndFecha(idUsuario, desde, hasta);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No hay citas para el usuario " + idUsuario + " en el rango indicado.");
        }
        List<CitaListaDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CitaListaDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}