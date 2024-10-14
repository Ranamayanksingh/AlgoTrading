package try2DI

import com.google.inject.Guice

object MainApp2 extends App {
  val injector = Guice.createInjector(new AppModule)

  val mainClass = injector.getInstance(classOf[MainC])
  mainClass.run()

}
