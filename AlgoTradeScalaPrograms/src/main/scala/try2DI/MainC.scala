package try2DI

import com.google.inject.{Guice, Inject}

class MainC @Inject()(serviceImpl: ServiceImpl){
  def run():Unit = {
    val result = serviceImpl.doSomething()
    print(result)
  }
}
