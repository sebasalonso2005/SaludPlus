package pe.edu.sp.demosaludplus.dtos;

public class UsuarioPerfilDTO {
    private Integer idUsuario;
    private String nombre;
    private String dni;
    private String correo;
    private String telefono;
    private String direccion;
    private String comunidad;
    private String username;

    public UsuarioPerfilDTO(Integer idUsuario, String nombre, String dni, String correo, String telefono, String direccion, String comunidad, String username) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.comunidad = comunidad;
        this.username = username;
    }

    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getComunidad() { return comunidad; }
    public void setComunidad(String comunidad) { this.comunidad = comunidad; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
}
