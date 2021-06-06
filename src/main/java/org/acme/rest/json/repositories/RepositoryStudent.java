package org.acme.rest.json.repositories;

import java.util.List;
import java.util.Optional;

import org.acme.rest.json.entities.Student;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

public class RepositoryStudent implements PanacheRepository<Student> {

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