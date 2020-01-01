package gateway.wrb.services;

import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.VLR001Info;

import java.util.List;

public interface VLR001Service {
    void importVLR001(FbkFilesInfo fbkFilesInfo);

    List<VLR001Info> getAllVLR001();

    List<VLR001Info> getVLR001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt);

    void updateVLR001(VLR001Info info);

    void deleteVLR001(long id);

    boolean isVLR001exist(VLR001Info info);
}
