import sbt._

class PrefuseProject(info: ProjectInfo) extends DefaultProject(info) {
   override def javaCompileOptions = super.javaCompileOptions ++ javaCompileOptions("-Xlint:unchecked", "-source", "1.4")
}
