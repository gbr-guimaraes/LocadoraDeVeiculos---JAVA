package Classes;

class Veiculo {

    private String placa;
    private String cor;
    private String modelo;
    private int ano;
    private double preco;
    private Aluguel aluguel;

    Veiculo(String placa, String cor, String modelo, int ano, double preco) {
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    Aluguel getAluguel() {
        return aluguel;
    }

    String getPlaca() {
        return placa;
    }
    
    boolean disponivel(){
        if(aluguel == null){
            return true;
        }
        else{
            return false;
        }
    }
    
    void associaAluguel(Aluguel aluguel){
        if(disponivel()){
            this.aluguel = aluguel;
        }
    }
    
    void removeAluguel(){
        this.aluguel = null;
    }
    
}