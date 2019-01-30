package com.osetrova.databaselocalizationtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"translations", "items"})
@EqualsAndHashCode(
        exclude = {
                "name",
                "translations",
                "items"
        })
@Table(name = "attribute", schema = "product_storage")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "default_name", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL)
    private Set<AttributeTranslation> translations;

    @ManyToMany
    @JoinTable(name = "item_attribute", schema = "product_storage",
            joinColumns = @JoinColumn(name = "attribute_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;
}
