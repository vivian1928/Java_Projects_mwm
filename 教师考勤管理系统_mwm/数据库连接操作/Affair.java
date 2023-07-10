package 数据库连接操作;

public class Affair {
	public String ano;
	public String tno;
	public String affair_type;
	public String affair_start;
	public String affair_end;
	public String reason;

	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getAffair_type() {
		return affair_type;
	}
	public void setAffair_type(String string) {
		this.affair_type = string;
	}
	public String getAffair_start() {
		return affair_start;
	}
	public void setAffair_start(String affair_start) {
		this.affair_start = affair_start;
	}
	public String getAffair_end() {
		return affair_end;
	}
	public void setAffair_end(String affair_end) {
		this.affair_end = affair_end;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public String toString() {
		return "Affair [tno=" + tno + ", affair_type=" + affair_type + ", affair_start=" + affair_start
				+ ", affair_end=" + affair_end + ", reason=" + reason + "]";
	}
	public Affair(String ano, String tno, String affair_type, String affair_start, String affair_end, String reason) {
		super();
		this.ano = ano;
		this.tno = tno;
		this.affair_type = affair_type;
		this.affair_start = affair_start;
		this.affair_end = affair_end;
		this.reason = reason;
	}
	public Affair() {
		super();
		// TODO 自动生成的构造函数存根
	}


	
}
