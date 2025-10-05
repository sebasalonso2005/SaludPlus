package pe.edu.sp.demosaludplus.dtos;

public class InicioSesionSolicitudDTO {
    private String usernameOrEmail;
    private String password;

    public InicioSesionSolicitudDTO() {}

    public InicioSesionSolicitudDTO(String usernameOrEmail, String password) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }

    public String getUsernameOrEmail() { return usernameOrEmail; }
    public void setUsernameOrEmail(String usernameOrEmail) { this.usernameOrEmail = usernameOrEmail; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
