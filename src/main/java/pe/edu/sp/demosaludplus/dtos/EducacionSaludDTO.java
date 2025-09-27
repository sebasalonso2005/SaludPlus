package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;

public class EducacionSaludDTO {
    private int idEdu;
    private int tipo;
    private String titulo;
    private String description;
    private LocalDate fechaPublicacion;
    private int idOrganizacion;
    private String reportesIncidente;

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

    public String getReportesIncidente() {
        return reportesIncidente;
    }

    public void setReportesIncidente(String reportesIncidente) {
        this.reportesIncidente = reportesIncidente;
    }
}
