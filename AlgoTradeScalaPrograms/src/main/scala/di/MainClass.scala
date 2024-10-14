package di

import com.google.inject.AbstractModule

import javax.inject.{Inject, Singleton}

@Singleton
class MainClass @Inject()(component: Component) extends AbstractModule{
  def run():Unit = {
    val result  = component.doSomething()
    print(result)
  }
}
