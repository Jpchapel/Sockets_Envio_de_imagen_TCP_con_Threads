/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servidor;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Joaquin Pereira Chapel
 */
public class ServidorConThreads extends Thread{
    private final int PUERTO;
    private ServerSocket serverSocket;
    private Socket socket;
    private BufferedImage bufferedImage;

    public ServidorConThreads(int PUERTO) throws IOException {
        this.PUERTO = PUERTO;
        serverSocket = new ServerSocket(PUERTO);
    }  
    
    @Override
    public void run() {
        System.out.println("Esperando conexiones");
        
        try {
            socket = serverSocket.accept();
            
            System.out.println("Nueva conexion: " + socket.getInetAddress());
            
            bufferedImage = ImageIO.read(socket.getInputStream());
            ImageIO.write(bufferedImage, "png", new FileOutputStream("D:/Destino/deadpool.png"));
            
            System.out.println("Imagen Recibida");
            
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServidorConThreads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
