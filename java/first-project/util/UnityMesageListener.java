package util;

import util.UnityMessage;

@FunctionalInterface
public interface UnityMessageListener {
  void onMessage(UnityMessage message);
}