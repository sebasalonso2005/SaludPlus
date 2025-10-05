package pe.edu.sp.demosaludplus.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;
import pe.edu.sp.demosaludplus.dtos.ContenidoCrearDTO;
import pe.edu.sp.demosaludplus.dtos.ContenidoSaludDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEducacionSaludService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/educacion")
public class EducacionSaludController {

    @Autowired
    private IEducacionSaludService service;

    @GetMapping
    public List<ContenidoSaludDTO> listar() {
        return service.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, ContenidoSaludDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody ContenidoCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        EducacionSalud e = m.map(dto, EducacionSalud.class);
        service.insert(e);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        EducacionSalud e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe contenido con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(e, ContenidoSaludDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody ContenidoSaludDTO dto) {
        ModelMapper m = new ModelMapper();
        EducacionSalud e = m.map(dto, EducacionSalud.class);
        EducacionSalud existente = service.listId(e.getIdEdu());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe contenido con ID: " + e.getIdEdu());
        }
        service.update(e);
        return ResponseEntity.ok("Contenido " + e.getIdEdu() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        EducacionSalud e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe contenido con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Contenido con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/busquedas/titulo")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarTitulo(@RequestParam String q) {
        List<EducacionSalud> lista = service.searchTitulo(q);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron contenidos con título que contenga: " + q);
        }
        List<ContenidoSaludDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContenidoSaludDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/busquedas/fecha")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorFecha(@RequestParam LocalDate desde,
                                            @RequestParam LocalDate hasta) {
        List<EducacionSalud> lista = service.searchByFecha(desde, hasta);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron contenidos en el rango indicado.");
        }
        List<ContenidoSaludDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContenidoSaludDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/tipos/{tipo}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorTipo(@PathVariable Integer tipo) {
        List<EducacionSalud> lista = service.listByTipo(tipo);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron contenidos para el tipo: " + tipo);
        }
        List<ContenidoSaludDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ContenidoSaludDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}