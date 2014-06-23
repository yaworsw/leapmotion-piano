(ns airguitar.basic-instrument)

(gen-interface
  :name    airguitar.BasicInstrument
  :methods [[play [long] void]])
