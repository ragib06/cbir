/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imageretrieval;

/**
 *
 * @author nautilus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("net.sourceforge.mlf.metouia.MetouiaLookAndFeel");
            //javax.swing.UIManager.setLookAndFeel("net.beeger.squareness.SquarenessLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
        new UserInterface().setVisible(true);
    }

}
