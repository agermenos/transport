package com.sleepsoft.transport.pojos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sleepsoft.transport.pojos.enums.CatalogType;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "type_catalogs", schema = "public", catalog = "transport")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "@id")
public class TypeCatalogsPOJO extends BaseEntity{
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="parent_id")
    TypeCatalogsPOJO parent;

    @OneToMany(mappedBy = "parent")
    @Fetch(FetchMode.JOIN)
    private Set<TypeCatalogsPOJO> children;

    public void setType(CatalogType catalogType){
        this.type=catalogType.definition();
    }

    public void setType(String type){
        this.type=type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TypeCatalogsPOJO that = (TypeCatalogsPOJO) o;
        return Objects.equals(getId(), that.getId()) || Objects.equals(type, that.type);
    }

    @Override
    public String toString() {
        return "TypeCatalogsPOJO{" +
                "id='" + getId() + '\'' +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), type);
    }
}
