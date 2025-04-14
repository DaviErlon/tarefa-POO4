package src;

// era melhor ter herdado direto da classe Conta
public class ContaTesouroDireto extends ContaPoupanca {
    public ContaTesouroDireto(String titular, long saldoInicial){
        super(titular, saldoInicial);
        if(saldoInicial < 1000) {
            throw new IllegalArgumentException("Tesouro direto só aceita depositos acima de mil reais");
        }
    }

    @Override
    public boolean depositar(long deposito) {
        if (deposito < 1000) {
            return false;
        } 
        setSaldo(getSaldo() + deposito);
        adcTransacao(deposito);
        return true;
    }

    @Override
    public void aplicarJuros() {
        adcTransacao((long)(getSaldo() * 0.01));
        setSaldo((long)(getSaldo()* 1.01));
    }
}