package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;

public interface MessagePipeHandle extends Handle {
  MessagePipeHandle pass();
  
  ResultAnd readMessage(MessagePipeHandle$ReadFlags paramMessagePipeHandle$ReadFlags);
  
  void writeMessage(ByteBuffer paramByteBuffer, List paramList, MessagePipeHandle$WriteFlags paramMessagePipeHandle$WriteFlags);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\MessagePipeHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */