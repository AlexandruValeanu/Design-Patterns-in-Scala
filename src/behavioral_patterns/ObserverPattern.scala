package behavioral_patterns

import scala.collection.mutable.ArrayBuffer

class ObserverPattern {
  abstract class Observer {
    protected val subject: Subject
    abstract def update()
  }

  class Subject {
    private val observers = new ArrayBuffer[Observer]()
    private var _state = 0

    def add(observer: Observer): Unit ={
      observers += observer
    }

    def remove(observer: Observer): Unit ={
      observers -= observer
    }

    def state: Int = _state

    def state_=(newState: Int): Unit ={
      _state = newState
      notifyObservers()
    }

    private def notifyObservers(): Unit ={
      observers.foreach(ob => ob.update())
    }
  }

  class SimpleObserver(private [this] val sb: Subject) extends Observer{
    override protected val subject: Subject = sb

    override def update(): Unit = {
      println("simple observer " + sb.state)
    }
  }

  class ComplexObserver(private [this] val sb: Subject) extends Observer{
    override protected val subject: Subject = sb

    override def update(): Unit = {
      println("complex observer " + sb.state)
    }
  }
}
