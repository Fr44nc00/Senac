 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author RaquelNunes
 */
public class ListaPaciente {
   private static final List<Paciente> lista = new ArrayList<>(); 
   
   public static List<Paciente> Listar() {
       return lista;
   }
   public static void adicionar(Paciente pac){
   lista.add(pac);
   }
}
