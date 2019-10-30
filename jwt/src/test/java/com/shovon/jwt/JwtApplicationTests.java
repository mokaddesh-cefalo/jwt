package com.shovon.jwt;

import io.jsonwebtoken.Claims;
import org.assertj.core.error.ShouldBeAfterYear;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;

@SpringBootTest
class JwtApplicationTests {

	static double dude(int x){
		return x*1.5;
	}

	static String didi(int x){
		return "FUck";
	}

	static <R> void prin(Function<Integer, R> function){
		System.out.println(function.apply(1));
	}

	@Test
	void contextLoads() {
	    /*AuthenticationRequest authenticationRequest = new AuthenticationRequest("fish", "pass");
        System.out.println(authenticationRequest);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse("Auth");
        System.out.println(authenticationResponse);*/

		/*//prin(JwtApplicationTests::didi);
		JwtUtil jwtUtil = new JwtUtil();
		String token = jwtUtil.generateToken("fish");
		System.out.println(jwtUtil.extractClaim(token, Claims::getSubject));
		System.out.println(jwtUtil.extractClaim(token, JwtUtil::getRole));*/
	}

}
