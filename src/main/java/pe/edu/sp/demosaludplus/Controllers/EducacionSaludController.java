package pe.edu.sp.demosaludplus.Controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;
import pe.edu.sp.demosaludplus.dtos.EducacionSaludDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IEducacionSaludService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("educacionSalud")
public class EducacionSaludController {
    @Autowired
    private IEducacionSaludService eS;
    @GetMapping
    public List<EducacionSaludDTO> listar(){
        return eS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x,EducacionSaludDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EducacionSaludDTO e){
        ModelMapper m = new ModelMapper();
        EducacionSalud eduS=m.map(e, EducacionSalud.class);
        eS.insert(eduS);
    }
}
