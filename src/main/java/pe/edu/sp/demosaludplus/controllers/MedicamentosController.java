package pe.edu.sp.demosaludplus.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.dtos.MedicamentoDTO;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;
import pe.edu.sp.demosaludplus.servicesinterfaces.IMedicamentosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {

    @Autowired
    private IMedicamentosService service;

    @GetMapping
    public List<MedicamentoDTO> listar() {
        return service.list().stream().map(med -> {
            ModelMapper m = new ModelMapper();
            return m.map(med, MedicamentoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public void registrar(@RequestBody MedicamentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Medicamentos med = m.map(dto, Medicamentos.class);
        service.insert(med);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Medicamentos med = service.listId(id);
        if (med == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un medicamento con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(med, MedicamentoDTO.class));
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> modificar(@RequestBody MedicamentoDTO dto) {
        ModelMapper m = new ModelMapper();
        Medicamentos med = m.map(dto, Medicamentos.class);
        Medicamentos existente = service.listId(med.getIdMedicamento());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un medicamento con ID: " + med.getIdMedicamento());
        }
        service.update(med);
        return ResponseEntity.ok("Medicamento " + med.getIdMedicamento() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Medicamentos med = service.listId(id);
        if (med == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un medicamento con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Medicamento con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/cita/{idCita}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ResponseEntity<?> listarPorCita(@PathVariable Integer idCita) {
        List<Medicamentos> lista = service.listByCita(idCita);
        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("La cita " + idCita + " no tiene medicamentos.");
        }
        List<MedicamentoDTO> dtos = lista.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, MedicamentoDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }
}