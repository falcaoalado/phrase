package entity;

public class Phrase {

	private Integer id;
	private String phrase;

	private Person person;

	public Phrase() {
	}

	public Phrase(Integer id, String phrase) {
		this.id = id;
		this.phrase = phrase;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	@Override
	public String toString() {
		return "Phrase [id=" + id + ", phrase=" + phrase + "]";
	}

}
