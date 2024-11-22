package br.com.smartweb.airlines;

import java.util.Objects;
import java.util.Optional;

public class ServicoDeBagagem {

    private ServicoDeReserva servicoDeReserva;

    public ServicoDeBagagem(ServicoDeReserva servicoDeReserva) {
        Objects.requireNonNull(servicoDeReserva);
        this.servicoDeReserva = servicoDeReserva;
    }
          // verificando se a quantidade de bagagem é menor que 0, se for menor é exibida a mensagem abaixo. 
    
    public void contratar(String codigoReserva, int quantidadeBagagens) {
        if (quantidadeBagagens <= 0) {
            throw new IllegalArgumentException("Quantidade de bagagens inválida");
        }
        
     // Verificando se a reserva existe
        
        Optional<Reserva> reservaOptional = servicoDeReserva.buscar(codigoReserva);

        // caso exista reservar, vai exibir a quantidade de bagagem
        
        reservaOptional.ifPresentOrElse(
            reserva -> reserva.adicionarBagagens(quantidadeBagagens),
            
          // caso não exista, vai exibir a mensagem abaixo
        () -> { throw new ReservaNaoEncontradaException("Reserva com código " + codigoReserva + " não encontrada."); }
      );
    }
}