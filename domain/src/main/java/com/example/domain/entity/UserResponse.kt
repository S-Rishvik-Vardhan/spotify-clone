package com.example.domain.entity

data class UserResponse(
  val email: String,
  val firstName: String,
  val lastName: String,
  val profileImage: String,
  val uid: String,
  val userName: String
)