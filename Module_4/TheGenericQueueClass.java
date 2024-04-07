
/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/

 
// Generic class representing a queue data structure
// TheGenericQueueClass.java
import java.util.LinkedList;

public class TheGenericQueueClass<T> {
    private LinkedList<T> list;

    public TheGenericQueueClass() {
        list = new LinkedList<>();
    }

    public void enqueue(T item) {
        list.addLast(item);
    }

    public T dequeue() {
        return list.removeFirst();
    }

    public int size() {
        return list.size();
    }
}
