package com.example.jawaclinicnew.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<com.example.jawaclinicnew.token.Token, Integer> {

  @Query(value = """
      select t from Token t inner join User u\s
      on t.user.userID = u.userID\s
      where u.userID = :id and (t.expired = false or t.revoked = false)\s
      """)
  List<com.example.jawaclinicnew.token.Token> findAllValidTokenByUser(Integer id);

  Optional<com.example.jawaclinicnew.token.Token> findByToken(String token);
}
