package Classes;

import java.util.*;

public class Locadora {

    private ArrayList<Cliente> clientes;
    private ArrayList<Veiculo> veiculos;
    private ArrayList<Aluguel> alugueis;

    public Locadora() {
        this.clientes = new ArrayList();
        this.veiculos = new ArrayList();
        this.alugueis = new ArrayList();
    }

    private ArrayList<String> veiculosDisponiveis(){
        ArrayList<String> lista = new ArrayList();
        
        for(int i = 0; i< veiculos.size(); i++){
            if(veiculos.get(i).disponivel()){
                lista.add(veiculos.get(i).getPlaca());
            }
        }
        
        return lista;
        
    }
    
    private ArrayList<Cliente> clientesComCarrosAlugados(){
        
        ArrayList<Cliente> aux = new ArrayList();
        
        for(int i = 0; i< clientes.size(); i++){
            if(clientes.get(i).temAluguel()){
                aux.add(clientes.get(i));
            }
        }
        
        return aux;
        
    }
    
    public boolean incluirCliente(String nome, String cpf, Long cartao){
        Cliente novo = new Cliente(nome, cpf, cartao);
        return clientes.add(novo);
    }
    
    public boolean incluirVeiculo(String placa, String cor, String modelo, int ano, double preco){
        Veiculo novo = new Veiculo(placa, cor, modelo, ano, preco);
        return veiculos.add(novo);
    }
    
    public boolean alugaVeiculo(String cpf, String placa, int dias, double valor){
        
        if(buscarCliente(cpf).temAluguel() || !buscarVeiculo(placa).disponivel()){
            return false;
        }
        
        boolean aux = alugueis.add(new Aluguel(buscarCliente(cpf), buscarVeiculo(placa), dias, valor));
        buscarCliente(cpf).associaAluguel(buscarAluguel(cpf));
        buscarVeiculo(placa).associaAluguel(buscarAluguel(cpf));
        return aux;
        
    }
        
    public boolean devolucaoVeiculo(String cpf){
        
        Aluguel aux = buscarAluguel(cpf);
        aux.getCliente().removeAluguel();
        aux.getVeiculo().removeAluguel();
        return alugueis.remove(buscarAluguel(cpf));
        
    }
    
    public double valorASerPago(String cpf){
        Aluguel aux = buscarAluguel(cpf);
        return aux.getDias()*aux.getValor();
    }
    
    private Cliente buscarCliente(String cpf){
        for(int i = 0; i<clientes.size(); i++){
            if(clientes.get(i).getCpf().equals(cpf)){
                return clientes.get(i);
            }
        }
        return null;
    }
    
    private Veiculo buscarVeiculo(String placa){
        for(int i = 0; i<veiculos.size(); i++){
            if(veiculos.get(i).getPlaca().equals(placa)){
                return veiculos.get(i);
            }
        }
        return null;
    }
    
    private Aluguel buscarAluguel(String cpf){
        for(int i = 0; i<alugueis.size(); i++){
            if(alugueis.get(i).getCliente().getCpf().equals(cpf)){
                return alugueis.get(i);
            }
        }
        return null;
    }
    
    public void exibirClientesComCarrosAlugados(){
        for(int i = 0; i<clientesComCarrosAlugados().size();i++){
            System.out.println(clientesComCarrosAlugados().get(i).getNome() + " - " + clientesComCarrosAlugados().get(i).getCpf());
        }
    }
    
    public void exibirVeiculosDisponiveis(){
        for(int i = 0; i<veiculosDisponiveis().size(); i++){
            System.out.println(veiculosDisponiveis().get(i));
        }
    }

}