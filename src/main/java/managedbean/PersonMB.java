package managedbean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dao.PersonDAO;
import dao.PhraseDAO;
import entity.Person;
import entity.Phrase;

@ManagedBean(name = "personMB")
@ViewScoped
public class PersonMB {

	private List<Person> people;
	private List<Phrase> phrases;

	private Person person;
	private Phrase phrase;

	private Person selectedPerson;

	@PostConstruct
	public void init() {
		this.person = new Person();
		this.phrase = new Phrase();
		this.selectedPerson = new Person();
		try {
			this.people = new PersonDAO().findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Person getSelectedPerson() {
		return selectedPerson;
	}

	public void setSelectedPerson(Person selectedPerson) {
		this.selectedPerson = selectedPerson;
	}

	public List<Person> getPeople() {
		return people;
	}

	public void setPeople(List<Person> people) {
		this.people = people;
	}

	public List<Phrase> getPhrases() {
		return phrases;
	}

	public void setPhrases(List<Phrase> phrases) {
		this.phrases = phrases;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Phrase getPhrase() {
		return phrase;
	}

	public void setPhrase(Phrase phrase) {
		this.phrase = phrase;
	}

	public void registerPerson() {

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			new PersonDAO().create(this.person);
			fc.addMessage("formPerson", new FacesMessage("Successfully registered!"));
			this.people = new PersonDAO().findAll();
		} catch (Exception e) {
			fc.addMessage("formPerson", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Something isn't right!", null));
		} finally {
			this.person = new Person();
		}
	}

	public void registerPhrase() {

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			System.out.println(this.selectedPerson);
			this.phrase.setPerson(this.selectedPerson);
			new PhraseDAO().create(this.phrase);
			fc.addMessage("formPhrase", new FacesMessage("Successfully registered!"));
			this.people = new PersonDAO().findAll();
		} catch (Exception e) {
			e.printStackTrace();
			fc.addMessage("formPhrase", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Something isn't right!", null));
		} finally {
			this.phrase = new Phrase();
			this.selectedPerson = new Person();
		}
	}
}
