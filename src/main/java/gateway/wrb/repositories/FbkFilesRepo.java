package gateway.wrb.repositories;


import gateway.wrb.domain.FbkFilesInfo;

import java.util.List;

public interface FbkFilesRepo {
    FbkFilesInfo getFbkFileInfo(String directoryPath);

    List<FbkFilesInfo> getFbkFiles();

    FbkFilesInfo getFbkInfo(long id);

    void addFbkFile(FbkFilesInfo fbkFile);

    void updateFile(FbkFilesInfo fbkFile);

    void deleteFbkFile(String id);

    boolean isFileExist(FbkFilesInfo fbkFilesInfo);
}
