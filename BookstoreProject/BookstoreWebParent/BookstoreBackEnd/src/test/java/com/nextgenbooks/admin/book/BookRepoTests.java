package com.nextgenbooks.admin.book;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.nextgenbooks.common.entity.Book;
import com.nextgenbooks.common.entity.Genre;
import com.nextgenbooks.common.entity.Perspective;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class BookRepoTests {

	@Autowired
	private BookRepo repo;
	
	//for getting genres and perspectives in the db
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateBook() {
		Perspective vietus = entityManager.find(Perspective.class, 1 );
		Genre epis = entityManager.find(Genre.class, 1);
		Book book = new Book();
		book.setName("On Earth We're Briefly Gorgeous");
		book.setAlias("gorgeous");
		book.setAuthorFirst("Ocean");
		book.setAuthorLast("Vuong");
		book.setQuote("They say nothing lasts forever but they're just scared it will last longer than they can love it.");
		book.setDescription("On Earth We're Briefly Gorgeous is the debut novel by Vietnamese-American poet Ocean Vuong, "
				+ "published by Penguin Press on June 4, 2019. An epistolary novel, it is written in the form of a letter "
				+ "from a Vietnamese American son to his illiterate mother.");
		book.setPrice(24);
		book.setPageCount(256);
		book.setImage("gorgeous.png");
		
		book.setPerspective(vietus);
		book.setGenre(epis);
		Book savedBook = repo.save(book);
		assertThat(savedBook).isNotNull();
		assertThat(savedBook.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateRest() {
		//get all perspectives
		Perspective vietus = entityManager.find(Perspective.class, 1 );
		Perspective korjpn = entityManager.find(Perspective.class, 2 );
		Perspective jpnbrit = entityManager.find(Perspective.class, 3 );
		Perspective chinus = entityManager.find(Perspective.class, 4 );
		Perspective korus = entityManager.find(Perspective.class, 5 );
		Perspective fil = entityManager.find(Perspective.class, 6 );
		//get all genres
		Genre epis = entityManager.find(Genre.class, 1);
		Genre hisfic = entityManager.find(Genre.class, 2);
		Genre scifi = entityManager.find(Genre.class, 3);
		Genre domfic = entityManager.find(Genre.class, 4);
		Genre confic = entityManager.find(Genre.class, 5);
		Genre autobio = entityManager.find(Genre.class, 6);
		Genre poetry = entityManager.find(Genre.class, 7);
		
		Book pachinko = new Book();
		pachinko.setName("Pachinko");
		pachinko.setAlias("pachinko");
		pachinko.setAuthorFirst("Min Jin");
		pachinko.setAuthorLast("Lee");
		pachinko.setQuote("You want to see a very bad man? Make an ordinary man successful beyond his imagination. "
				+ "Let’s see how good he is when he can do whatever he wants.");
		pachinko.setDescription("Richly told and profoundly moving, Pachinko is a story of love, sacrifice, ambition, and loyalty. "
				+ "From bustling street markets to the halls of Japan's finest universities to the pachinko parlors of the "
				+ "criminal underworld, Lee's complex and passionate characters—strong, stubborn women, devoted sisters and sons, "
				+ "fathers shaken by moral crisis—survive and thrive against the indifferent arc of history.");
		pachinko.setPrice(17);
		pachinko.setPageCount(490);
		pachinko.setImage("pachinko.png");
		
		pachinko.setPerspective(korjpn);
		pachinko.setGenre(hisfic);
		repo.save(pachinko);
		
		Book klara = new Book();
		klara.setName("Klara and the Sun");
		klara.setAlias("klara");
		klara.setAuthorFirst("Kazuo");
		klara.setAuthorLast("Ishiguro");
		klara.setQuote("Perhaps all humans are lonely. At least potentially.");
		klara.setDescription("Klara and the Sun, the first novel by Kazuo Ishiguro since he was awarded the Nobel Prize in Literature, "
				+ "tells the story of Klara, an Artificial Friend with outstanding observational qualities, who, from her place in the store, "
				+ "watches carefully the behavior of those who come in to browse, and of those who pass on the street outside. "
				+ "She remains hopeful that a customer will soon choose her.");
		klara.setPrice(26);
		klara.setPageCount(307);
		klara.setImage("klara.png");
		
		klara.setPerspective(jpnbrit);
		klara.setGenre(scifi);
		repo.save(klara);
		
		Book gold = new Book();
		gold.setName("How Much of These Hills Is Gold");
		gold.setAlias("gold");
		gold.setAuthorFirst("C Pam");
		gold.setAuthorLast("Zhang");
		gold.setQuote("What real riches are? I could spend this gold tomorrow and it would belong to someone else. No. "
				+ "I want us rich in choices, that's something no one can take.");
		gold.setDescription("Both epic and intimate, blending Chinese symbolism and reimagined history with fiercely original language and storytelling, "
				+ "How Much of These Hills Is Gold is a haunting adventure story, an unforgettable sibling story, and the announcement of a stunning "
				+ "new voice in literature. On a broad level, it explores race in an expanding country and the question of where immigrants are allowed to belong. "
				+ "But page by page, it's about the memories that bind and divide families, and the yearning for home.");
		gold.setPrice(24);
		gold.setPageCount(288);
		gold.setImage("gold.png");
		
		gold.setPerspective(chinus);
		gold.setGenre(hisfic);
		repo.save(gold);
		
		Book luck = new Book();
		luck.setName("The Joy Luck Club");
		luck.setAlias("luck");
		luck.setAuthorFirst("Amy");
		luck.setAuthorLast("Tan");
		luck.setQuote("'Now you see,' said the turtle, drifting back into the pond, 'why it is useless to cry. Your tears do not wash away your sorrows. "
				+ "They feed someone else's joy. And that is why you must learn to swallow your own tears.");
		luck.setDescription("In 1949 four Chinese women, recent immigrants to San Francisco, begin meeting to eat dim sum, play mahjong, and talk. "
				+ "United in shared unspeakable loss and hope, they call themselves the Joy Luck Club. Rather than sink into tragedy, they choose to "
				+ "gather to raise their spirits and money.");
		luck.setPrice(16);
		luck.setPageCount(288);
		luck.setImage("luck.png");
		
		luck.setPerspective(chinus);
		luck.setGenre(domfic);
		repo.save(luck);
		
		Book feelings = new Book();
		feelings.setName("Minor Feelings: An Asian American Reckoning");
		feelings.setAlias("feelings");
		feelings.setAuthorFirst("Cathy Park");
		feelings.setAuthorLast("Hong");
		feelings.setQuote("But where does the silence that neglects her end, and where does the silence that respects her begin?");
		feelings.setDescription("Poet and essayist Cathy Park Hong fearlessly and provocatively blends memoir, cultural criticism, and history to "
				+ "expose fresh truths about racialized consciousness in America. Part memoir and part cultural criticism, this collection is vulnerable, "
				+ "humorous, and provocative—and its relentless and riveting pursuit of vital questions around family and friendship, art and politics, identity "
				+ "and individuality, will change the way you think about our world.");
		feelings.setPrice(20);
		feelings.setPageCount(224);
		feelings.setImage("feelings.png");
		
		feelings.setPerspective(korus);
		feelings.setGenre(autobio);
		repo.save(feelings);
		
		Book crying = new Book();
		crying.setName("Crying in H Mart: A Memoir");
		crying.setAlias("crying");
		crying.setAuthorFirst("Michelle");
		crying.setAuthorLast("Zauner");
		crying.setQuote("Hers was tougher than tough love. It was brutal, industrial-strength. A sinewy love that never gave way to an inch of weakness. It was a love that "
				+ "saw what was best for you ten steps ahead, and didn't care if it hurt like hell in the meantime.");
		crying.setDescription("From the indie rockstar of Japanese Breakfast fame, and author of the viral 2018 New Yorker essay that shares the title of this book, an unflinching, "
				+ "powerful memoir about growing up Korean American, losing her mother, and forging her own identity.");
		crying.setPrice(26);
		crying.setPageCount(256);
		crying.setImage("crying.png");
		
		crying.setPerspective(korus);
		crying.setGenre(autobio);
		repo.save(crying);
		
		Book dogeaters = new Book();
		dogeaters.setName("Dogeaters");
		dogeaters.setAlias("dogeaters");
		dogeaters.setAuthorFirst("Jessica");
		dogeaters.setAuthorLast("Hagedorn");
		dogeaters.setQuote("The Suffering Pilipino: We Pinoys suffer collectively from a cultural inferiority complex. We are doomed by our need for assimilation into the West "
				+ "and our own curious fatalism.");
		dogeaters.setDescription("A wildly disparate group of characters—from movie stars to waiters, from a young junkie to the richest man in the Philippines—becomes caught up in "
				+ "a spiral of events culminating in a beauty pageant, a film festival, and an assassination. In the center of this maelstrom is Rio, a feisty schoolgirl who will grow "
				+ "up to live in America and look back with longing on the land of her youth.");
		dogeaters.setPrice(22);
		dogeaters.setPageCount(272);
		dogeaters.setImage("dogeaters.png");
		
		dogeaters.setPerspective(fil);
		dogeaters.setGenre(confic);
		repo.save(dogeaters);
		
		Book wounds = new Book();
		wounds.setName("Night Sky with Exit Wounds");
		wounds.setAlias("wounds");
		wounds.setAuthorFirst("Ocean");
		wounds.setAuthorLast("Vuong");
		wounds.setQuote("How sweet. That rain. How something that lives only to fall can be nothing but sweet.");
		wounds.setDescription("Ocean Vuong's first full-length collection aims straight for the perennial \"big\"—and very human—subjects of romance, family, memory, grief, war, and melancholia. "
				+ "None of these he allows to overwhelm his spirit or his poems, which demonstrate, through breath and cadence and unrepentant enthrallment, that a gentle palm on a chest can calm "
				+ "the fiercest hungers.");
		wounds.setPrice(17);
		wounds.setPageCount(304);
		wounds.setImage("wounds.png");
		
		wounds.setPerspective(vietus);
		wounds.setGenre(poetry);
		repo.save(wounds);
	}
	
	@Test
	public void testForDelete() {
		Perspective vietus = entityManager.find(Perspective.class, 1 );
		Genre epis = entityManager.find(Genre.class, 1);
		Book book = new Book();
		book.setName("A Good Book");
		book.setAlias("book");
		book.setAuthorFirst("Cool");
		book.setAuthorLast("Author");
		book.setQuote("Very Cool Quote Here");
		book.setDescription("Short Description");
		book.setPrice(24);
		book.setPageCount(256);
		book.setImage("book.png");
		
		book.setPerspective(vietus);
		book.setGenre(epis);
		repo.save(book);
	}
	
}
