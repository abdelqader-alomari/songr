package com.example.songr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SongrApplicationTests<Albums> {
	Album albums = new Album("MyWay", "Frank Sinatra", 10, 1947,"https://th.bing.com/th/id/R.30f669b2967e9ab95bf74268c52f0f8a?rik=my6BBb79N6n%2bLQ&pid=ImgRaw&r=0");

	@Test
	public void constructorTest(){

		Assertions.assertNotNull(albums);
	}

	@Test
	public void setAndGetTest(){

		Album MyWay = new Album("MyWay", "Frank Sinatra", 10, 1947,"https://th.bing.com/th/id/R.30f669b2967e9ab95bf74268c52f0f8a?rik=my6BBb79N6n%2bLQ&pid=ImgRaw&r=0");
		assertEquals("Frank Sinatra", MyWay.getArtist());

		MyWay.setLength(2000);
		assertEquals(2000,MyWay.getLength());
	}

}
