package pe.edu.sp.demosaludplus.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.Entities.Usuarios;
import pe.edu.sp.demosaludplus.dtos.UsuariosDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IUsuariosService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
    @Autowired
    private IUsuariosService usuariosService;

    // GET: /usuarios/dni/12345678
    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> buscarPorDni(@PathVariable("dni") String dni) {
        Usuarios usuario = usuariosService.buscarPorDni(dni).orElse(null);
        if (usuario == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró usuario con DNI: " + dni);
        }
        return ResponseEntity.ok(usuario);
    }

    // GET: /usuarios/id/15
    @GetMapping("/id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Integer id) {
        Usuarios usuarioId = usuariosService.buscarPorId(id);
        if (usuarioId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró usuario con ID: " + id);
        }
        return ResponseEntity.ok(usuarioId);
    }
}


