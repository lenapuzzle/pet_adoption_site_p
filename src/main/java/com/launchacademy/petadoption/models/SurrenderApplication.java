package com.launchacademy.petadoption.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "surrender_applications")
public class SurrenderApplication {
  @Id
  @SequenceGenerator(name="surrender_application_generator", sequenceName="surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="surrender_application_generator")
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
  @NotNull
  @Column
  private String email;

  @Column
  private String applicationStatus;
}

