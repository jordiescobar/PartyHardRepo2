package escobar.jordi.infobosccoma.partyhard.models.business.entities;

import org.parceler.Parcel;

import java.io.Serializable;

/**
 * Created by Jordi Escobar on 15/02/2016.
 */
@Parcel
public class Party {

    private String titol;
    private String ubicacio;
    private String descripcio;
    private String urlImage;
    private long codi;

    public Party (){

    }

    public Party(String titol, String urlImage, String ubicacio, String descripcio){
        this.titol = titol;
        this.urlImage = urlImage;
        this.ubicacio = ubicacio;
        this.descripcio = descripcio;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getUbicacio() {
        return ubicacio;
    }

    public void setUbicacio(String ubicacio) {
        this.ubicacio = ubicacio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public long getCodi() {
        return codi;
    }

    public void setCodi(long codi) {
        this.codi = codi;
    }
}
