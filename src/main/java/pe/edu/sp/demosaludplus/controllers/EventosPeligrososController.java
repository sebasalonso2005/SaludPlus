package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoSaludPlusNuevo.dtos.EventoPeligrosoCrearDTO;
import pe.edu.upc.demoSaludPlusNuevo.dtos.EventoPeligrosoDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.EventosPeligrosos;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IEventosPeligrososService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos-peligrosos")
public class EventosPeligrososController {

    @Autowired
    private IEventosPeligrososService service;

    @GetMapping
    public List<EventoPeligrosoDTO> listar() {
        return service.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, EventoPeligrosoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody EventoPeligrosoCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        EventosPeligrosos e = m.map(dto, EventosPeligrosos.class);
        service.insert(e);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        EventosPeligrosos e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un evento con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(e, EventoPeligrosoDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody EventoPeligrosoDTO dto) {
        ModelMapper m = new ModelMapper();
        EventosPeligrosos e = m.map(dto, EventosPeligrosos.class);
        EventosPeligrosos existente = service.listId(e.getIdEvento());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un evento con ID: " + e.getIdEvento());
        }
        service.update(e);
        return ResponseEntity.ok("Evento " + e.getIdEvento() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EventosPeligrosos e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un evento con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Evento con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorUsuario(@PathVariable Integer idUsuario) {
        List<EventosPeligrosos> lista = service.listByUsuario(idUsuario);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario " + idUsuario + " no tiene eventos peligrosos.");
        }
        List<EventoPeligrosoDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventoPeligrosoDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorUsuarioYFecha(@RequestParam Integer idUsuario,
                                                    @RequestParam LocalDateTime desde,
                                                    @RequestParam LocalDateTime hasta) {
        List<EventosPeligrosos> lista = service.searchByUsuarioYFecha(idUsuario, desde, hasta);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sin eventos peligrosos en el rango indicado para el usuario.");
        }
        List<EventoPeligrosoDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EventoPeligrosoDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
