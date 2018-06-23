
public class Main {

	public static void main(String[] args) {
        Sala sala = new Sala(1, 23, 2);
        
        System.out.println("\n" + sala + "\n");
        
        sala.ligarAres();
        
        System.out.println("\n" + sala + "\n");
        
        sala.entrarPessoas(9);
        
        System.out.println("\n" + sala + "\n");
        
        sala.entrarPessoas(9);
        
        System.out.println("\n" + sala + "\n");
        
        sala.sairPessoas(10);
        
        System.out.println("\n" + sala + "\n");
    }
}
