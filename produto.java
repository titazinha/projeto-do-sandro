class Produto {
    private String nome;
    private double preco;
    private int cod;
    
    public Produto(String nome, double preco, int cod) {
        this.nome = nome;
        this.preco = preco;
        this.cod = cod;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getCod() {
        return cod;
    }
}
