package pe.edu.upc.demoSaludPlusNuevo.dtos;

import java.util.List;

public class HiloChatDTO {
    private String id;
    private String titulo;
    private List<MensajeChatDTO> mensajes;

    public HiloChatDTO(String id, String titulo, List<MensajeChatDTO> mensajes) {
        this.id = id;
        this.titulo = titulo;
        this.mensajes = mensajes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public List<MensajeChatDTO> getMensajes() { return mensajes; }
    public void setMensajes(List<MensajeChatDTO> mensajes) { this.mensajes = mensajes; }
}
