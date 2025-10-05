package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "examenes_medicos")
public class ExamenesMedicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private Integer idExamen;

    @Column(name = "tipo_examen", nullable = false, length = 100)
    private String tipoExamen;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "resultado", nullable = false, columnDefinition = "text")
    private String resultado;

    @Column(name = "archivo_url", nullable = false, length = 255)
    private String archivoUrl;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita", nullable = false)
    private CitasMedicas citaMedica;

    public ExamenesMedicos() {}

    public ExamenesMedicos(Integer idExamen, String tipoExamen, LocalDate fecha,
                           String resultado, String archivoUrl, CitasMedicas citaMedica) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
        this.fecha = fecha;
        this.resultado = resultado;
        this.archivoUrl = archivoUrl;
        this.citaMedica = citaMedica;
    }

    public Integer getIdExamen() { return idExamen; }
    public void setIdExamen(Integer idExamen) { this.idExamen = idExamen; }
    public String getTipoExamen() { return tipoExamen; }
    public void setTipoExamen(String tipoExamen) { this.tipoExamen = tipoExamen; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public String getArchivoUrl() { return archivoUrl; }
    public void setArchivoUrl(String archivoUrl) { this.archivoUrl = archivoUrl; }
    public CitasMedicas getCitaMedica() { return citaMedica; }
    public void setCitaMedica(CitasMedicas citaMedica) { this.citaMedica = citaMedica; }
}