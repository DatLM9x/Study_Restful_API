package gateway.wrb.services;

import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.PR001DInfo;

import java.util.List;

public interface PR001Service {

    void importPR001(FbkFilesInfo fbkFilesInfo);

    List<PR001DInfo> getAllPR001D();

    PR001DInfo getPR001D(long id);

    void updatePR001D(PR001DInfo info);

    void deletePR001D(long id);

    boolean isPR001Dexist(PR001DInfo info);

}
