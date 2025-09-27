package pe.edu.sp.demosaludplus.dtos;

import java.time.LocalDateTime;

public class CitasPresencialesDTO {
    private Integer id_presencial;
    private String direccion;
    private String consultorio;
    private String medicoAsignado;
    private String estado;
    private LocalDateTime programadaEn;
    private LocalDateTime iniciaEn;
    private LocalDateTime finalizaEn;

    public Integer getId_presencial() {return id_presencial;}

    public void setId_presencial(Integer id_presencial) {this.id_presencial = id_presencial;}

    public String getDireccion() {return direccion;}

    public void setDireccion(String direccion) {this.direccion = direccion;}

    public String getConsultorio() {return consultorio;}

    public void setConsultorio(String consultorio) {this.consultorio = consultorio;}

    public String getMedicoAsignado() {return medicoAsignado;}

    public void setMedicoAsignado(String medicoAsignado) {this.medicoAsignado = medicoAsignado;}

    public String getEstado() {return estado;}

    public void setEstado(String estado) {this.estado = estado;}

    public LocalDateTime getProgramadaEn() {return programadaEn;}

    public void setProgramadaEn(LocalDateTime programadaEn) {this.programadaEn = programadaEn;}

    public LocalDateTime getIniciaEn() {return iniciaEn;}

    public void setIniciaEn(LocalDateTime iniciaEn) {this.iniciaEn = iniciaEn;}

    public LocalDateTime getFinalizaEn() {return finalizaEn;}

    public void setFinalizaEn(LocalDateTime finalizaEn) {this.finalizaEn = finalizaEn;}
}
