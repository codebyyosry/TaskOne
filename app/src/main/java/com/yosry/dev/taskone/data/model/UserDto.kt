package com.yosry.dev.taskone.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.yosry.dev.taskone.domain.model.User


@Entity(tableName = "users")
data class UserDto(
    @PrimaryKey val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phoneNumber") val phoneNumber: String,
    @SerializedName("age") val age: Int,
    @SerializedName("gender") val gender: String,
    @SerializedName("password") val password: String? = null, // optional
    val avatarUri: String? = null
)

fun UserDto.toDomain(): User = User(
    id = id,
    name = name,
    email = email,
    age = age,
    gender = gender,
    phoneNumber = phoneNumber,
    avatarUri = avatarUri
)

fun User.toDto(): UserDto = UserDto(
    id = id,
    name = name,
    email = email,
    phoneNumber = phoneNumber,
    age = age,
    gender = gender,
    avatarUri = avatarUri
)