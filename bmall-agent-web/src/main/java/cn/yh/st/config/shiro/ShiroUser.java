package cn.yh.st.config.shiro;

public class ShiroUser {

	private long id;
	private String username;
	private String realname;

	public ShiroUser(long id, String username, String realname) {
		super();
		this.id = id;
		this.username = username;
		this.realname = realname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}
