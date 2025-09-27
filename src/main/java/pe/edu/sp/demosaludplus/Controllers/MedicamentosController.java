package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.Medicamentos;
import pe.edu.sp.demosaludplus.servicesinterfaces.IMedicamentosService;

import java.util.*;

@RestController
@RequestMapping("/medicamentos")

public class MedicamentosController {

    @Autowired
    private IMedicamentosService medicamentosService;

    // GET: /medicamentos/nombre/Paracetamol
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Medicamentos>> buscarPorNombre(@PathVariable String nombre) {
        List<Medicamentos> lista = medicamentosService.buscarPorNombre(nombre);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // GET: /medicamentos/dosis/500mg
    @GetMapping("/dosis/{dosis}")
    public ResponseEntity<List<Medicamentos>> buscarPorDosis(@PathVariable String dosis) {
        List<Medicamentos> lista = medicamentosService.buscarPorDosis(dosis);
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(lista);
    }

    // GET: /medicamentos/contar/duracion
    @GetMapping("/contar/duracion")
    public ResponseEntity<List<Map<String, Object>>> contarPorDuracion() {
        List<Object[]> filas = medicamentosService.contarMedicamentosPorDuracion();
        if (filas == null || filas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }

        // devolvemos JSON claro sin tocar DTOs existentes
        List<Map<String, Object>> out = new ArrayList<>();
        for (Object[] row : filas) {
            // Suposición: row[0] = duracion, row[1] = cantidad
            Map<String, Object> m = new HashMap<>();
            m.put("duracion", String.valueOf(row[0]));
            m.put("totalMedicamentos", ((Number) row[1]).intValue());
            out.add(m);
        }
        return ResponseEntity.ok(out);
    }



}
