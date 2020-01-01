package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
@Getter
public class RV001Config {
    @Value("${rv001.length.coNo}")
    private Integer coNoLength;
    @Value("${rv001.length.mgscd}")
    private Integer mgscdLength;
    @Value("${rv001.length.recMsgcd}")
    private Integer recMsgcdLength;
    @Value("${rv001.length.tmsDt}")
    private Integer tmsDtLength;
    @Value("${rv001.length.tmsTm}")
    private Integer tmsTmLength;

    @Value("${rv001.length.msgDscd}")
    private Integer msgDscdLength;
    @Value("${rv001.length.trnDt}")
    private Integer trnDtLength;
    @Value("${rv001.length.trnTm}")
    private Integer trnTmLength;
    @Value("${rv001.length.msgNo}")
    private Integer msgNoLength;
    @Value("${rv001.length.wdracNo}")
    private Integer wdracNoLength;
    @Value("${rv001.length.wdrViracNo}")
    private Integer wdrViracNoLength;
    @Value("${rv001.length.rcvacNo}")
    private Integer rcvacNoLength;
    @Value("${rv001.length.rcvViracNo}")
    private Integer rcvViracNoLength;
    @Value("${rv001.length.rcvacDppeNm}")
    private Integer rcvacDppeNmLength;
    @Value("${rv001.length.curCd}")
    private Integer curCdLength;
    @Value("${rv001.length.wdrAm}")
    private Integer wdrAmLength;
    @Value("${rv001.length.tobkDscd}")
    private Integer tobkDscdLength;
    @Value("${rv001.length.istDscd}")
    private Integer istDscdLength;
    @Value("${rv001.length.inCdAccGb}")
    private Integer inCdAccGbLength;
    @Value("${rv001.length.rcvbk1Cd}")
    private Integer rcvbk1CdLength;
    @Value("${rv001.length.rcvbk2Cd}")
    private Integer rcvbk2CdLength;
    @Value("${rv001.length.regModCd}")
    private Integer regModCdLength;
    @Value("${rv001.length.trnStat}")
    private Integer trnStatLength;
    @Value("${rv001.length.trnSrno}")
    private Integer trnSrnoLength;
    @Value("${rv001.length.refNo}")
    private Integer refNoLength;
    @Value("${rv001.length.vractCusNm}")
    private Integer vractCusNmLength;
    @Value("${rv001.length.stsDscd}")
    private Integer stsDscdLength;
}
