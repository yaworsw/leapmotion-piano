package airguitar

import com.leapmotion.leap._

abstract class Detector(instrument: Instrument) extends Listener {

  def getInstrument(): Instrument = instrument

  def onCircleGesture(gesture: CircleGesture) {

  }

  def onSwipeGesture(gesture: SwipeGesture) {

  }

  def onScreenTapGesture(gesture: ScreenTapGesture) {

  }

  def onKeyTapGesture(gesture: KeyTapGesture) {

  }

  private def onGesture(gesture: Gesture) {
    gesture match {
      case g: CircleGesture    => this.onCircleGesture(g)
      case g: SwipeGesture     => this.onSwipeGesture(g)
      case g: ScreenTapGesture => this.onScreenTapGesture(g)
      case g: KeyTapGesture    => this.onKeyTapGesture(g)
    }
  }

  override def onFrame(controller: Controller) {
    val frame: Frame = controller.frame
    val gestures: GestureList = frame.gestures()
    val gestureIterator: GestureIterator = new GestureIterator(gestures)
    gestureIterator.foreach(onGesture)
  }

}
