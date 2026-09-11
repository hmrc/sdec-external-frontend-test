lazy val root = (project in file("."))
  .settings(
    name := "sdec-external-frontend-test",
    version := "0.1.0",
    scalaVersion := "3.3.4",
    libraryDependencies ++= Dependencies.test,
    (Compile / compile) := ((Compile / compile) dependsOn (
      Compile / scalafmtSbtCheck,
      Compile / scalafmtCheckAll
    )).value,
    semanticdbEnabled := true,
    Test / fork := true,
    Test / javaOptions ++= Seq(
      "-Dbrowser=chrome",
      "-Denvironment=local",
      "-Dbrowser.option.headless=true",
      "-Dbrowser.usePreviousVersion=true"
    ),
    Test / parallelExecution := false
  )

addCommandAlias("prePrChecks", "; scalafmtCheckAll; scalafmtSbtCheck; scalafixAll --check")
addCommandAlias("lint", "; scalafmtAll; scalafmtSbt; scalafixAll")
addCommandAlias("prePush", "; reload; clean; compile; test; lint;")
