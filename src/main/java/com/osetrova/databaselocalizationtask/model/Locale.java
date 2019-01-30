package com.osetrova.databaselocalizationtask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"attributeTranslations", "itemTranslations"})
@EqualsAndHashCode(
        exclude = {
                "type",
                "attributeTranslations",
                "itemTranslations"
        })
@Data
@Entity
@Table(name = "locale", schema = "product_storage")
public class Locale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name", unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LocaleType type;

    @OneToMany(mappedBy = "locale")
    private Set<AttributeTranslation> attributeTranslations;

    @OneToMany(mappedBy = "locale")
    private Set<ItemTranslation> itemTranslations;
}