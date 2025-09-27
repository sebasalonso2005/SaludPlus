package pe.edu.sp.demosaludplus.dtos;

import pe.edu.sp.demosaludplus.Entities.CitasMedicas;

public class MedicamentosDTO {
    private Integer id_medicamento;
    private String nombre;
    private String dosis;
    private String frecuencia;
    private String duracion;
    private CitasMedicas citaMedica;

    public Integer getId_medicamento() {return id_medicamento;}

    public void setId_medicamento(Integer id_medicamento) {this.id_medicamento = id_medicamento;}

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getDosis() {return dosis;}

    public void setDosis(String dosis) {this.dosis = dosis;}

    public String getFrecuencia() {return frecuencia;}

    public void setFrecuencia(String frecuencia) {this.frecuencia = frecuencia;}

    public String getDuracion() {return duracion;}

    public void setDuracion(String duracion) {this.duracion = duracion;}

    public CitasMedicas getCitaMedica() {return citaMedica;}

    public void setCitaMedica(CitasMedicas citaMedica) {this.citaMedica = citaMedica;}
}
