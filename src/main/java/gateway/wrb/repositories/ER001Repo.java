package gateway.wrb.repositories;

import gateway.wrb.domain.ER001Info;

import java.math.BigDecimal;
import java.util.List;

public interface ER001Repo {
    void save(ER001Info er001Info);

    Integer isER001Exist(String msgdscd, String noticeDt, Integer noticeCnt, String fromCcy, String toCcy
            , BigDecimal baseRate, BigDecimal cashBuying, BigDecimal cashSelling, BigDecimal ttBuying
            , BigDecimal ttSelling, String orderDscd, String status, String filler);

    List<ER001Info> filterER001(String orgCd, String bankCd, String bankCoNo, String noticeSdt, String noticeEdt);
}
