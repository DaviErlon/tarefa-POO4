package src;

// ideia de limmite

public class ContaCorrente extends Conta {
    private int limite;

    public ContaCorrente(String titular, long saldoInicial){
        super(titular, saldoInicial);
        limite = 20000;
    }

    public int getLimite() {
        return limite;
    }

    @Override
    public boolean sacar(long saque) {
        if(saque > limite + getSaldo()) {
            return false;
        }
        setSaldo(getSaldo() - saque);
        adcTransacao(saque* -1);
        return true;
    }
}