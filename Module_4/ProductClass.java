/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/



// ProductClass.java
 
// Class representing a product in the bowling shop
public class ProductClass {
    private String code;
    private String description;
    private double price;
    // all products share code, description, and price 
    public ProductClass() {
        this.code = "";
        this.description = "";
        this.price = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product code: " + code + "\nDescription: " + description + "\nPrice: $" + String.format("%.2f", price);
    }
}
