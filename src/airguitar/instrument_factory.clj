(ns airguitar.instrument-factory
  (:import [airguitar InstrumentType]))

(defn instrument-factory [type]
  (if (string? type)
    (instrument-factory (. InstrumentType get type))
    (.build type)))
