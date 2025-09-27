package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasPresencialesService;

import java.util.*;

@RestController
@RequestMapping("/citasPresenciales")
public class CitasPresencialesController {

    @Autowired
    private ICitasPresencialesService citasPresencialesService;

    // 1) Mostrar estado de citas
    // GET: /citas-presenciales/estado
    @GetMapping("/estado")
    public ResponseEntity<List<Map<String, Object>>> mostrarEstadoDeCitas() {
        List<Object[]> filas = citasPresencialesService.mostrarEstadoDeCitas();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [estado, (opcional) cantidad]
            if (row.length > 0) m.put("estado", String.valueOf(row[0]));
            if (row.length > 1) m.put("cantidad", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 2) Cantidad de citas presenciales por estado
    // GET: /citas-presenciales/contar/estado
    @GetMapping("/contar/estado")
    public ResponseEntity<List<Map<String, Object>>> cantidadCitasPresencialesPorEstado() {
        List<Object[]> filas = citasPresencialesService.cantidadCitasPresencialesPorEstado();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [estado, total]
            m.put("estado", String.valueOf(row[0]));
            m.put("totalCitas", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 3) Cantidad de médicos por consultorio
    // GET: /citas-presenciales/contar/medicos-por-consultorio
    @GetMapping("/contar/medicos-por-consultorio")
    public ResponseEntity<List<Map<String, Object>>> cantidadMedicosPorConsultorio() {
        List<Object[]> filas = citasPresencialesService.cantidadMedicosPorConsultorio();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [consultorio, totalMedicos]
            m.put("consultorio", String.valueOf(row[0]));
            m.put("totalMedicos", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 4) Cantidad de citas por consultorio
    // GET: /citas-presenciales/contar/citas-por-consultorio
    @GetMapping("/contar/citas-por-consultorio")
    public ResponseEntity<List<Map<String, Object>>> cantidadCitasPorConsultorio() {
        List<Object[]> filas = citasPresencialesService.cantidadCitasPorConsultorio();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [consultorio, totalCitas]
            m.put("consultorio", String.valueOf(row[0]));
            m.put("totalCitas", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 5) Cantidad de citas por médico asignado
    // GET: /citas-presenciales/contar/citas-por-medico
    @GetMapping("/contar/citas-por-medico")
    public ResponseEntity<List<Map<String, Object>>> cantidadCitasPorMedicoAsignado() {
        List<Object[]> filas = citasPresencialesService.cantidadCitasPorMedicoAsignado();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [medico (id o nombre), totalCitas]
            m.put("medico", String.valueOf(row[0]));
            m.put("totalCitas", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }
}
