name := "$name;format="Camel"$"

fork := true
test / javaOptions ++= Seq(
  "-Xms128M", "-Xmx256M",
  "-XX:MaxPermSize=256M",
  "-XX:+CMSClassUnloadingEnabled"
)

test / parallelExecution := false

version := "1.0"

scalaVersion := "$scalaVersion$"

libraryDependencies ++=
  Seq(

    "ch.qos.logback" % "logback-classic" % "1.4.5",
    "com.typesafe" % "config" % "1.4.2",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",

    "org.scalatest" %% "scalatest" % "3.2.14" % "test"
  )

assembly / mainClass := Some("$package$.Main")
assembly / assemblyJarName := "$name;format="Camel"$.jar"

assembly / assemblyMergeStrategy := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

