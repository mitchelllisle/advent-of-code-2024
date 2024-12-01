ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.20"

lazy val root = (project in file("."))
  .settings(
    name := "aoc"
  )

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.19" % Test,
  "org.slf4j" % "slf4j-api" % "2.0.16",
  "ch.qos.logback" % "logback-classic" % "1.4.12"
)
