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
public class Agendamento {
    private int identificadorSala;
	private int dia;
	private int horaInicio;
	private int minutoInicio;
	private int horaFim;
	private int minutoFim;
	
	public Agendamento(int identificadorSala, int dia, int horaInicio, int minutoInicio, int horaFim, int minutoFim) {
		this.identificadorSala = identificadorSala;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.minutoInicio = minutoInicio;
		this.horaFim = horaFim;
		this.minutoFim = minutoFim;
	}
	
	public int getIdentificadorSala(){
		return identificadorSala;
	}
	
	public void setIdentificadorSala(int identificadorSala){
		this.identificadorSala = identificadorSala;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getMinutoInicio() {
		return minutoInicio;
	}

	public void setMinutoInicio(int minutoInicio) {
		this.minutoInicio = minutoInicio;
	}

	public int getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(int horaFim) {
		this.horaFim = horaFim;
	}

	public int getMinutoFim() {
		return minutoFim;
	}

	public void setMinutoFim(int minutoFim) {
		this.minutoFim = minutoFim;
	}
	
}
