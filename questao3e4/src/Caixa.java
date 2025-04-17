package src;

public class Caixa {
    private String id;
    private String conteudo;
    private double peso;
    private double altura;

    public Caixa(String id, String conteudo, double peso, double altura){
        if(peso <= 0 || altura <= 0){
            throw new IllegalArgumentException("peso e altura têm que ser positivos");
        }
        this.id = id;
        this.conteudo = conteudo;
        this.peso = peso;
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }
    public String getConteudo() {
        return conteudo;
    }
    public String getId() {
        return id;
    }
    public double getPeso() {
        return peso;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void exibirEtiqueta(){
        System.out.println();
        System.out.println("Id: " + id);
        System.out.println("Conteúdo: " + conteudo);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
    }
}
