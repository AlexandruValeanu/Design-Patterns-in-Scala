package creational_patterns

object FactoryMethod {
  /*
   "Define an interface for creating an object, but let subclasses decide which class
   to instantiate. The Factory method lets a class defer instantiation it uses to
   subclasses." (Gang Of Four)
   */

  trait Cocktail
  private class Martini extends Cocktail
  private class Vesper extends Cocktail

  object Cocktail{
    def apply(king: String): Cocktail = king match {
      case "martini" => new Martini
      case "vesper" => new Vesper
    }
  }
}
