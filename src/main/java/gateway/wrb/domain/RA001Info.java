package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ra001")
@Data
public class RA001Info implements Serializable {
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

    @Column(name = "wdr_act_no")
    private String wdrActNo;

    @Column(name = "apl_dscd")
    private String aplDscd;

    @Column(name = "msg_tr_no")
    private String msgTrno;

    @Column(name = "trn_st_dt")
    private String trnStDt;

    @Column(name = "trn_cls_dt")
    private String trnClsDt;

    @Column(name = "trn_type")
    private String trnType;

    @Column(name = "status")
    private String status;

    @Column(name = "cur_cd")
    private String curCd;

    @Column(name = "rcp_am")
    private String rcpAm;

    @Column(name = "rcp_cnt")
    private String rcpCnt;

    @Column(name = "out_particular")
    private String outParticular;

    @Column(name = "in_particular")
    private String inParticular;

    @Column(name = "cus_id_no_cd")
    private String cusIdNoCd;

    @Column(name = "cus_id_no")
    private String cusIdNo;

    @Column(name = "isu_dt")
    private String isuDt;

    @Column(name = "vld_edt")
    private String vldEdt;

}
