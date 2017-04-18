name := "preowned-kittens"

version := "1.0"

scalaVersion := "2.10.5"

libraryDependencies += "org.specs2" % "specs2_2.10" % "1.14" % "test"

val gitHeadCommitSha = taskKey[String]("Det current git commit SHA")

gitHeadCommitSha := Process("git rev-parse HEAD").lines.head

val makeVersionProperties = taskKey[Seq[File]]("Make version.properties file")

makeVersionProperties := {
  val propFile = new File((resourceManaged in Compile).value, "version.properties")
  val content = f"version=${gitHeadCommitSha.value}"
  IO.write(propFile, content)
  Seq(propFile)
}

(resourceGenerators in Compile) <+= makeVersionProperties
