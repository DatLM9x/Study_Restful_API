package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
@Getter
public class RV002Config {
    @Value("${rv002.length.coNo}")
    private Integer coNoLength;
    @Value("${rv002.length.aplDscd}")
    private Integer aplDscdLength;

    @Value("${rv002.length.msgDscd}")
    private Integer msgDscdLength;
    @Value("${rv002.length.outActNo}")
    private Integer outActNoLength;
    @Value("${rv002.length.virActNo}")
    private Integer virActNoLength;
    @Value("${rv002.length.virAcNm}")
    private Integer virAcNmLength;
    @Value("${rv002.length.refNo}")
    private Integer refNoLength;
    @Value("${rv002.length.recCodCd}")
    private Integer recCodCdLength;
    @Value("${rv002.length.trnAm}")
    private Integer trnAmLength;
    @Value("${rv002.length.trnAvlSdt}")
    private Integer trnAvlSdtLength;
    @Value("${rv002.length.trnAvlEdt}")
    private Integer trnAvlEdtLength;
    @Value("${rv002.length.trnAvlStm}")
    private Integer trnAvlStmLength;
    @Value("${rv002.length.trnAvlEtm}")
    private Integer trnAvlEtmLength;
    @Value("${rv002.length.trnAvlyn}")
    private Integer trnAvlYnLength;
    @Value("${rv002.length.corpRecCompCode}")
    private Integer corpRecCompCodeLength;
    @Value("${rv002.length.filler}")
    private Integer fillerLength;

}
