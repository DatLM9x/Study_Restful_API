package gateway.wrb.services.impl;

import gateway.wrb.config.PR001Config;
import gateway.wrb.constant.FileType;
import gateway.wrb.domain.FbkFilesInfo;
import gateway.wrb.domain.PR001DInfo;
import gateway.wrb.domain.PR001EInfo;
import gateway.wrb.repositories.FbkFilesRepo;
import gateway.wrb.repositories.PR001DRepo;
import gateway.wrb.repositories.PR001ERepo;
import gateway.wrb.services.PR001Service;
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
public class PR001ServiceImpl implements PR001Service {

    public static final Logger logger = LoggerFactory.getLogger(PR001ServiceImpl.class);

    @Autowired
    PR001Config pr001Config;

    @Autowired
    PR001DRepo pr001DRepo;

    @Autowired
    PR001ERepo pr001ERepo;

    @Autowired
    FbkFilesRepo fbkFilesRepo;

    @Override
    public List<PR001DInfo> getAllPR001D() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PR001DInfo getPR001D(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void importPR001(FbkFilesInfo fbkFilesInfo) {
        Integer msgDscdLength = pr001Config.getMsgDscdLength();

        Integer coNoLength = pr001Config.getCoNoLength();
        Integer msgscdLength = pr001Config.getMgscdLength();
        Integer recMsgcdLength = pr001Config.getRecMsgcdLength();
        Integer tmsDtLength = pr001Config.getTmsDtLength();
        Integer tmsTmLength = pr001Config.getTmsTmLength();
        Integer etcLength = pr001Config.getEtcLength();

        Integer trnDtLength = pr001Config.getTrnDtLength();
        Integer trnTmLength = pr001Config.getTrnTmLength();
        Integer msgNoLength = pr001Config.getMsgNoLength();
        Integer wdracNoLength = pr001Config.getWdracNoLength();
        Integer wdrViracNoLength = pr001Config.getWdrViracNoLength();
        Integer rcvacNoLength = pr001Config.getRcvacNoLength();
        Integer rcvViracNoLength = pr001Config.getRcvViracNoLength();
        Integer rcvacDppeNmLength = pr001Config.getRcvacDppeNmLength();
        Integer curCdLength = pr001Config.getCurCdLength();
        Integer wdrAmLength = pr001Config.getWdrAmLength();
        Integer tobkDscdLength = pr001Config.getTobkDscdLength();
        Integer istDscdLength = pr001Config.getIstDscdLength();
        Integer inCdAccGbLength = pr001Config.getInCdAccGbLength();
        Integer rcvbk1CdLength = pr001Config.getRcvbk1CdLength();
        Integer rcvbk2CdLength = pr001Config.getRcvbk2CdLength();
        Integer regModCdLength = pr001Config.getRegModCdLength();
        Integer trnStatLength = pr001Config.getTrnStatLength();

        Integer norTranCntLength = pr001Config.getNorTranCntLength();
        Integer norTranTotAmtLength = pr001Config.getNorTranTotAmtLength();
        Integer canTranCntLength = pr001Config.getCanTranCntLength();
        Integer canTranTotAmtLength = pr001Config.getCanTranTotAmtLength();
        Integer procTranTotCntLength = pr001Config.getProcTranTotCntLength();
        Integer procTransTotAmtLength = pr001Config.getProcTransTotAmtLength();

        try (Stream<String> stream = Files.lines(Paths.get(fbkFilesInfo.getFullfbkpath()))) {
            stream.forEach(line -> {
                try {
                    if (line.startsWith(FileType.PREFIX_START)) {
                        line = line.substring(msgDscdLength);

                        String coNo = line.substring(0, coNoLength);
                        line = line.substring(coNoLength);
                        String mgscd = line.substring(0, msgscdLength);
                        line = line.substring(msgscdLength);
                        String recMsgcd = line.substring(0, recMsgcdLength);
                        line = line.substring(recMsgcdLength);

                        String tmsDt = line.substring(0, tmsDtLength);
                        line = line.substring(tmsDtLength);
                        String tmsTm = line.substring(0, tmsTmLength);
                        line = line.substring(tmsTmLength);
                        //String etc = line.substring(0, etcLength);
                        line = line.substring(etcLength);

                        fbkFilesInfo.setConos(coNo);
                        fbkFilesInfo.setMgscds(mgscd);
                        fbkFilesInfo.setRecmsgcds(recMsgcd);
                        fbkFilesInfo.setTmsdts(tmsDt);
                        fbkFilesInfo.setTmstms(tmsTm);
                        //fbkFilesInfo.setEtc(etc);

                    } else if (line.startsWith(FileType.PREFIX_CONTENT)) {
                        String msgDscD = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);

                        String trnDt = line.substring(0, trnDtLength);
                        line = line.substring(trnDtLength);
                        String trnTm = line.substring(0, trnTmLength);
                        line = line.substring(trnTmLength);
                        String msgNo = line.substring(0, msgNoLength);
                        line = line.substring(msgNoLength);
                        String wdracNo = line.substring(0, wdracNoLength);
                        line = line.substring(wdracNoLength);
                        String wdrViracNo = line.substring(0, wdrViracNoLength);
                        line = line.substring(wdrViracNoLength);
                        String rcvacNo = line.substring(0, rcvacNoLength);
                        line = line.substring(rcvacNoLength);
                        String rcvViracNo = line.substring(0, rcvViracNoLength);
                        line = line.substring(rcvViracNoLength);
                        String rcvacDppeNm = line.substring(0, rcvacDppeNmLength);
                        line = line.substring(rcvacDppeNmLength);
                        String curCd = line.substring(0, curCdLength);
                        line = line.substring(curCdLength);
                        String wdrAm = line.substring(0, wdrAmLength);
                        line = line.substring(wdrAmLength);
                        String tobkDscd = line.substring(0, tobkDscdLength);
                        line = line.substring(tobkDscdLength);
                        String istDscd = line.substring(0, istDscdLength);
                        line = line.substring(istDscdLength);
                        String inCdAccGb = line.substring(0, inCdAccGbLength);
                        line = line.substring(inCdAccGbLength);
                        String rcvbk1Cd = line.substring(0, rcvbk1CdLength);
                        line = line.substring(rcvbk1CdLength);
                        String rcvbk2Cd = line.substring(0, rcvbk2CdLength);
                        line = line.substring(rcvbk2CdLength);
                        String regModCd = line.substring(0, regModCdLength);
                        line = line.substring(regModCdLength);
                        String trnStat = line.substring(0, trnStatLength);
                        line = line.substring(trnStatLength);

                        logger.info("er001Path : [" + fbkFilesInfo.getFullfbkpath() + ", msgDscd :" + msgDscD
                                + ", trnDt:" + trnDt + ", trnTm :" + trnTm + ", msgNo :" + msgNo + ", wdracNo:"
                                + wdracNo + ", wdrViracNo:" + wdrViracNo + ", rcvacNo:" + rcvacNo + ", rcvViracNo:"
                                + rcvViracNo + ", rcvacDppeNm:" + rcvacDppeNm + ", curCd:" + curCd + ", wdrAm:" + wdrAm
                                + ", tobkDscd:" + tobkDscd + ", istDscd:" + istDscd + ", inCdAccGb:" + inCdAccGb + "]");

                        // save to DB
                        PR001DInfo info = new PR001DInfo();
                        info.setFbkname(fbkFilesInfo.getFbkname());
                        info.setMsgdscd(msgDscD);
                        info.setTrnDt(trnDt);
                        info.setTrnTm(trnTm);
                        info.setMsgNo(msgNo);
                        info.setWdracNo(wdracNo);
                        info.setWdrViracNo(wdrViracNo);
                        info.setRcvacNo(rcvacNo);
                        info.setRcvViracNo(rcvViracNo);
                        info.setRcvacDppeNm(rcvacDppeNm);
                        info.setCurCd(curCd);
                        info.setWdrAm(NumberUtils.parseToDecimal(wdrAm));
                        info.setIstDscd(istDscd);
                        info.setInCdAccGb(inCdAccGb);
                        info.setRcvbk1Cd(rcvbk1Cd);
                        info.setRcvbk2Cd(rcvbk2Cd);
                        info.setRegModCd(regModCd);
                        info.setTrnStat(trnStat);

                        if (!isPR001Dexist(info))
                            pr001DRepo.save(info);

                    } else if (line.startsWith(FileType.PREFIX_END)) {
                        String msgDscE = line.substring(0, msgDscdLength);
                        line = line.substring(msgDscdLength);
                        String norTranCnt = line.substring(0, norTranCntLength);
                        line = line.substring(norTranCntLength);
                        String norTranTotAmt = line.substring(0, norTranTotAmtLength);
                        line = line.substring(norTranTotAmtLength);
                        String canTranCnt = line.substring(0, canTranCntLength);
                        line = line.substring(canTranCntLength);
                        String canTranTotAmt = line.substring(0, canTranTotAmtLength);
                        line = line.substring(canTranTotAmtLength);
                        String procTranTotCnt = line.substring(0, procTranTotCntLength);
                        line = line.substring(procTranTotCntLength);
                        String procTransTotAmt = line.substring(0, procTransTotAmtLength);
                        line = line.substring(procTransTotAmtLength);

                        // save to DB
                        PR001EInfo info = new PR001EInfo();
                        info.setFbkname(fbkFilesInfo.getFbkname());
                        info.setMsgdscd(msgDscE);
                        info.setNorTranCnt(NumberUtils.parseToInteger(norTranCnt));
                        info.setNorTranTotAmt(NumberUtils.parseToInteger(norTranTotAmt));
                        info.setCanTranCnt(NumberUtils.parseToInteger(canTranCnt));
                        info.setCanTranTotAmt(NumberUtils.parseToInteger(canTranTotAmt));
                        info.setProcTranTotCnt(NumberUtils.parseToInteger(procTranTotCnt));
                        info.setProcTransTotAmt(NumberUtils.parseToInteger(procTransTotAmt));

                        pr001ERepo.save(info);
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
    public void updatePR001D(PR001DInfo info) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletePR001D(long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isPR001Dexist(PR001DInfo info) {
        try {
            Integer countEntity = pr001DRepo.countItem(info.getMsgdscd(), info.getTrnDt(), info.getTrnTm(),
                    info.getMsgNo(), info.getWdracNo(), info.getRcvacNo(), info.getRcvacDppeNm(), info.getCurCd(),
                    info.getWdrAm(), info.getTobkDscd());
            logger.info("PR001 " + info.getMsgdscd() + "," + info.getTrnDt() + " detail has count = " + countEntity);

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
