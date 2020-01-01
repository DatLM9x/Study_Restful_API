CREATE DEFINER=`root`@`%` PROCEDURE `wrb`.`proc_get_next_seq`(
	IN fileDT VARCHAR(20),
	IN fileType VARCHAR(20),
	OUT curSeq INT)
BEGIN
	DECLARE count_vl INT;
	SELECT COUNT(*) INTO count_vl FROM wrb.sys_file_seq WHERE  wrb.sys_file_seq.file_dt = fileDT and wrb.sys_file_seq.code= fileType;

	IF (count_vl  > 0) THEN		
		UPDATE wrb.sys_file_seq SET wrb.sys_file_seq.nxt_seq = (wrb.sys_file_seq.nxt_seq + 1) WHERE wrb.sys_file_seq.code= fileType;
	ELSE
		UPDATE wrb.sys_file_seq SET wrb.sys_file_seq.file_dt = fileDT, wrb.sys_file_seq.nxt_seq = 1 WHERE wrb.sys_file_seq.code= fileType;
	END IF;

	COMMIT;
	SELECT wrb.sys_file_seq.nxt_seq INTO curSeq FROM wrb.sys_file_seq WHERE wrb.sys_file_seq.file_dt = fileDT and wrb.sys_file_seq.code= fileType;
END