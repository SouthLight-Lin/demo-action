package com.lnw.mongodb.entity

import java.util.*

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/8
 */
class UserInfo(var id: Long?, var name: String, var age: Int?, var birth: Date?) {

    override fun toString(): String {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", age=" + age +
                '}'.toString()
    }
}
