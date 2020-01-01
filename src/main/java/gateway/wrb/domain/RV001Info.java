package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rv001")
@Data
public class RV001Info implements Serializable {
    @Id
    @GeneratedValue
    private Long rv001id;

    private String fbkname;
    private String msgdscd;
    private String trndt;
    private String trntm;
    private String msgno;
    private String wdracno;
    private String wdrviracno;
    private String rcvacno;
    private String rcvviracno;
    private String rcvacdppenm;
    private String curcd;
    private String wdram;
    private String tobkdscd;
    private String istdscd;
    private String incdaccgb;
    private String rcvbk1cd;
    private String rcvbk2cd;
    private String regmodcd;
    private String trnstat;
    private String trnsrno;
    private String refno;
    private String vractcusnm;
    private String stsdscd;
    private String msgdscde;
    private String nortrancnte;
    private String nortrantotamte;
    private String orgcantrancnte;
    private String orgcantrantotamte;
    private String cantrancnte;
    private String cantrantotamte;
}