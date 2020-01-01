package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RA001Config {
    /* START */
    @Value("${ra001.length.tmsDt}")
    private Integer tmsDtLength;

    @Value("${ra001.length.tmsTm}")
    private Integer tmsTmLength;

    @Value("${ra001.length.coNo}")
    private Integer coNoLength;

    @Value("${ra001.length.ActNo}")
    private Integer actNoLength;

    @Value("${ra001.length.dataCnt}")
    private Integer dataCntLength;

    @Value("${ra001.length.etcAr}")
    private Integer etcLength;

    /* DATA */
    @Value("${ra001.length.msgDscd}")
    private Integer msgDscdLength;

    @Value("${ra001.length.wdrActNo}")
    private Integer wdrActNoLength;

    @Value("${ra001.length.aplDscd}")
    private Integer aplDscdLength;

    @Value("${ra001.length.msgTrno}")
    private Integer msgTrnoLength;

    @Value("${ra001.length.trnStDt}")
    private Integer trnStDtLength;

    @Value("${ra001.length.trnClsDt}")
    private Integer trnClsDtLength;

    @Value("${ra001.length.trnType}")
    private Integer trnTypeLength;

    @Value("${ra001.length.status}")
    private Integer statusLength;

    @Value("${ra001.length.curCd}")
    private Integer curCdLength;

    @Value("${ra001.length.rcpAm}")
    private Integer rcpAmLength;

    @Value("${ra001.length.rcpCnt}")
    private Integer rcpCntLength;

    @Value("${ra001.length.outParticular}")
    private Integer outParticularLength;

    @Value("${ra001.length.inParticular}")
    private Integer inParticularLength;

    @Value("${ra001.length.cus_id_no_cd}")
    private Integer cusIdNoCdLength;

    @Value("${ra001.length.cus_id_no}")
    private Integer cusIdNoLength;

    @Value("${ra001.length.isuDt}")
    private Integer isuDtLength;

    @Value("${ra001.length.vld_edt}")
    private Integer vldEdtLength;
}
