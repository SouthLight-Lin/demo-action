package com.lnw.mongodb.entity

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/8
 */
class UserInfo(var id: Long?, var name: String, var age: Int?) {

    override fun toString(): String {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\''.toString() +
                ", age=" + age +
                '}'.toString()
    }
}
