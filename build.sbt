import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version      := "0.0.1"
    )),
    name := "kips",
    libraryDependencies += scalaTest % Test
  )
