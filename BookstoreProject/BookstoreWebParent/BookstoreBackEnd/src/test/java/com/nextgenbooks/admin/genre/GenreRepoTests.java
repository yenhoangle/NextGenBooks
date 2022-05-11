package com.nextgenbooks.admin.genre;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Genre;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class GenreRepoTests {

	@Autowired
	private GenreRepo repo;
	
	@Test
	public void testCreateRootGenre() {
		Genre epis = new Genre("Epistolary Novel", "epis");
		Genre saved = repo.save(epis);
		assertThat(saved.getId()).isGreaterThan(0);
	}
	@Test
	public void testCreateRest() {
		Genre his = new Genre("Historical Fiction", "hisfic");
		Genre scifi = new Genre("Science Fiction", "scifi");
		Genre df = new Genre("Domestic Fiction", "domfic");
		Genre cf = new Genre("Contemporary Fiction", "confic");
		Genre auto = new Genre("Autobiography", "autobio");
		Genre poe = new Genre("Poetry", "poetry");
		repo.save(his);
		repo.save(scifi);
		repo.save(df);
		repo.save(cf);
		repo.save(auto);
		repo.save(poe);
	}
	
	@Test void getGenre() {
		Genre genre = repo.findById(1).get();
		System.out.println(genre.getName());
	}
}
