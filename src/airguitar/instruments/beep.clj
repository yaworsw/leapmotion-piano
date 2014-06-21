(ns airguitar.instruments.beep
  (:use [overtone.live])
  (:import [airguitar.Instrument])
  (:gen-class
    :name airguitar.instruments.Beep
    :implements [airguitar.Instrument]
    :constructors {[] []}
    :methods []))

(definst beep [note 60]
  (let [sound-src (sin-osc (midicps note))
        env       (env-gen (perc 0.01 1.0) :action FREE)]
    (* sound-src env)))

(defn -play [this note]
  (beep note))
