package pe.edu.upc.demoSaludPlusNuevo.dtos;

public class UsuarioActualizacionDTO {
    private String nombre;
    private String telefono;
    private String direccion;
    private String comunidad;

    public UsuarioActualizacionDTO(String nombre, String telefono, String direccion, String comunidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.comunidad = comunidad;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getComunidad() { return comunidad; }
    public void setComunidad(String comunidad) { this.comunidad = comunidad; }
}
