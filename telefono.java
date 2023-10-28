/*
Universidad del Valle de Guatemala
cc2008 - POO
Seccion 10
Ejercicio #6
Eliazar Canastuj
carnet: 23384
*/


public class telefono implements dispositivo{
    private String modelo;
    private boolean estado;

    public telefono(String modelo){
        this.modelo = modelo;
    }

    //get 
    public String getModelo(){
        return this.modelo;
    }

    public String getEstado() {
        if (estado == true){
            return "encendido";
        }else{
            return "apagado";
        }
    }

    @Override
    public void apagar() {
        estado = false;
    }

    @Override
    public void encender() {
        estado = true;
    }

    @Override
    public void validar() {
        if(estado == true){
            System.out.println(modelo + " esta encendido.");
        }else{
            System.out.println(modelo + " esta apagado.");
        }
    }

    public String toString() {
        return "Tipo: telefono  Modelo: " + modelo;
    }

}