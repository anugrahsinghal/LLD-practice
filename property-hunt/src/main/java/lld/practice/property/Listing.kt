package lld.practice.property

class Listing(
  var id: Int,
  var title: String,
  var location: String,
  var price: Price,
  var size: Size,
  var rooms: String,
  var listingType: ListingType,
  var listingStatus: ListingStatus,
  var owner: User
) {


  fun isAvailable(): ListingStatus {
    return this.listingStatus
  }

  override fun toString(): String {
    return "Listing(id=$id, title='$title', location='$location', price=$price, size=$size, rooms='$rooms', listingType=$listingType, listingStatus=$listingStatus, owner=$owner)"
  }
}

enum class ListingStatus {
  SOLD,
  AVAILABLE
}

enum class ListingType {
  RENT,
  SELL
}

class Size(
  val value: Int,
  val unit: SizeUnit
) {
  fun standardize(s: Size): Size {
    return Size(unit.toSQFT(s.value), SizeUnit.SQFT)
  }
}

class Price(
  val value: Int,
  val unit: PriceUnit
) {
  fun standardize(p: Price): Price {
    return Price(unit.toThousand(price = p.value), PriceUnit.THOUSAND)
  }
}

enum class PriceUnit(val unit: String, val multiplierForThousand: Int = 1) {
  THOUSAND("", 1),
  K("K", 1_000),
  CRORE("CR", 1_00_00_000),
  LAKH("L", 1_00_000);

  fun toThousand(price: Int): Int = price * multiplierForThousand
}

enum class SizeUnit(val unit: String, val multiplierForSQFT: Double) {
  SQFT("sqft", 1.0),
  SQYARD("sqyard", 9.0),
  SQMETER("sqmeter", 10.764);

  fun toSQFT(size: Int): Int = (size * multiplierForSQFT).toInt()
}