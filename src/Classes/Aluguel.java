package Classes;

class Aluguel {

    private Cliente cliente;
    private Veiculo veiculo;
    private int dias;
    private double valor;

    Aluguel(Cliente cliente, Veiculo veiculo, int dias, double valor) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dias = dias;
        this.valor = valor;
    }

    Cliente getCliente() {
        return cliente;
    }

    Veiculo getVeiculo() {
        return veiculo;
    }

    int getDias() {
        return dias;
    }

    double getValor() {
        return valor;
    }
    
    

}
