package pe.edu.upc.demoSaludPlusNuevo.dtos;

public class SOSSolictudDTO {
    private Double latitud;
    private Double longitud;
    private Double precisionMetros;
    private Integer idUsuario;
    private String direccionTexto;

    public SOSSolictudDTO(Double latitud, Double longitud, Double precisionMetros, Integer idUsuario, String direccionTexto) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.precisionMetros = precisionMetros;
        this.idUsuario = idUsuario;
        this.direccionTexto = direccionTexto;
    }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }
    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }
    public Double getPrecisionMetros() { return precisionMetros; }
    public void setPrecisionMetros(Double precisionMetros) { this.precisionMetros = precisionMetros; }
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getDireccionTexto() { return direccionTexto; }
    public void setDireccionTexto(String direccionTexto) { this.direccionTexto = direccionTexto; }
}
