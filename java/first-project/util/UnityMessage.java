package util;

public class UnityMessage {
  public enum MessageType {
    GET,
    POST
  }

  public enum ContentType {
    MAKE_OBJECT,
    DELETE_OBJECT,

    GET_STATE,
    CHANGE_STATE
  }

  //////////////////////////////////////////////////

  private String message;
  private MessageType messageType;

  //////////////////////////////////////////////////

  public UnityMessage(
    String sourceName,
    MessageType messageType,
    ContentType contentType,
    String arguments
  ) {
    if (arguments == null) {
      arguments = "";
    }

    message = String.format(
      "{\"sourceName\":\"%s\",\"messageType\":\"%s\",\"contentType\":\"%s\",\"arguments\":\"%s\"}",
      sourceName,
      messageType.name(),
      contentType.name(),
      arguments
    );
    this.messageType = messageType;
  }

  public String getMessage() {
    return message;  
  }
}