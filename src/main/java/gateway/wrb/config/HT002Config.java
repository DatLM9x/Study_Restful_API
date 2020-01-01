package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@org.springframework.context.annotation.Configuration
@Getter
public class HT002Config {
    @Value("${ht002.length.tmsDt}")
    private Integer tmsDtLength;
    @Value("${ht002.length.tmsTm}")
    private Integer tmsTmLength;
    @Value("${ht002.length.coNo}")
    private Integer coNoLength;
    @Value("${ht002.length.mgscd}")
    private Integer mgscdLength;

    @Value("${ht002.length.msgDscd}")
    private Integer msgDscdLength;
    @Value("${ht002.length.actNo}")
    private Integer actNoLength;
    @Value("${ht002.length.trnDt}")
    private Integer trnDtLength;
    @Value("${ht002.length.trnTm}")
    private Integer trnTmLength;
    @Value("${ht002.length.drCr}")
    private Integer drCrLength;
    @Value("${ht002.length.trnAmt}")
    private Integer trnAmtLength;
    @Value("${ht002.length.trnAfBl}")
    private Integer trnAfBlLength;
    @Value("${ht002.length.brCd}")
    private Integer brCdLength;
    @Value("${ht002.length.chkAmt}")
    private Integer chkAmtLength;
    @Value("${ht002.length.trnType}")
    private Integer trnTypeLength;
    @Value("${ht002.length.particular}")
    private Integer particularLength;
    @Value("${ht002.length.depSeq}")
    private Integer depSeqLength;
    @Value("${ht002.length.status}")
    private Integer statusLength;
    @Value("${ht002.length.channelType}")
    private Integer channelTypeLength;
    @Value("${ht002.length.trnSrno}")
    private Integer trnSrnoLength;
    @Value("${ht002.length.destAccount}")
    private Integer destAccountLength;
    @Value("${ht002.length.recieveName}")
    private Integer recieveNameLength;
    @Value("${ht002.length.refTxt}")
    private Integer refTxtLength;
    @Value("${ht002.length.depRmk}")
    private Integer depRmkLength;
    @Value("${ht002.length.trmPrcSrno}")
    private Integer trmPrcSrnoLength;
    @Value("${ht002.length.virActNo}")
    private Integer virActNoLength;
}
