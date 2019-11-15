package com.lnw.mongodb;

import java.util.Optional;

import com.lnw.mongodb.entity.UserInfo;
import com.lnw.mongodb.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/8
 */
@SpringBootTest
public class MongoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testAddUser() {
        final UserInfo userInfo = new UserInfo(1615432L, "LNW", 24);
        Assertions.assertNotNull(this.userRepository.insert(userInfo));
    }

    @Test
    void testQueryUser() {
        final Optional<UserInfo> result = this.userRepository.findById(1615431L);
        Assertions.assertNotNull(result.get());
        System.out.println(result.get());
    }

}
