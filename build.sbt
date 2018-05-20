name := """SampleAng4"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"
//we use nodejs to make our typescript build as fast as possible
JsEngineKeys.engineType := JsEngineKeys.EngineType.Node

resolvers ++= Seq(
  Resolver.jcenterRepo,
  Resolver.bintrayRepo("webjars","maven")
)


// use the webjars npm directory (target/web/node_modules ) for resolution of module imports of angular2/core etc
resolveFromWebjarsNodeModulesDir := true

// Compile the project before generating Eclipse files, so that generated .scala or .class files for views and routes are present
EclipseKeys.preTasks := Seq(compile in Compile, compile in Test)
PlayKeys.externalizeResources := false

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  javaJpa,
  "org.hibernate" % "hibernate-entitymanager" % "5.1.0.Final",
  "com.h2database" % "h2" % "1.4.192",
  "org.webjars.npm" % "minimatch" % "3.0.0",
  "org.webjars.npm" % "glob" % "7.1.2",
  "org.webjars" %% "webjars-play" % "2.6.1",
  "org.webjars" % "bootstrap" % "3.1.1-2",
  "org.webjars" % "typescript" % "1.5.3",
  "org.webjars.npm" % "angular__common" % "4.2.5",
    "org.webjars.npm" % "angular__compiler" % "4.2.5",
    "org.webjars.npm" % "angular__core" % "4.2.5",
    "org.webjars.npm" % "angular__http" % "4.2.5",
    "org.webjars.npm" % "angular__forms" % "4.2.5",
    "org.webjars.npm" % "angular__router" % "4.2.5",
    "org.webjars.npm" % "angular__platform-browser-dynamic" % "4.2.5",
    "org.webjars.npm" % "angular__platform-browser" % "4.2.5",
    "org.webjars.npm" % "systemjs" % "0.20.14",
    "org.webjars.npm" % "rxjs" % "5.4.2",
    "org.webjars.npm" % "reflect-metadata" % "0.1.8",
    "org.webjars.npm" % "zone.js" % "0.8.4",
     "org.webjars.npm" % "core-js" % "2.4.1",
    "org.webjars.npm" % "symbol-observable" % "1.0.1"
	
)
