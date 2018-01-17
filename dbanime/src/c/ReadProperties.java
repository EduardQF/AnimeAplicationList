package c;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduard QF
 */
public class ReadProperties {

    /**
     * @param args the command line arguments
     */
    public static Properties read(String file) {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        try {
            entrada = new FileInputStream(file + ".properties");
            propiedades.load(entrada);
            entrada.close();
            return propiedades;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void write(Properties date,String file) {
        Properties propiedades = date;
        OutputStream salida = null;
        try {
            salida = new FileOutputStream(file+".properties");
            propiedades.store(salida, null);
            salida.close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

}
