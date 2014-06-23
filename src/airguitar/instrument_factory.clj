(ns airguitar.instrument-factory
  (:require [airguitar.instruments.beep]
            [airguitar.instruments.drums]
            [airguitar.instruments.piano])
  (:import  [airguitar.instruments Beep Drums Piano]))

(defn instrument-factory [^String type]
  (case type
    "beep"  (airguitar.instruments.Beep.)
    "drums" (airguitar.instruments.Drums.)
    "piano" (airguitar.instruments.Piano.)
    (airguitar.instruments.Piano.)))
