import sbt._

class PrefuseProject(info: ProjectInfo) extends ParentProject(info) {
   lazy val core  = project("core", "prefuse", new Core(_))
   lazy val demos = project("demos", "prefuse-demos", new Demos(_), core)
      
   class Core(info: ProjectInfo) extends DefaultProject(info) {
      override def javaCompileOptions = super.javaCompileOptions ++ 
         javaCompileOptions("-Xlint:unchecked", "-source", "1.4")
         
      val junit = "junit" % "junit" % "3.8.1" % "test->default"

      override def disableCrossPaths = true
   }

   class Demos(info: ProjectInfo) extends DefaultProject(info) {
      override def javaCompileOptions = super.javaCompileOptions ++ 
         javaCompileOptions("-Xlint:unchecked", "-source", "1.4")
      
      def extraResources = "data"
      override def mainResources = super.mainResources +++ extraResources
         
      override def mainClass = Some("prefuse.demos.Demos")
      override def disableCrossPaths = true
   }

   def doNothing = task { None }
   override def publishLocalAction = doNothing
   override def deliverLocalAction = doNothing
   override def publishAction = doNothing
   override def deliverAction = doNothing
}
