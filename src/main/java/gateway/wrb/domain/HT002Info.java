package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ht002")
@Data
public class HT002Info implements Serializable {
    @Id
    @GeneratedValue
    private Long ht002id;

    private String fbkname;
    private String msgdscd;
    private String actno;
    private String trndt;
    private String trntm;
    private String drcr;
    private String trnamt;
    private String trnafbl;
    private String brcd;
    private String chkamt;
    private String trntype;
    private String particular;
    private String depseq;
    private String status;
    private String channeltype;
    private String trnsrno;
    private String destaccount;
    private String recievename;
    private String reftxt;
    private String deprmk;
    private String trmprcsrno;
    private String viractno;
    private String msgdscde;
    private String totcnte;
}