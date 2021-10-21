package logic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Crypto {
	
	public String encrypt(String plaintext) {
		
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] hashedPassword = md.digest(plaintext.getBytes(Charset.forName("UTF-8")));
		String hash = new String(hashedPassword,Charset.forName("UTF-8"));
		
		return hash;
	}
	
	public String decrypt(String ciphertext) {
		return "todo";
	}

}
