package com.osetrova.databaselocalizationtask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
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

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"translations", "attributes"})
@EqualsAndHashCode(
        exclude = {
                "name",
                "translations",
                "code",
                "attributes"
        })
@Builder
@Entity
@Table(name = "item", schema = "product_storage")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "default_name", unique = true, nullable = false)
    private String name;

    @Column(name = "code", unique = true)
    private Integer code;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private Set<ItemTranslation> translations;

    @ManyToMany
    @JoinTable(name = "item_attribute", schema = "product_storage",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Set<Attribute> attributes;
}