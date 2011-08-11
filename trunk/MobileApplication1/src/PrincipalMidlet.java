//package Principal;
// Paquetes importados.
import java.io.IOException;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import java.lang.String;



/**
 * @author Josue Cabrera, Luisa Portillo y Pablo 
 * Carné 10018
 * Proyecto No. 1.
 * Desarrollo de Juego PIX. El cual trata de imitar la herramienta de Rurple y Robomind.
 */
public class PrincipalMidlet extends MIDlet implements CommandListener {
    /**
     * @Atributos
     */
    private Command exit,run,instrucc,recibir,back,select,rand,reset,savemap,openmap;
    private TextField instrucciones;
    private Form f,obss,inss,help;
    private Image menu,imagen,obst,obstup,robot,crearmapa,bat,congrats;
    private Dibujar dibuj;
    private Image img = Image.createImage(48, 48);
    private Graphics graf;
    private int x=24 , y=288;
    private String truc = "";
    private String[] ops = {"Vertical","Horizontal"};
    private String[] coy = {"1","2","3","4","5","6"};
    private String[] cox = {"1","2","3","4","5"};
    private ChoiceGroup menulist,verticalHorizontal,opx,opy;
    private Mapa mapa;
    private String instrucion;
    private HThread hilo;
    private Alert alert = new Alert("Mensaje:", "", null, AlertType.CONFIRMATION);
    private Alert alert1 = new Alert("Mensaje:", "", null, AlertType.ERROR);
    /**
     * @Constructor
     */
    public PrincipalMidlet(){
        //Sección que inicializa los atributos de la clase.
        obss = new Form("Creacion de Mapas");
        obss.setCommandListener(this);
        help = new Form("Instrucciones");
        help.setCommandListener(this);
        inss = new Form("Ingreso de instrucciones");
        inss.setCommandListener(this);
        back = new Command("Regresar",Command.ITEM,0);
        reset = new Command("Nuevo mapa",Command.ITEM,4);
        exit = new Command("salir",Command.EXIT,1);
        run = new Command("RUN",Command.SCREEN,2);
        select = new Command("Seleccionar",Command.ITEM,0);
        instrucc = new Command("Ingresar",Command.ITEM,3);
        recibir = new Command("Ingresar",Command.ITEM,1);
        rand = new Command("Crear aleatorio",Command.ITEM,0);
        savemap = new Command("Guardar mapa",Command.ITEM,5);
        openmap = new Command("Abrir mapa",Command.ITEM,6);
        dibuj = new Dibujar();
        dibuj.addCommand(back);
        dibuj.setCommandListener(this);
        menulist = new ChoiceGroup("Menu",Choice.POPUP);
        opx = new ChoiceGroup("Coordenada Y: ",Choice.POPUP,coy,null);
        opy = new ChoiceGroup("Coordenada X: ",Choice.POPUP,cox,null);
        verticalHorizontal = new ChoiceGroup("Orientacion", Choice.POPUP,ops,null);
        menulist.append("Crear mapa", null);
        menulist.append("Ingresar Codigo", null);
        menulist.append("Leer instrucciones",null);
        instrucciones = new TextField("Instrucciones: ","",20,0);
        instrucion = "Para  poder jugar con Pix, se tienen  las  siguientes opciones: crear  mapa, ingresar cÛdigo, guardar cÛdigo y correr el programa. Para crear cÛdigo se puede escoger en donde desea colocar los muros, al ingresar  el  cÛdigo  solamente  tiene las opciones: 2 para arriba, 8 para abajo, 6 para la derecha y  4 para la izquierda. Si usted no desea colocar  los muros estos  se  pueden colocar de manera aleatoria. El robot debe de llegar a la tuerca que se muestra en pantalla";
        mapa = new Mapa();
        //conjunto de Try/Catch para las imagenes a utilizar.
        try {
            crearmapa = Image.createImage("/Recursos/Pisonumerado.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            menu = Image.createImage("/Recursos/LOGO_pix.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            imagen = Image.createImage("/Recursos/Pisomadera.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            congrats = Image.createImage("/Recursos/Congratulations.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            obst = Image.createImage("/Recursos/block.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            obstup = Image.createImage("/Recursos/blockup.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            robot = Image.createImage("/Recursos/Robot-icon.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
                try {
            bat = Image.createImage("/Recursos/tuerca.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Sección que añade los elementos graficos a los diferentes Forms a utilizar.
        obss.addCommand(back);
        //obss.append(crearmapa);
        obss.addCommand(recibir);
        obss.addCommand(rand);
        obss.addCommand(reset);
        obss.addCommand(savemap);
        obss.addCommand(openmap);
        obss.append(verticalHorizontal);
        obss.append(opy);
        obss.append(opx);
        dibuj.nuevaImagen();
        obss.append(dibuj.nueva);
        inss.addCommand(back);
        inss.addCommand(instrucc);
        inss.append(instrucciones);
        inss.addCommand(run);
        inss.append(dibuj.nueva);
        help.append(instrucion);
        help.addCommand(back);
    }
    public void startApp() {
        // Metodo principal que es llamado automaticamente al correr el programa.
        f = new Form("Proyecto 1");
        f.append(menu);
        f.append(menulist);
        f.addCommand(exit);
        f.addCommand(select);
        f.setCommandListener(this);
        Display.getDisplay(this).setCurrent(f);
        alert.addCommand(back);
    }

    public void pauseApp() {
        //Método heredado pero no es utilizado.
    }

    public void destroyApp(boolean unconditional) {
        //Método heredado pero no es utilizado.
    }

    /**
     * @param Command c, Displayable d
     * c representa el comando que fue seleccioinado.
     * d representa el Current Display utilizado.
     */
    public void commandAction(Command c, Displayable d) {
        //Variables internas del método
        int u,v,cooryy,coorx;
        hilo = new HThread();
        //Sección de comparación para cada comando.
        if (c == exit){
            destroyApp(false);
            notifyDestroyed();

            return;
        }
        // Decisión que genera llama la animación del robot.
        if(c == run){
            Display.getDisplay(this).setCurrent(dibuj);
            graf = img.getGraphics();
            dibuj.paint(graf);
            hilo.start();
           // Display.getDisplay(this).setCurrent(f);
        }
        // Decisión que ingresa el codigo del usuario.
        if (c == instrucc){
            truc = instrucciones.getString();
        }
        // Decisión que regresa al menu principal.
        if (c == back)
            Display.getDisplay(this).setCurrent(f);
        if (c==recibir){
               coorx = opx.getSelectedIndex();
               cooryy = opy.getSelectedIndex();
               u = verticalHorizontal.getSelectedIndex();
               if (u==0){
                   v = mapa.getVal(cooryy, coorx);
                   mapa.setVal(cooryy, coorx, (v+=2));
               }
               if (u==1){
                   v = mapa.getVal(cooryy, coorx);
                   mapa.setVal(cooryy, coorx, (v+=1));
               }
            dibuj.nuevaImagen();
            obss.delete(3);
            obss.append(dibuj.nueva);
        }
        if (c==select){
            switch(menulist.getSelectedIndex()){
                case 0:{Display.getDisplay(this).setCurrent(obss);
                obss.delete(3);
                mapa = new Mapa();
                dibuj.nuevaImagen();
                obss.append(dibuj.nueva);break;}
                case 1:{Display.getDisplay(this).setCurrent(inss);x=24;y=288;
                instrucciones.setInitialInputMode(" ");
                inss.delete(1);
                dibuj.nuevaImagen();
                inss.append(dibuj.nueva);
                break;}
                case 2:{Display.getDisplay(this).setCurrent(help);break; }
            }
        }
        if (c==rand){
            mapa.random();
            alert.setString("Se ha generado un mapa random!!");
            Display.getDisplay(this).setCurrent(alert);
            dibuj.nuevaImagen();
            obss.delete(3);
            obss.append(dibuj.nueva);
        }
        if(c==reset){
           mapa = new Mapa();
           obss.delete(3);
           dibuj.nuevaImagen();
           obss.append(dibuj.nueva);
        }
        if(c==savemap){
            mapa.writeFile();
            alert.setString("Se ha guardado el mapa exitosamente!!");
            Display.getDisplay(PrincipalMidlet.this).setCurrent(alert);
        }
        if(c==openmap){
            mapa.readFile();
            obss.delete(3);
            dibuj.nuevaImagen();
            obss.append(dibuj.nueva);
        }
    }

    public class Dibujar extends Canvas{
        Image nueva;
        public Dibujar(){
        }
            public void paint(Graphics g){
                g.setColor(20,20,20);
                g.fillRect(0, 0, getWidth(), getHeight());
                g.drawImage(imagen, 0, 0, Graphics.LEFT | Graphics.TOP);
                g.drawImage(robot, x, y, Graphics.VCENTER | Graphics.HCENTER);
                g.drawImage(bat, 120, 130, Graphics.VCENTER | Graphics.HCENTER);
                for(int i=0;i<mapa.getLength();i++){
                    for(int j=0;j<mapa.getFilLength();j++){
                        if (mapa.getVal(j, i)==1){
                            paintBlock(g,(j)*48,(i+1)*54);
                        }
                        if (mapa.getVal(j, i)==2){
                            paintBlockUp(g,((j+1)*48),((i)*55));
                        }
                        if (mapa.getVal(j, i)==3){
                            paintBlock(g,(j)*48,(i+1)*54);
                            paintBlockUp(g,(j+1)*48,(i)*55);
                        }
                    }
                }

            }

            public void nuevaImagen(){
                nueva = Image.createImage(getWidth(), getHeight());
                Graphics b = nueva.getGraphics();
                dibuj.paint(b);
            }

            public void paintBlock(Graphics g,int x,int y){
                g.drawImage(obst, x, y, Graphics.VCENTER | Graphics.LEFT);
            }
            public void paintBlockUp(Graphics g,int x,int y){
                g.drawImage(obstup, x, y, Graphics.HCENTER | Graphics.TOP);
            }

    }
    public class HThread extends Thread{
        int indicex, indicey,val;
            public void run(){
                char[] inst = truc.toCharArray();
                String a;
                for(int i=0;i<inst.length;i++){
                try {
                    HThread.sleep(1500);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                    if((x<0)|(x>240)){
                        alert1.setString("Se ha salido de pantalla!!");
                        Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                        i = inst.length;
                        break;
                    }
                    if((y<0)|(y>320)){
                        alert1.setString("Se ha salido de pantalla!!");
                        Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                        i = inst.length;
                        break;
                    }
                    a = inst[i]+"";
                    indicex = x/48;
                    if(indicex > 0)
                        indicex --;
                    indicey = y/48;
                    if(indicey > 0)
                        indicey --;

                    if(x == 2){
                        if(y==2){
                        alert1.setString("HA GANADO!!!");
                        alert1.setImage(congrats);
                        Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                        i = inst.length;
                        break;
                        }
                    }
                    if (a.equals("2")){
                        val = mapa.getVal(indicex,(indicey-1));
                        if (val!=1){
                            if(val!=3){
                                arriba();
                                }
                            }
                        if((1 | 3)==val){
                            alert1.setString("Se ha chocado con un obstaculo!!");
                            Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                            i = inst.length;
                        }
                    }
                    if (a.equals("4")){
                        val = mapa.getVal(indicex-1,indicey);
                        if (val!=2){
                            if(val!=3){
                                izq();
                                }
                        }
                        if((2 | 3)==val){
                            alert1.setString("Se ha chocado con un obstaculo!!");
                            Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                            i = inst.length;
                        }
                    }
                    if (a.equals("6")){
                        val = mapa.getVal(indicex,indicey);
                        if (val!=2){
                            if (val!=3){
                                derecha();
                                }
                        }
                        if((2 | 3)==val){
                            alert1.setString("Se ha chocado con un obstaculo!!");
                            Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                            i = inst.length;
                        }
                    }
                    if (a.equals("8")){
                        val = mapa.getVal(indicex,indicey);
                        if (val!=1){
                            if(val!=3){
                                abajo();
                                }
                        }
                        if((1 | 3)==val){
                            alert1.setString("Se ha chocado con un obstaculo!!");
                            Display.getDisplay(PrincipalMidlet.this).setCurrent(alert1);
                            i = inst.length;
                        }
                    }
                }
            }
            public void derecha(){
                x += 48;
                dibuj.repaint();
            }
            public void izq(){
                x -= 48;
                dibuj.repaint();
            }
            public void arriba(){
                y -= 52;
                dibuj.repaint();
            }
            public void abajo(){
                y += 52;
                dibuj.repaint();
            }
    }
}


