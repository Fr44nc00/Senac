package idade;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Idade {

    public static void main(String[] args) {
        
        Calendar cal = GregorianCalendar.getInstance();

        int anoAtual = cal.get(Calendar.YEAR);
       
        int anoNasc = 1991;
        
        int idade = anoAtual - anoNasc;
        
        System.out.println("Você tem: " + idade);
    }

}
