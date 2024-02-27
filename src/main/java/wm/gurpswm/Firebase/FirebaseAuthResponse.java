package wm.gurpswm.Firebase;

public record FirebaseAuthResponse(
    String kind, String localId, String email, String displayName,
    String idToken, Boolean registered, String refreshToken, String expiresIn
    ) {}
