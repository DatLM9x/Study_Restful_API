package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pr001_sum")
@Data
public class PR001EInfo implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fbkname")
    private String fbkname;

    @Column(name = "msgdscd")
    private String msgdscd;

    @Column(name = "nor_tran_cnt")
    private Integer norTranCnt;

    @Column(name = "nor_tran_to_amt")
    private Integer norTranTotAmt;

    @Column(name = "can_tran_cnt")
    private Integer canTranCnt;

    @Column(name = "can_tran_to_amt")
    private Integer canTranTotAmt;

    @Column(name = "proc_tran_to_cnt")
    private Integer procTranTotCnt;

    @Column(name = "proc_tran_to_amt")
    private Integer procTransTotAmt;

}
