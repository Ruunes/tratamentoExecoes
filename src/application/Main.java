/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;

/**
 *
 * @author Ruan
 */
public class Main {
    
    public static void main(String[] args) throws ParseException{
        
        Scanner ler = new Scanner(System.in);        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
        System.out.print("Room Number: ");
        int number = ler.nextInt();
        
        System.out.print("Check-in Date (dd/MM/yyyyy): ");
        Date checkIn = sdf.parse(ler.next());
        
        System.out.print("Check-Out Date (dd/MM/yyyyy): ");
        Date checkOut = sdf.parse(ler.next());
        
        
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be"
                    + " after check-in date");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation"+reservation);
            System.out.println("");
            
            System.out.println("Enter data to update the Reservation: ");
            System.out.print("Check-in Date (dd/MM/yyyyy): ");
            checkIn = sdf.parse(ler.next());
        
            System.out.print("Check-Out Date (dd/MM/yyyyy): ");
            checkOut = sdf.parse(ler.next());
            
            String error = reservation.updateDates(checkIn, checkOut);
            
            if (error != null) {
                System.out.println("Error in reservation: "+ error);
            }else{
                System.out.println("Reservation: "+reservation);
            }
                     
        }
     
    }
}
