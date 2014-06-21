package airguitar.detectors

import airguitar.Detector
import airguitar.Instrument
import airguitar.GestureIterator

import com.leapmotion.leap._
import com.leapmotion.leap.Gesture.State

class Piano(instrument: Instrument) extends Detector(instrument: Instrument) {

  override def onConnect(controller: Controller) {
    controller.enableGesture(Gesture.Type.TYPE_KEY_TAP)
  }

  override def onKeyTapGesture(gesture: KeyTapGesture) {
    val x: Float = gesture.position().getX()
    var n: Int   = ((((x + 120) * 50) / 240) + 50).toInt;
    super.getInstrument().play(n)
  }

}
