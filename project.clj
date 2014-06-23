(defproject airguitar "0.1.0"

  :main airguitar.core

  :description "Air guitar for leap motion"

  :aot :all

  :dependencies [[com.leapmotion/leap "1.0.0"]
                 [org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.3.1"]
                 [org.scala-lang/scala-library "2.9.1"]
                 [overtone "0.9.1"]]

  :plugins [[lein-localrepo "0.5.3"]
            [lein-scalac "0.1.0"]]

  :source-paths      ["src"]
  :java-source-paths ["src"]
  :scala-source-path  "src"

  :prep-tasks ["scalac"])
