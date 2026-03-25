package com.learnOw.server.module.auth.service;

import com.learnOw.server.module.user.model.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtService {
  @Value("${app.jwt.secret}")
  private String SIGNER_KEY;

  public String generateToken(User user) {

    try {
      JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
      JWTClaimsSet jwtClaimsSet =
          new JWTClaimsSet.Builder()
              .subject(user.getEmail())
              .issuer("learnOw.com")
              .issueTime(new Date())
              .claim("user name", user.getFullName())
              .expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()))
              .build();

      Payload payload = new Payload(jwtClaimsSet.toJSONObject());
      JWSObject jwsObject = new JWSObject(header, payload);
      jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
      return jwsObject.serialize();

    } catch (JOSEException e) {
      throw new RuntimeException(e);
    }
  }
}
