package com.rpg.model;

/**
 * Created by ronaldpatino on 10/19/14.
 */
public class MensajeModel {
    private long id;
    private String identificador;
    private String mensaje;
    private String informacionAdicional;
    private String tipo;
    private String fecha;
    private RespuestaModel respuesta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    public void setInformacionAdicional(String informacionAdicional) {
        this.informacionAdicional = informacionAdicional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MensajeModel that = (MensajeModel) o;

        if (id != that.id) return false;
        if (identificador != null ? !identificador.equals(that.identificador) : that.identificador != null)
            return false;
        if (informacionAdicional != null ? !informacionAdicional.equals(that.informacionAdicional) : that.informacionAdicional != null)
            return false;
        if (mensaje != null ? !mensaje.equals(that.mensaje) : that.mensaje != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (identificador != null ? identificador.hashCode() : 0);
        result = 31 * result + (mensaje != null ? mensaje.hashCode() : 0);
        result = 31 * result + (informacionAdicional != null ? informacionAdicional.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public RespuestaModel getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaModel respuesta) {
        this.respuesta = respuesta;
    }
}
