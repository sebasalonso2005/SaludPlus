package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasVideollamadasService;

import java.util.*;

@RestController
@RequestMapping("/citasVideollamada")
public class CitasVideollamadasController {

    @Autowired
    private ICitasVideollamadasService citasVideoService;

    // 1) Estado + Plataforma
    // GET: /citas-videollamadas/estado-plataforma
    @GetMapping("/estado-plataforma")
    public ResponseEntity<List<Map<String, Object>>> obtenerEstadoYPlataforma() {
        List<Object[]> filas = citasVideoService.obtenerEstadoYPlataformaDeCitasVideoLlamadas();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [estado, plataforma, (opcional) cantidad]
            if (row.length > 0) m.put("estado", String.valueOf(row[0]));
            if (row.length > 1) m.put("plataforma", String.valueOf(row[1]));
            if (row.length > 2) {
                Object v = row[2];
                m.put("cantidad", (v instanceof Number) ? ((Number) v).intValue() : String.valueOf(v));
            }
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 2) Mostrar estados (lista de estados y, si viene, su cantidad)
    // GET: /citas-videollamadas/estado
    @GetMapping("/estado")
    public ResponseEntity<List<Map<String, Object>>> mostrarEstadoDeCitas() {
        List<Object[]> filas = citasVideoService.mostrarEstadoDeCitasVideoLlamadas();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            // Supuesto: [estado, (opcional) cantidad]
            if (row.length > 0) m.put("estado", String.valueOf(row[0]));
            if (row.length > 1) {
                Object v = row[1];
                m.put("cantidad", (v instanceof Number) ? ((Number) v).intValue() : String.valueOf(v));
            }
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 3) Cantidad de citas por estado
    // GET: /citas-videollamadas/contar/estado
    @GetMapping("/contar/estado")
    public ResponseEntity<List<Map<String, Object>>> cantidadPorEstado() {
        List<Object[]> filas = citasVideoService.cantidadCitasVideollamadasPorEstado();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Supuesto: [estado, total]
            Map<String, Object> m = new HashMap<>();
            m.put("estado", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }
}
