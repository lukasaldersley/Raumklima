package serialIO.IO.NETWORK;

import javax.swing.JOptionPane;
public class Meldung{
    public static void main(String[] bla){

        // Erstellung Array vom Datentyp Object, Hinzuf�gen der Optionen		
            Object[] options={"JA","STANDARD VERWENDEN","NEUEN EINGEBEN"};
            int result=JOptionPane.showOptionDialog(null,"Wollen Sie wirklich "+5+" als Server-Port verwenden?","BEST�TIGUNG ERFORDERLICH",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(result);

    }
}