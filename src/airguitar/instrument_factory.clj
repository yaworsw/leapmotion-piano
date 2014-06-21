(ns airguitar.instrument-factory
  (:import [airguitar InstrumentType]
           [airguitar.instruments Piano]))

(defn instrument-factory [type]
  (if (string? type)
    (instrument-factory (. InstrumentType get type))
    (condp = type
      (. InstrumentType PIANO) (new Piano))))
