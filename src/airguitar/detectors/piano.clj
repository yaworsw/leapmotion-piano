(ns airguitar.detectors.piano
  (:import [com.leapmotion.leap Controller Gesture Listener]
           [airguitar BasicInstrument GestureIterator])
  (:gen-class
    :name         airguitar.detectors.Piano
    :extends      [com.leapmotion.leap.Listener]
    :init         init
    :state        instrument))

(def key-tap-gesture
  (. com.leapmotion.leap.Gesture$Type TYPE_KEY_TAP))

(defn -init [^airguitar.BasicInstrument instrument]
  [[] instrument])

(defn -onConnect [this ^com.leapmotion.leap.Controller controller]
  (.enableGesture controller key-tap-gesture))

(defn -onFrame [this ^com.leapmotion.leap.Controller controller]
  (let [frame    (. controller frame)
        gestures (GestureIterator. (.getGestures frame))]
    (while (.hasNext gestures)
      (let [gesture (.next gestures)
            x       (int (.getX (.position gesture)))]
        (.play (.instrument this) x)))))
