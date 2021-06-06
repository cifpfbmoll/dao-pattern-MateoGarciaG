package org.acme.rest.json.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import org.acme.rest.json.entities.Student;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

@ApplicationScoped
public class RepositoryStudent implements PanacheRepository<Student> {

    // There is not need to create a method to call panache methods because Repository Student implements PanacheRepository already have this methods lika persist() which can be used and called directly in the layer Service

    // It's also not neccesary called the constructor to let this class become a CDI because PanacheRepository will be managed.

    public Set<Student> allStudents() {
        Stream<Student> studentStream = this.streamAll();

        return studentStream.collect(Collectors.toSet());
    }

    public List<Student> listAllOrderedByName() {
        return this.listAll(Sort.by("name").ascending());
    }

    public Optional<Student> findByNameOptional(String name) {
        return this.find("name", name).firstResultOptional();
    }

    public void deleteByName(String name) {
        Optional<Student> student = this.findByNameOptional(name);
        if (student.isPresent()) {
            this.delete(student.get());
        }
    }

}