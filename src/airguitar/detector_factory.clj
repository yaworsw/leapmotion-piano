(ns airguitar.detector-factory
  (:import [airguitar DetectorType])
  (:use [airguitar.instrument-factory]))

(defn detector-factory [type, instrument-type]
  (if (string? type)
    (detector-factory (. DetectorType get type) instrument-type)
    (let [instrument (instrument-factory instrument-type)]
      (.build type instrument))))
