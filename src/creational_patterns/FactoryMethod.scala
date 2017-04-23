package creational_patterns

object FactoryMethod {
  /*
   "Define an interface for creating an object, but let subclasses decide which class
   to instantiate. The Factory method lets a class defer instantiation it uses to
   subclasses." (Gang Of Four)
   */

  // Static version (no overriding)

  abstract class Cocktail
  private class Martini extends Cocktail
  private class Vesper extends Cocktail

  object Cocktail{
    def apply(king: String): Cocktail = king match {
      case "martini" => new Martini
      case "vesper" => new Vesper
    }
  }

  // Classic version (with overriding)

  abstract class Ingredient
  private class Tomato extends Ingredient
  private class Cucumber extends Ingredient

  abstract class SimpleSalad{ // made of only one type of ingredient
    private var ingredients = List.empty[Ingredient]

    def addIngredient(): Unit ={
      ingredients ::= newIngredient()
    }

    abstract protected def newIngredient(): Ingredient
  }

  class TomatoSalad extends SimpleSalad{
    override protected def newIngredient(): Unit = new Tomato
  }

  class CucumberSalad extends SimpleSalad{
    override protected def newIngredient(): Ingredient = new Cucumber
  }
}
