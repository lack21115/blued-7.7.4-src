package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ServiceMessage extends Message {
  public final MessageHeader mHeader;
  
  private Message mPayload;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  ServiceMessage(Message paramMessage) {
    this(paramMessage, new MessageHeader(paramMessage));
  }
  
  public ServiceMessage(Message paramMessage, MessageHeader paramMessageHeader) {
    super(paramMessage.mBuffer, paramMessage.mHandles);
    assert false;
    throw new AssertionError();
  }
  
  public final ServiceMessage asServiceMessage() {
    return this;
  }
  
  public final Message getPayload() {
    if (this.mPayload == null) {
      ByteBuffer byteBuffer = ((ByteBuffer)this.mBuffer.position(this.mHeader.mDataHeader.size)).slice();
      byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.mPayload = new Message(byteBuffer, this.mHandles);
    } 
    return this.mPayload;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\ServiceMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */