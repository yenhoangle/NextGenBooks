package com.nextgenbooks.admin.perspective;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Genre;
import com.nextgenbooks.common.entity.Perspective;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PerspectiveRepoTests {
	@Autowired
	private PerspectiveRepo repo;
	
	@Test
	public void testCreatePerspective() {
		Perspective p = new Perspective("Vietnamese American", "vietus");
		Genre epis = new Genre(1);
		Genre poe = new Genre(7);
		p.getGenres().add(epis);
		p.getGenres().add(poe);
		Perspective saved = repo.save(p);
		assertThat(saved.getId()).isGreaterThan(0);
	}
	@Test
	public void testCreateRest() {
		Genre epis = new Genre(1);
		Genre hisfic = new Genre(2);
		Genre scifi = new Genre(3);
		Genre domfic = new Genre(4);
		Genre confic = new Genre(5);
		Genre autobio = new Genre(6);
		Genre poe = new Genre(7);
		Perspective kj = new Perspective("Korean Japanese", "korjpn");
		kj.getGenres().add(hisfic);
		Perspective jb = new Perspective("Japanese British", "jpnbrit");
		jb.getGenres().add(scifi);
		Perspective ca = new Perspective("Chinese American", "chinus");
		ca.getGenres().add(hisfic);
		ca.getGenres().add(domfic);
		Perspective ka = new Perspective("Korean American", "korus");
		ka.getGenres().add(domfic);
		ka.getGenres().add(autobio);
		Perspective f = new Perspective("Filipino", "fil");
		f.getGenres().add(confic);
		
		repo.save(kj);
		repo.save(jb);
		repo.save(ca);
		repo.save(ka);
		repo.save(f);
	}
	
	@Test void getGenre() {
		Perspective p = repo.findById(1).get();
		System.out.println(p.getName());
	}

}
