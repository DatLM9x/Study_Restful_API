CREATE TABLE `er001` (
  `er001id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `msgdscd` varchar(10) DEFAULT NULL,
  `notice_dt` varchar(10) DEFAULT NULL,
  `notice_cnt` int(11) DEFAULT NULL,
  `from_ccy` varchar(100) DEFAULT NULL,
  `to_ccy` varchar(10) DEFAULT NULL,
  `base_rate` decimal(10,3) DEFAULT NULL,
  `cash_buying` decimal(10,3) DEFAULT NULL,
  `cash_selling` decimal(10,3) DEFAULT NULL,
  `tt_buying` decimal(10,3) DEFAULT NULL,
  `tt_selling` decimal(10,3) DEFAULT NULL,
  `order_dscd` varchar(10) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `filler` text,
  PRIMARY KEY (`er001id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8

CREATE TABLE `fbkfiles` (
  `fbkid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `conos` varchar(100) DEFAULT NULL,
  `mgscds` varchar(100) DEFAULT NULL,
  `recmsgcds` varchar(100) DEFAULT NULL,
  `tmsdts` varchar(100) DEFAULT NULL,
  `tmstms` varchar(100) DEFAULT NULL,
  `apldscd` varchar(100) DEFAULT NULL,
  `other` varchar(100) DEFAULT NULL,
  `filetype` varchar(100) DEFAULT NULL,
  `fullfbkpath` varchar(100) DEFAULT NULL,
  `trndt` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`fbkid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8

CREATE TABLE `pr001_data` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `msgdscd` varchar(10) DEFAULT NULL,
  `trn_dt` varchar(8) DEFAULT NULL,
  `trn_tm` varchar(6) DEFAULT NULL,
  `msg_no` varchar(7) DEFAULT NULL,
  `wdr_acno` varchar(25) DEFAULT NULL,
  `rcv_acno` varchar(25) DEFAULT NULL,
  `rcv_vir_acno` varchar(25) DEFAULT NULL,
  `rcv_acdppe_nm` varchar(69) DEFAULT NULL,
  `cur_cd` varchar(3) DEFAULT NULL,
  `wdr_am` decimal(10,0) DEFAULT NULL,
  `to_bk_dscd` char(1) DEFAULT NULL,
  `ist_dscd` char(1) DEFAULT NULL,
  `incd_acc_gb` char(1) DEFAULT NULL,
  `rcv_bk1_cd` varchar(8) DEFAULT NULL,
  `rcv_bk2_cd` varchar(8) DEFAULT NULL,
  `regmod_cd` char(1) DEFAULT NULL,
  `trn_stat` varchar(5) DEFAULT NULL,
  `wdr_vir_acno` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3689 DEFAULT CHARSET=utf8

CREATE TABLE `pr001_sum` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `msgdscd` char(1) DEFAULT NULL,
  `nor_tran_cnt` int(11) DEFAULT NULL COMMENT 'Normal Transaction Count',
  `nor_tran_to_amt` int(11) DEFAULT NULL COMMENT 'Normal Transaction Total Amount',
  `can_tran_cnt` int(11) DEFAULT NULL COMMENT 'Cancel Transaction Count',
  `can_tran_to_amt` int(11) DEFAULT NULL COMMENT 'Cancel Transaction Total Amount',
  `proc_tran_to_cnt` int(11) DEFAULT NULL COMMENT 'Processing Transaction Total Count',
  `proc_tran_to_amt` int(11) DEFAULT NULL COMMENT 'Processing Transaction Total Amount',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8

CREATE TABLE `vlr001` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `msgdscd` varchar(10) DEFAULT NULL,
  `vir_act_no` varchar(25) DEFAULT NULL,
  `apl_dscd` varchar(5) DEFAULT NULL,
  `vr_act_cus_nm` varchar(200) DEFAULT NULL,
  `trn_am` decimal(10,0) DEFAULT NULL,
  `ir_trn_yn` char(1) DEFAULT NULL,
  `lmt_am_ov_yn` char(1) DEFAULT NULL,
  `lmt_am_blw_yn` char(1) DEFAULT NULL,
  `dup_rcv_prhb_yn` char(1) DEFAULT NULL,
  `mo_ac_rv_avl_yn` char(1) DEFAULT NULL,
  `trn_avl_sdt` varchar(8) DEFAULT NULL,
  `trn_avl_edt` varchar(8) DEFAULT NULL,
  `trn_avl_stm` varchar(6) DEFAULT NULL,
  `trn_avl_etm` varchar(6) DEFAULT NULL,
  `rgs_trn_dt` varchar(8) DEFAULT NULL,
  `doc_no` varchar(50) DEFAULT NULL,
  `sts_dscd` varchar(2) DEFAULT NULL,
  `filler` text,
  `line_flag` char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8

CREATE TABLE `ra001` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fbkname` varchar(100) DEFAULT NULL,
  `msgdscd` varchar(10) DEFAULT NULL,
  `apl_dscd` varchar(5) DEFAULT NULL,
  `msg_tr_no` varchar(50) DEFAULT NULL,
  `trn_st_dt` varchar(8) DEFAULT NULL,
  `trn_cls_dt` varchar(8) DEFAULT NULL,
  `trn_type` varchar(5) DEFAULT NULL,
  `status` varchar(5) DEFAULT NULL,
  `cur_cd` varchar(3) DEFAULT NULL,
  `rcp_am` varchar(23) DEFAULT NULL,
  `rcp_cnt` varchar(5) DEFAULT NULL,
  `out_particular` varchar(210) DEFAULT NULL,
  `in_particular` varchar(210) DEFAULT NULL,
  `cus_id_no_cd` varchar(2) DEFAULT NULL,
  `cus_id_no` varchar(50) DEFAULT NULL,
  `isu_dt` varchar(8) DEFAULT NULL,
  `vld_edt` varchar(8) DEFAULT NULL,
  `wdr_act_no` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

CREATE TABLE `sys_file_seq` (
  `code` varchar(10) NOT NULL,
  `nxt_seq` int(11) DEFAULT NULL,
  `file_dt` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8