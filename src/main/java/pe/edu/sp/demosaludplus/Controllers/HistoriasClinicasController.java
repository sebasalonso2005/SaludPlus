package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.HistoriasClinicas;
import pe.edu.sp.demosaludplus.servicesinterfaces.IHistoriasClinicasService;

import java.util.*;

@RestController
@RequestMapping("/historiasClinicas")
public class HistoriasClinicasController {

    @Autowired
    private IHistoriasClinicasService historiasService;

    // 1) Contar por enfermedad crónica
    // GET: /historias/contar/enfermedad/diabetes
    @GetMapping("/contar/enfermedad/{enfermedad}")
    public ResponseEntity<Map<String, Object>> contarPorEnfermedadCronica(@PathVariable String enfermedad) {
        int total = historiasService.contarPorEnfermedadCronica(enfermedad);
        Map<String, Object> body = new HashMap<>();
        body.put("enfermedad", enfermedad);
        body.put("totalHistorias", total);
        return ResponseEntity.ok(body);
    }

    // 2) Buscar por diagnóstico
    // GET: /historias/diagnostico/asma
    @GetMapping("/diagnostico/{diagnostico}")
    public ResponseEntity<List<HistoriasClinicas>> buscarPorDiagnostico(@PathVariable String diagnostico) {
        List<HistoriasClinicas> lista = historiasService.buscarPorDiagnostico(diagnostico);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 3) Contar por fecha de creación
    // GET: /historias/contar/fecha-creacion
    @GetMapping("/contar/fecha-creacion")
    public ResponseEntity<List<Map<String, Object>>> contarPorFechaCreacion() {
        List<Object[]> filas = historiasService.contarPorFechaCreacion();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = fecha, row[1] = cantidad
            Map<String, Object> m = new HashMap<>();
            m.put("fecha", String.valueOf(row[0]));
            m.put("totalHistorias", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }
}
