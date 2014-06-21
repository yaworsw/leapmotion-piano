(ns airguitar.core
  (:use [overtone.live]
        [airguitar.detector-factory])
  (:import [com.leapmotion.leap Controller]))

(def controller (new Controller))
(def detector   (detector-factory "piano" "beep"))

(defn -main [& args]
  (.addListener controller detector))
