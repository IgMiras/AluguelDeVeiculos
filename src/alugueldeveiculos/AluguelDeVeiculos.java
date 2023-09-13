/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alugueldeveiculos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.Period;

/**
 *
 * @author Windows
 */
public class AluguelDeVeiculos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalDate from = LocalDate.of(2023, 10, 9);
        LocalDate to = LocalDate.of(2023, 10, 10);

        long daysDifference = Math.abs(from.toEpochDay() - to.toEpochDay());

        System.out.println("Difference in days: " + daysDifference);
    }
    
}
