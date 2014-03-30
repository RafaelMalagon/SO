/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peterson;

/**
 *
 * @author Administrador
 */
public class Test {

    public static void main(String[] args) {
        ModeloExclusion alg = new Peterson(); // alternar entre los algoritmos
        Hilo hilo1 = new Hilo("Hilo 1", 0, alg);
        Hilo hilo2 = new Hilo("Hilo 2", 0, alg);
        Hilo hilo3 = new Hilo("Hilo 3", 0, alg);
        Hilo hilo4 = new Hilo("Hilo 4", 0, alg);
        Hilo hilo5 = new Hilo("Hilo 5", 0, alg);
        Hilo hilo6 = new Hilo("Hilo 6", 0, alg);
        Hilo hilo7 = new Hilo("Hilo 7", 0, alg);
        Hilo hilo8 = new Hilo("Hilo 8", 1, alg);
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
    }
}
