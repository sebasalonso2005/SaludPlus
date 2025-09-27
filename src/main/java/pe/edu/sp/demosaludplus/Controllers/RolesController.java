package pe.edu.sp.demosaludplus.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.sp.demosaludplus.dtos.RolesDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IRolesService;

@RestController
@RequestMapping("/roles")

public class RolesController {
    @Autowired
    private IRolesService rolesService;

    @GetMapping("/rol/{rol}")
    public ResponseEntity<Integer> contarUsuariosPorRol(@PathVariable String rol) {
        int total = rolesService.contarUsuariosPorRol(rol);
        return ResponseEntity.ok(total);
    }
}
