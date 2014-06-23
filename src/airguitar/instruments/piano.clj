(ns airguitar.instruments.piano
  (:use    [overtone.live]
           [overtone.inst.piano])
  (:import [airguitar BasicInstrument])
  (:gen-class
    :name       airguitar.instruments.Piano
    :implements [airguitar.BasicInstrument]))

(defn -play [this ^long note]
  (piano note))
