package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student createStudent (Student student) {
        return studentRepository.save(student);
    }
    public Student findStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    public Collection<Student> getAll() {
        return studentRepository.findAll();
    }
    public Collection<Student> getAllByAge(int age) {
        return getAll().stream().filter(it -> it.getAge() == age).collect(Collectors.toList());
    }
    public ArrayList<Student> findByAgeBetweenOrderByAge(int min, int max) {
        return studentRepository.findByAgeBetweenOrderByAge(min, max);
    }

    public Faculty getFacultyByStudentId(Long id) {
        return studentRepository.findById(id).map(Student::getFaculty).orElse(null);
    }
    public Collection<Student> findAllByFacultyId(Long id) {
        return studentRepository.findAllByFacultyId(id);
    }

    public int getCountOfStudents() {
        return studentRepository.getCountOfStudents();
    }
    public int getAverageAge() {
        return studentRepository.getAverageAge();
    }
    public List<Student> getFiveStudentsOrderedById() {
        return studentRepository.getFiveStudentsOrderedById();
    }
    }