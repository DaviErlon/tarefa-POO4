package src;

// ideia de juros

public class ContaPoupanca extends Conta{
    
    public ContaPoupanca(String titular, long saldoInicial) {
        super(titular, saldoInicial);
    }

    @Override
    public boolean sacar(long saque) {
        if (saque > getSaldo()) {
            return false;
        }
        setSaldo(getSaldo() - saque);
        adcTransacao(saque * -1);
        return true;
    }

    public void aplicarJuros() {
        adcTransacao((long)(getSaldo() * 0.005));
        setSaldo((long)(getSaldo() * 1.005));
    }

}
