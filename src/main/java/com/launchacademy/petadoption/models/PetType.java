package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "pet_types")
public class PetType {
  @Id
  @SequenceGenerator(name="pet_type_generator", sequenceName="pet_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="pet_type_generator")
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
  private String description;

  @OneToMany(mappedBy = "petType")
  @JsonIgnoreProperties("petType")
  private List<Pet> pets = new ArrayList<>();
}
