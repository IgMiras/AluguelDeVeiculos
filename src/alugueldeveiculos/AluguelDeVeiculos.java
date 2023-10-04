/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alugueldeveiculos;

import java.sql.Connection;
import connection.Conexao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;
import models.LocadoraDeVeiculos;
import models.Seguro;

/**
 *
 * @author Windows
 */
public class AluguelDeVeiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UIPrincipal().setVisible(true);
            }
        });
        LocadoraDeVeiculos locadora = LocadoraDeVeiculos.getInstancia("AluguelDeVeiculos"
            , "R. Osvaldo Peretti, 98. Jardim das Rosas. Presidente Prudente - SP"
            , "www.alugueldeveiculos.com.br"
            ,"Instagram: @AluguelDeVeiculos");
        
      /*locadora.addSeguro("Seguro anti-furto", "Seguro Automovel",
                "O seguro cobre integralmente o valor do veiculo em caso de furto", 20);
        locadora.addSeguro("Seguro acidente", "Seguro Automovel",
                "O seguro cobre integralmente o valor do veiculo em caso de acidente", 25);
        
        locadora.addCliente("Igor", "454.474.348-22", "52.047.755-2",
                "20/07/2004", "R. Osvaldo Peretti, 98 - Jardim das Rosas, Presidente Prudente",
                "19060-160", "im.miras@unesp.br", "A", "22222222222",
                "01/01/2024", true);
                 
        locadora.addCliente("Joao", "333.374.348-22", "12.052.725-2",
                "10/05/2004",
                "R. Tchurusbengo Tchurusbangos, 12 - Jardim das Rosas, Presidente Prudente",
                "19260-161", "lais.isabella@unesp.br", "B", "91299999999",
                "01/01/2025", true);

        locadora.addCliente("Sergio", "442.178.111-77", "34.067.134-3",
                "13/04/2004", "R. Aquela Mesmo, 33 - Jardim das Rosas, Presidente Prudente",
                "19331-156", "sah.oliver@unesp.br", "A", "227777777",
                "11/05/2025", true);
        */
        
        
    }
    
}
