/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/



import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {
    private static final String FILE_NAME = "expenses.txt";

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }
            output = new PrintWriter(new FileWriter(FILE_NAME, true));
            for (Transaction transaction : transactions) {
                output.println(transaction.getDate() + "," + transaction.getDescription() + "," + transaction.getAmount());
            }
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactionList = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return transactionList;
        }
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(",");
            String date = parts[0];
            String description = parts[1];
            double amount = Double.parseDouble(parts[2]);
            Transaction transaction = new Transaction(date, description, amount);
            transactionList.add(transaction);
        }
        input.close();
        return transactionList;
    }
}
