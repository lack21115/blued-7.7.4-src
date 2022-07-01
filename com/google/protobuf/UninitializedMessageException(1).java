package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UninitializedMessageException extends RuntimeException {
  private static final long serialVersionUID = -7466929953374883507L;
  
  private final List<String> missingFields = null;
  
  public UninitializedMessageException(MessageLite paramMessageLite) {
    super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
  }
  
  public UninitializedMessageException(List<String> paramList) {
    super(buildDescription(paramList));
  }
  
  private static String buildDescription(List<String> paramList) {
    StringBuilder stringBuilder = new StringBuilder("Message missing required fields: ");
    Iterator<String> iterator = paramList.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      String str = iterator.next();
      if (bool) {
        bool = false;
      } else {
        stringBuilder.append(", ");
      } 
      stringBuilder.append(str);
    } 
    return stringBuilder.toString();
  }
  
  public InvalidProtocolBufferException asInvalidProtocolBufferException() {
    return new InvalidProtocolBufferException(getMessage());
  }
  
  public List<String> getMissingFields() {
    return Collections.unmodifiableList(this.missingFields);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UninitializedMessageException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */