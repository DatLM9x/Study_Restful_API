package gateway.wrb.services;


import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.RV001Info;

import java.util.List;

public interface RV001Service {
    List<RV001Info> getAllRV001();

    List<RV001Info> getRV001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt);

    void importRV001(FbkFilesInfo fbkFilesInfo);

    void updateRV001(RV001Info rv001Info);

    void deleteRV001(String viracno);

    boolean isRV001exist(RV001Info rv001Info);
}
