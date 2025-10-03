package pe.edu.upc.demoSaludPlusNuevo.dtos;

import java.time.LocalDate;

public class ExamenDTO {
    private Integer idExamen;
    private String tipoExamen;
    private LocalDate fecha;
    private String resultado;
    private String archivoUrl;

    public ExamenDTO(Integer idExamen, String tipoExamen, LocalDate fecha, String resultado, String archivoUrl) {
        this.idExamen = idExamen;
        this.tipoExamen = tipoExamen;
        this.fecha = fecha;
        this.resultado = resultado;
        this.archivoUrl = archivoUrl;
    }

    public Integer getIdExamen() { return idExamen; }
    public void setIdExamen(Integer idExamen) { this.idExamen = idExamen; }
    public String getTipoExamen() { return tipoExamen; }
    public void setTipoExamen(String tipoExamen) { this.tipoExamen = tipoExamen; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    public String getArchivoUrl() { return archivoUrl; }
    public void setArchivoUrl(String archivoUrl) { this.archivoUrl = archivoUrl; }
}
