package pe.edu.upc.demoSaludPlusNuevo.dtos;

public class ArchivoMetadatosDTO {
    private String id;
    private String nombre;
    private String url;
    private Long tamanoBytes;

    public ArchivoMetadatosDTO(String id, String nombre, String url, Long tamanoBytes) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.tamanoBytes = tamanoBytes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public Long getTamanoBytes() { return tamanoBytes; }
    public void setTamanoBytes(Long tamanoBytes) { this.tamanoBytes = tamanoBytes; }
}
