(ns airguitar.detector-factory
  (:import [airguitar DetectorType]
           [airguitar.detectors Piano])
  (:use [airguitar.instrument-factory]))

(defn detector-factory [type, instrument-type]
  (if (string? type)
    (detector-factory (. DetectorType get type) instrument-type)
    (let [instrument (instrument-factory instrument-type)]
      (condp = type
        (. DetectorType PIANO) (new Piano instrument)))))
