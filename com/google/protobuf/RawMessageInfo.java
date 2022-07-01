package com.google.protobuf;

final class RawMessageInfo implements MessageInfo {
  private final MessageLite defaultInstance;
  
  private final int flags;
  
  private final String info;
  
  private final Object[] objects;
  
  RawMessageInfo(MessageLite paramMessageLite, String paramString, Object[] paramArrayOfObject) {
    this.defaultInstance = paramMessageLite;
    this.info = paramString;
    this.objects = paramArrayOfObject;
    char c = paramString.charAt(0);
    if (c < '?') {
      this.flags = c;
      return;
    } 
    int j = c & 0x1FFF;
    int i = 13;
    c = '\001';
    while (true) {
      char c1 = paramString.charAt(c);
      if (c1 >= '?') {
        j |= (c1 & 0x1FFF) << i;
        i += 13;
        int k = c + 1;
        continue;
      } 
      this.flags = j | c1 << i;
      return;
    } 
  }
  
  public MessageLite getDefaultInstance() {
    return this.defaultInstance;
  }
  
  Object[] getObjects() {
    return this.objects;
  }
  
  String getStringInfo() {
    return this.info;
  }
  
  public ProtoSyntax getSyntax() {
    return ((this.flags & 0x1) == 1) ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
  }
  
  public boolean isMessageSetWireFormat() {
    return ((this.flags & 0x2) == 2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\RawMessageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */