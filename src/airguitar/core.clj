(ns airguitar.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:import  [com.leapmotion.leap Controller])
  (:use     [airguitar.detector-factory])
  (:gen-class
    :main true))


(def controller (Controller.))
(def detector   (detector-factory "piano" "drums"))

(defn cli-options
  "Command line arguments
  @see https://github.com/clojure/tools.cli"
  {  }
  [])

(defn -main
  "Application entry point"
  {  }
  [& args]
  (.addListener controller detector))
