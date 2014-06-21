package airguitar

import com.leapmotion.leap._

class GestureIterator(gestures: GestureList) extends Iterator[Gesture] {
  var i     = 0
  val count = gestures.count()

  def hasNext(): Boolean = i < count

  def next(): Gesture = {
    val gesture = gestures.get(i)
    i = i + 1
    gesture.`type` match {
      case Gesture.Type.TYPE_CIRCLE     => new CircleGesture(gesture)
      case Gesture.Type.TYPE_SWIPE      => new SwipeGesture(gesture)
      case Gesture.Type.TYPE_SCREEN_TAP => new ScreenTapGesture(gesture)
      case Gesture.Type.TYPE_KEY_TAP    => new KeyTapGesture(gesture)
    }
  }
}
