package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "rv002")
@Data
public class RV002Info implements Serializable {
    @Id
    @GeneratedValue
    private Long rv002id;

    private String fbkname;
    private String msgdscd;
    private String outactno;
    private String viractno;
    private String viracnm;
    private String refno;
    private String reccodcd;
    private String trnam;
    private String trnavlsdt;
    private String trnavledt;
    private String trnavlstm;
    private String trnavletm;
    private String trnavlyn;
    private String corpreccompcode;
    private String filter;

    private String msgdscde;
    private String totcnte;
    private String totreqcnte;
    private String totreqamte;
    private String fillere;
}