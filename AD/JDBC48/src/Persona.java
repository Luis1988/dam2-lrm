
public class Persona {

	private String nya = "", tel = "" , loc = "" , dir = "";
	
	public String getNya() {
		return nya;
	}

	public void setNya(String nya) {
		this.nya = nya;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Persona(String nya, String dir, String loc, String tel) {
		this.nya=nya;
		this.tel=tel;
		this.loc=loc;
		this.dir=dir;
		
	}
}
