package src;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

public class Transacao {
    final long valor;
    final LocalDateTime hora;
    public Transacao(long valor, LocalDateTime hora){
        this.valor = valor;
        this.hora = hora;
    }

    @Override
    public String toString() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formato.format(valor / 100.0) + " \t" + hora;
    }
}
