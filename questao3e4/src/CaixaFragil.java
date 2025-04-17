package src;

public class CaixaFragil extends Caixa {
    
    private double pesoMax;
    private double pesoAcima;
    
    public CaixaFragil(String id, String conteudo, double peso, double altura, double pesoMax){
        super(id, conteudo, peso, altura);
        if(pesoMax <= 0){
            throw new IllegalArgumentException("peso máximo precisa ser positivo");
        }
        this.pesoMax = pesoMax;
        this.pesoAcima = 0.0;
    }

    public double getPesoMax() {
        return pesoMax;
    }

    public void setPesoMax(double pesoMax) {
        this.pesoMax = pesoMax;
    }

    protected double getPesoAcima() {
        return pesoAcima;
    }

    protected boolean setPesoAcima(double novoPesoAcima) {
        if(novoPesoAcima + pesoAcima > pesoMax){
            return false;
        }
        this.pesoAcima += novoPesoAcima;
        return true;
    }

    @Override
    public void exibirEtiqueta() {
        super.exibirEtiqueta();
        System.out.println("peso máximo suportado: " + pesoMax);
    }
}
