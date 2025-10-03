package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;
import java.util.List;

public class HistoriaClinicaDTO {
    private Integer idHistoria;
    private LocalDateTime fechaCreacion;
    private String alergias;
    private String antecedentes;
    private String enfermedadesCronicas;
    private String detalle;
    private String diagnosticos;
    private String tratamientos;
    private Integer idCita;
    private List<MedicamentoDTO> medicamentos;
    private List<ExamenDTO> examenes;

    public Integer getIdHistoria() { return idHistoria; }
    public void setIdHistoria(Integer idHistoria) { this.idHistoria = idHistoria; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public String getAlergias() { return alergias; }
    public void setAlergias(String alergias) { this.alergias = alergias; }
    public String getAntecedentes() { return antecedentes; }
    public void setAntecedentes(String antecedentes) { this.antecedentes = antecedentes; }
    public String getEnfermedadesCronicas() { return enfermedadesCronicas; }
    public void setEnfermedadesCronicas(String enfermedadesCronicas) { this.enfermedadesCronicas = enfermedadesCronicas; }
    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }
    public String getDiagnosticos() { return diagnosticos; }
    public void setDiagnosticos(String diagnosticos) { this.diagnosticos = diagnosticos; }
    public String getTratamientos() { return tratamientos; }
    public void setTratamientos(String tratamientos) { this.tratamientos = tratamientos; }
    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }
    public List<MedicamentoDTO> getMedicamentos() { return medicamentos; }
    public void setMedicamentos(List<MedicamentoDTO> medicamentos) { this.medicamentos = medicamentos; }
    public List<ExamenDTO> getExamenes() { return examenes; }
    public void setExamenes(List<ExamenDTO> examenes) { this.examenes = examenes; }
}
