(ns airguitar.detector-factory
  (:use [airguitar.detectors.piano]
        [airguitar.instrument-factory]))

(defn detector-factory [^String type, ^String instrument-type]
  (let [instrument (instrument-factory instrument-type)]
    (case type
      "piano" (airguitar.detectors.Piano. instrument)
      (airguitar.detectors.Piano. instrument))))
