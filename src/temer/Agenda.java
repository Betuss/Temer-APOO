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
		agendamentosSabado = new ArrayList<Agendamento>();
		agendamentosDomingo = new ArrayList<Agendamento>();
		agendamentosSegunda = new ArrayList<Agendamento>();
		agendamentosTerca = new ArrayList<Agendamento>();
		agendamentosQuarta = new ArrayList<Agendamento>();
		agendamentosQuinta = new ArrayList<Agendamento>();
		agendamentosSexta = new ArrayList<Agendamento>();
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

	public ArrayList<Agendamento> getAgendamentosSabado() {
		return agendamentosSabado;
	}

	public ArrayList<Agendamento> getAgendamentosDomingo() {
		return agendamentosDomingo;
	}

	public ArrayList<Agendamento> getAgendamentosSegunda() {
		return agendamentosSegunda;
	}

	public ArrayList<Agendamento> getAgendamentosTerca() {
		return agendamentosTerca;
	}

	public ArrayList<Agendamento> getAgendamentosQuarta() {
		return agendamentosQuarta;
	}

	public ArrayList<Agendamento> getAgendamentosQuinta() {
		return agendamentosQuinta;
	}

	public ArrayList<Agendamento> getAgendamentosSexta() {
		return agendamentosSexta;
	}
	
}
