package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class HistoriasClinicasDTO {
    private Integer idHistoria;
    private LocalDateTime fechaCreacion;
    private String alergias;
    private String antecedentes;
    private String enfermedadesCronicas;
    private String detalle;
    private String diagnosticos;
    private String tratamientos;

    public Integer getIdHistoria() {return idHistoria;}

    public void setIdHistoria(Integer idHistoria) {this.idHistoria = idHistoria;}

    public LocalDateTime getFechaCreacion() {return fechaCreacion;}

    public void setFechaCreacion(LocalDateTime fechaCreacion) {this.fechaCreacion = fechaCreacion;}

    public String getAlergias() {return alergias;}

    public void setAlergias(String alergias) {this.alergias = alergias;}

    public String getAntecedentes() {return antecedentes;}

    public void setAntecedentes(String antecedentes) {this.antecedentes = antecedentes;}

    public String getEnfermedadesCronicas() {return enfermedadesCronicas;}

    public void setEnfermedadesCronicas(String enfermedadesCronicas) {this.enfermedadesCronicas = enfermedadesCronicas;}

    public String getDetalle() {return detalle;}

    public void setDetalle(String detalle) {this.detalle = detalle;}

    public String getDiagnosticos() {return diagnosticos;}

    public void setDiagnosticos(String diagnosticos) {this.diagnosticos = diagnosticos;}

    public String getTratamientos() {return tratamientos;}

    public void setTratamientos(String tratamientos) {this.tratamientos = tratamientos;}
}
