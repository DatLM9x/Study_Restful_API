package gateway.wrb.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "er001")
@Data
public class ER001Info implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long er001id;

    @Column(name = "fbkname")
    private String fbkname;

    @Column(name = "msgdscd")
    private String msgdscd;

    @Column(name = "notice_dt")
    private String noticeDt;

    @Column(name = "notice_cnt")
    private Integer noticeCnt;

    @Column(name = "from_ccy")
    private String fromCcy;

    @Column(name = "to_ccy")
    private String toCcy;

    @Column(name = "base_rate")
    private BigDecimal baseRate;

    @Column(name = "cash_buying")
    private BigDecimal cashBuying;

    @Column(name = "cash_selling")
    private BigDecimal cashSelling;

    @Column(name = "tt_buying")
    private BigDecimal ttBuying;

    @Column(name = "tt_selling")
    private BigDecimal ttSelling;

    @Column(name = "order_dscd")
    private String orderDscd;

    @Column(name = "status")
    private String status;

    @Column(name = "filler")
    private String filler;
}
