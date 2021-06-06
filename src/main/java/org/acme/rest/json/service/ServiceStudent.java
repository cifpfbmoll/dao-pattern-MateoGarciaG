package org.acme.rest.json.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.rest.json.entities.Student;
import org.acme.rest.json.repositories.RepositoryStudent;




@ApplicationScoped
public class ServiceStudent {

    @Inject
    RepositoryStudent repo;
    
    public ServiceStudent() {}

    public Set<Student> setStudents() {

        return repo.allStudents();
    }

    public List<Student> studentsOrderByName() {
        return repo.listAllOrderedByName();
    }

    public void add(Student student) {

        // Like it was said in RepoStudent, in this layer we can call directly the method persist() or other from Panache to manage the Entity inside the Persistence Context. But with the use of a REPOSITORY we need to insert in the parameter of Panache methods the Entity which is affect by the panache method
        repo.persist(student);
    }

    public void remove(String name) {

        repo.deleteByName(name);

    }

    public Optional<Student> getStudentByName(String name) {
        
        return name.isBlank() ? Optional.ofNullable(null) : repo.findByNameOptional(name);
    }

    /* 
    https://stackoverflow.com/questions/797834/should-a-restful-put-operation-return-something
    */

    public Optional<Student> updateStudent(Student newStudent) {
        
        Optional<Student> studentOptional = repo.find("name", newStudent.getName()).firstResultOptional();

        if(studentOptional.isPresent()) {
            Student student = studentOptional.get();
            student.setSurname(newStudent.getSurname());
            student.setDateBirth(newStudent.getDateBirth());
            student.setPhone(newStudent.getPhone());

            // We need to put in the parameter the Entity updated to persist it
            repo.persist(student);

        } else {
            return Optional.ofNullable(null);
        }

        return studentOptional;
    }


}
