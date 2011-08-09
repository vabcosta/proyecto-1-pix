//package Principal;

/**
 *Fondo del juego. Creado 27 de Julio de 2011
 * Algoritmos y Estructura de Datos
 * Proyecto 1
 * @author Josue Cabrera 10018
 */
import java.io.IOException;
//import java.awt.Canvas;
//import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.TiledLayer;

public class BasicBackGround extends TiledLayer{
    static Image image;
    private Object Graphics;
    public BasicBackGround()throws IOException{
        super(1,1, Image.createImage("/background11.png"),240,180);
    }



}