/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apllicação;

import Classes.Locadora;

/**
 *
 * @author gbr
 */
public class UsaLocadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Locadora test = new Locadora();
        
        test.incluirVeiculo("abd-1234", "preto", "celta", 2012, 120.00);
        test.incluirCliente("Gbr", "12345678900", 0000111122223333l);
        
        test.exibirVeiculosDisponiveis();
        test.exibirClientesComCarrosAlugados();
        
        test.alugaVeiculo("12345678900", "abd-1234", 5, 120.00);
        
        System.out.println(test.valorASerPago("12345678900"));
        
        test.devolucaoVeiculo("12345678900");
    }
    
}
