package src;
import java.util.Deque;
import java.util.ArrayDeque;
import java.time.LocalDateTime;


abstract class Conta {
    private String titular;
    private long saldo;
    Deque<Transacao> transacoes = new ArrayDeque<>(3);

    public Conta(String titular, long saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    protected void adcTransacao(long valor){
        if(transacoes.size() == 3) {
            transacoes.pollLast();
        }
        transacoes.offerFirst(new Transacao(valor, LocalDateTime.now()));
    }

    public void extrato(){
        System.out.println("====Extrato bancário====");
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + (double)(saldo*0.01));
        System.out.println("===Últimas transações===");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
        System.out.println();
    }

    public boolean depositar(long deposito){
        if(deposito <= 0) {
            return false;
        }
        saldo += deposito;
        adcTransacao(deposito);
        return true;
    }

    // a conta corrente se diferencia porque possui o atributo limite
    abstract boolean sacar(long saque);   
}
