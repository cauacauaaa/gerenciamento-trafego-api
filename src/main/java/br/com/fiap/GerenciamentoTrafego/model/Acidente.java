package br.com.fiap.GerenciamentoTrafego.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tbl_acidentes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Acidente {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ACIDENTES"
    )
    @SequenceGenerator(
            name = "SEQ_ACIDENTES",
            sequenceName = "SEQ_ACIDENTES",
            allocationSize = 1
    )
    @Column(name = "acidente_id")
    private Long acidenteId;
    private String descricao;
    private String severidade;
    private LocalDate dia;
    private String lugar;


    public Long getAcidenteId() {
        return acidenteId;
    }

    public void setAcidenteId(Long acidenteId) {
        this.acidenteId = acidenteId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSeveridade() {
        return severidade;
    }

    public void setSeveridade(String severidade) {
        this.severidade = severidade;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
}
