
package repositories;
import model.Student;
import model.StudentList;

/**
 * @author ionawright
 */

public interface iRepository {

    void add(Student item);

//    Student getItem(int id);

    StudentList getItems();

//    void remove(int id);

    void setItems(StudentList items);

    void store(String filename);

    @Override
    String toString();

}
