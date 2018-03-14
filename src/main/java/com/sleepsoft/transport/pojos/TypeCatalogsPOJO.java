package com.sleepsoft.transport.pojos;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sleepsoft.transport.pojos.enums.CatalogType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

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
        TypeCatalogsPOJO that = (TypeCatalogsPOJO) o;
        if (that.getType().equals(this.getType())) {
            if (this.getParent()!=null && that.getParent()!=null) {
                return (this.getParent().equals(that.getParent()));
            }
            return true;
        }
        else return false;
    }

    @Override
    public String toString() {
        return "TypeCatalogsPOJO{" +
                "id='" + this.getId() + '\'' +
                "type='" + type + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId()) + super.hashCode();
    }

    public String getType() {
        return type;
    }

    public TypeCatalogsPOJO getParent() {
        return parent;
    }

    public void setParent(TypeCatalogsPOJO parent) {
        this.parent = parent;
    }

    public Set<TypeCatalogsPOJO> getChildren() {
        return children;
    }

    public void setChildren(Set<TypeCatalogsPOJO> children) {
        this.children = children;
    }

    @Override
    public boolean isEmpty() {
        return this.parent==null &&
                this.type==null;
    }
}
