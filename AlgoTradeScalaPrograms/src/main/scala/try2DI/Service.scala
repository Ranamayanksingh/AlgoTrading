package try2DI

import javax.inject.Singleton

trait Service {
  def doSomething():String
}

@Singleton
class ServiceImpl extends Service {
  override def doSomething(): String = "Hello from ServiceImpl"
}
