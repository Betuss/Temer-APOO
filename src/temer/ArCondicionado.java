/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temer;

/**
 *
 * 
 */
public class ArCondicionado {
    private int identificador;
	private boolean ligado;
	private int temperatura;
		
	public ArCondicionado(int identificador){
		this.identificador = identificador;
		ligado = false;
		temperatura = 0;
	}
	
	public String toString(){
		String retorno = "";
		retorno += "[Ar-condicionado " + identificador + ": ";
		if(ligado){
			retorno += "LIGADO | ";
			retorno += "Temperatura: " + temperatura + "] ";
		} else {
			retorno += "DESLIGADO] ";
		}
		
		return retorno;
	}
	
	public void ligar(int temperaturaIdeal){
		if(ligado == false){
			ligado = true;
			temperatura = temperaturaIdeal;
		}
	}
	
	public void desligar(){
		if(ligado == true){
			ligado = false;
		}
	}
	
	public void ajustarTemperatura(int novaTemperatura){
		temperatura = novaTemperatura;
	}
	
	public int getTemperatura(){
		return temperatura;
	}
}
