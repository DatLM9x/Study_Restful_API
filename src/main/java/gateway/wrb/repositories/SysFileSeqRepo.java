package gateway.wrb.repositories;

import gateway.wrb.domain.SysFileSeqInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface SysFileSeqRepo extends JpaRepository<SysFileSeqInfo, Long> {

    @Query("SELECT a FROM SysFileSeqInfo a where a.code = :code ")
    List<SysFileSeqInfo> getSysFileSeq(String code);

    @Procedure(name = "procGetNextSeq")
    Integer getNextSeq(@Param("fileDT") String fileDT, @Param("fileType") String fileType);

}
