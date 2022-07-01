package com.google.protobuf;

class GeneratedMessageInfoFactory implements MessageInfoFactory {
  private static final GeneratedMessageInfoFactory instance = new GeneratedMessageInfoFactory();
  
  public static GeneratedMessageInfoFactory getInstance() {
    return instance;
  }
  
  public boolean isSupported(Class<?> paramClass) {
    return GeneratedMessageLite.class.isAssignableFrom(paramClass);
  }
  
  public MessageInfo messageInfoFor(Class<?> paramClass) {
    if (GeneratedMessageLite.class.isAssignableFrom(paramClass))
      try {
        return (MessageInfo)GeneratedMessageLite.<GeneratedMessageLite<?, ?>>getDefaultInstance((Class)paramClass.asSubclass((Class)GeneratedMessageLite.class)).buildMessageInfo();
      } catch (Exception exception) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("Unable to get message info for ");
        stringBuilder1.append(paramClass.getName());
        throw new RuntimeException(stringBuilder1.toString(), exception);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Unsupported message type: ");
    stringBuilder.append(paramClass.getName());
    throw new IllegalArgumentException(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\GeneratedMessageInfoFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */