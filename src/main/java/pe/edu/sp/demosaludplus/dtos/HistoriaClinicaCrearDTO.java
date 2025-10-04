package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class HistoriaClinicaCrearDTO {
    private Integer idCita;
    private LocalDateTime fechaCreacion;
    private String alergias;
    private String antecedentes;
    private String enfermedadesCronicas;
    private String detalle;
    private String diagnosticos;
    private String tratamientos;

    public HistoriaClinicaCrearDTO(Integer idCita, LocalDateTime fechaCreacion, String alergias, String antecedentes, String enfermedadesCronicas, String detalle, String diagnosticos, String tratamientos) {
        this.idCita = idCita;
        this.fechaCreacion = fechaCreacion;
        this.alergias = alergias;
        this.antecedentes = antecedentes;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.detalle = detalle;
        this.diagnosticos = diagnosticos;
        this.tratamientos = tratamientos;
    }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }
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
}
