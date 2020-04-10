package repositories;

import java.io.Serializable;
import daos.DAOObjImpl;
import model.Student;
import model.StudentList;

public class Repository implements iRepository, Serializable {

    private StudentList items;

    public Repository() {
        this.items = new StudentList();
    }

    public Repository(StudentList items) {
        this.items = items;
    }

    public Repository(String filename) {
        this();
        DAOObjImpl dao = new DAOObjImpl();
        this.items = dao.load(filename).getItems();
    }

    @Override
    public StudentList getItems() {
        return this.items;
    }

    @Override
    public void setItems(StudentList items) {
        this.items = items;
    }

    @Override
    public void add(Student item) {
        this.items.addStudent(item);
    }

//    @Override
    public void remove(Student item) {
        this.items.removeStudent(item);
    }

//    @Override
//    public Student getItem(int id) {
//        for (Student item: this.items) {
//            if (item.getId() == id)
//                return item;
//        }
//        return null;
//    }

    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }

    @Override
    public void store(String filename) {
        DAOObjImpl dao = new DAOObjImpl();
        dao.store(filename, this);
    }
}