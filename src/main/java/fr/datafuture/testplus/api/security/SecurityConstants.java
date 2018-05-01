package fr.datafuture.testplus.api.security;

public class SecurityConstants {

	public static final String SECRET = "TestPlus_!:987SecretKeyToGenJWTs";
	// public static final long EXPIRATION_TIME_IN_MS = 14_400_000; // 4 heures
	public static final long EXPIRATION_TIME_IN_MS = 2*60*1000; // 2 minutes
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String ACCESS_AUTH_STRING = "accessToken";
	public static final String SIGN_UP_URL = "/api/public/accounts";
}
