package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDate;

public class ContenidoSaludDTO {
    private Integer idEdu;
    private Integer tipo;
    private String titulo;
    private String description;
    private LocalDate fechaPublicacion;
    private Integer idOrganizacion;

    public ContenidoSaludDTO(Integer idEdu, Integer tipo, String titulo, String description, LocalDate fechaPublicacion, Integer idOrganizacion) {
        this.idEdu = idEdu;
        this.tipo = tipo;
        this.titulo = titulo;
        this.description = description;
        this.fechaPublicacion = fechaPublicacion;
        this.idOrganizacion = idOrganizacion;
    }

    public Integer getIdEdu() { return idEdu; }
    public void setIdEdu(Integer idEdu) { this.idEdu = idEdu; }
    public Integer getTipo() { return tipo; }
    public void setTipo(Integer tipo) { this.tipo = tipo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public Integer getIdOrganizacion() { return idOrganizacion; }
    public void setIdOrganizacion(Integer idOrganizacion) { this.idOrganizacion = idOrganizacion; }
}
