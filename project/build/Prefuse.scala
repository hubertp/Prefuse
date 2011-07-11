import sbt._

class PrefuseProject(info: ProjectInfo) extends ParentProject(info) {
   lazy val core  = project("core", "core", new Core(_))
   lazy val demos = project("demos", "demos", new Demos(_), core)
   
   class Core(info: ProjectInfo) extends DefaultProject(info) {
      override def javaCompileOptions = super.javaCompileOptions ++ 
         javaCompileOptions("-Xlint:unchecked", "-source", "1.4")
         
      val junit = "junit" % "junit" % "3.8.1" % "test->default"
   }

   class Demos(info: ProjectInfo) extends DefaultProject(info) {
      override def javaCompileOptions = super.javaCompileOptions ++ 
         javaCompileOptions("-Xlint:unchecked", "-source", "1.4")
      
      def extraResources = "data"
      override def mainResources = super.mainResources +++ extraResources
         
      override def mainClass = Some("prefuse.demos.Demos")
   }
}
