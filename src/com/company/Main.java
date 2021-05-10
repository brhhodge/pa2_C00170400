// Brian Hodge
// C00170400
// CMPS 260
// Programming Assignment: #2
// Due Date: 2/10/19 at 11:55pm
// Program Description: The program repeatedly presents a menu to the user to select between calling the method to
//                      compute quadratic roots, the method to sum the integers, the method to calculate the simple
//                      number series or to exit the program.
// Certificate of Authenticity: I certify that the code in the method function main of thi project is entirely my own
//                              work.

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);      // A reference variable "input" to read the input from the user is
        int selection;                               // defined.
        nameAndId();                                 // The method to output my name and ULID is called.

        do {                                                            // do-while loop that prompts a menu with 4
            System.out.print("0-Exit, 1-Quadratic, 2-Sum, 3-Series: "); // choices for the user to choose which method
            selection = input.nextInt();                                // to execute; the loop continues until the user
                                                                        // inputs a "0"
            if (selection == 1) {                                           // When the user inputs a "1", the condition
                System.out.print("Enter a, b and c separated by spaces: "); // prompts the user to enter 3 numbers for
                double a = input.nextInt();                                 // the 3 variables needed in the quadratic
                double b = input.nextInt();                                 // formula method
                double c = input.nextInt();
                quadratic(a,b,c);                      // calls the quadratic method
            }
            else if (selection == 2) {                                        // When the user inputs a "2", the
                System.out.print("Enter two integers separated by spaces: "); // condition prompts the user to enter 2
                int a = input.nextInt();                                      // numbers for the 2 variables needed in
                int b = input.nextInt();                                      // the sumBetweenInts method
                System.out.println("Sum: " + sumBetweenInts(a,b)); // calls the sumBetweenInts method and prints the
                System.out.println();                              // string "Sum: " and the result of the called method
            }
            else if (selection == 3) {                                  // When the user inputs a "3", the condition
                System.out.print("Enter a integer value for i: ");      // prompts the user to enter a number for the
                int i = input.nextInt();                                // variable needed in the simpleNumSeries method
                System.out.println("Sum: " + simpleNumSeries(i)); // calls the simpleNumSeries method and prints the
                System.out.println();                             // string "Sum: " plus the result of the called method
            }

        } while (selection != 0);                        // When the user inputs a "0", the condition to exit the loop
        System.out.println();                            // is executed.
        System.out.println("Bye!");                      // The do-while loop ends and the string "Bye!" is printed
    }

    public static void nameAndId() {
        System.out.println();                              // void method that receives nothing and returns nothing
        System.out.println("Name: " + "Brian Hodge");      // When called, the method prints out a blank line, followed
        System.out.println("ULID: " + "C00170400");        // by a new line with my name, followed by a new line with my
        System.out.println();                              // ULID number followed by a blank new line
    }

    public static void quadratic(double a, double b, double c) {      // void method that receives three double values
        double discriminant = ((b * b) - (4 * a * c));                // from the user's input when prompted (in main)
        double r1 = (( - b + Math.sqrt(discriminant)) / 2 * a);
        double r2 = (( - b - Math.sqrt(discriminant)) / 2 * a);

        if (discriminant > 0) {                                       // If the discriminant is positive, the method
            System.out.println("There are two real roots:");          // outputs two roots
            System.out.println(r1);
            System.out.println(r2);
            System.out.println();
        }
        else if(discriminant == 0) {                                  // If the discriminant is equal to 0, the method
            System.out.println("There is one real root: " + r1);      // outputs one root
            System.out.println();
        }
        else {                                                        // If the discriminant is negative, the method
            System.out.println("The equation has no real roots");     // outputs the string "The equation has no real
            System.out.println();                                     // roots
        }
    }

    public static int sumBetweenInts(int a, int b) {                  // sumBetweenInts method that receives 2 integer
        int sum = 0;                                                  // variables and returns the sum of the 2
        int smallest;                                                 // integers from the smallest parameter value to
        int largest = Math.max(a, b);                                 // the largest parameter value

        for (smallest = Math.min(a, b); smallest <= largest; smallest++) {
            sum = sum + smallest;
    }
        return sum;
    }

    public static double simpleNumSeries(int i) {                     // simpleNumSeries method that receives 1 double
        double sum = 0;                                               // parameter(i) and uses a while loop to compute
                                                                      // m(i) and returns the result
        if (i < 1) {              // if i is less than 1,
            sum = 0;              // the method returns 0
            return sum;
        }
        else {                               // if i is greater than or equal to 1, the method
            while (i >= 1) {                 // uses a while loop to compute m(i)
                sum += (i / (i + 1.0));      // [m(i) = 1/2 + 2/3 + ...... + i/(i + 1)]
                i--;
            }
            return sum;                      // when the while loop is finished, sum is returned m(i).
        }
    }
}
