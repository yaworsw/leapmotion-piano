(ns airguitar.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:import  [com.leapmotion.leap Controller])
  (:use     [airguitar.detector-factory])
  (:gen-class
    :main true))

(Controller.) ; For some reason the JVM will crash if a leap controller isn't instantiated before main is ran

(defn cli-options
  "Command line arguments
  @see https://github.com/clojure/tools.cli"
  {  }
  [])

(defn -main
  "Application entry point"
  {  }
  [& args]
  (let [controller (Controller.)]
    (.addListener controller (detector-factory "piano" "beep"))))
