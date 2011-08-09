//package Principal;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
//import javax.microedition.lcdui.Graphics;

/**
 * @author Josue
 */
public class PrincipalMidlet extends MIDlet implements CommandListener {
    private Command exit;
    private Command obstaculo;
    private Form f;
    private Image imagen;
    private Image obst;
    private Dibujar dibuj;
    Image img = Image.createImage(48, 48);
    private Graphics graf;
    public PrincipalMidlet(){
        exit = new Command("salir",Command.EXIT,1);
        obstaculo = new Command("Add Obstacle",Command.SCREEN,2);
        dibuj = new Dibujar();
        try {
            imagen = Image.createImage("/Recursos/Pisomadera.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            obst = Image.createImage("/Recursos/Robot-icon.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void startApp() {
        f = new Form("Proyecto 1");
        f.append(imagen);
        f.addCommand(obstaculo);
        f.addCommand(exit);
        f.setCommandListener(this);
        Display.getDisplay(this).setCurrent(f);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }


    public void commandAction(Command c, Displayable d) {
        if (c == exit){
            destroyApp(false);
            notifyDestroyed();

            return;
        }
        if(c == obstaculo){
            //f.append(obst);
            graf = img.getGraphics();
            dibuj.paint(graf);
        }
    }

    public class Dibujar extends Canvas{
        public Dibujar(){
            
        }
            public void paint(Graphics g){
        // Fill the background using black
                g.setColor(0);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(obst, 0, 0, Graphics.VCENTER | Graphics.HCENTER);
            }
    }


}
