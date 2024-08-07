package com.task.credmarg.worksync.authentication.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {
    Optional<UserDetails> findByEmailAndPassword(String email, String password);
}
