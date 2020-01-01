package gateway.wrb.services.impl;

import gateway.wrb.config.ER001Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.ER001Info;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.repositories.ER001Repo;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.services.ER001Service;
import gateway.wrb.util.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ER001ServiceImpl implements ER001Service {
    public static final Logger logger = LoggerFactory.getLogger(ER001ServiceImpl.class);

    @Autowired
    ER001Config er001Config;

    @Autowired
    ER001Repo er001Repo;

    @Autowired
    FbkFilesRepo fbkFilesRepo;

    @Override
    public List<ER001Info> getAllER001() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ER001Info> getER001(String orgCd, String bankCd, String bankCoNo, String noticeSdt, String noticeEdt) {
        List<ER001Info> er001Infos = er001Repo.filterER001(orgCd, bankCd, bankCoNo, noticeSdt, noticeEdt);
        return er001Infos;
    }

    @Override
    public void importER001(FbkFilesInfo fbkFilesInfo) {
        Integer tmsDtLength = er001Config.getTmsDtLength();
        Integer tmsTmLength = er001Config.getTmsTmLength();
        Integer mgscdLength = er001Config.getMgscdLength();
        Integer otherLength = er001Config.getOtherLength();

        Integer msgDscdLength = er001Config.getMsgDscdLength();
        Integer noticeDtLength = er001Config.getNoticeDtLength();
        Integer noticeCntLength = er001Config.getNoticeCntLength();
        Integer fromCcyLength = er001Config.getFromCcyLength();
        Integer toCcyLength = er001Config.getToCcyLength();
        Integer baseRateLength = er001Config.getBaseRateLength();
        Integer cashBuyingLength = er001Config.getCashBuyingLength();
        Integer cashSellingLength = er001Config.getCashSellingLength();
        Integer ttBuyingLength = er001Config.getTtBuyingLength();
        Integer ttSellingLength = er001Config.getTtSellingLength();
        Integer orderDscdLength = er001Config.getOrderDscdLength();
        Integer statusLength = er001Config.getStatusLength();
        Integer fillerLength = er001Config.getFillerLength();

        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullfbkpath()))) {
            stream.forEach(line -> {
                try {
                    if (line.startsWith(FileType.PREFIX_START)) {
                        String msgDscdS = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);
                        String tmsDt = line.substring(0, tmsDtLength);
                        line = line.substring(tmsDtLength);
                        String tmsTm = line.substring(0, tmsTmLength);
                        line = line.substring(tmsTmLength);
                        String mgsCd = line.substring(0, mgscdLength);
                        line = line.substring(mgscdLength);
                        String other = line.substring(0, otherLength);
                        line = line.substring(otherLength);

                        fbkFilesInfo.setTmsdts(tmsDt);
                        fbkFilesInfo.setTmstms(tmsTm);

                        fbkFilesInfo.setMgscds(mgsCd);
                        fbkFilesInfo.setOther(other);

                    } else if (line.startsWith(FileType.PREFIX_CONTENT)) {
                        String msgDscd = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);

                        String noticeDt = line.substring(0, noticeDtLength);
                        line = line.substring(noticeDtLength);
                        String noticeCnt = line.substring(0, noticeCntLength);
                        line = line.substring(noticeCntLength);
                        String fromCcy = line.substring(0, fromCcyLength);
                        line = line.substring(fromCcyLength);
                        String toCcy = line.substring(0, toCcyLength);
                        line = line.substring(toCcyLength);
                        String baseRate = line.substring(0, baseRateLength);
                        line = line.substring(baseRateLength);
                        String cashBuying = line.substring(0, cashBuyingLength);
                        line = line.substring(cashBuyingLength);
                        String cashSelling = line.substring(0, cashSellingLength);
                        line = line.substring(cashSellingLength);
                        String ttBuying = line.substring(0, ttBuyingLength);
                        line = line.substring(ttBuyingLength);
                        String ttSelling = line.substring(0, ttSellingLength);
                        line = line.substring(ttSellingLength);
                        String orderDscd = line.substring(0, orderDscdLength);
                        line = line.substring(orderDscdLength);
                        String status = line.substring(0, statusLength);
                        line = line.substring(statusLength);
                        String filler = line.substring(0, fillerLength);
                        line = line.substring(fillerLength);

                        logger.info("er001Path : [" + fbkFilesInfo.getFullfbkpath() + ", msgDscd :" + msgDscd
                                + ", noticeDt:" + noticeDt + ", noticeCnt :" + noticeCnt + ", fromCcy :" + fromCcy
                                + ", toCcy:" + toCcy + ", baseRate:" + baseRate + ", cashBuying:" + cashBuying
                                + ", cashSelling:" + cashSelling + ", ttBuying:" + ttBuying + ", ttSelling:" + ttSelling
                                + ", orderDscd:" + orderDscd + ", status:" + status + ", status:" + status + ", filler:"
                                + filler + "]");

                        // save to DB
                        ER001Info er001Info = new ER001Info();
                        er001Info.setFbkname(fbkFilesInfo.getFbkname());
                        er001Info.setMsgdscd(msgDscd);
                        er001Info.setNoticeDt(noticeDt);
                        er001Info.setNoticeCnt(NumberUtils.parseToInteger(noticeCnt));
                        er001Info.setFromCcy(fromCcy);
                        er001Info.setToCcy(toCcy);
                        er001Info.setBaseRate(NumberUtils.parseToDecimal(baseRate));
                        er001Info.setCashBuying(NumberUtils.parseToDecimal(cashBuying));
                        er001Info.setCashSelling(NumberUtils.parseToDecimal(cashSelling));
                        er001Info.setTtBuying(NumberUtils.parseToDecimal(ttBuying));
                        er001Info.setTtSelling(NumberUtils.parseToDecimal(ttSelling));
                        er001Info.setOrderDscd(orderDscd);
                        er001Info.setStatus(status);
                        er001Info.setFiller(filler);

                        if (!isExisted(er001Info))
                            er001Repo.save(er001Info);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.error(e.getMessage());
                }
            });
            fbkFilesRepo.addFbkFile(fbkFilesInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateER001(ER001Info info) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteER001(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isER001exist(ER001Info info) {
        // TODO Auto-generated method stub
        return false;
    }

    private boolean isExisted(ER001Info info) {
        try {
            Integer countEntity = er001Repo.isER001Exist(info.getMsgdscd(), info.getNoticeDt(), info.getNoticeCnt(),
                    info.getFromCcy(), info.getToCcy(), info.getBaseRate(), info.getCashBuying(), info.getCashSelling(),
                    info.getTtBuying(), info.getTtSelling(), info.getOrderDscd(), info.getStatus(), info.getFiller());
            logger.info("ER001 " + info.getMsgdscd() + "," + info.getNoticeDt() + " has count = " + countEntity);

            if (countEntity < 1)
                return false;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return true;
    }
}
