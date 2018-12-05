package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Person;

public class PersonDAO extends DAO {

	public void create(Person person) throws Exception {
		super.open();
		super.preparedStatement = super.connection.prepareStatement("INSERT INTO PERSON VALUES (NULL, ?)");
		super.preparedStatement.setString(1, person.getName());
		super.preparedStatement.execute();
		super.close();
	}

	public List<Person> findAll() throws Exception {

		super.open();
		List<Person> people = new ArrayList<>();
		super.resultSet = super.connection.prepareStatement("SELECT * FROM PERSON").executeQuery();

		while (super.resultSet.next()) {
			Person person = new Person();
			person.setId(super.resultSet.getInt(1));
			person.setName(super.resultSet.getString(2));
			people.add(person);
		}
		super.close();

		return people;
	}

	public Person findByName(String name) throws Exception {
		super.open();
		super.preparedStatement = super.connection.prepareStatement("SELECT * FROM PERSON WHERE NAME = ?");
		super.preparedStatement.setString(1, name);
		super.resultSet = super.preparedStatement.executeQuery();
		Person person = new Person();
		while (super.resultSet.next()) {
			person.setId(super.resultSet.getInt(1));
			person.setName(super.resultSet.getString(2));
		}
		super.close();

		return person;
	}
}