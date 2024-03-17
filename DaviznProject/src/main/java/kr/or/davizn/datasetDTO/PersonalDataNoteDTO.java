package kr.or.davizn.datasetDTO;

import java.sql.Date;

public class PersonalDataNoteDTO {
	
	private int dataseq;
	private String filepath;
	private String dataname;
	private String datahtml;
	private int strgseq;
	private int datatype;
	private Date datacreate;
	private String origin;
	private String userid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
	}
	public int getStrgseq() {
		return strgseq;
	}
	public void setStrgseq(int strgseq) {
		this.strgseq = strgseq;
	}
	public int getDatatype() {
		return datatype;
	}
	public void setDatatype(int datatype) {
		this.datatype = datatype;
	}
	public Date getDatacreate() {
		return datacreate;
	}
	public void setDatacreate(Date datacreate) {
		this.datacreate = datacreate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDatahtml() {
		return datahtml;
	}
	public void setDatahtml(String datahtml) {
		this.datahtml = datahtml;
	}
	
}
