package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PR001Config {

    /* START */
    @Value("${pr001.length.coNo}")
    private Integer coNoLength;

    @Value("${pr001.length.mgscd}")
    private Integer mgscdLength;

    @Value("${pr001.length.recMsgcd}")
    private Integer recMsgcdLength;

    @Value("${pr001.length.tmsDt}")
    private Integer tmsDtLength;

    @Value("${pr001.length.tmsTm}")
    private Integer tmsTmLength;

    @Value("${pr001.length.etc}")
    private Integer etcLength;

    /* DATA */
    @Value("${pr001.length.msgDscd}")
    private Integer msgDscdLength;

    @Value("${pr001.length.trnDt}")
    private Integer trnDtLength;

    @Value("${pr001.length.trnTm}")
    private Integer trnTmLength;

    @Value("${pr001.length.msgNo}")
    private Integer msgNoLength;

    @Value("${pr001.length.wdracNo}")
    private Integer wdracNoLength;

    @Value("${pr001.length.wdrViracNo}")
    private Integer wdrViracNoLength;

    @Value("${pr001.length.rcvacNo}")
    private Integer rcvacNoLength;

    @Value("${pr001.length.rcvViracNo}")
    private Integer rcvViracNoLength;

    @Value("${pr001.length.rcvacDppeNm}")
    private Integer rcvacDppeNmLength;

    @Value("${pr001.length.curCd}")
    private Integer curCdLength;

    @Value("${pr001.length.wdrAm}")
    private Integer wdrAmLength;

    @Value("${pr001.length.tobkDscd}")
    private Integer tobkDscdLength;

    @Value("${pr001.length.istDscd}")
    private Integer istDscdLength;

    @Value("${pr001.length.inCdAccGb}")
    private Integer inCdAccGbLength;

    @Value("${pr001.length.rcvbk1Cd}")
    private Integer rcvbk1CdLength;

    @Value("${pr001.length.rcvbk2Cd}")
    private Integer rcvbk2CdLength;

    @Value("${pr001.length.regModCd}")
    private Integer regModCdLength;

    @Value("${pr001.length.trnStat}")
    private Integer trnStatLength;

    /*END*/
    @Value("${pr001.length.norTranCnt}")
    private Integer norTranCntLength;

    @Value("${pr001.length.norTranTotAmt}")
    private Integer norTranTotAmtLength;

    @Value("${pr001.length.canTranCnt}")
    private Integer canTranCntLength;


    @Value("${pr001.length.canTranTotAmt}")
    private Integer canTranTotAmtLength;

    @Value("${pr001.length.procTranTotCnt}")
    private Integer procTranTotCntLength;

    @Value("${pr001.length.procTransTotAmt}")
    private Integer procTransTotAmtLength;
}
