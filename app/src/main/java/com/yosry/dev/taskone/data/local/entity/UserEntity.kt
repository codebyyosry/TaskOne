package com.yosry.dev.taskone.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.yosry.dev.taskone.domain.model.User


@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("age") val age: Int,
    @SerializedName("gender") val gender: String,
    @SerializedName("password") val password: String? = null, // optional
    val avatarUri: String? = null
)

fun UserEntity.toDomain(): User = User(
    id = id,
    name = name,
    email = email,
    age = age,
    gender = gender,
    phoneNumber = phoneNumber,
    avatarUri = avatarUri
)

fun User.toDto(): UserEntity = UserEntity(
    id = id,
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    age = age,
    gender = gender,
    avatarUri = avatarUri
)