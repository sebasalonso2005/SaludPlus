package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "EducacionSalud")
public class EducacionSalud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEdu;

    @Column(name = "tipo", nullable = false , length = 19)
    private int tipo;

    @Column(name = "titulo",nullable = false , length = 25)
    private String titulo;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(name = "id_organizacion", nullable = false , length = 30)
    private int idOrganizacion;


    @ManyToOne
    @JoinColumn(name = "idReporte")
    private ReportesIncidentes reportesIncidentes;

    public EducacionSalud() {

    }

    public EducacionSalud(int idEdu, int tipo, String titulo, String description, LocalDate fechaPublicacion, int idOrganizacion, ReportesIncidentes reportesIncidentes) {
        this.idEdu = idEdu;
        this.tipo = tipo;
        this.titulo = titulo;
        this.description = description;
        this.fechaPublicacion = fechaPublicacion;
        this.idOrganizacion = idOrganizacion;
        this.reportesIncidentes = reportesIncidentes;
    }

    public int getIdEdu() {
        return idEdu;
    }

    public void setIdEdu(int idEdu) {
        this.idEdu = idEdu;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public ReportesIncidentes getReportesIncidentes() {
        return reportesIncidentes;
    }

    public void setReportesIncidentes(ReportesIncidentes reportesIncidentes) {
        this.reportesIncidentes = reportesIncidentes;
    }
}