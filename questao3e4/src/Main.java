package src;

public class Main {

    public static void main(String[] args){

        PilhaDeCaixas pilha = new PilhaDeCaixas(300);
        CaixaFragil caixa1 = new CaixaFragil(null, null, 3.0, 20.0, 20.0);
        Caixa caixa2 = new Caixa(null, null, 10.5, 40.0);
        Caixa caixa3 = new Caixa(null, null, 10.0, 55.0);
        
        pilha.empilhar(caixa1);
        pilha.empilhar(caixa2);
        pilha.exibirPilha();

        pilha.desempilhar();
        pilha.empilhar(caixa3);
        pilha.exibirPilha();
    }
}
