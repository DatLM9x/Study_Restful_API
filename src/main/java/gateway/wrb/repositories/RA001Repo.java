package gateway.wrb.repositories;

import gateway.wrb.domain.RA001Info;

import java.util.List;

public interface RA001Repo {
    List<RA001Info> filterRA001(String orgCd, String bankCd, String bankCoNo);

    void save(RA001Info info);

    Integer isRA001Exist(String msgdscd, String wdrActNo, String aplDscd, String trnStDt, String trnType, String curCd, String cusIdNo);

    List<RA001Info> filterRA001_2(String orgCd, String bankCd, String bankCoNo, String bankRsvSdt, String bankRsvEdt);
}
