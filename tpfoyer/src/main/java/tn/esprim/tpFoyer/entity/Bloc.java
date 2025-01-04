package tn.esprim.tpFoyer.entity;

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
public class Bloc implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    @Column(name = "nom_Bloc")
    private String nomBloc;

    @Column(name = "capacite_Bloc")
    private String capaciteBloc;

    @ManyToOne
    private Foyer foyer;

}
