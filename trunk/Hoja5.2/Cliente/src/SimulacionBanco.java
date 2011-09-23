import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luisa Portillo
 */
public class SimulacionBanco {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        //--------------------------------------------------------------
        // Creacion de objetos
        List<Cliente> ListaClientes = new ArrayList<Cliente>();
        VectorHeap<Cliente> caja1;
        VectorHeap<Cliente> caja2; 
        VectorHeap<Cliente> caja3;
        VectorHeap<Cliente> caja4;

        Scanner in = new Scanner(System.in);
        //--------------------------------------------------------------
        // Creacion de variables
        int r, c, timeE, numeroClientes, prom=0;
        //--------------------------------------------------------------
        do{
            menu();
            r = (int)obtenerNumero("Seleccione la opcion que desea realizar:  ", true);
            switch(r){
            //Opcion que crea la lista de arreglos
              
            case 1:
               caja1 = new VectorHeap<Cliente>();
               caja2 = new VectorHeap<Cliente>();
               caja3 = new VectorHeap<Cliente>();
               caja4 = new VectorHeap<Cliente>();
               //Cliente nuevo = new Cliente();
               //Opcion de ingresar el tiempo de entrada de los clientes.
               numeroClientes = (int)obtenerNumero("Ingrese la cantidad de clientes que desea ingresar al banco:  ", true); 
               for(int i=0; i<numeroClientes; i++){
                  Cliente nuevo = new Cliente();    
                  timeE = (int)obtenerNumero("Ingrese el tiempo de entrada del cliente, para salir ingrese un numero negativo: ", true); 
                  nuevo.setLlegada(timeE); //Se ingresa en el cliente nuevo su tiempo de entrada
                  nuevo.setTrans(); //Se genera el tiempo de transaccion
                  nuevo.setSalida(); //Se tiene el tiempo de salida
                  nuevo.setEstado(true);
                  ListaClientes.add(nuevo);
               }  
                for(int j=0; j<ListaClientes.size(); j++){
                    //Cliente nuevo = new Cliente();
                    Cliente cliente1 =  ListaClientes.get(j);        //Se examina un cliente de la lista y se guarda en una variable
                    cliente1.setEspera(tiempoEspera(ListaClientes,j));
                    prom+= tiempoEspera(ListaClientes,j);
                    cliente1.setSalida();
                    int clientesCaja1 = caja1.size();     //Obtiene la cantidad de usuario de la caja1
                    int clientesCaja2 = caja2.size();     //Obtiene la cantidad de usuario de la caja2
                    int clientesCaja3 = caja3.size();     //Obtiene la cantidad de usuario de la caja3
                    int clientesCaja4 = caja4.size();     //Obtiene la cantidad de usuario de la caja4
                    int[]ListaCajas = new int[4];         //Se crea una lista normal de longitud 4 para tener las cajas
                    ListaCajas[0] = clientesCaja1;        //Se ingresa la cantidad de clientes en la posicion 0 de la lista de cajas
                    ListaCajas[1] = clientesCaja2;
                    ListaCajas[2] = clientesCaja3;
                    ListaCajas[3] = clientesCaja4;
                    
                    
                    int tamMenor = cajaMenorSize(ListaCajas);  //Se guarda en la variable tamMenor la caja que tiene la menor cantidad de clientes
                    sacarEstado(caja1, caja2, caja3, caja4, ListaClientes, j);
                    
                    System.out.println(ListaCajas[0]);
                    System.out.println(ListaCajas[1]);
                    System.out.println(ListaCajas[2]);
                    System.out.println(ListaCajas[3]);
                    
                    switch(tamMenor){
                        case 0:
                            caja1.add(cliente1);
                            cliente1.setCola(1);
                            System.out.println(cliente1);
                            break;
                        case 1:
                            caja2.add(cliente1);
                            cliente1.setCola(2);
                            System.out.println(cliente1);
                            break;
                        case 2:
                            caja3.add(cliente1);
                            cliente1.setCola(3);
                            System.out.println(cliente1);
                            break;
                        case 3:
                            caja4.add(cliente1);
                            cliente1.setCola(4);
                            System.out.println(cliente1);
                            break;
           
                    }
                   
                }
                prom = numeroClientes+30;
                prom = prom/(numeroClientes);
                System.out.println("La espera promedio de los clientes es de: "+prom);
  
            break;
                
            case 2:
                System.out.print("Adios.");
            break;
            
            default:
		System.out.print("Numero invalido, ingresa de nuevo su opcion de 1-2.");
		break;
            }
        }while(r!=2);
        
    }
    
    //Metodo que remueve y cambia el estado del cliente
    public static void sacarEstado(VectorHeap<Cliente> caja1,VectorHeap<Cliente> caja2, VectorHeap<Cliente> caja3, VectorHeap<Cliente> caja4, List<Cliente> tamanos, int j){
        Cliente cli = tamanos.get(j);
        Cliente cli1 = null;
        Cliente cli2 = null;
        Cliente cli3 = null;
        Cliente cli4 = null;
        int prom =0;
       
        if(!caja1.isEmpty())cli1 = caja1.getFirst();
        if(!caja2.isEmpty())cli2 = caja2.getFirst();
        if(!caja3.isEmpty())cli3 = caja3.getFirst();
        if(!caja4.isEmpty())cli4 = caja4.getFirst();   
        
        try{
           if(cli1.getSalida()<cli.getLlegada()){
           cli1.setEstado(false); 
           caja1.remove();
           System.out.print("Se encuentra saliendo un cliente de la caja 1.");
           prom += cli1.getTrans();
           
        }  
        
        if(cli2.getSalida()<cli.getLlegada()){
           cli2.setEstado(false);  
           caja2.remove();
           System.out.print("Se encuentra saliendo un cliente de la caja 2.");
           prom += cli2.getTrans();
        }
        
        if(cli3.getSalida()<cli.getLlegada()){
           cli3.setEstado(false);
           caja3.remove();
           System.out.print("Se encuentra saliendo un cliente de la caja 3.");
           prom += cli3.getTrans();
        }
        
        if(cli4.getSalida()<cli.getLlegada()){
           cli4.setEstado(false); 
           caja4.remove();
           System.out.print("Se encuentra saliendo un cliente de la caja 4.");
           prom += cli4.getTrans();
        }
        }
        catch(NullPointerException e){}
        
        
    }
    
    //Metodo que recorre la lista de cajas de atras hacia adelante
    public static int tiempoEspera(List<Cliente> tamanos, int j){
        int tEspera = 0;
        Cliente cliente1 = tamanos.get(j);
        int fila = cliente1.getCola();
        Cliente clientec;
        for(int h=j-1; h>-1;h--){
            clientec = tamanos.get(h);
            if(fila == clientec.getCola()){
                if(clientec.getEstado()){
                    tEspera += clientec.getTrans();
                    
                }
            }   
        } 
        return tEspera;
    }
    
  
    //Metodo que revisa que caja es menor, recorrela la lista de ListaCajas
    public static int cajaMenorSize(int tamanos[]){
        int menor = 0; 
        int valorMenor = tamanos[0] ;
            for(int k=0; k<tamanos.length;k++){
                if(tamanos[k]<valorMenor){
                    valorMenor = tamanos[k];  
                    menor = k;
                } 
            }
         return menor;
    }
    
    public static void menu(){
	
	System.out.println();
	System.out.println("+-----------------------------------------+");
	System.out.println("+----- Menu de opciones del programa -----+");
	System.out.println("+-----------------------------------------+");
	System.out.println("| 1. Empezar el funcionamiento del Banco. |");
    System.out.println("| 2. Salir.                               |");
	System.out.println("+-----------------------------------------+");
    }
    
    
    public static double obtenerNumero(String mensaje, boolean mostrar){
        Scanner ingreso = new Scanner(System.in);
        double num = -1;
        
        System.out.print(mensaje);
        try{
            num = ingreso.nextDouble();
        }
        catch(InputMismatchException exception){
            if (mostrar)
                System.out.println("\n ERROR:  Dato invalido. \n");
        }
        finally{
            ingreso.nextLine();//Atrapar el ENTER
        }
        return num;
    }
}
