package br.com.fiap.GerenciamentoTrafego.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_semaforos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Semaforo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_SEMAFOROS"
    )
    @SequenceGenerator(
            name = "SEQ_SEMAFOROS",
            sequenceName = "SEQ_SEMAFOROS",
            allocationSize = 1
    )
    @Column(name = "semaforo_id")
    private Long semaforoId;
    private String estado;
    private int duracao;
    private String lugar;
    private boolean funcionando;


    public Long getSemaforoId() {
        return semaforoId;
    }

    public void setSemaforoId(Long semaforoId) {
        this.semaforoId = semaforoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public boolean isFuncionando() {
        return funcionando;
    }

    public void setFuncionando(boolean funcionando) {
        this.funcionando = funcionando;
    }
}
