import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) with AkkaProject with sbt_akka_bivy.AkkaKernelDeployment {
  // Compiler and distribution specific options
  override def compileOptions = super.compileOptions ++ Seq(Unchecked)
  override val artifactID = "basakkaly"

  // Project dependencies
  val akkaModuleConfig = ModuleConfiguration("se.scalablesolutions.akka", AkkaRepositories.Akka_Repository)
  val akkaKernel = akkaModule("kernel")
  val akkaSlf4j = akkaModule("slf4j")
  val logback = "ch.qos.logback" % "logback-classic" % "0.9.28"
  override def ivyXML =
    <dependencies>
      <exclude module="slf4j-simple"/>
    </dependencies>

  // Bivy configuration
  override def akkaKernelBootClass = "akka.kernel.Main"
  override def akkaBootScript = """#!/bin/sh
SCALA_VERSION=%s
SCRIPT=$(readlink -f $0)
export AKKA_HOME=`dirname $SCRIPT`
java -jar -server -Xss128k $AKKA_HOME/%s&
echo $! > $AKKA_HOME/akka.pid
""".format(buildScalaVersion, defaultJarPath(".jar").name)
}
