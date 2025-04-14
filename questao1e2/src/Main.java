package src;

public class Main {
    public static void main(String[] args) {

        // Questão 1
        ContaCorrente minhaCC = new ContaCorrente("Davi", 100000);
        minhaCC.extrato();
        minhaCC.depositar(10000);
        minhaCC.extrato();
        minhaCC.depositar(40000);
        minhaCC.extrato();
        minhaCC.sacar(20000);
        minhaCC.extrato();

        ContaPoupanca minhaCP = new ContaPoupanca("Davi", 500000);
        minhaCP.extrato();
        minhaCP.depositar(100000);
        minhaCP.extrato();
        minhaCP.aplicarJuros();
        minhaCP.extrato();

        // Questão 2
        ContaPoupanca[] contas = new ContaPoupanca[10];
        contas[0] = new ContaPoupanca("Davi", 1000000);
        contas[1] = new ContaTesouroDireto("Davi", 1000000);
        contas[0].extrato();
        contas[1].extrato();
        contas[0].depositar(50000);
        contas[0].extrato();
        contas[1].depositar(50000);
        contas[1].extrato();
        contas[0].aplicarJuros();
        contas[0].extrato();
        contas[1].aplicarJuros();
        contas[1].extrato();
    }    
}
