package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private List<Student> studentList = new ArrayList<>();

    public StudentServiceImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentServiceImpl() {
        studentList = new ArrayList<>();
        studentList.add(new Student(1, "khanh1", 5, 1, 1));
        studentList.add(new Student(2, "khanh2", 6, 1, 1));
        studentList.add(new Student(3, "khanh3", 1, 1, 1));
        studentList.add(new Student(4, "khanh4", 9, 1, 1));
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);

    }

    @Override
    public Student findById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public int findIndexById(int id) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void update(int id, Student student) {
        int update = findIndexById(id);
        studentList.set(update, student);

    }

    @Override
    public void delete(int id) {
        int delete = findIndexById(id);
        studentList.remove(delete);
    }
}
