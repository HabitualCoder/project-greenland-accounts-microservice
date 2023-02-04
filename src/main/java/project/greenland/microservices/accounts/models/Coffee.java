package project.greenland.microservices.accounts.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Coffee {
    @Id
    private String id;
    private String name;

    public Coffee() {}

    public Coffee(String id, String name) {
        this.id=id;
        this.name=name;
    }

    public Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    public void setId(String id) {
        this.id=id;
    }
}
