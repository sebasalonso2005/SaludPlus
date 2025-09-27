package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.Notificaciones;
import pe.edu.sp.demosaludplus.servicesinterfaces.INotificacionesService;

import java.util.*;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {

    @Autowired
    private INotificacionesService notificacionesService;

    // 1) GET: /notificaciones
    @GetMapping
    public ResponseEntity<List<Notificaciones>> listarTodo() {
        List<Notificaciones> lista = notificacionesService.list();
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 2) GET: /notificaciones/id/{idNotificacion}
    @GetMapping("/id/{idNotificacion}")
    public ResponseEntity<Notificaciones> buscarPorId(@PathVariable Integer idNotificacion) {
        return notificacionesService.buscarPorIdNotificaciones(idNotificacion)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // 3) GET: /notificaciones/cantidad/{idUsuario}
    @GetMapping("/cantidad/{idUsuario}")
    public ResponseEntity<List<Map<String, Object>>> cantidadPorUsuario(@PathVariable Integer idUsuario) {
        List<String[]> filas = notificacionesService.cantidadNotificacionesPorUsuario(idUsuario);
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        // Suposición: row[0] = idUsuario o categoría, row[1] = cantidad
        List<Map<String, Object>> out = new ArrayList<>();
        for (String[] row : filas) {
            Map<String, Object> m = new HashMap<>();
            m.put("idUsuario", row[0]);                     // ajusta si tu query agrupa por algo distinto
            m.put("totalNotificaciones", Integer.parseInt(row[1]));
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }
}
