/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peterson;

/**
 *
 * @author Administrador
 */
public class Peterson extends ModeloExclusion {
private volatile int m_iTurn;
private volatile boolean[] m_bFlag = new boolean[2];
public Peterson() {
m_iTurn = TURN_0;
m_bFlag[0] = false;
m_bFlag[1] = false;
}
public void entrarSC(int iId) {
int other = 1 - iId;
m_bFlag[iId] = true;
m_iTurn = other;
while (m_bFlag[other] == true && m_iTurn == other)
Thread.yield();
}
public void salirSC(int iId) {
m_bFlag[iId] = false;
}
}



