package com.lnw.mongodb.entity

/**
 * @author linnanwei
 * @version 1.0.0
 * @since 1.0.0
 * Date： 2019/11/11
 */
data class User(var name: String, var address: Address): Cloneable {
    public override fun clone(): User = (super.clone() as User)
        .apply {
            address = this.address.clone()
        }

}


data class Address(var city: String, var country: String): Cloneable {
    public override fun clone(): Address  = super.clone() as Address
}