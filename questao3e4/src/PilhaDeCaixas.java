package src;
import java.util.Stack;

public class PilhaDeCaixas {

    private double alturaMaxima;
    private double alturaAtual;
    private double pesoAtual;
    private Stack<Caixa> pilha;

    public PilhaDeCaixas(double alturaMaxima) {
        if (alturaMaxima <= 0) {
            throw new IllegalArgumentException("A altura máxima deve ser positiva");
        }
        this.alturaMaxima = alturaMaxima;
        this.pilha = new Stack<>();
        this.alturaAtual = 0.0;
        this.pesoAtual = 0.0;
    }
    
    public double getAlturaMaxima() {
        return alturaMaxima;
    }
    
    public void setAlturaMaxima(double alturaMaxima) {
        if (alturaMaxima <= 0) {
            throw new IllegalArgumentException("A altura máxima deve ser positiva");
        }
        this.alturaMaxima = alturaMaxima;
    }
    
    public double getAlturaAtual() {
        return alturaAtual;
    }
    
    public double getPesoAtual() {
        return pesoAtual;
    }

    public Stack<Caixa> getPilha() {
        return pilha;
    }

    public boolean empilhar(Caixa novaCaixa){
        if(getAlturaAtual() + novaCaixa.getAltura() > alturaMaxima){
            System.out.println("Falha ao empilhar, altura máxima excedida");
            return false;
        }
        for(Caixa caixa : pilha){
            if(caixa instanceof CaixaFragil){
                CaixaFragil fragil = (CaixaFragil) caixa;
                if(!fragil.setPesoAcima(novaCaixa.getPeso())){
                    System.out.println("Falha ao empilhar, peso máximo excedido por uma caixa frágil");
                    return false;
                }
            }
        }
        alturaAtual += novaCaixa.getAltura();
        pesoAtual += novaCaixa.getPeso();
        pilha.add(novaCaixa);
        return true;
    }

    public Caixa desempilhar() {
        if (pilha.isEmpty()) {
            System.out.println("Não há nenhuma caixa para desempilhar");
            return null;
        }
    
        Caixa topo = pilha.pop();
        alturaAtual -= topo.getAltura();
        pesoAtual -= topo.getPeso();

        for (Caixa caixa : pilha) {
            if (caixa instanceof CaixaFragil) {
                CaixaFragil fragil = (CaixaFragil) caixa;
                fragil.setPesoAcima(-1.0 * topo.getPeso());
            }
        }
    
        return topo;
    }    

    public void exibirPilha() {
        System.out.println();
        System.out.println("========Pilha========");
        System.out.println("Altura atual: " + alturaAtual);
        System.out.println("Peso atual: " + pesoAtual);
    
        for (int i = pilha.size() - 1; i >= 0; i--) {
            pilha.get(i).exibirEtiqueta();
        }
    }
    
}
