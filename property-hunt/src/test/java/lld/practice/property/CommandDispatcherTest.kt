package lld.practice.property

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CommandDispatcherTest {




  @Test
  fun test()  {
    val commandDispatcher = CommandDispatcher(
      ShortListRepo(),
      UserRepo(),
      ListingRepo()
    )

    commandDispatcher.process(VIEW_SHORTLISTED)

  }
}