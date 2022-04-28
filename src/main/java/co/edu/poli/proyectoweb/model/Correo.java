package co.edu.poli.proyectoweb.model;

import java.util.Date;
import java.util.List;

public class Correo {

    private String correoPara;

    private String correoCc;

    private String correoBcc;

    private String correoSubject;

    private String correoContenido;

    private String tipoContenido;

    private List < Object > attachments;

    public String getCorreoPara() {
        return correoPara;
    }

    public String getCorreoCc() {
        return correoCc;
    }

    public void setCorreoCc(String correoCc) {
        this.correoCc = correoCc;
    }

    public String getCorreoBcc() {
        return correoBcc;
    }

    public void setCorreoBcc(String correoBcc) {
        this.correoBcc = correoBcc;
    }

    public String getCorreoSubject() {
        return correoSubject;
    }

    public void setCorreoSubject(String correoSubject) {
        this.correoSubject = correoSubject;
    }

    public String getCorreoContenido() {
        return correoContenido;
    }

    public void setCorreoContenido(String correoContenido) {
        this.correoContenido = correoContenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public void setCorreoPara(String correoPara) {
        this.correoPara = correoPara;
    }

    public List< Object > getAttachments() {
        return attachments;
    }

    public void setAttachments(List < Object > attachments) {
        this.attachments = attachments;
    }


}
