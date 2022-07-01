package org.chromium.mojo.system;

import java.nio.ByteBuffer;
import java.util.List;

public final class InvalidHandle implements DataPipe$ConsumerHandle, DataPipe$ProducerHandle, MessagePipeHandle, SharedBufferHandle, UntypedHandle {
  public static final InvalidHandle INSTANCE = new InvalidHandle();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public final void close() {}
  
  public final Core getCore() {
    return null;
  }
  
  public final boolean isValid() {
    return false;
  }
  
  public final ByteBuffer map(long paramLong1, long paramLong2, SharedBufferHandle$MapFlags paramSharedBufferHandle$MapFlags) {
    throw new MojoException(3);
  }
  
  public final ResultAnd readMessage(MessagePipeHandle$ReadFlags paramMessagePipeHandle$ReadFlags) {
    throw new MojoException(3);
  }
  
  public final int releaseNativeHandle() {
    return 0;
  }
  
  public final DataPipe$ProducerHandle toDataPipeProducerHandle() {
    return this;
  }
  
  public final MessagePipeHandle toMessagePipeHandle() {
    return this;
  }
  
  public final SharedBufferHandle toSharedBufferHandle() {
    return this;
  }
  
  public final UntypedHandle toUntypedHandle() {
    return this;
  }
  
  public final void writeMessage(ByteBuffer paramByteBuffer, List paramList, MessagePipeHandle$WriteFlags paramMessagePipeHandle$WriteFlags) {
    throw new MojoException(3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\InvalidHandle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */