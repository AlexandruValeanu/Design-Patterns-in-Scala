package creational_patterns

object AbstractFactory {
  /*
  The abstract factory pattern provides a way to encapsulate
  a group of individual factories that have a common theme without
  specifying their concrete classes

  Example adapted from wikipedia.
   */

  trait Button{
    def paint()
  }

  trait GUIFactory{
    def createButton(): Button
  }

  class LinuxFactory extends GUIFactory{
    override def createButton(): Button = new LinuxButton
  }

  class WindowsFactory extends GUIFactory{
    override def createButton(): Button = new WindowsButton
  }

  class LinuxButton extends Button{
    override def paint(): Unit = println("Linux button")
  }

  class WindowsButton extends Button{
    override def paint(): Unit = println("Windows button")
  }
}
