package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "vlr001")
@Data
public class VLR001Info implements Serializable {

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

    @Column(name = "vir_act_no")
    private String virActNo;

    @Column(name = "apl_dscd")
    private String aplDscd;

    @Column(name = "vr_act_cus_nm")
    private String vractCusNm;

    @Column(name = "trn_am")
    private BigDecimal trnAm;

    @Column(name = "ir_trn_yn")
    private String irTrnYn;

    @Column(name = "lmt_am_ov_yn")
    private String lmtAmOvYn;

    @Column(name = "lmt_am_blw_yn")
    private String lmtAmBlwYn;

    @Column(name = "dup_rcv_prhb_yn")
    private String dupRcvPrhbYn;

    @Column(name = "mo_ac_rv_avl_yn")
    private String moacrvAvlYn;

    @Column(name = "trn_avl_sdt")
    private String trnAvlSdt;

    @Column(name = "trn_avl_edt")
    private String trnAvlEdt;

    @Column(name = "trn_avl_stm")
    private String trnAvlStm;

    @Column(name = "trn_avl_etm")
    private String trnAvlEtm;

    @Column(name = "rgs_trn_dt")
    private String rgsTrnDt;

    @Column(name = "doc_no")
    private String docNo;

    @Column(name = "sts_dscd")
    private String stsDscd;

    @Column(name = "filler")
    private String filler;

    @Column(name = "line_flag")
    private String lineFlag;

}
