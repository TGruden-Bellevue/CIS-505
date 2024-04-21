/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/



import java.util.List;

public interface GenericDao<T, ID> {
    //Retrieve entities
    List<T> findAll();
    //find by ID 
    T findBy(ID id);
    //insert new entity 
    void insert(T entity);
}
