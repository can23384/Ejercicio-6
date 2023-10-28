/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #6
Eliazar Canastuj
carnet: 23384
*/


import java.util.*;
import java.io.*;


public class main{

    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);
        ArrayList<dispositivo> dispositivos = new ArrayList<dispositivo>();
        //CARGAR ARCHIVO .CSV
        try{
            File archivo = new File("dispositivos.csv");
            Scanner scanner = new Scanner(archivo);

            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(";");

                String modelo = campos[1];
//comprobar si el tipo de dispositvo es telefono o computadora
                if (campos[0].equals("telefono")) {
                        telefono telefono = new telefono(modelo);
                        if(campos[2].equals("encendido")){
                            telefono.encender();
                            dispositivos.add(telefono);
                        }else{
                            telefono.apagar();
                            dispositivos.add(telefono);
                        }     
                    }

                else if (campos[0].equals("computadora")) {
                        computadora computadora = new computadora(modelo);
                        if(campos[2].equals("encendido")){
                            computadora.encender();
                            dispositivos.add(computadora);
                        }else{
                            computadora.apagar();
                            dispositivos.add(computadora);
                        }     
                    }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


/////a///////////////////menu
        boolean hola = true;
        while(hola){
            System.out.println("==============================");
            System.out.println("Elija una opcion: ");
            System.out.println("1. Agregar dispositivo");
            System.out.println("2. Modificar dispositivo");
            System.out.println("3. Desplegar la información de cada dispositivo");
            System.out.println("4. Validar qué elementos se encuentran en encendidos y qué elementos están apagados");
            System.out.println("5. salir");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            System.out.println("==============================");

            switch(opcion){
                case 1:
                    //opcion para agregar un dispositivo nuevo
                    System.out.println("Que tipo de dispositivo quiere agregar telefono/computadora? ");
                    String tipo = teclado.nextLine();
                    System.out.println("Escriba el modelo del dispositivo: ");
                    String modelo = teclado.nextLine();
                    System.out.println("El dispositivo se encuentra encendido o apagado?");
                    String estado = teclado.nextLine();

                    if (tipo.equals("telefono")) {
                        telefono telefono = new telefono(modelo);
                        if(estado.equals("encendido")){
                            telefono.encender();
                            dispositivos.add(telefono);
                        }else{
                            telefono.apagar();
                            dispositivos.add(telefono);
                        }     
                    }else if (tipo.equals("computadora")) {
                            computadora computadora = new computadora(modelo);
                            if(estado.equals("encendido")){
                                computadora.encender();
                                dispositivos.add(computadora);
                            }else{
                                computadora.apagar();
                                dispositivos.add(computadora);
                            }     
                        } 
                    break;

                case 2:
                    //yo creo que esta opcion ni sirve 
                    System.out.println("Que modelo quiere modificar?");
                    String nombre = teclado.nextLine();
                    System.out.println("El dispositivo se encuentra encendido o apagado?");
                    String lol = teclado.nextLine();

                    for(dispositivo dispositivo : dispositivos){
                        if (dispositivo instanceof telefono) {
                            telefono cell = (telefono) dispositivo;
                            if((cell.getModelo()).equals(nombre)){
                                if(lol.equals("encendido")){
                                    cell.encender();
                                }
                            }else{
                                cell.apagar();
                            }     
                        }
                        //ojala pudiera declararle el amor que siento pero solo se declarar variables :c
                        else if (dispositivo instanceof telefono) {
                            computadora cumpu = (computadora) dispositivo;
                            if((cumpu.getModelo()).equals(nombre)){
                                if(lol.equals("encendido")){
                                    cumpu.encender();
                                }
                            }else{
                                cumpu.apagar();
                            }     
                        }
                        
                    }
                    break;

                case 3:
                    for(dispositivo dispositivo : dispositivos){
                        System.out.println(dispositivo);
                    }
                    break;

                case 7:
                    System.out.println("Lo que no sabes afton es que yo soy el fnaf");
                    break;

                case 4:
                    for(dispositivo dispositivo : dispositivos){
                        dispositivo.validar();
                    }
                    break;

                case 5:
                    System.out.println("Guardando datos....");
                    //guardar en el .csv
                    String nombreArchivo = "dispositivos.csv";
                    String encabezado = "tipo;modelo;encendido/apagado";

                    try{
                        FileWriter escritor = new FileWriter(nombreArchivo, false);
                        escritor.write(encabezado + "\n");

                        for(dispositivo dispositivo : dispositivos){
                            if (dispositivo instanceof telefono){
                                telefono telefono = (telefono) dispositivo;
                                System.out.println(telefono);
                                escritor.write("telefono" + ";" + telefono.getModelo() + ";"+ telefono.getEstado() + "\n");
                            }
                            else if (dispositivo instanceof computadora){
                                computadora computadora = (computadora) dispositivo;
                                escritor.write("computadora" + ";" + computadora.getModelo() + ";"+ computadora.getEstado() + "\n");
                            }

                        }
                        escritor.close();

                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    //YA SE GUARDO EL ARCHIVO
                    hola = false;                    

                    break;
            }



        }

    }
}