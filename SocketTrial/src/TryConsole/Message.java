package TryConsole;

import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 5450169619410265476L;
	private int id;
	private String name;
	private String address;
	
	public Message(int id, String name, String address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public boolean equals(Object p) {
		if(this == p) return true;
		if(p == null || getClass() != p.getClass()) return false;
		
		Message mahasiswa = (Message) p;
		
		if(id != mahasiswa.id) return false;
		if(name != null ? !name.equals(mahasiswa.name) : mahasiswa.name != null) return false;
		
		return true;
	}
	
	public int hashCode() {
		return id;
	}
	
	public String toString() {
		return "\nId\t: "+getId()+"\nName\t: "+getName()+"\nAddress\t: "+getAddress();
	}
}