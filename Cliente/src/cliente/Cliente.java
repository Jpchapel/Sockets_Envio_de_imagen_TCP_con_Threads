/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    private static final String HOST = "localhost";
    private static final int PUERTO = 5555;
    
    public static void main(String[] args) {
        Socket socket = null;
        BufferedImage bufferedImage = null;
        
        try {
            socket = new Socket(HOST, PUERTO);
            bufferedImage = ImageIO.read(new File("D:\\Origen"));
            ImageIO.write(bufferedImage, "png", socket.getOutputStream());
            socket.getOutputStream().flush();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
