package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas_medicas")
public class CitasMedicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    private Integer id_cita;

    @Column(name = "fecha_cita", nullable = false)
    private LocalDate fecha_cita;

    @Column(name = "hora", nullable = false)
    private LocalDateTime hora;

    @Column(name = "tipo", nullable = false, length = 30)
    private String tipo;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "motivo", nullable = false, columnDefinition = "text")
    private String motivo;

    @Column(name = "creada_en", nullable = false)
    private LocalDateTime creadaEn;

    @Column(name = "duracion_min", nullable = false)
    private Integer duracionMin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "id_usuario",        // nombre exacto de la FK en tu diagrama
            referencedColumnName = "id_usuario",
            nullable = false
    )
    private Usuarios usuario;

    public CitasMedicas() {}

    public CitasMedicas(Integer id_cita, LocalDate fecha_cita, LocalDateTime hora, String tipo, String estado, String motivo, LocalDateTime creadaEn, Integer duracionMin, Usuarios usuario) {
        this.id_cita = id_cita;
        this.fecha_cita = fecha_cita;
        this.hora = hora;
        this.tipo = tipo;
        this.estado = estado;
        this.motivo = motivo;
        this.creadaEn = creadaEn;
        this.duracionMin = duracionMin;
        this.usuario = usuario;
    }

    public Integer getId_cita() {
        return id_cita;
    }

    public void setId_cita(Integer id_cita) {
        this.id_cita = id_cita;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getCreadaEn() {
        return creadaEn;
    }

    public void setCreadaEn(LocalDateTime creadaEn) {
        this.creadaEn = creadaEn;
    }

    public Integer getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(Integer duracionMin) {
        this.duracionMin = duracionMin;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}

