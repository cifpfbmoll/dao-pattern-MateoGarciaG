package org.acme.rest.json.service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;


import org.acme.rest.json.entities.Student;


@ApplicationScoped
public class ServiceStudent {
    
    public ServiceStudent() {}

    public Set<Student> setStudents() {

        Stream<Student> studentStream = Student.streamAll();

        return studentStream.collect(Collectors.toSet());
    }

    public void add(Student student) {

        student.persist();
    }

    public void remove(String name) {

        Student student = Student.find("name", name).firstResult();

        student.delete();

    }

    public Optional<Student> getStudentByName(String name) {
        
        return name.isBlank() ? Optional.ofNullable(null) : Student.find("name", name).firstResultOptional();
    }

    /* 
    https://stackoverflow.com/questions/797834/should-a-restful-put-operation-return-something
    */

    public Optional<Student> updateStudent(Student newStudent) {
        
        Optional<Student> studentOptional = Student.find("name", newStudent.getName()).firstResultOptional();

        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setSurname(newStudent.getSurname());
            student.setDateBirth(newStudent.getDateBirth());
            student.setPhone(newStudent.getPhone());

            student.persist();

        } else {
            return Optional.ofNullable(null);
        }

        return studentOptional;
    }


}
