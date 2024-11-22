package br.com.smartweb.airlines;

public class AirLinesMain {

	public static void main(String[] args) {
		System.out.println("======================== SMARTWEB AIRLINES ========================");
		var servicoDeReserva = new ServicoDeReserva();
        var servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
        Voo_old voo = new Voo_old("G31333", "UDI", "GRU");
     
      //reservas
        
        servicoDeReserva.adicionar(new Reserva("28A888", voo, "Juca Ferreira do Nascimento"));
        servicoDeReserva.adicionar(new Reserva("28B111", voo, "Mari Lins da Fonseca"));
        servicoDeReserva.adicionar(new Reserva("74F877", voo, "Sebastião Coelho Beltrão"));

     // verificando se existe esse reserva
        try {
            servicoDeBagagem.contratar("28Axxx", 2);  
        } catch (ReservaNaoEncontradaException e) {
          //caso erro 
            System.err.println("Erro: " + e.getMessage());  
        }
        
        //adicionar 2 bagagens, caso numero de bagagens seja menor ou igual a 0 vai exibir erro de argumento..
        try {
            servicoDeBagagem.contratar("28A888", 2);  
        } catch (IllegalArgumentException e) {
            System.err.println("Erro de argumento: " + e.getMessage());  
        }

         // busca todas as reservas do sistema
        servicoDeReserva.getReservas().forEach(System.out::println);
        
        //exibir no final
        System.err.println("=====================================================================");

	}

}
