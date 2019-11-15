package com.lnw.mongodb

import com.lnw.mongodb.entity.Address
import com.lnw.mongodb.entity.User

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/11
 */
fun main(args: Array<String>) {
    // 拷贝

    /**-------------------------------------------**/
    // 方法一：构造函数，在调用构造函数的时候进行深拷贝
    constructorClone()

    /**-------------------------------------------**/
    // 方法二：重载clone方法，实现Cloneable接口
    overrideCloneMethod()
}

fun constructorClone() {
    val address = Address("广东", "中国")
    val user = User("SouthLight-Lin", address)
    // 调用构造函数进行深拷贝
    val copy = User(user.name, Address(address.city, address.country))
    // 修改源对象的值
    user.address.city = "深圳"
    // 检查两个对象的值不同
    println(user.address.city == copy.address.city)  // false
}

fun overrideCloneMethod() {
    val address = Address("广东", "中国")
    val user = User("SouthLight-Lin", address)
    // 调用clone()方法进行深拷贝
    val copyUser = user.clone()
    // 修改源对象
    user.address.city = "深圳"
    // 检查两个对象的值不同
    println(user.address.city == copyUser.address.city)  // false
}