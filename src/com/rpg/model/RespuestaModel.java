package com.rpg.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by ronaldpatino on 10/19/14.
 */
public class RespuestaModel {
    private long id;
    private String codigoDocumentoSri;
    private String codigoLocal;
    private String codigoPuntoVenta;
    private String numeroFactura;
    private String claveAcceso;
    private String numeroAutorizacion;
    private String resultado;
    private String ambiente;
    private String idFactura;
    private String fecha;
    private Collection<MensajeModel> mensajes = new HashSet<MensajeModel>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodigoDocumentoSri() {
        return codigoDocumentoSri;
    }

    public void setCodigoDocumentoSri(String codigoDocumentoSri) {
        this.codigoDocumentoSri = codigoDocumentoSri;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getCodigoPuntoVenta() {
        return codigoPuntoVenta;
    }

    public void setCodigoPuntoVenta(String codigoPuntoVenta) {
        this.codigoPuntoVenta = codigoPuntoVenta;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getClaveAcceso() {
        return claveAcceso;
    }

    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    public String getNumeroAutorizacion() {
        return numeroAutorizacion;
    }

    public void setNumeroAutorizacion(String numeroAutorizacion) {
        this.numeroAutorizacion = numeroAutorizacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
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

        RespuestaModel that = (RespuestaModel) o;

        if (id != that.id) return false;
        if (ambiente != null ? !ambiente.equals(that.ambiente) : that.ambiente != null) return false;
        if (claveAcceso != null ? !claveAcceso.equals(that.claveAcceso) : that.claveAcceso != null) return false;
        if (codigoDocumentoSri != null ? !codigoDocumentoSri.equals(that.codigoDocumentoSri) : that.codigoDocumentoSri != null)
            return false;
        if (codigoLocal != null ? !codigoLocal.equals(that.codigoLocal) : that.codigoLocal != null) return false;
        if (codigoPuntoVenta != null ? !codigoPuntoVenta.equals(that.codigoPuntoVenta) : that.codigoPuntoVenta != null)
            return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (idFactura != null ? !idFactura.equals(that.idFactura) : that.idFactura != null) return false;
        if (numeroAutorizacion != null ? !numeroAutorizacion.equals(that.numeroAutorizacion) : that.numeroAutorizacion != null)
            return false;
        if (numeroFactura != null ? !numeroFactura.equals(that.numeroFactura) : that.numeroFactura != null)
            return false;
        if (resultado != null ? !resultado.equals(that.resultado) : that.resultado != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (codigoDocumentoSri != null ? codigoDocumentoSri.hashCode() : 0);
        result = 31 * result + (codigoLocal != null ? codigoLocal.hashCode() : 0);
        result = 31 * result + (codigoPuntoVenta != null ? codigoPuntoVenta.hashCode() : 0);
        result = 31 * result + (numeroFactura != null ? numeroFactura.hashCode() : 0);
        result = 31 * result + (claveAcceso != null ? claveAcceso.hashCode() : 0);
        result = 31 * result + (numeroAutorizacion != null ? numeroAutorizacion.hashCode() : 0);
        result = 31 * result + (resultado != null ? resultado.hashCode() : 0);
        result = 31 * result + (ambiente != null ? ambiente.hashCode() : 0);
        result = 31 * result + (idFactura != null ? idFactura.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        return result;
    }

    public Collection<MensajeModel> getMensajes() {
        return mensajes;
    }

    public void setMensajes(Collection<MensajeModel> mensajes) {
        this.mensajes = mensajes;
    }
}
