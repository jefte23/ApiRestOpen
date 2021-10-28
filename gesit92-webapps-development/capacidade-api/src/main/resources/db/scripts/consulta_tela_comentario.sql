-- CONSULTA QUE RETORNA OS FILESYSTEMS COM CONSUMO ACIMA DO THRESHOLD NOS ÚLTIMOS 30 DIAS PARA O GRUPO/SERVIDOR INFORMADO - ok
SELECT 
       SAD.CD_TAB_SIS_ARQ AS ID_FILESISTEM
       SAD.NM_SIS_ARQ AS FILESYSTEM,
       SAD.NM_DSVO_SIS_ARQ AS DISPOSITIVO,
       SAD.NR_AREA_TTL/1024 AS AREA_TOTAL,
       SAD.NR_AREA_UTZD/1024 AS AREA_UTILIZADA,
       GR.PC_LIM_DCO AS THRESHOLD,
       TRUNC((SAD.NR_AREA_UTZD*100)/SAD.NR_AREA_TTL,2) AS PC_UTZD,
       SAD.DT_CLA_SIS_ARQ
FROM TAB_SIS_ARQ_FS_PART SAD
INNER JOIN TAB_SVDR_GR SG ON SAD.CD_SVDR=SG.CD_SVDR
INNER JOIN TAB_GR GR ON SG.CD_GR=GR.CD_GR
WHERE  SAD.CD_SVDR = ? AND GR.CD_GR=?
AND SAD.TIP_GR='M' AND SAD.DT_CLA_SIS_ARQ > SYSDATE-30
AND (SAD.NR_AREA_UTZD*100)/SAD.NR_AREA_TTL> GR.PC_LIM_DCO
ORDER BY SAD.DT_CLA_SIS_ARQ DESC

-- CONSULTA QUE RETORNA O HISTÓRICO DE CONSUMO DE CPU E MEMÓRIA DOS ÚLTIMOS 30 DIAS PARA O SERVIDOR INFORMADO - ok 
SELECT
   M1.CD_SVDR,
   M1.DT_MDD,
   M1.PC_CPU_TTL_UTZD_MAX AS CONSUMO_CPU,
   GR.PC_LIM_CPU AS THRESHOLD_CPU,
   M1.QT_MB_MMR_FSCO/1024 AS TOTAL_MEMORIA,
   TRUNC((M1.PC_MMR_UTZD_TTL_MAX *  M1.QT_MB_MMR_FSCO / 100 / 1024),2) AS CONSUMO_MEMORIA,
   M1.QT_MB_MMR_FSCO/1024 * GR.PC_LIM_MMR/100 AS THRESHOLD_MMR
FROM ORAIIT.MDD_CPDD_HW_DIA_PART M1
INNER JOIN TAB_SVDR_GR SG ON M1.CD_SVDR=SG.CD_SVDR
INNER JOIN TAB_GR GR ON SG.CD_GR=GR.CD_GR
WHERE M1.CD_SVDR=? AND  M1.DT_MDD > SYSDATE-30

-- CONSULTA QUE RETORNA O HISTÓRICO DE CONSUMO DOS ÚLTIMOS 30 DIAS DO SERVIDOR/DISPOSITIVO/FILESYSTEM INFORMADO - TODO
SELECT
   T1.DT_CLA_SIS_ARQ AS dataColeta,
   T1.NR_AREA_TTL/1024 AS AREA_TOTAL,
   T1.NR_AREA_UTZD/1024 AS AREA_UTILIZADA
FROM
   ORAIIT.TAB_SIS_ARQ_FS_PART T1
WHERE T1.TIP_GR = 'D' and T1.CD_SVDR = :IdServidor AND T1.CD_TAB_SIS_ARQ = :IdFileSystem AND T1.NM_DSVO_SIS_ARQ = :dispositivo AND  T1.DT_CLA_SIS_ARQ > SYSDATE-30

-- SCRIPT DE CARGA NA TABELA TAB_LST_THR QUE POPULA A TABELA DA TELA DE SERVIÇOS ACIMA DO THRESHOLD
insert int tab_lst_thr (cd_gr, nm_gr, cd_svdr, nm_svdr_inft, dt_csm, dt_rslc, dt_incl, nm_rdo, tip_rcs, in_csm) values (11696,	'ged ondemand imagem cheque', 	3276, 	'pbws1508', 		'07/06/2018', NULL, '06/06/2018', 	'RDI20180034030',	'MMR', 	'S');
insert int tab_lst_thr (cd_gr, nm_gr, cd_svdr, nm_svdr_inft, dt_csm, dt_rslc, dt_incl, nm_rdo, tip_rcs, in_csm) values (11644,	'cwat', 						1290, 	'srwtko00076', 		'07/06/2018', NULL, '05/06/2018', 	'RDI20180031163', 	'MMR', 	'S');
insert int tab_lst_thr (cd_gr, nm_gr, cd_svdr, nm_svdr_inft, dt_csm, dt_rslc, dt_incl, nm_rdo, tip_rcs, in_csm) values (48836,	'ged mitaka', 					23745, 	'svwtko01ged0002', 	'06/06/2018', NULL, '05/06/2018', 	'RDI20180033737', 	'DCO',	'S');
insert int tab_lst_thr (cd_gr, nm_gr, cd_svdr, nm_svdr_inft, dt_csm, dt_rslc, dt_incl, nm_rdo, tip_rcs, in_csm) values (11918,	'tvbb - streaming', 			5968, 	'pvmltvbstr023', 	'01/06/2018', NULL, '05/06/2018', 	NULL, 				'CPU', 	'S');
insert int tab_lst_thr (cd_gr, nm_gr, cd_svdr, nm_svdr_inft, dt_csm, dt_rslc, dt_incl, nm_rdo, tip_rcs, in_csm) values (11918,	'tvbb - streaming', 			5967, 	'pvmltvbstr020', 	'04/06/2018', NULL, '05/06/2018', 	NULL, 				'CPU', 	'S');
