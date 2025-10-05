package pe.edu.sp.demosaludplus.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.Entities.ExamenesMedicos;
import pe.edu.sp.demosaludplus.dtos.ExamenCrearDTO;
import pe.edu.sp.demosaludplus.dtos.ExamenDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IExamenesMedicosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/examenes")
public class ExamenesMedicosController {

    @Autowired
    private IExamenesMedicosService service;

    @GetMapping
    public List<ExamenDTO> listar() {
        return service.list().stream().map(e -> {
            ModelMapper m = new ModelMapper();
            return m.map(e, ExamenDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public void registrar(@RequestBody ExamenCrearDTO dto) {
        ModelMapper m = new ModelMapper();
        ExamenesMedicos e = m.map(dto, ExamenesMedicos.class);
        service.insert(e);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        ExamenesMedicos e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un examen con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(e, ExamenDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody ExamenDTO dto) {
        ModelMapper m = new ModelMapper();
        ExamenesMedicos e = m.map(dto, ExamenesMedicos.class);
        ExamenesMedicos existente = service.listId(e.getIdExamen());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un examen con ID: " + e.getIdExamen());
        }
        service.update(e);
        return ResponseEntity.ok("Examen " + e.getIdExamen() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        ExamenesMedicos e = service.listId(id);
        if (e == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un examen con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Examen con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/cita/{idCita}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorCita(@PathVariable Integer idCita) {
        List<ExamenesMedicos> lista = service.listByCita(idCita);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La cita " + idCita + " no tiene exámenes registrados.");
        }
        List<ExamenDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ExamenDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}
