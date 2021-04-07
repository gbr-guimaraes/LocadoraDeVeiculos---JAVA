package Classes;

class Cliente {

    private String nome;
    private String cpf;
    private long cartaoCredito;
    private Aluguel aluguel;

    Cliente(String nome, String cpf, long cartaoCredito) {
        this.nome = nome;
        this.cpf = cpf;
        this.cartaoCredito = cartaoCredito;
    }

    Aluguel getAluguel() {
        return aluguel;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    boolean temAluguel(){
       if(this.aluguel == null){
           return false;
       }
       else return true;
    }
    
    void associaAluguel(Aluguel aluguel){
        this.aluguel = aluguel;
    }
    
    void removeAluguel(){
        this.aluguel = null;
    }

}
