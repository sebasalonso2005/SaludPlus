package pe.edu.sp.demosaludplus.dtos;

public class SOSRespuestaDTO {
    private boolean ok;
    private String idCaso;
    private String mensaje;

    public SOSRespuestaDTO(boolean ok, String idCaso, String mensaje) {
        this.ok = ok;
        this.idCaso = idCaso;
        this.mensaje = mensaje;
    }

    public boolean isOk() { return ok; }
    public void setOk(boolean ok) { this.ok = ok; }
    public String getIdCaso() { return idCaso; }
    public void setIdCaso(String idCaso) { this.idCaso = idCaso; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
