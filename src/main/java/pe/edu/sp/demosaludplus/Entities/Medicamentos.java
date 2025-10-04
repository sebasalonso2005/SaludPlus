package pe.edu.upc.demoSaludPlusNuevo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "medicamentos")
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicamento")
    private Integer id_medicamento;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "dosis", length = 50)
    private String dosis;

    @Column(name = "frecuencia", length = 50)
    private String frecuencia;

    @Column(name = "duracion", length = 50)
    private String duracion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cita", referencedColumnName = "id_cita", nullable = false)
    private CitasMedicas citaMedica;

    public Medicamentos() {}

    public Medicamentos(Integer idMedicamento, String nombre, String dosis,
                        String frecuencia, String duracion, CitasMedicas citaMedica) {
        this.id_medicamento = idMedicamento;
        this.nombre = nombre;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.citaMedica = citaMedica;
    }

    public Integer getIdMedicamento() { return id_medicamento; }
    public void setIdMedicamento(Integer idMedicamento) { this.id_medicamento = idMedicamento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDosis() { return dosis; }
    public void setDosis(String dosis) { this.dosis = dosis; }
    public String getFrecuencia() { return frecuencia; }
    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    public CitasMedicas getCitaMedica() { return citaMedica; }
    public void setCitaMedica(CitasMedicas citaMedica) { this.citaMedica = citaMedica; }
}