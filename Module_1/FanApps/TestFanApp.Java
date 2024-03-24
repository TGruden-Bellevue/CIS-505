

/*
 * Citations 
 * 
 * Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved.
 * 
 * Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
Modified by R. Krasso 2021
Additional modifications by A. Student 2021
 * 
 */


public class TestFanApp {
    public static void main(String[] args) {
        //This code is the main method, which serves as the entry point for the Java program
        Fan defaultFan = new Fan();
        Fan customFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");
        //This code prints out the string representations
      System.out.println(defaultFan); 
      System.out.println(customFan); 
  }
}
