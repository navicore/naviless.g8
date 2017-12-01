lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4",
      libraryDependencies ++= Seq(
          "com.chuusai" %% "shapeless" % "2.3.2",
          "io.github.mkotsur" %% "aws-lambda-scala" % "0.0.7"

        )
    )),
    name := "naviless.g8"
  )
