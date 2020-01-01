package gateway.wrb.repositories;

import gateway.wrb.domain.PR001DInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
public interface PR001DRepo extends JpaRepository<PR001DInfo, Long> {
    @Query("SELECT count(a) FROM PR001DInfo a where a.msgdscd = :msgdscd and a.trnDt = :trnDt"
            + " and a.trnTm = :trnTm and a.msgNo = :msgNo and a.wdracNo = :wdracNo"
            + " and a.rcvacNo = :rcvacNo and a.rcvacDppeNm = :rcvacDppeNm and a.curCd = :curCd"
            + " and a.wdrAm = :wdrAm and a.tobkDscd = :tobkDscd")
    Integer countItem(String msgdscd, String trnDt, String trnTm, String msgNo, String wdracNo
            , String rcvacNo, String rcvacDppeNm, String curCd
            , BigDecimal wdrAm, String tobkDscd);
}
