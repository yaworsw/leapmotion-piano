(ns airguitar.core
  (:use [overtone.live]
        [airguitar.detector-factory])
  (:import [com.leapmotion.leap Controller]
           [airguitar.detectors Drums]))

(def controller (new Controller))
(def detector   (detector-factory "piano" "piano"))

(defn -main [& args]
  (.addListener controller detector))
