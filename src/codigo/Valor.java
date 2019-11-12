/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

/**
 *
 * @author Carlos
 */
public class Valor<T> {
    private String tipo = "";
    private T value;
    
    public Valor(String texto){
        this.tipo = texto;
    }
    
    public void setValor(T valor){
        this.value = valor;
    }
    
    public String getTipo(){
        return tipo;
    }
    
    public T getValor(){
        return value;
    }
    
    @Override
    public String toString(){
        return tipo + "," + value;
    }
}




