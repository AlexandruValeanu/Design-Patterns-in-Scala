package creational_patterns

object LazyInitialization {
  /*
  Lazy initialization is a special case of lazy evaluation strategy.
  It’s a technique that initializes a value (or an object) on its first access.
  Lazy initialization allows to defer (or avoid) some expensive computation.

  Lazy values in Scala can hold null values.
  Access to lazy value is thread-safe.
   */

  lazy val x: Int = {
    println("computing x")
    42
  }
}
