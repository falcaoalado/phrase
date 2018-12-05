package entity;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;

	private List<Phrase> phrases;

	public Person() {
	}

	public Person(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj instanceof Person) {
			return ((Person) obj).getName().equals(this.getName());
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}
}
