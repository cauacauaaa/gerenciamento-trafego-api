package br.com.fiap.GerenciamentoTrafego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_fluxos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Fluxo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_FLUXOS"
    )
    @SequenceGenerator(
            name = "SEQ_FLUXOS",
            sequenceName = "SEQ_FLUXOS",
            allocationSize = 1
    )
    @Column(name = "fluxos_id")
    private Long fluxoId;

    @Column(name = "qtd_veiculos")
    private int quantidadeVeiculos;

    @Column(name = "v_media")
    private double velocidadeMedia;

    public Long getFluxoId() {
        return fluxoId;
    }

    public void setFluxoId(Long fluxoId) {
        this.fluxoId = fluxoId;
    }

    public int getQuantidadeVeiculos() {
        return quantidadeVeiculos;
    }

    public void setQuantidadeVeiculos(int quantidadeVeiculos) {
        this.quantidadeVeiculos = quantidadeVeiculos;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }
}
