/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temer;

import java.util.Random;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
    public enum Dia{
		SABADO(0), DOMINGO(1), SEGUNDA(2), TERCA(3), QUARTA(4), QUINTA(5), SEXTA(6);
		private int dia;
		
		Dia(int dia){
			this.dia = dia;
		}
		
		public int getDia(){
			return dia;
		}
	}
        
   
    public static void main(String[] args) {
        
        Tela tela = new Tela(); 
        tela.setVisible(true);
        Sistema sistema = new Sistema();
        
		
        
        Sala sala = new Sala(1, 23, 2);
        sala.adicionarAgendamento(Dia.TERCA.getDia(), 14, 55, 16, 35);
		sistema.addSala(sala);
		
		Random gerador = new Random();
		
		sala.ligarAres();
		
		for(int i = 0; i < 100; i++){
			System.out.println("\n" + sala + "Dia: " + sistema.getDia() + " | Hora: " + sistema.getHorario() +  "\n");
			
                        tela.jhora.setText(sistema.getHorario());
                        
                        String identificadorJ = Integer.toString(sala.getIdentificador());
                        tela.JidSala.setText(identificadorJ);
                        
                        //String temperaturaIdealJ = Integer.toString(sala.getTemperaturaIdeal());
                        //tela.jtempIdeal.setText(temperaturaIdealJ);
                        
                        String temperaturaAtualJ = Integer.toString(sala.getTemperaturaAtual());
                        tela.jtemperatura.setText(temperaturaAtualJ);
                        
                        try { 
                            Thread.sleep (1000); // Espera 1s para dar as saídas, fica melhor pra enxergar as mudanças
                        } catch (InterruptedException ex) {
                           System.out.println("Erro");
                        }                        
                        
                        sala.entrarPessoas(gerador.nextInt(3));
                        
			if(i % 2 == 0){
				sala.sairPessoas(gerador.nextInt(4));
			}
			if(i % 5 == 0){
				sistema.passarMeiaHora();
			}
			sistema.passarCincoMinutos();
		}
    }
    
}
