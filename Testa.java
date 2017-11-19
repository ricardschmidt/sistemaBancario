/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoSistemaBancario.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Ricardo
 */
public class Testa {
    public static void main(String[] args) throws ParseException {
        Date d = new SimpleDateFormat("dd/MM/yyyy").parse("23/05/1993");
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        System.out.println(cal.getTime()); //data atual
        cal.add(Calendar.MONTH, 1);
        System.out.println(cal.getTime()); //daqui a 1 mês

        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        formatador.format(data);
        System.out.println(formatador.format(data));
        System.out.println(formatador.format(cal.getTime()));
        
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MMM/yy");
        LocalDate data1 = LocalDate.now();
        data1 = data1.plusMonths(1);
        System.out.println(formato.format(data1));
        
        
    }
}
