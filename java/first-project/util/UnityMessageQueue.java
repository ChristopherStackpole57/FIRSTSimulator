package util;

import util.UnityMessage;

public class UnityMessageQueue {
  private UnityMessageQueue() {

  }

  public static native void dispatchToJavaScript(String message);

  public static String getMessage(UnityMessage message) {
    // TODO(ChristopherStackpole): Implement
    return "";
  }

  public static void postMessage(UnityMessage message) {
    System.out.println("[Java] Emitting Message to Javascript: " + message.getMessage());
    dispatchToJavaScript(message.getMessage());
  }
}