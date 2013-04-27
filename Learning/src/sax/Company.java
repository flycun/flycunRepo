package sax;

public class Company {

	private String jydm;
	private String jsp;
	private String rzdf;
	public String getJydm() {
		return jydm;
	}
	public void setJydm(String jydm) {
		this.jydm = jydm;
	}
	public String getJsp() {
		return jsp;
	}
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}
	public String getRzdf() {
		return rzdf;
	}
	public void setRzdf(String rzdf) {
		this.rzdf = rzdf;
	}
	@Override
	public String toString() {
		StringBuilder buf=new StringBuilder();
		buf.append("company[jydm=").append(jydm).append(",jsp=").append(jsp).append(",rzdf=").append(rzdf).append("]");
		return buf.toString();
	}
}
