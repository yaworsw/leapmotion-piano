(ns airguitar.instrument-factory
  (:require [airguitar.instruments.beep]
            [airguitar.instruments.piano])
  (:import  [airguitar.instruments Beep Piano]))

(defn instrument-factory [^String type]
  (case type
    "beep"  (airguitar.instruments.Beep.)
    "piano" (airguitar.instruments.Piano.)
    (airguitar.instruments.Piano.)))
