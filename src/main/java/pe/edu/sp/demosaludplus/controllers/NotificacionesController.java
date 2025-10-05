package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoSaludPlusNuevo.dtos.NotificacionCrearDTO;
import pe.edu.upc.demoSaludPlusNuevo.dtos.NotificacionDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.Notificaciones;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.INotificacionesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private INotificacionesService service;

    @GetMapping
    public List<NotificacionDTO> listar() {
        return service.list().stream().map(n -> {
            ModelMapper m = new ModelMapper();
            return m.map(n, NotificacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody NotificacionCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        service.insert(n);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Notificaciones n = service.listId(id);
        if (n == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificación con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(n, NotificacionDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody NotificacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        Notificaciones existente = service.listId(n.getIdNotificacion());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificación con ID: " + n.getIdNotificacion());
        }
        service.update(n);
        return ResponseEntity.ok("Notificación " + n.getIdNotificacion() + " modificada correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Notificaciones n = service.listId(id);
        if (n == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una notificación con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Notificación con ID " + id + " eliminada correctamente.");
    }

    @GetMapping("/usuario/{idUsuario}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorUsuario(@PathVariable Integer idUsuario) {
        List<Notificaciones> lista = service.listByUsuario(idUsuario);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("El usuario " + idUsuario + " no tiene notificaciones.");
        }
        List<NotificacionDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/usuario/{idUsuario}/no-leidas")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarNoLeidas(@PathVariable Integer idUsuario) {
        List<Notificaciones> lista = service.listNoLeidas(idUsuario);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Sin notificaciones no leídas para el usuario " + idUsuario);
        }
        List<NotificacionDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/usuario/{idUsuario}/no-leidas/count")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> contarNoLeidas(@PathVariable Integer idUsuario) {
        long total = service.countNoLeidas(idUsuario);
        return ResponseEntity.ok(total);
    }
}