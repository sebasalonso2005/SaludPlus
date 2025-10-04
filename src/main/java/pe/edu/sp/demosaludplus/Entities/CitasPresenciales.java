package pe.edu.upc.demoSaludPlusNuevo.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "citas_presenciales")
public class CitasPresenciales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presencial")
    private Integer id_presencial;

    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;

    @Column(name = "consultorio", length = 100)
    private String consultorio;

    @Column(name = "medico_asignado", length = 100)
    private String medicoAsignado;

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

    public CitasPresenciales() {}

    public CitasPresenciales(Integer idPresencial, String direccion, String consultorio,
                             String medicoAsignado, String estado,
                             LocalDateTime programadaEn, LocalDateTime iniciaEn,
                             LocalDateTime finalizaEn, CitasMedicas citaMedica) {
        this.id_presencial = idPresencial;
        this.direccion = direccion;
        this.consultorio = consultorio;
        this.medicoAsignado = medicoAsignado;
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

    // Getters y setters
    public Integer getIdPresencial() { return id_presencial; }
    public void setIdPresencial(Integer idPresencial) { this.id_presencial = idPresencial; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getConsultorio() { return consultorio; }
    public void setConsultorio(String consultorio) { this.consultorio = consultorio; }

    public String getMedicoAsignado() { return medicoAsignado; }
    public void setMedicoAsignado(String medicoAsignado) { this.medicoAsignado = medicoAsignado; }

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
