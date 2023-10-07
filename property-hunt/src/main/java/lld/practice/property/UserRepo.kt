package lld.practice.property

class UserRepo {
  private var users: MutableMap<String, User> = HashMap()

  fun findUserByName(name: String): User {
    if (users[name] == null) {
      throw RuntimeException("User not found")
    }
    return users[name]!!
  }

  fun createUser(user: User) {
    users[user.name] = user
  }

}