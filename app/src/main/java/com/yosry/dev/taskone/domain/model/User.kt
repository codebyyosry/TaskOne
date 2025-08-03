package com.yosry.dev.taskone.domain.model

import com.yosry.dev.taskone.data.local.entity.UserEntity

data class User(
    val id: Long,
    val name: String,
    val email: String,
    val age: Int,
    val gender: String,
    val phoneNumber: String,
    val avatarUri: String? = null

)


fun User.toUpdateRequestDB(password: String? = null): UserEntity {
    return UserEntity(
        id = id,
        name = this.name,
        email = this.email,
        password = password,
        phoneNumber = this.phoneNumber,
        age = this.age,
        gender = this.gender,
    )
}