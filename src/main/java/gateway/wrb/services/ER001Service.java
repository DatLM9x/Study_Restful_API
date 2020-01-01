package gateway.wrb.services;

import gateway.wrb.domain.ER001Info;
import gateway.wrb.domain.FbkFilesInfo;

import java.util.List;

public interface ER001Service {
    List<ER001Info> getAllER001();

    List<ER001Info> getER001(String orgCd, String bankCd, String bankCoNo, String noticeSdt, String noticeEdt);

    void importER001(FbkFilesInfo fbkFilesInfo);

    void updateER001(ER001Info rv001Info);

    void deleteER001(long id);

    boolean isER001exist(ER001Info rv001Info);
}
