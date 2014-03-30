/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peterson;

/**
 *
 * @author Administrador
 */
public class Dekker1 extends ModeloExclusion {
private volatile int m_iTurn;
public Dekker1() {
m_iTurn = TURN_0;
}
public void entrarSC(int iId) {
while (m_iTurn != iId)
Thread.yield();
}
public void salirSC(int iId) {
m_iTurn = 1 - iId;
}
}