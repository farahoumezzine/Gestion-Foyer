package tn.esprim.tpFoyer.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "universite")

public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @JsonProperty("nomUniversite")
    @Column(name = "nom_universite")
    private String nomUniversite;

    @JsonProperty("adresseUniversite")

    @Column(name = "adresse_universite")
    private String adresseUniversite;

    @OneToOne
    private Foyer foyer;
}
