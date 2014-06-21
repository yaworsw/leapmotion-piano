(ns airguitar.instrument-factory
  (:import [airguitar InstrumentType]
           [airguitar.instruments Beep Piano]))

(defn instrument-factory [type]
  (if (string? type)
    (instrument-factory (. InstrumentType get type))
    (condp = type
      (. InstrumentType BEEP)  (new Beep)
      (. InstrumentType PIANO) (new Piano))))
