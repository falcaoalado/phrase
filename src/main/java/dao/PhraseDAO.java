package dao;

import entity.Phrase;

public class PhraseDAO extends DAO {

	public void create(Phrase phrase) throws Exception {
		
		super.open();
		super.preparedStatement = super.connection.prepareStatement
				("INSERT INTO PHRASE VALUES (NULL, ?, ?)");
		super.preparedStatement.setString(1, phrase.getPhrase());
		super.preparedStatement.setInt(2, phrase.getPerson().getId());
		super.preparedStatement.execute();
		super.close();
	}
	
}