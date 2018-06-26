/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temer;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Sala {
    
   
    
        private int identificador;
	private int quantidadePessoas;
	private int temperaturaIdeal;
	private int temperaturaAtual;
	private int quantidadeAr;
        private String identificadorJ;
	private ArrayList<ArCondicionado> listaAr;
	private ArrayList<Agendamento> listaAgendamentos;
        private boolean aresLigados;
	
	public Sala(int identificador, int temperatura, int quantidadeAr) {
		super();
		this.identificador = identificador;
		this.quantidadePessoas = 0;
		this.temperaturaIdeal = temperatura;
		this.temperaturaAtual = 0;
		listaAr = new ArrayList<ArCondicionado>();
		for(int i = 1; i <= quantidadeAr; i++){
			listaAr.add(new ArCondicionado(i));
		}
		listaAgendamentos = new ArrayList<Agendamento>();
                aresLigados = false;
	}
	
	public String toString(){
		String retorno = "";
		
		retorno += "[ID da sala: " + identificador + " | Temperatura ideal: " + temperaturaIdeal + "] ";
		retorno += "Quantidade de pessoas: " + String.format("%02d", quantidadePessoas) + " | ";
		
                /*for(ArCondicionado ar : listaAr){
			retorno += ar;
		}*/
		retorno += listaAr.get(0);
		
		return retorno;
	}
	
	public void adicionarAgendamento(int dia, int horaInicio, int minutoInicio, int horaFim, int minutoFim){
		listaAgendamentos.add(new Agendamento(this, dia, horaInicio, minutoInicio, horaFim, minutoFim));
	}
	
	public void ligarAres(){
            if(!aresLigados){
		for(ArCondicionado ar : listaAr){
			ar.ligar(temperaturaIdeal);
		}
		temperaturaAtual = temperaturaIdeal;
                aresLigados = true;
            }
	}
	
	public void desligarAres(){
            if(aresLigados){
		for(ArCondicionado ar : listaAr){
			ar.desligar();
		}
		temperaturaAtual = 30;
                aresLigados = false;
            }
	}
        
        public boolean isAresLigados(){
            return aresLigados;
        }
	
	public void entrarPessoas(int quantidade){
		quantidadePessoas += quantidade;
		calcularNovaTemperatura();
	}
	
	public void sairPessoas(int quantidade){
		quantidadePessoas -= quantidade;
		if(quantidadePessoas < 0){
			quantidadePessoas = 0;
		}
		calcularNovaTemperatura();
	}
	
	public int calcularNovaTemperatura(){
		
		int quociente = quantidadePessoas / 10;
		int novaTemperatura = temperaturaIdeal - quociente;
		if(!(novaTemperatura == temperaturaAtual)){
			for(ArCondicionado ar : listaAr){
				ar.ajustarTemperatura(novaTemperatura);
			}
			temperaturaAtual = novaTemperatura;
		}
		
		return 1;
	}
	
        public boolean temAgendamentoProx30Minutos(int horaAtual, int minutoAtual){
            for(Agendamento agendamento : listaAgendamentos){
                if(isProx30Minutos(horaAtual, minutoAtual, agendamento.getHoraInicio(), agendamento.getMinutoInicio())){
                    return true;
                }
            }
            return false;
        }
        
        public void esvaziarCasoTenhaTerminado(int horaAtual, int minutoAtual){
            for(Agendamento agendamento : listaAgendamentos){
                //System.out.println("If( " + horaAtual + " == " + agendamento.getHoraFim() + " && " + minutoAtual + " == " + agendamento.getMinutoFim() +");");
                if(horaAtual == agendamento.getHoraFim() && minutoAtual == agendamento.getMinutoFim()){
                    //System.out.println("\nTerminei\n");
                    quantidadePessoas = 0;
                }
            }
        }
        
        public void popularAoComecar(int horaAtual, int minutoAtual){
            for(Agendamento agendamento : listaAgendamentos){
                if(horaAtual == agendamento.getHoraInicio() && minutoAtual == agendamento.getMinutoInicio()){
                    quantidadePessoas = 10;
                }
            }
        }
        
        public boolean isProx30Minutos(int horaAtual, int minutoAtual, int horaAgendamento, int minutoAgendamento){
        if(horaAgendamento == horaAtual){
            if(minutoAgendamento - minutoAtual <= 30){
                return true;
            } else {
                return false;
            }
        } else {
            if(horaAtual == horaAgendamento - 1 && minutoAtual - minutoAgendamento <= 30){
                return true;
            } else {
                return false;
            }
        }
    }
        
	public int getIdentificador(){
		return identificador;
	}
	
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}
	
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	
	public int getTemperaturaIdeal() {
		return temperaturaIdeal;
	}
	
	public void setTemperaturaIdeal(int temperatura) {
		this.temperaturaIdeal = temperatura;
	}
        
        public int getTemperaturaAtual() {
		return temperaturaAtual;
	}
	
	public void setTemperaturaAtual(int temperatura) {
		this.temperaturaAtual = temperatura;
	}
	
        
	public int getQuantidadeAr() {
		return quantidadeAr;
	}

	public void setQuantidadeAr(int quantidadeAr) {
		this.quantidadeAr = quantidadeAr;
	}

	public ArrayList<ArCondicionado> getListaAr() {
		return listaAr;
	}
	
	public void setListaAr(ArrayList<ArCondicionado> listaAr) {
		this.listaAr = listaAr;
	}
	
	public ArrayList<Agendamento> getListaAgendamentos(){
		return listaAgendamentos;
	}
	
}
