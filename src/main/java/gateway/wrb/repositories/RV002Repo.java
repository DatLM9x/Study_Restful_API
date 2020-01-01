package gateway.wrb.repositories;


import gateway.wrb.domain.RV002Info;

import java.util.List;

public interface RV002Repo {
    List<RV002Info> getAllRV002();

    RV002Info getRV002byID(long id);

    void addRV002(RV002Info rv002Info);

    void updateRV002(RV002Info rv002Info);

    void deleteRV002(long id);

    boolean isRV002Exist(String msgDscd, String trnDt, String trnTm, String msgNo, String wrdacNo, String rcvacNo, String amount);
}
