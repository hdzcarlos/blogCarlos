/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author carlos
 */
public class Entrada {
    private String titulo;
    private String subtitulo;
    private String cuerpo;
    private String imagenDestacada;

    public Entrada() {
    }

    public Entrada(String titulo, String subtitulo, String cuerpo, String imagenDestacada) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.cuerpo = cuerpo;
        this.imagenDestacada = imagenDestacada;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public String getImagenDestacada() {
        return imagenDestacada;
    }

    public void setImagenDestacada(String imagenDestacada) {
        this.imagenDestacada = imagenDestacada;
    }
    
    
    
}
