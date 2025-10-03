package pe.edu.upc.demoSaludPlusNuevo.dtos;

public class InicioSesionRespuestaDTO {
    private String accessToken;
    private String tokenType;
    private Long expiresInSeconds;

    public InicioSesionRespuestaDTO(String accessToken, String tokenType, Long expiresInSeconds) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
        this.expiresInSeconds = expiresInSeconds;
    }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public Long getExpiresInSeconds() { return expiresInSeconds; }
    public void setExpiresInSeconds(Long expiresInSeconds) { this.expiresInSeconds = expiresInSeconds; }
}
