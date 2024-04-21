/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/


// Store Composer Data
public class Composer {
    private int id;
    private String name;
    private String genre;

    public Composer() {
        this.id = 0;
        this.name = "";
        this.genre = "";
    }

    public Composer(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }
//Composer's ID 
    public int getId() {
        return id;
    }
// Composer's Name 
    public String getName() {
        return name;
    }
//Composer's Genre
    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nName: " + name + "\nGenre: " + genre;
    }
}
