/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrador
 */
public class mipanel extends javax.swing.JPanel {

    public mipanel(){    
        this.setSize(50,80);
    }
        
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        try{
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/vista/semaforo-rojo.png"));        
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        
        }catch(Exception ex){
        System.out.println(getClass().getResource("/vista/semaforo-rojo.png").toString());
        }
        setOpaque(false);
        super.paintComponent(g);
    }    
}

