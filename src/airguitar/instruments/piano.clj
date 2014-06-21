(ns airguitar.instruments.piano
  (:use [overtone.inst.piano])
  (:import [airguitar.Instrument])
  (:gen-class
    :name airguitar.instruments.Piano
    :implements [airguitar.Instrument]
    :constructors {[] []}
    :methods []))

(defn -play [this note]
  (piano note))
