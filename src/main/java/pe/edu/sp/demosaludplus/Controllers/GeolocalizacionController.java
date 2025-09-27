package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.Geolocalizacion;
import pe.edu.sp.demosaludplus.servicesinterfaces.IGeolocalizacionService;

import java.util.*;

@RestController
@RequestMapping("/geolocalizacion")
public class GeolocalizacionController {


    @Autowired
    private IGeolocalizacionService geolocalizacionService;

    // 1) Buscar por tipo
    // GET: /geolocalizaciones/tipo/{tipo}
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Geolocalizacion>> buscarPorTipo(@PathVariable String tipo) {
        List<Geolocalizacion> lista = geolocalizacionService.buscarPorTipo(tipo);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 2) Contar por fecha
    // GET: /geolocalizaciones/contar/fecha
    @GetMapping("/contar/fecha")
    public ResponseEntity<List<Map<String, Object>>> contarPorFecha() {
        List<Object[]> filas = geolocalizacionService.contarPorFecha();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = fecha, row[1] = cantidad
            Map<String, Object> m = new HashMap<>();
            m.put("fecha", String.valueOf(row[0]));
            m.put("totalRegistros", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 3) Contar usuarios únicos
    // GET: /geolocalizaciones/contar/usuarios-unicos
    @GetMapping("/contar/usuarios-unicos")
    public ResponseEntity<Map<String, Object>> contarUsuariosUnicos() {
        int total = geolocalizacionService.contarUsuariosUnicos();
        Map<String, Object> body = new HashMap<>();
        body.put("totalUsuariosUnicos", total);
        return ResponseEntity.ok(body);
    }
}
