package lld.practice.property

import java.util.ArrayList
import java.util.HashMap

class ShortListRepo {
  private val shortlist: MutableMap<User, MutableList<Listing>> = HashMap()

  fun addToShortList(user: User, listingId: Listing) {
    if (!shortlist.containsKey(user)) {
      shortlist[user] = ArrayList()
    }

    shortlist[user]!!.add(listingId)
  }

  fun getListings(user: User): List<Listing> {
    return shortlist[user]?.toList() ?: emptyList()
  }
}