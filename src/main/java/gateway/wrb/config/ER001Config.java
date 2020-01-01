package gateway.wrb.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class ER001Config {
    @Value("${er001.length.tmsDt}")
    private Integer tmsDtLength;
    @Value("${er001.length.tmsTm}")
    private Integer tmsTmLength;
    @Value("${er001.length.mgscd}")
    private Integer mgscdLength;
    @Value("${er001.length.other}")
    private Integer otherLength;

    @Value("${er001.length.msgDscd}")
    private Integer msgDscdLength;
    @Value("${er001.length.noticeDt}")
    private Integer noticeDtLength;
    @Value("${er001.length.noticeCnt}")
    private Integer noticeCntLength;
    @Value("${er001.length.fromCcy}")
    private Integer fromCcyLength;
    @Value("${er001.length.toCcy}")
    private Integer toCcyLength;
    @Value("${er001.length.baseRate}")
    private Integer baseRateLength;
    @Value("${er001.length.cashBuying}")
    private Integer cashBuyingLength;
    @Value("${er001.length.cashSelling}")
    private Integer cashSellingLength;
    @Value("${er001.length.ttBuying}")
    private Integer ttBuyingLength;
    @Value("${er001.length.ttSelling}")
    private Integer ttSellingLength;
    @Value("${er001.length.orderDscd}")
    private Integer orderDscdLength;
    @Value("${er001.length.status}")
    private Integer statusLength;
    @Value("${er001.length.filler}")
    private Integer fillerLength;
}
