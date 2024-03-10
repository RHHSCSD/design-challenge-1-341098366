/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package designprojectone;
import java.util.*;
import java.text.*;
/***************************************************
*
*  Program: Tech Fair Cost Calculator
*  Author: Max Yang
*  Date: 07/03/2024
*  Description: calculator to calculate cost of materials needed for science fair
****************************************************/

/**************** IPO CHART ************************
*INPUT:
* number of students purchasing Arduino
* number of students purchasing Raspberry PI
* number of students purchasing VR Project
*PROCESSING:
* total number of students
* total cost of all materials
* price per students
* is there a discount?
*
*OUTPUT:
* price per student
*
************* PSEUDOCODE ************/
/*
Get number of arduino users (int)
Get number of RaspberryPI users (int)
Get number of VR users (int)
Calculate number of students (int)
If number of student >100
    Calculate Entrance Fee (double) with discount (1 constant: discounted entrance fee price) 
Else
    Calculate Entrance Fee (1 constant: regular entrance fee price)
If number of Arduino users >15
    Calculate Arduino Price (double) with discount (price for each material is a constant)
Else
    Calculate Arduino Price
If number of RaspberryPI users >15
    Calculate RaspberryPI Price (double) with discount
Else
    Calculate RaspberryPI Price
Calculate Price of VR (double)
calculate total cost (double)
calculate price per student (double)
Print price per student
*/  

/**************** TEST CASES ************************
*Test      Input                                   Desired Ouput
*        Arduino        RaspberryPI     VR
*      not an int       not an int     not an int     program crash
*           15              20          65              $67.50 per student
*           15              20          66              $65.02 per student
*           16              21          0               $60.70 per student
*           1               1           1               $65.00 per student
*           0               0           0               $0.00 per student
*           -1              -1          -1              nice try buckaroo
***************************************************/
public class DesignProjectOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   //Write Pseudocode FIRST as comments and THEN write the code
        Scanner keyboard = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.00");
  //CONSTANTS
        final double entranceFee = 50.00;
        final double entranceFeeDiscount = 47.50;
        final double arduinoPrice = 10.00;
        final double arduinoPriceDiscount = 9.00;
        final double raspberryPrice = 15.00;
        final double raspberryPriceDiscount = 12.00;
        final double vrPrice = 20.00;
  //VARIABLES
        int arduinoUsers;
        int raspberryUsers;
        int vrUsers;
        int numberOfStudents;
        double totalEntranceFee = 0;
        double totalArduinoPrice = 0;
        double totalRaspberryPrice = 0;
        double totalVrPrice;
        double totalCost;
        double pricePerStudent;
  //CODE
        System.out.println("Thank you for using the Tech Fair Cost Calculator");
//      Obtain inputs from user (number of Arduino, RaspberryPI and VR users)
        System.out.print("Please enter the number of students purchasing the Arduino Project Kit: ");
        arduinoUsers = keyboard.nextInt();
        System.out.print("Please enter the number of students purchasing the Raspberry PI Project Kit: ");
        raspberryUsers = keyboard.nextInt();
        System.out.print("Please enter the number of students purchasing the VR Project Kit: ");
        vrUsers = keyboard.nextInt();
//      2 extreme instances which will output a specific message and stop the program
//      output a message if user tries to input a negative number of users and then stops program
        if (arduinoUsers < 0 || raspberryUsers < 0 || vrUsers < 0){
            System.out.println("Nice try buddy. I ain't falling for that one");
            System.exit(0);
        }
//      output a message if user inputs all 0's and then stops program
        if (arduinoUsers == 0 && raspberryUsers == 0 && vrUsers == 0){
            System.out.println("The price per student is (wait for it...) $0. What was the point of doing this?");
            System.exit(0);
        }
//      calculate total number of students
        numberOfStudents = arduinoUsers + raspberryUsers + vrUsers;
//      check if there should be a discount for the entrance fee and apply if needed
        if (numberOfStudents > 100){
            totalEntranceFee = numberOfStudents * entranceFeeDiscount;
        }
        else if (numberOfStudents <=100){
            totalEntranceFee = numberOfStudents * entranceFee;
        }
//      check if there should be a discount on Arduino kits and apply if needed
        if (arduinoUsers > 15){
            totalArduinoPrice = arduinoPriceDiscount * arduinoUsers; 
        }
        else if (arduinoUsers <= 15){
            totalArduinoPrice = arduinoPrice * arduinoUsers;
        }
//      check if there should be a discount on RaspberryPI kits and apply if needed
        if (raspberryUsers >20){
            totalRaspberryPrice = raspberryPriceDiscount * raspberryUsers;
        }
        else if (raspberryUsers <= 20){
            totalRaspberryPrice = raspberryPrice * raspberryUsers;
        }
//      calculate price for VR kits
        totalVrPrice = vrPrice * vrUsers;
//      calculate the total price for all projects and entrance fees
        totalCost = totalEntranceFee + totalArduinoPrice + totalRaspberryPrice + totalVrPrice;
//      calculate price per student
        pricePerStudent = totalCost/numberOfStudents;
//      output price per student rounded to 2 decimal places
        System.out.println("The price per student is $" + df.format(pricePerStudent));
        
    }
    
}
    