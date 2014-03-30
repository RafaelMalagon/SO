/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Administrador
 */
public class Recurso {

    RetroAlimentadas alimentadas;
    int id, cantidaddeturnos = 0;
    boolean banderaUtilizado=false;

    public Recurso(RetroAlimentadas alimentadas, int id) {
        this.alimentadas = alimentadas;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCantidaddeturnos(int cantidaddeturnos) {
        this.cantidaddeturnos = cantidaddeturnos;
    }

    public int getCantidaddeturnos() {
        return cantidaddeturnos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RetroAlimentadas getAlimentadas() {
        return alimentadas;
    }

      

    public void setAlimentadas(RetroAlimentadas alimentadas) {
        this.alimentadas = alimentadas;
    }
}
