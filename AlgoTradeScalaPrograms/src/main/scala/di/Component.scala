package di

import com.google.inject.AbstractModule

import javax.inject.Singleton

@Singleton
class Component {
  def doSomething():String = "Hello From Component"
}
