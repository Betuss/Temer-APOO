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
public class Agenda {
    private ArrayList<Agendamento> agendamentosSabado;
	private ArrayList<Agendamento> agendamentosDomingo;
	private ArrayList<Agendamento> agendamentosSegunda;
	private ArrayList<Agendamento> agendamentosTerca;
	private ArrayList<Agendamento> agendamentosQuarta;
	private ArrayList<Agendamento> agendamentosQuinta;
	private ArrayList<Agendamento> agendamentosSexta;
	
	public Agenda(){
		agendamentosSabado = new ArrayList<>();
		agendamentosDomingo = new ArrayList<>();
		agendamentosSegunda = new ArrayList<>();
		agendamentosTerca = new ArrayList<>();
		agendamentosQuarta = new ArrayList<>();
		agendamentosQuinta = new ArrayList<>();
		agendamentosSexta = new ArrayList<>();
	}
	
	public void adicionarAgendamento(Agendamento agendamento){
            switch(agendamento.getDia()){
		case 0:
			agendamentosSabado.add(agendamento);
			break;
		case 1:
			agendamentosDomingo.add(agendamento);
			break;
		case 2:
			agendamentosSegunda.add(agendamento);
			break;
		case 3:
			agendamentosTerca.add(agendamento);
			break;
		case 4:
			agendamentosQuarta.add(agendamento);
			break;
		case 5:
			agendamentosQuinta.add(agendamento);
			break;
		case 6:
			agendamentosSexta.add(agendamento);
			break;
		default:
			break;
		}
	}
        
        public ArrayList<Agendamento> getAgendamentos(int dia){
            ArrayList<Agendamento> listaRetorno = new ArrayList<>();
            switch(dia){
		case 0:
			listaRetorno = agendamentosSabado;
			break;
		case 1:
			listaRetorno = agendamentosDomingo;
			break;
		case 2:
			listaRetorno = agendamentosSegunda;
			break;
		case 3:
			listaRetorno = agendamentosTerca;
			break;
		case 4:
			listaRetorno = agendamentosQuarta;
			break;
		case 5:
			listaRetorno = agendamentosQuinta;
			break;
		case 6:
			listaRetorno = agendamentosSexta;
			break;
		default:
			break;
		}
            return listaRetorno;
	}
	
}
