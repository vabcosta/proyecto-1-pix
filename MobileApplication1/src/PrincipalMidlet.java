//package Principal;

import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.lang.String;
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
    private Image robot;
    private Dibujar dibuj;
    Image img = Image.createImage(48, 48);
    private Graphics graf;
    private int x=24 , y=288;
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
            obst = Image.createImage("/Recursos/obstaculo.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            robot = Image.createImage("/Recursos/Robot-icon.png");
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
            Display.getDisplay(this).setCurrent(dibuj);
            graf = img.getGraphics();
            dibuj.paint(graf);
            dibuj.revtext("62");
           // Display.getDisplay(this).setCurrent(f);
        }
    }

    public class Dibujar extends Canvas{
        //Color transparent = new Color(0,0,0,0);
        public Dibujar(){
        }
            public void paint(Graphics g){
                g.setColor(20,20,20);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(imagen, 0, 0, Graphics.LEFT | Graphics.TOP);
                g.drawImage(robot, x, y, Graphics.VCENTER | Graphics.HCENTER);

            }
            public void revtext(String moves){
                char[] inst = moves.toCharArray();
                String a;
                for(int i=0;i<inst.length;i++){
                    a = inst[i]+"";
                    if (a.equals("2"))
                        arriba();
                    if (a.equals("4"))
                        izq();
                    if (a.equals("6"))
                        derecha();
                    if (a.equals("8"))
                        abajo();
                }
            }
            public void derecha(){
                x += 48;
                repaint();
            }
            public void izq(){
                x -= 48;
                repaint();
            }
            public void arriba(){
                y -= 48;
                repaint();
            }
            public void abajo(){
                y += 48;
                repaint();
            }
    }
}


