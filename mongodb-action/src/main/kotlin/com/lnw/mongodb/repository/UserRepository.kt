package com.lnw.mongodb.repository

import com.lnw.mongodb.entity.UserInfo
import org.springframework.data.mongodb.repository.MongoRepository

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/8
 */
interface UserRepository : MongoRepository<UserInfo, Long>
