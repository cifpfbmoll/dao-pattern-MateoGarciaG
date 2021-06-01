package org.acme.rest.json.entities;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="Fruit")
@JsonPropertyOrder({"name", "description"})
public class Fruit extends PanacheEntity{

    /*
    * Las propiedades/atributos deben ser public para que Jackson pueda acceder a ellas mediante Reflection y podeer realizar la serialización o deserialización donde Quarkus los hace PUBLIC
    * */

    @NotEmpty
    @NotBlank
    @Column(unique = true, name="name")
    public String name;

    @NotEmpty
    @NotBlank
    @Column(name="description")
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}