package pe.edu.sp.demosaludplus.dtos;

public class CitaActualizarEstadoDTO {
    private Integer idCita;
    private String nuevoEstado;
    private String observacion;

    public CitaActualizarEstadoDTO(Integer idCita, String nuevoEstado, String observacion) {
        this.idCita = idCita;
        this.nuevoEstado = nuevoEstado;
        this.observacion = observacion;
    }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }
    public String getNuevoEstado() { return nuevoEstado; }
    public void setNuevoEstado(String nuevoEstado) { this.nuevoEstado = nuevoEstado; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}
