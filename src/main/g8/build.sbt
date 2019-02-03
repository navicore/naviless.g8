name := "$name;format="Camel"$"

fork := true
javaOptions in test ++= Seq(
  "-Xms128M", "-Xmx256M",
  "-XX:MaxPermSize=256M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

scalaVersion := "$scalaVersion$"

libraryDependencies ++=
  Seq(
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )

mainClass in assembly := Some("$package$.Main")
assemblyJarName in assembly := "$name;format="Camel"$.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

