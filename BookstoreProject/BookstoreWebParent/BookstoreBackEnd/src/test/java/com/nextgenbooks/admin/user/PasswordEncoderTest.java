package com.nextgenbooks.admin.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.matches;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
	@Test
	public void testEncodePassword() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String raw = "123";
		String encoded = passwordEncoder.encode(raw);
		System.out.println(encoded);
		boolean match = passwordEncoder.matches(raw,  encoded);
		assertThat(match).isTrue();
	}

}
