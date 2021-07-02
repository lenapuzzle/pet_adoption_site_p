package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "pets")
public class Pet {
  @Id
  @SequenceGenerator(name="pet_generator", sequenceName="pets_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @NotNull
  @Column
  private String name;

  @URL
  @NotNull
  @Column
  private String imgUrl;

  @Column
  private Integer age;

  @Column
  private Boolean vaccinationStatus;

  @Column
  private String adoptionStory;

  @Column
  private Boolean availableForAdoption = true;

  @Column(name="pet_type_id", nullable=false, insertable = false, updatable = false)
  private Integer petTypeId;

  @ManyToOne
  @JoinColumn(name = "pet_type_id", nullable = false)
  @JsonIgnoreProperties("pets")
  private PetType petType;

  @OneToMany(mappedBy = "pet")
  @JsonIgnoreProperties("pet")
  private List<AdoptionApplication> adoptionApp = new ArrayList<>();
}