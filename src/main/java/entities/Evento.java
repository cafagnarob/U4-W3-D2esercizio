package entities;

import Enum.TipoEvento;
import jakarta.persistence.*;

import java.time.LocalDate;

// dichiariamo che questa classe sarà un Entity, questo è l'inizio per creare la
// struttura della tabella.
@Entity
// dichiariamo la tabella e ne cambiamo il nome
@Table(name = "eventi")
public class Evento {
    // dichiarimao che il seguente attributo sarà un attributo unico per ogni evento
    @Id
    // dichiariamo che sarà il server a generare un valore per questo attributo
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titolo;

    // possiamo dichiarare gli altri attributi come colonne della tabella e anche
    // dare un nome specifico o anche altre info come nullable=false (= not null)

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;


    @Column(nullable = false)
    private String descrizione;

    @Column(name = "tipo_evento", nullable = false)
    // di solito JAP considera gli enum di tipo integer quindi dobbiamo utilizzarte
    // @Enumerated(EnumType.STRING) per dirgli di considerarlo con il valore di stringa
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    private Integer numeroMassimoPartecipanti;
}
