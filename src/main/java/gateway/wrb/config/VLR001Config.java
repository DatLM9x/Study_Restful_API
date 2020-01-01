package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class VLR001Config {

    /* START */
    @Value("${vlr001.length.tmsDt}")
    private Integer tmsDtLength;

    @Value("${vlr001.length.tmsTm}")
    private Integer tmsTmLength;

    @Value("${vlr001.length.coNo}")
    private Integer coNoLength;

    @Value("${vlr001.length.outActNo}")
    private Integer outActNoLength;

    @Value("${vlr001.length.dataCnt}")
    private Integer dataCntLength;

    @Value("${vlr001.length.etc}")
    private Integer etcLength;

    /* DATA */
    @Value("${vlr001.length.msgDscd}")
    private Integer msgDscdLength;

    @Value("${vlr001.length.virActNo}")
    private Integer virActNoLength;

    @Value("${vlr001.length.aplDscd}")
    private Integer aplDscdLength;

    @Value("${vlr001.length.vractCusNm}")
    private Integer vractCusNmLength;

    @Value("${vlr001.length.irTrnYn}")
    private Integer irTrnYnLength;

    @Value("${vlr001.length.trnAm}")
    private Integer trnAmLength;

    @Value("${vlr001.length.lmtAmOvYn}")
    private Integer lmtAmOvYnLength;

    @Value("${vlr001.length.lmtAmBlwYn}")
    private Integer lmtAmBlwYnLength;

    @Value("${vlr001.length.dupRcvPrhbYn}")
    private Integer dupRcvPrhbYnLength;

    @Value("${vlr001.length.moacrvAvlYn}")
    private Integer moacrvAvlYnLength;

    @Value("${vlr001.length.trnAvlSdt}")
    private Integer trnAvlSdtLength;

    @Value("${vlr001.length.trnAvlEdt}")
    private Integer trnAvlEdtLength;

    @Value("${vlr001.length.trnAvlStm}")
    private Integer trnAvlStmLength;

    @Value("${vlr001.length.trnAvlEtm}")
    private Integer trnAvlEtmLength;

    @Value("${vlr001.length.rgsTrnDt}")
    private Integer rgsTrnDtLength;

    @Value("${vlr001.length.docNo}")
    private Integer docNoLength;

    @Value("${vlr001.length.stsDscd}")
    private Integer stsDscdLength;

    @Value("${vlr001.length.filler}")
    private Integer fillerLength;

    @Value("${vlr001.length.lineFlag}")
    private Integer lineFlagLength;
}
