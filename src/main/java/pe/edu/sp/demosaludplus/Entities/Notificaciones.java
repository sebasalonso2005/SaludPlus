package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacion")
    private Integer idNotificacion;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "mensaje", nullable = false, length = 1000)
    private String mensaje;

    @Column(name = "fecha_envio", nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(name = "leido", nullable = false)
    private Boolean leido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", nullable = false)
    private Usuarios usuario;

    public Notificaciones() {}

    public Notificaciones(Integer idNotificacion, String titulo, String mensaje,
                          LocalDateTime fechaEnvio, Boolean leido, Usuarios usuario) {
        this.idNotificacion = idNotificacion;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaEnvio = fechaEnvio;
        this.leido = leido;
        this.usuario = usuario;
    }

    @PrePersist
    void prePersist() {
        if (fechaEnvio == null) fechaEnvio = LocalDateTime.now();
        if (leido == null) leido = false;
    }

    public Integer getIdNotificacion() {
        return idNotificacion;
    }

    public void setIdNotificacion(Integer idNotificacion) {
        this.idNotificacion = idNotificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDateTime fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Boolean getLeido() {
        return leido;
    }

    public void setLeido(Boolean leido) {
        this.leido = leido;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}