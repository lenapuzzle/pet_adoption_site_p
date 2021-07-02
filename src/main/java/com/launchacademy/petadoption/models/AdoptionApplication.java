package com.launchacademy.petadoption.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "adoption_applications")
public class AdoptionApplication {
  @Id
  @SequenceGenerator(name="adoption_application_generator", sequenceName="adoption_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="adoption_application_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotBlank
  @NotNull
  @Column
  private String name;

  @NotNull
  @Column
  private String phoneNumber;

  @Email
  @NotBlank
  @NotNull
  @Column
  private String email;

  @NotNull
  @Column
  private String homeStatus;

  @Column
  private String applicationStatus;

  @ManyToOne
  @JoinColumn(name = "pet_id", nullable = false)
  @JsonIgnoreProperties("adoptionApp")
  private Pet pet;
}
