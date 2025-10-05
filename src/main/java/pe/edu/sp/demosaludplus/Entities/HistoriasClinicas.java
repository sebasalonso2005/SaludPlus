package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historias_clinicas")
public class HistoriasClinicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historia")
    private Integer idHistoria;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "alergias", nullable = false, length = 250)
    private String alergias;

    @Column(name = "antecedentes", nullable = false, length = 500)
    private String antecedentes;

    @Column(name = "enfermedades_cronicas", nullable = false, length = 250)
    private String enfermedadesCronicas;

    @Column(name = "detalle", nullable = false, length = 500)
    private String detalle;

    @Column(name = "diagnosticos", nullable = false, length = 500)
    private String diagnosticos;

    @Column(name = "tratamientos", nullable = false, length = 500)
    private String tratamientos;

    // ✅ 1–1 con la cita (historia de esa cita)
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "id_cita",
            referencedColumnName = "id_cita",
            nullable = false,
            unique = true
    )
    private CitasMedicas citaMedica;

    public HistoriasClinicas() {}

    public HistoriasClinicas(Integer idHistoria, LocalDateTime fechaCreacion, String alergias, String antecedentes, String enfermedadesCronicas, String detalle, String diagnosticos, String tratamientos, CitasMedicas citaMedica) {
        this.idHistoria = idHistoria;
        this.fechaCreacion = fechaCreacion;
        this.alergias = alergias;
        this.antecedentes = antecedentes;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.detalle = detalle;
        this.diagnosticos = diagnosticos;
        this.tratamientos = tratamientos;
        this.citaMedica = citaMedica;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getEnfermedadesCronicas() {
        return enfermedadesCronicas;
    }

    public void setEnfermedadesCronicas(String enfermedadesCronicas) {
        this.enfermedadesCronicas = enfermedadesCronicas;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public CitasMedicas getCitaMedica() {
        return citaMedica;
    }

    public void setCitaMedica(CitasMedicas citaMedica) {
        this.citaMedica = citaMedica;
    }
}