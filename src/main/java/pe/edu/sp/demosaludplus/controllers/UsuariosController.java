package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoSaludPlusNuevo.dtos.UsuarioActualizacionDTO;
import pe.edu.upc.demoSaludPlusNuevo.dtos.UsuarioPerfilDTO;
import pe.edu.upc.demoSaludPlusNuevo.dtos.UsuarioRegistroDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.Usuarios;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IUsuariosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosService service;

    @GetMapping
    public List<UsuarioPerfilDTO> listar() {
        return service.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UsuarioPerfilDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody UsuarioRegistroDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios u = m.map(dto, Usuarios.class);
        service.insert(u);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuarios u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioPerfilDTO dto = m.map(u, UsuarioPerfilDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody UsuarioPerfilDTO dto) {
        ModelMapper m = new ModelMapper();
        Usuarios u = m.map(dto, Usuarios.class);

        Usuarios existente = service.listId(u.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un usuario con ID: " + u.getIdUsuario());
        }
        service.update(u);
        return ResponseEntity.ok("Usuario " + u.getIdUsuario() + " modificado correctamente.");
    }

    @PatchMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> actualizarParcial(@PathVariable("id") Integer id,
                                               @RequestBody UsuarioActualizacionDTO dto) {
        Usuarios existente = service.listId(id);
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + id);
        }
        // map parcial
        if (dto.getNombre() != null) existente.setNombre(dto.getNombre());
        if (dto.getTelefono() != null) existente.setTelefono(dto.getTelefono());
        if (dto.getDireccion() != null) existente.setDireccion(dto.getDireccion());
        if (dto.getComunidad() != null) existente.setComunidad(dto.getComunidad());
        service.update(existente);

        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(existente, UsuarioPerfilDTO.class));
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorComunidad(@RequestParam String comunidad) {
        List<Usuarios> lista = service.searchByComunidad(comunidad);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios en la comunidad: " + comunidad);
        }
        List<UsuarioPerfilDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioPerfilDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Usuarios u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un usuario con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Usuario con ID " + id + " eliminado correctamente.");
    }
}