package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.demoSaludPlusNuevo.dtos.ReporteIncidenteCrearDTO;
import pe.edu.upc.demoSaludPlusNuevo.dtos.ReporteIncidenteDTO;
import pe.edu.upc.demoSaludPlusNuevo.entities.ReportesIncidentes;
import pe.edu.upc.demoSaludPlusNuevo.servicesinterfaces.IReportesIncidentesService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reportes-incidentes")
public class ReportesIncidentesController {

    @Autowired
    private IReportesIncidentesService service;

    @GetMapping
    public List<ReporteIncidenteDTO> listar() {
        return service.list().stream().map(r -> {
            ModelMapper m = new ModelMapper();
            return m.map(r, ReporteIncidenteDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public void registrar(@RequestBody ReporteIncidenteCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        ReportesIncidentes r = m.map(dto, ReportesIncidentes.class);
        service.insert(r);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        ReportesIncidentes r = service.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(r, ReporteIncidenteDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody ReporteIncidenteDTO dto) {
        ModelMapper m = new ModelMapper();
        ReportesIncidentes r = m.map(dto, ReportesIncidentes.class);
        ReportesIncidentes existente = service.listId(r.getId_reporte());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con ID: " + r.getId_reporte());
        }
        service.update(r);
        return ResponseEntity.ok("Reporte " + r.getId_reporte() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ReportesIncidentes r = service.listId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un reporte con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Reporte con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/busquedas")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> buscarPorTipoYFecha(@RequestParam String tipo,
                                                 @RequestParam LocalDate desde,
                                                 @RequestParam LocalDate hasta) {
        List<ReportesIncidentes> lista = service.searchByTipoYFecha(tipo, desde, hasta);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reportes para el tipo indicado en el rango.");
        }
        List<ReporteIncidenteDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReporteIncidenteDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
