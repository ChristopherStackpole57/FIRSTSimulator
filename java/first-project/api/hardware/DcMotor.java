package api.hardware;

import util.UnityMessage;
import util.UnityMessageQueue;

public class DcMotor {
  private String API_SOURCENAME = "api::eventloop::hardware::DcMotor";

  // private SOME_ID API_simID;

  //////////////////////////////////////////////////

  public enum Direction {
    REVERSE,
    FORWARD
  }

  //////////////////////////////////////////////////

  public DcMotor() {
    util.UnityMessageQueue.postMessage(new UnityMessage(
      API_SOURCENAME,
      util.UnityMessage.MessageType.POST,
      util.UnityMessage.ContentType.MAKE_OBJECT,
      null
    ));
  }

  //////////////////////////////////////////////////

  public Direction getDirection() {
    String direction = util.UnityMessageQueue.getMessage(new UnityMessage(
      API_SOURCENAME,
      util.UnityMessage.MessageType.POST,
      util.UnityMessage.ContentType.GET_STATE,
      null
      // API_someID.toString()
    ));

    try {
      return Direction.valueOf(direction);
    } catch (IllegalArgumentException e) {
      System.out.println("API returned bad value, what do we do???");
      return Direction.FORWARD;
    }
  }

  public void setDirection(Direction direction) {
    util.UnityMessageQueue.postMessage(new UnityMessage(
      API_SOURCENAME,
      util.UnityMessage.MessageType.POST,
      util.UnityMessage.ContentType.CHANGE_STATE,
      direction.name()
    ));
  }  
}