name := "$name;format="Camel"$"

fork := true
javaOptions in test ++= Seq(
  "-Xms512M", "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

scalaVersion := "$scalaVersion$"
ensimeScalaVersion in ThisBuild := "$scalaVersion$"

libraryDependencies ++=
  Seq(
    "com.chuusai" %% "shapeless" % "2.3.2"
  )

mainClass in assembly := Some("$package$.Main")
assemblyJarName in assembly := "$name;format="Camel"$.jar"

assemblyMergeStrategy in assembly := {
  case PathList("reference.conf") => MergeStrategy.concat
  case x if x.endsWith("io.netty.versions.properties") => MergeStrategy.first
  case PathList("META-INF", _ @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

