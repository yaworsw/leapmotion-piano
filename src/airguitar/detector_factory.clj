(ns airguitar.detector-factory
  (:use     [airguitar.instrument-factory])
  (:require [airguitar.detectors.piano])
  (:import  [airguitar.detectors Piano]))

(defn detector-factory [^String type, ^String instrument-type]
  (let [instrument (instrument-factory instrument-type)]
    (case type
      "piano" (airguitar.detectors.Piano. instrument)
      (airguitar.detectors.Piano. instrument))))
