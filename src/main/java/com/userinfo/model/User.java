package com.userinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_tbl")
@Getter
@Setter
public class User extends BaseEntity implements Serializable {
   private static final long serialVersionUID = 1L;
   private String name;
   private boolean agreedToTerms;
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
           name = "user_sectors",
           joinColumns = @JoinColumn(name = "user_id"),
           inverseJoinColumns = @JoinColumn(name = "sector_id")
   )
   private Set<Sector> sectors;
}
