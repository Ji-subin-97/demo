package com.example.demo.hello;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.domain.JpaMemberRepository;
import com.example.demo.domain.MemberRepository;
import com.example.demo.domain.MemberService;
import com.example.demo.domain.MemoryMemberRepository;

@Configuration
public class SpringConfig {
	
	private EntityManager em;
	
	@Autowired
	public SpringConfig(EntityManager em) {
		this.em = em;
	}

	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new JpaMemberRepository(em);
	}
}
