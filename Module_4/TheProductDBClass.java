/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/

 
// Class representing the bowling shop's database
// TheProductDBClass.java

public class TheProductDBClass {
    public static TheGenericQueueClass<ProductClass> getProducts(String code) {
        TheGenericQueueClass<ProductClass> products = new TheGenericQueueClass<>();
          // Bowling Balls 
        if (code.equals("b")) {
            products.enqueue(createBall("B500", "Phase III", 154.99, "Purple and Green"));
            products.enqueue(createBall("B400", "Force Unleashed", 139.99, "Red and Green"));
            products.enqueue(createBall("B300", "Proton Physix", 174.95, "Pink and Purple"));
            products.enqueue(createBall("B500", "Phase III", 154.99, "Purple and Green"));
            products.enqueue(createBall("B200", "Axiom Pearl", 154.95, "Blue and Red"));
            products.enqueue(createBall("B100", "Black Widow 2.0", 144.95, "Black and Red"));
            //Shoes 
        } else if (code.equals("s")) {
            products.enqueue(createShoe("S500", "Youth Skull Green/Black", 39.99, 3.0));
            products.enqueue(createShoe("S400", "Men's Tribal White", 26.99, 8.5));
            products.enqueue(createShoe("S300", "Women's Path Lite Seamless Mesh", 54.99, 6.0));
            products.enqueue(createShoe("S200", "Women's Rise Black/Hot Pink", 39.99, 7.0));
            products.enqueue(createShoe("S100", "Men's Ram Black", 39.99, 10.5));
        } else if (code.equals("a")) {
            //Bags 
            products.enqueue(createBag("A300", "Silver/Royal Blue", 74.99, "Triple"));
            products.enqueue(createBag("A200", "Prime Roller Black/Royal Blue", 54.99, "Double"));
            products.enqueue(createBag("A100", "Path Pro Deluxe", 34.99, "Single"));
        }

        return products;
    }
        // Bowling Ball 
    private static TheBallClass createBall(String code, String description, double price, String color) {
        TheBallClass ball = new TheBallClass();
        ball.setCode(code);
        ball.setDescription(description);
        ball.setPrice(price);
        ball.setColor(color);
        return ball;
    }
    // Shoe 
    private static TheShoeClass createShoe(String code, String description, double price, double size) {
        TheShoeClass shoe = new TheShoeClass();
        shoe.setCode(code);
        shoe.setDescription(description);
        shoe.setPrice(price);
        shoe.setSize(size);
        return shoe;
    }
    // Bowling Bags 
    private static TheBagClass createBag(String code, String description, double price, String type) {
        TheBagClass bag = new TheBagClass();
        bag.setCode(code);
        bag.setDescription(description);
        bag.setPrice(price);
        bag.setType(type);
        return bag;
    }
}
