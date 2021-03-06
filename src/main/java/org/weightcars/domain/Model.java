package org.weightcars.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;

/**
 * A Model.
 */
@Entity
@Table(name = "model")
public class Model implements Serializable, Comparable<Model> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JsonIgnoreProperties("")
    private Brand manufacturer;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Model name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getManufacturer() {
        return manufacturer;
    }

    public Model manufacturer(Brand manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }

    public void setManufacturer(Brand manufacturer) {
        this.manufacturer = manufacturer;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Model model = (Model) o;
        if (model.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), model.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Model{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }

    @Override
    public int compareTo(Model other) {
        int result;
        if (other == null) {
            result = -1; // null first
        } else {
            result = this.getManufacturer().compareTo(other.getManufacturer());
            if (result == 0) {
                result = StringUtils.compareIgnoreCase(this.getName(), other.getName());
            }
        }
        return result;
    }
}
