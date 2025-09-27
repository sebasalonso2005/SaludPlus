package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.CitasMedicas;
import pe.edu.sp.demosaludplus.servicesinterfaces.ICitasMedicasService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

@RestController
@RequestMapping("/citasMedicas")
public class CitasMedicasController {


    @Autowired
    private ICitasMedicasService citasService;

    // 1) Citas médicas ACTIVAS
    // GET: /citas-medicas/activas
    @GetMapping("/activas")
    public ResponseEntity<List<CitasMedicas>> obtenerCitasMedicasActivas() {
        List<CitasMedicas> lista = citasService.obtenerCitasMedicasActivas();
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 2) Cantidad de citas PRESENCIALES por ESTADO
    // GET: /citas-medicas/contar/presenciales-por-estado
    @GetMapping("/contar/presenciales-por-estado")
    public ResponseEntity<List<Map<String, Object>>> cantidadCitasPresencialesPorEstado() {
        List<Object[]> filas = citasService.cantidadCitasPresencialesPorEstado();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Supuesto: row[0] = estado, row[1] = total
            Map<String, Object> m = new HashMap<>();
            m.put("estado", String.valueOf(row[0]));
            m.put("total", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

    // 3) Buscar citas por ID de usuario
    // GET: /citas-medicas/usuario/{idUsuario}
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<CitasMedicas>> buscarCitasPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        List<CitasMedicas> lista = citasService.buscarCitasPorIdUsuario(idUsuario);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // 4) Cantidad de usuarios con cita en FECHA (YYYY-MM-DD)
    // GET: /citas-medicas/contar/usuarios-por-fecha/2025-09-23
    @GetMapping("/contar/usuarios-por-fecha/{fecha}")
    public ResponseEntity<List<Map<String, Object>>> cantidadUsuariosConCitaEnFecha(@PathVariable String fecha) {
        LocalDate f;
        try {
            f = LocalDate.parse(fecha); // formato ISO yyyy-MM-dd
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.emptyList());
        }

        List<Object[]> filas = citasService.cantidadUsuariosConCitaEnFecha(f);
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Supuesto común: row[0] = fecha o criterio, row[1] = total usuarios
            Map<String, Object> m = new HashMap<>();
            m.put("criterio", String.valueOf(row[0]));
            m.put("totalUsuarios", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }

}
