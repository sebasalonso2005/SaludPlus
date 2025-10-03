package pe.edu.upc.demoSaludPlusNuevo.dtos;

import java.time.LocalDate;

public class ExamenCrearDTO {
    private Integer idCita;
    private String tipoExamen;
    private LocalDate fecha;
    private String resultado;
    private String archivoUrl;

    public ExamenCrearDTO(Integer idCita, String tipoExamen, LocalDate fecha, String resultado, String archivoUrl) {
        this.idCita = idCita;
        this.tipoExamen = tipoExamen;
        this.fecha = fecha;
        this.resultado = resultado;
        this.archivoUrl = archivoUrl;
    }

    public Integer getIdCita() { return idCita; }
    public void setIdCita(Integer idCita) { this.idCita = idCita; }
    public String getTipoExamen() { return tipoExamen; }
    public void setTipoExamen(String tipoExamen) { this.tipoExamen = tipoExamen; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public String getArchivoUrl() { return archivoUrl; }
    public void setArchivoUrl(String archivoUrl) { this.archivoUrl = archivoUrl; }
}
