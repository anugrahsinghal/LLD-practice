package lld.practice.property

import java.util.HashMap

class ListingRepo {
  private val properties: MutableMap<Int, Listing> = HashMap()

  fun getUserListings(user: User): List<Listing> {
    return properties.values.filter { it.owner == user }
  }

  fun search(
    location: String?,
    priceStart: Int?,
    priceEnd: Int?,
    sizeStart: Double?,
    sizeEnd: Double?,
    rooms: String?,
    listingType: String?,
    sortOn: String,
  ): List<Listing> {

    var locationFilter: (Listing) -> Boolean = { true } // default filter that lets everything pass
    if (location != null) {
      locationFilter = { it.location.lowercase() == location.lowercase() }
    }

    var roomsFilter: (Listing) -> Boolean = { true } // default filter that lets everything pass
    if (rooms != null) {
      roomsFilter = { it.rooms == rooms }
    }

    var sizeFilter: (Listing) -> Boolean = { true } // default filter that lets everything pass
    if (sizeStart != null && sizeEnd != null) {
      sizeFilter = { it.size.value >= sizeStart && it.size.value <= sizeEnd }
    }

    var priceFilter: (Listing) -> Boolean = { true } // default filter that lets everything pass
    if (priceStart != null && priceEnd != null) {
      priceFilter = { it.size.value >= priceStart && it.size.value <= priceEnd }
    }

    var listingTypeFilter: (Listing) -> Boolean = { true } // default filter that lets everything pass
    if (listingType != null) {
      listingTypeFilter = { it.listingType == ListingType.valueOf(listingType) }
    }


    // chain the filters
    var sortCriteria: (Listing) -> Int? = { 1 }
    if (sortOn.lowercase() == "price") {
      sortCriteria = { it.price.value }
    }
    if (sortOn.lowercase() == "size") {
      sortCriteria = { it.size.value }
    }

    var filteredProperties =
      properties.values
        .filter(locationFilter)
        .filter(roomsFilter)
        .filter(listingTypeFilter)
        .filter(priceFilter)
        .filter(sizeFilter)
        .sortedBy(sortCriteria)

    return filteredProperties

  }

  fun save(listing: Listing) {
    properties[listing.id] = listing
  }

  fun getListing(listingId: Int): Listing? {
    return properties.values.find { it.id == listingId }
  }
}