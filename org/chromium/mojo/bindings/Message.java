package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.util.List;

public class Message {
  final ByteBuffer mBuffer;
  
  final List mHandles;
  
  private ServiceMessage mWithHeader;
  
  public Message(ByteBuffer paramByteBuffer, List paramList) {
    this.mBuffer = paramByteBuffer;
    this.mHandles = paramList;
  }
  
  public ServiceMessage asServiceMessage() {
    if (this.mWithHeader == null)
      this.mWithHeader = new ServiceMessage(this); 
    return this.mWithHeader;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */