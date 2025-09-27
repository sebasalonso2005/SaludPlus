package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.servicesinterfaces.IExamenesMedicosService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
@RequestMapping("/examenesMedicos")
public class ExamenesMedicosController {

    @Autowired
    private IExamenesMedicosService examenesService;

    // 1) Contar por fecha (enviada en la URL como YYYY-MM-DD)
    // GET: /examenes/contar/fecha/2025-09-23
    @GetMapping("/contar/fecha/{fecha}")
    public ResponseEntity<List<Map<String, Object>>> contarPorFecha(@PathVariable String fecha) {
        LocalDate fechaLD;
        try {
            fechaLD = LocalDate.parse(fecha); // formato: 2025-09-23
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.emptyList());
        }

        List<Object[]> filas = examenesService.contarPorFecha(fechaLD);
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición común: row[0] = criterio (p.ej., tipoExamen), row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("criterio", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 2) Contar exámenes por TIPO
    // GET: /examenes/contar/tipo
    @GetMapping("/contar/tipo")
    public ResponseEntity<List<Map<String, Object>>> contarExamenesPorTipo() {
        List<Object[]> filas = examenesService.contarExamenesPorTipo();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = tipoExamen, row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("tipoExamen", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 3) Contar exámenes por ARCHIVO URL
    // GET: /examenes/contar/archivo-url
    @GetMapping("/contar/archivo-url")
    public ResponseEntity<List<Map<String, Object>>> contarExamenesPorArchivoUrl() {
        List<Object[]> filas = examenesService.contarExamenesPorArchivoUrl();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = archivoUrl (o flag), row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("archivoUrl", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

}
