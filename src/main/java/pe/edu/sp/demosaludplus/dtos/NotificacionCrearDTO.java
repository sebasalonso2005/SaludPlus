package pe.edu.sp.demosaludplus.dtos;

public class NotificacionCrearDTO {
    private String titulo;
    private String mensaje;
    private Integer idUsuario;

    public NotificacionCrearDTO(String titulo, String mensaje, Integer idUsuario) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.idUsuario = idUsuario;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
}
