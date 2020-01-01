package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "pr001_data")
@Data
public class PR001DInfo implements Serializable {
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

    @Column(name = "trn_dt")
    private String trnDt;

    @Column(name = "trn_tm")
    private String trnTm;

    @Column(name = "msg_no")
    private String msgNo;

    @Column(name = "wdr_acno")
    private String wdracNo;

    @Column(name = "wdr_vir_acno")
    private String wdrViracNo;

    @Column(name = "rcv_acno")
    private String rcvacNo;

    @Column(name = "rcv_vir_acno")
    private String rcvViracNo;

    @Column(name = "rcv_acdppe_nm")
    private String rcvacDppeNm;

    @Column(name = "cur_cd")
    private String curCd;

    @Column(name = "wdr_am")
    private BigDecimal wdrAm;

    @Column(name = "to_bk_dscd")
    private String tobkDscd;

    @Column(name = "ist_dscd")
    private String istDscd;

    @Column(name = "incd_acc_gb")
    private String inCdAccGb;

    @Column(name = "rcv_bk1_cd")
    private String rcvbk1Cd;

    @Column(name = "rcv_bk2_cd")
    private String rcvbk2Cd;

    @Column(name = "regmod_cd")
    private String regModCd;

    @Column(name = "trn_stat")
    private String trnStat;
}
