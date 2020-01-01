package gateway.wrb.repositories;

import gateway.wrb.domain.VLR001Info;

import java.util.List;

public interface VLR001Repo {
    void addVLR001(VLR001Info vlr001Info);

    List<VLR001Info> filterVLRV001(String orgCd, String bankCd, String bankCoNo, String outActNo, String rgsTrnSdt, String rgsTrnEdt);

    Integer isVLR001exist(String msgdscd, String virActNo, String aplDscd, String trnAvlSdt, String trnAvlEdt, String trnAvlStm, String trnAvlEtm, String rgsTrnDt, String stsDscd);
}
