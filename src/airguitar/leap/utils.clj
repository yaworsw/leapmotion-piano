(ns airguitar.leap.utils
  (:import [com.leapmotion.leap
    CircleGesture
    Gesture
    GestureList
    KeyTapGesture
    ScreenTapGesture
    SwipeGesture]))

(def circle-gesture
  (. com.leapmotion.leap.Gesture$Type TYPE_CIRCLE))

(def swipe-gesture
  (. com.leapmotion.leap.Gesture$Type TYPE_SWIPE))

(def key-tap-gesture
  (. com.leapmotion.leap.Gesture$Type TYPE_KEY_TAP))

(def screen-tap-gesture
  (. com.leapmotion.leap.Gesture$Type TYPE_SCREEN_TAP))

(defn gesture-list-to-list [^GestureList gesture-list]
  (map #(let [gesture (.get gesture-list %)
              type    (.type gesture)]
    (condp = type
      circle-gesture     (CircleGesture.    gesture)
      swipe-gesture      (SwipeGesture.     gesture)
      key-tap-gesture    (KeyTapGesture.    gesture)
      screen-tap-gesture (ScreenTapGesture. gesture)
      gesture))
    (range (.count gesture-list))))
