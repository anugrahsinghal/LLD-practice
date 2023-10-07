package lld.practice.property

import lombok.RequiredArgsConstructor
import java.util.*

@RequiredArgsConstructor
class CommandDispatcher(
  private val scanner: Scanner,
  private val shortListRepo: ShortListRepo,
  private val userRepo: UserRepo,
  private val listingRepo: ListingRepo,
) {

  fun process(command: String): String {

    println("Processing $command")
    if (command == REGISTER) {
      // ensure user is uniq on name
      executeCreateUser()
      return "User Created"
    } else if (command == LIST_PROPERTY) {
      addPropertyListing()
      return "Property listed successfully."
    } else if (command == SEARCH) {
      // Todo
    } else if (command == SHORTLIST) {
      addPropertyToShortlist()

      return "Shortlisted property."
    } else if (command == VIEW_SHORTLISTED) {
      var listings = getShortlistedListings()

      // todo: transform output message
      return listings.toString()
    } else if (command == VIEW_LISTED) {
      var listings = getUserListings()

      // todo: transform output message
      return listings.toString()
    }

    return "INVALID COMMAND"
  }

  private fun executeCreateUser() {
    var input = scanner.nextLine()
    require(input != null || input != "")
    println(input)

    val user: User = User(input)

    userRepo.createUser(user)
  }

  private fun getUserListings(): List<Listing> {
    var input = scanner.nextLine()
    val user: User = toUser(input)

    return listingRepo.getUserListings(user)
  }

  private fun getShortlistedListings(): List<Listing> {
    var input = scanner.nextLine()
    val user: User = toUser(input)

    return shortListRepo.getListings(user)
  }

  private fun toUser(name: String): User {
    return userRepo.findUserByName(name)
  }

  private fun addPropertyToShortlist() {
    var input = scanner.nextLine()
    val (user: User, listingId: Int) = toUserAndPropertyId(input)
    val listing = listingRepo.getListing(listingId)
    require(listing != null)

    shortListRepo.addToShortList(user, listing)
  }

  private fun toUserAndPropertyId(input: String): Pair<User, Int> {
    val split = input.split(",")
    return Pair(userRepo.findUserByName(split[0]), split[1].toInt())
  }

  private fun addPropertyListing() {
    println("Enter Property Details:")
    var input = scanner.nextLine()
    val p: Listing = toPropertyListing(input)
    listingRepo.save(p)

  }

  private fun toPropertyListing(input: String): Listing {
    val split = input.split(",")


    val listing = Listing(
      title = split.find { it.contains("title") }!!.split(" ", limit = 2)[1],
      location = split.find { it.contains("location") }!!.split(" ", limit = 2)[1],
      listingType = ListingType.valueOf(split.find { it.contains("type") }!!.split(" ", limit = 2)[1]),
      rooms = split.find { it.contains("rooms") }!!.split(" ", limit = 2)[1],
      size = Size(split.find { it.contains("size") }!!.split(" ", limit = 2)[1].toInt(), SizeUnit.SQFT),
      price = Price(split.find { it.contains("price") }!!.split(" ", limit = 2)[1].toInt(), PriceUnit.THOUSAND),
      listingStatus = ListingStatus.AVAILABLE,
      owner = userRepo.findUserByName(split.find { it.contains("owner") }!!.split(" ", limit = 2)[1]),
      id = 1
    )

    return listing
  }


}
