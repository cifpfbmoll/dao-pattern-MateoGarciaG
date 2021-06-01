package org.acme.rest.json.entities;

import io.quarkus.runtime.annotations.RegisterForReflection;
/* @RegisterForReflection, permite que Legume 
pueda ser procesado por la reflection de Java mediante Jackson,
tuvimos que colocarlo explicitamente debido a que
en el LegumeResource, Quarkus no pudo determinar que Legume necesitaba Reflection para poder ser serializada por Jackson y por eso en el Ejecutable Runner Nativo
La lista aparecía vacía, por lo cual mediante está etiqueta estamos indicandle a Quarkus que explicitamente haga la Reflection sobre los Objetos Legume y así Jackson poder hacer su trabajo de serialización
*/
@RegisterForReflection
public class Legume {

    public String name;
    public String description;

    public Legume() {
    }

    public Legume(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
