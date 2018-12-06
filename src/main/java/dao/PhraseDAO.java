package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Person;
import entity.Phrase;

public class PhraseDAO extends DAO {

	public void create(Phrase phrase) throws Exception {

		super.open();
		super.preparedStatement = super.connection.prepareStatement("INSERT INTO PHRASE VALUES (NULL, ?, ?)");
		super.preparedStatement.setString(1, phrase.getPhrase());
		super.preparedStatement.setInt(2, phrase.getPerson().getId());
		super.preparedStatement.execute();
		super.close();
	}

	public Person findPhrasesFromPerson(Person person) throws Exception {

		super.open();
		super.preparedStatement = super.connection.prepareStatement("SELECT * FROM PHRASE WHERE ID_PERSON=?");
		super.preparedStatement.setInt(1, person.getId());
		super.resultSet = super.preparedStatement.executeQuery();

		List<Phrase> phrases = new ArrayList<>();

		while (super.resultSet.next()) {
			Phrase phrase = new Phrase();
			phrase.setId(super.resultSet.getInt(1));
			phrase.setPhrase(super.resultSet.getString(2));
			phrase.setPerson(person);

			phrases.add(phrase);
		}

		person.setPhrases(phrases);

		return person;
	}

}