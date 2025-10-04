package pe.edu.sp.demosaludplus.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas_videollamadas")
public class CitasVideollamadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_videollamada")
    private Integer id_videollamada;

    @Column(name = "enlace_url", nullable = false, length = 255)
    private String enlaceUrl;

    @Column(name = "codigo_acceso", length = 50)
    private String codigoAcceso;

    @Column(name = "plataforma", nullable = false, length = 30)
    private String plataforma;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    @Column(name = "programada_en", nullable = false)
    private LocalDateTime programadaEn;

    @Column(name = "inicia_en")
    private LocalDateTime iniciaEn;

    @Column(name = "finaliza_en")
    private LocalDateTime finalizaEn;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "id_cita",
            referencedColumnName = "id_cita",
            nullable = false,
            unique = true
    )
    private CitasMedicas citaMedica;

    public CitasVideollamadas() {}

    public CitasVideollamadas(Integer idVideollamada, String enlaceUrl, String codigoAcceso,
                              String plataforma, String estado, LocalDateTime programadaEn,
                              LocalDateTime iniciaEn, LocalDateTime finalizaEn,
                              CitasMedicas citaMedica) {
        this.id_videollamada = idVideollamada;
        this.enlaceUrl = enlaceUrl;
        this.codigoAcceso = codigoAcceso;
        this.plataforma = plataforma;
        this.estado = estado;
        this.programadaEn = programadaEn;
        this.iniciaEn = iniciaEn;
        this.finalizaEn = finalizaEn;
        this.citaMedica = citaMedica;
    }

    @PrePersist
    void prePersist() {
        if (programadaEn == null) programadaEn = LocalDateTime.now();
        if (estado == null) estado = "PROGRAMADA";
    }

    // Getters/Setters
    public Integer getIdVideollamada() { return id_videollamada; }
    public void setIdVideollamada(Integer idVideollamada) { this.id_videollamada = idVideollamada; }

    public String getEnlaceUrl() { return enlaceUrl; }
    public void setEnlaceUrl(String enlaceUrl) { this.enlaceUrl = enlaceUrl; }

    public String getCodigoAcceso() { return codigoAcceso; }
    public void setCodigoAcceso(String codigoAcceso) { this.codigoAcceso = codigoAcceso; }

    public String getPlataforma() { return plataforma; }
    public void setPlataforma(String plataforma) { this.plataforma = plataforma; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getProgramadaEn() { return programadaEn; }
    public void setProgramadaEn(LocalDateTime programadaEn) { this.programadaEn = programadaEn; }

    public LocalDateTime getIniciaEn() { return iniciaEn; }
    public void setIniciaEn(LocalDateTime iniciaEn) { this.iniciaEn = iniciaEn; }

    public LocalDateTime getFinalizaEn() { return finalizaEn; }
    public void setFinalizaEn(LocalDateTime finalizaEn) { this.finalizaEn = finalizaEn; }

    public CitasMedicas getCitaMedica() { return citaMedica; }
    public void setCitaMedica(CitasMedicas citaMedica) { this.citaMedica = citaMedica; }
}