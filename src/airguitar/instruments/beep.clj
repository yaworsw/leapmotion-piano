(ns airguitar.instruments.beep
  (:use     [airguitar.basic-instrument]
            [overtone.live])
  (:gen-class
    :name       airguitar.instruments.Beep
    :implements [airguitar.BasicInstrument]))

(definst beep [^long note 60]
  (let [sound-src (sin-osc (midicps note))
        env       (env-gen (perc 0.01 1.0) :action FREE)]
    (* sound-src env)))

(defn -play [this ^long note]
  (beep note))
