package pe.edu.sp.demosaludplus.dtos;

public class NotificacionMarcarLeidoSolicitudDTO {
    private Integer idNotificacion;
    private Boolean leido;

    public NotificacionMarcarLeidoSolicitudDTO(Integer idNotificacion, Boolean leido) {
        this.idNotificacion = idNotificacion;
        this.leido = leido;
    }

    public Integer getIdNotificacion() { return idNotificacion; }
    public void setIdNotificacion(Integer idNotificacion) { this.idNotificacion = idNotificacion; }
    public Boolean getLeido() { return leido; }
    public void setLeido(Boolean leido) { this.leido = leido; }
}
