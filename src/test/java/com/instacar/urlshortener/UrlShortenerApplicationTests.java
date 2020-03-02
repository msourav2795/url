package com.instacar.urlshortener;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.instacar.urlshortener.controller.UrlShortenerController;
import com.instacar.urlshortener.dto.ShortenUrl;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class UrlShortenerApplicationTests {
	@MockBean
	ValueOperations<String, String> valueOperations;

	 @Autowired
	 StringRedisTemplate stringRedisTemplate;
	 
	 @Autowired
	 UrlShortenerController controller;
	 
	 private MockMvc mvc;
	 private static String HTTP_EXAMPLE_COM = "http://example.com/";
	 private static String HASH = "f684a3c4";
	 private static String HASH_HTTP_EXAMPLE_COM = "https://url-shortener-9.herokuapp.com/s/"+HASH;

	@Test
	public void testCreation() throws Exception {
       ShortenUrl shortenUrl= new ShortenUrl();
       shortenUrl.setfullUrl(HTTP_EXAMPLE_COM);
       ResponseEntity<Object> obj = controller.getShortenUrl(shortenUrl);
       ShortenUrl urlObj=(ShortenUrl) obj.getBody();
		assertThat(urlObj.getshortUrl()).isEqualTo(HASH_HTTP_EXAMPLE_COM);
		System.out.println("Test passed");
	}

}
  