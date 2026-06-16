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


    @Column(name = "n_max_partecipanti")
    private Integer numeroMassimoPartecipanti;


// creiamo un construttore vuoto INDISPENSABILE

    public Evento() {

    }

    // creiamo il costruttore

    public Evento(String titolo, LocalDate dataEvento,
                  String descrizione, TipoEvento tipoEvento,
                  Integer numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    //get e set


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Long getId() {
        return id;
    }

    public Integer getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }


    @Override
    public String toString() {
        return "Evento{ \n" +
                "id=" + id + "\n" +
                "titolo='" + titolo + '\'' + "\n" +
                " dataEvento=" + dataEvento + "\n" +
                "descrizione='" + descrizione + '\'' + "\n" +
                "tipoEvento=" + tipoEvento + "\n" +
                "numeroMassimoPartecipanti=" + numeroMassimoPartecipanti + "\n" +
                "}\n";
    }
}