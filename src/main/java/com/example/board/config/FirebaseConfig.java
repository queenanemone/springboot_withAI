package com.example.board.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig
{
	@Value("${firebase.database-url}")
	private String databaseUrl;
	
	/**
	 * FirebaseApp Bean 등록
	 * Firebase 초기화 및 설정
	 */
	@Bean
	public FirebaseApp firebaseApp() throws IOException
	{
		// Firebase 서비스 계정 키 파일 읽기
		InputStream serviceAccount = 
			new ClassPathResource("firebase-service-account.json").getInputStream();
		
		// Firebase 옵션 설정
		FirebaseOptions options = FirebaseOptions.builder()
			.setCredentials(GoogleCredentials.fromStream(serviceAccount))
			.setDatabaseUrl(databaseUrl)
			.build();
		
		// 중복 초기화 방지
		if (FirebaseApp.getApps().isEmpty())
		{
			return FirebaseApp.initializeApp(options);
		}
		
		return FirebaseApp.getInstance();
	}
	
	/**
	 * DatabaseReference Bean 등록
	 * Firebase Realtime Database 참조
	 */
	@Bean
	public DatabaseReference databaseReference(FirebaseApp firebaseApp)
	{
		return FirebaseDatabase.getInstance(firebaseApp)
			.getReference("boards");
	}
}