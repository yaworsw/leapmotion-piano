(ns airguitar.core
  (:use [overtone.live]
        [airguitar.detector-factory])
  (:import [com.leapmotion.leap Controller]
           [airguitar.detectors Piano]))

(def controller (new Controller))
(def detector   (detector-factory "piano" "piano"))

(defn -main [& args]
  (.addListener controller detector))
