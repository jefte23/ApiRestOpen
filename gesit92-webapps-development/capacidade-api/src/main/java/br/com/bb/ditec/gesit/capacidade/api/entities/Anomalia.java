package br.com.bb.ditec.gesit.capacidade.api.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_ANOMALIA", schema = "ORAIIT")
public class Anomalia {
	
	@Id
	@Column(name="HRCSMESPEND")
	private Date HRCSMESPEND;
	
	@Column(name="SG_DD_SMN")
	private String SG_DD_SMN;
	
	@Column(name="MES")
	private String MES;
	
	@Column(name="RPTCLASS")
	private String RPTCLASS;
	

	
	@Column(name="DATA_MVT")
	private Date DATA_MVT;

	public Anomalia() {
	}

	

	public Date getHRCSMESPEND() {
		return HRCSMESPEND;
	}

	public void setHRCSMESPEND(Date hRCSMESPEND) {
		HRCSMESPEND = hRCSMESPEND;
	}

	public String getSG_DD_SMN() {
		return SG_DD_SMN;
	}

	public void setSG_DD_SMN(String sG_DD_SMN) {
		SG_DD_SMN = sG_DD_SMN;
	}

	public String getMES() {
		return MES;
	}

	public void setMES(String mES) {
		MES = mES;
	}

	public String getRPTCLASS() {
		return RPTCLASS;
	}

	public void setRPTCLASS(String rPTCLASS) {
		RPTCLASS = rPTCLASS;
	}





	public Date getDATA_MVT() {
		return DATA_MVT;
	}

	public void setDATA_MVT(Date dATA_MVT) {
		DATA_MVT = dATA_MVT;
	}
	
	
	
}
