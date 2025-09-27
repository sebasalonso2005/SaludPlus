package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.EventosPeligrosos;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEventosPeligrososService;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
@RequestMapping("/eventosPeligrosos")
public class EventosPeligrososController {

    @Autowired
    private IEventosPeligrososService eventosService;

    // 1) Buscar por TIPO
    // GET: /eventos-peligrosos/tipo/INCENDIO
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<EventosPeligrosos>> buscarPorTipo(@PathVariable String tipo) {
        List<EventosPeligrosos> lista = eventosService.buscarPorTipo(tipo);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 2) Buscar por FECHA (ISO-8601: 2025-09-23T14:30:00)
    // GET: /eventos-peligrosos/fecha/2025-09-23T14:30:00
    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<EventosPeligrosos>> buscarPorFecha(@PathVariable String fecha) {
        LocalDateTime f;
        try {
            f = LocalDateTime.parse(fecha); // formato ISO por defecto
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }

        List<EventosPeligrosos> lista = eventosService.buscarPorFecha(f);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 3) Contar USUARIOS por TIPO
    // GET: /eventos-peligrosos/contar/usuarios-por-tipo/INCENDIO
    @GetMapping("/contar/usuarios-por-tipo/{tipo}")
    public ResponseEntity<List<Map<String, Object>>> contarUsuariosPorTipo(@PathVariable String tipo) {
        List<Object[]> filas = eventosService.contarUsuariosPorTipo(tipo);
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición común: row[0] = usuario (id o nombre), row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("tipo", tipo);
            m.put("usuario", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 4) Contar EVENTOS por FECHA
    // GET: /eventos-peligrosos/contar/fecha
    @GetMapping("/contar/fecha")
    public ResponseEntity<List<Map<String, Object>>> contarEventosPorFecha() {
        List<Object[]> filas = eventosService.contarEventosPorFecha();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = fecha (LocalDate/LocalDateTime/String), row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("fecha", String.valueOf(row[0]));
            m.put("totalEventos", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }
}
