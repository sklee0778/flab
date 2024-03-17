package kr.or.davizn.datasetDTO;

import java.sql.Date;

public class PersonalDataSketchDTO {
	
	private int dataseq;
	private int strgseq;
	private String dataname;
	private int datatype;
	private Date datacreate;
	private String filepath;
	private String datahtml;
	private String origin;


	public int getDataseq() {
		return dataseq;
	}
	public void setDataseq(int dataseq) {
		this.dataseq = dataseq;
	}
	public int getStrgseq() {
		return strgseq;
	}
	public void setStrgseq(int strgseq) {
		this.strgseq = strgseq;
	}
	public String getDataname() {
		return dataname;
	}
	public void setDataname(String dataname) {
		this.dataname = dataname;
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
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
