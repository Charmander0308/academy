/*
 * id/pw/이름/닉네임
 */

package kr.co.dong.member;

class Member {
	private String id;
	private String password;
	private String name;
	private String nickname;
	
	public Member(String id, String password, String name, String nickname) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
