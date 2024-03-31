/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/




// CustomerDB class
class CustomerDB {
    public static Customer getCustomer(Integer id) {
        if (id == 1007) {
            return new Customer("Annabeth Chase", "123 Main St", "Orlando", "12345");
        } else if (id == 1008) {
            return new Customer("Percy Jackson", "456 Oak Ave", "Tampa", "54321");
        } else if (id == 1009) {
            return new Customer("Nico Johnson", "789 Elm Rd", "HadesTown", "67890");
        } else {
            return new Customer(); // Default customer
        }
    }
}
