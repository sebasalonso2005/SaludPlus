package pe.edu.sp.demosaludplus.Controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.sp.demosaludplus.Entities.ReportesIncidentes;
import pe.edu.sp.demosaludplus.dtos.ReportesIncidentesDTO;
import pe.edu.sp.demosaludplus.servicesinterfaces.IReportesIncidentesService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reportesIncidentes")
public class ReportesIncidentesController {
    @Autowired
    private IReportesIncidentesService bS;
    @GetMapping
    public List<ReportesIncidentesDTO>listar(){
        return bS.list().stream().map(x->{
            ModelMapper m = new ModelMapper();
            return m.map(x, ReportesIncidentesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ReportesIncidentesDTO b){
        ModelMapper m = new ModelMapper();
        ReportesIncidentes bigD=m.map(b, ReportesIncidentes.class);
        bS.insert(bigD);
    }
    @GetMapping("/{idReporte}")
    public ResponseEntity<?> listarId(@PathVariable("idReporte") Integer idReporte) {
        ReportesIncidentes bigD = bS.list(idReporte);
        if (bigD == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + idReporte);
        }
        ModelMapper m = new ModelMapper();
        ReportesIncidentesDTO dto = m.map(bigD, ReportesIncidentesDTO.class);
        return ResponseEntity.ok(dto);
    }
    @DeleteMapping("/{idReporte}")
    public ResponseEntity<String> eliminar(@PathVariable("idReporte") Integer idReporte) {
        ReportesIncidentes bigD = bS.list(idReporte);
        if (bigD == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + idReporte);        }
        bS.delete(idReporte);
        return ResponseEntity.ok("Registro con ID " + idReporte + " eliminado correctamente.");
    }
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ReportesIncidentesDTO dto) {
        ModelMapper m = new ModelMapper();
        ReportesIncidentes b = m.map(dto, ReportesIncidentes.class);
        ReportesIncidentes existente = bS.list(b.getId_reporte());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + b.getId_reporte());
        }
        bS.update(b);
        return ResponseEntity.ok("Registro con ID " + b.getId_reporte() + " modificado correctamente.");
    }
}
