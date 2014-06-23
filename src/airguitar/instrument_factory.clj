(ns airguitar.instrument-factory
  (:use [airguitar.instruments.piano]))

(defn instrument-factory [^String type]
  (case type
    "piano" (airguitar.instruments.Piano.)
    (airguitar.instruments.Piano.)))
