package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Flags;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.ResultAnd;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.UntypedHandle;
import org.chromium.mojo.system.Watcher;

public class CoreImpl implements Core {
  private final int mByteBufferOffset = nativeGetNativeBufferOffset(ByteBuffer.allocateDirect(8), 8);
  
  final ThreadLocal mCurrentRunLoop = new ThreadLocal();
  
  private CoreImpl() {}
  
  public static Core getInstance() {
    return CoreImpl$LazyHolder.access$100();
  }
  
  private native ResultAnd nativeBeginReadData(int paramInt1, int paramInt2, int paramInt3);
  
  private native ResultAnd nativeBeginWriteData(int paramInt1, int paramInt2, int paramInt3);
  
  private native ResultAnd nativeCreateDataPipe(ByteBuffer paramByteBuffer);
  
  private native ResultAnd nativeCreateMessagePipe(ByteBuffer paramByteBuffer);
  
  private native ResultAnd nativeCreateSharedBuffer(ByteBuffer paramByteBuffer, long paramLong);
  
  private native ResultAnd nativeDuplicate(int paramInt, ByteBuffer paramByteBuffer);
  
  private native int nativeEndReadData(int paramInt1, int paramInt2);
  
  private native int nativeEndWriteData(int paramInt1, int paramInt2);
  
  private native int nativeGetNativeBufferOffset(ByteBuffer paramByteBuffer, int paramInt);
  
  private native long nativeGetTimeTicksNow();
  
  private native int nativeQueryHandleSignalsState(int paramInt, ByteBuffer paramByteBuffer);
  
  private native ResultAnd nativeReadData(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  private native int nativeUnmap(ByteBuffer paramByteBuffer);
  
  private native ResultAnd nativeWriteData(int paramInt1, ByteBuffer paramByteBuffer, int paramInt2, int paramInt3);
  
  @CalledByNative
  private static ResultAnd newNativeCreationResult(int paramInt1, int paramInt2, int paramInt3) {
    return new ResultAnd(paramInt1, new CoreImpl$IntegerPair(Integer.valueOf(paramInt2), Integer.valueOf(paramInt3)));
  }
  
  @CalledByNative
  private static ResultAnd newReadMessageResult(int paramInt, byte[] paramArrayOfbyte, int[] paramArrayOfint) {
    MessagePipeHandle.ReadMessageResult readMessageResult = new MessagePipeHandle.ReadMessageResult();
    if (paramInt == 0) {
      readMessageResult.mData = paramArrayOfbyte;
      readMessageResult.mRawHandles = paramArrayOfint;
    } 
    return new ResultAnd(paramInt, readMessageResult);
  }
  
  @CalledByNative
  private static ResultAnd newResultAndBuffer(int paramInt, ByteBuffer paramByteBuffer) {
    return new ResultAnd(paramInt, paramByteBuffer);
  }
  
  @CalledByNative
  private static ResultAnd newResultAndInteger(int paramInt1, int paramInt2) {
    return new ResultAnd(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public final UntypedHandle acquireNativeHandle(int paramInt) {
    return new UntypedHandleImpl(this, paramInt);
  }
  
  final ByteBuffer allocateDirectBuffer(int paramInt) {
    ByteBuffer byteBuffer2 = ByteBuffer.allocateDirect(paramInt + this.mByteBufferOffset);
    ByteBuffer byteBuffer1 = byteBuffer2;
    if (this.mByteBufferOffset != 0) {
      byteBuffer2.position(this.mByteBufferOffset);
      byteBuffer1 = byteBuffer2.slice();
    } 
    return byteBuffer1.order(ByteOrder.nativeOrder());
  }
  
  public final Pair createMessagePipe(MessagePipeHandle.CreateOptions paramCreateOptions) {
    if (paramCreateOptions != null) {
      ByteBuffer byteBuffer2 = allocateDirectBuffer(8);
      byteBuffer2.putInt(0, 8);
      byteBuffer2.putInt(4, ((Flags)paramCreateOptions.mFlags).mFlags);
      ByteBuffer byteBuffer1 = byteBuffer2;
    } else {
      paramCreateOptions = null;
    } 
    ResultAnd resultAnd = nativeCreateMessagePipe((ByteBuffer)paramCreateOptions);
    if (resultAnd.mMojoResult == 0)
      return new Pair(new MessagePipeHandleImpl(this, ((Integer)((CoreImpl$IntegerPair)resultAnd.mValue).first).intValue()), new MessagePipeHandleImpl(this, ((Integer)((CoreImpl$IntegerPair)resultAnd.mValue).second).intValue())); 
    throw new MojoException(resultAnd.mMojoResult);
  }
  
  public final SharedBufferHandle createSharedBuffer(SharedBufferHandle.CreateOptions paramCreateOptions, long paramLong) {
    if (paramCreateOptions != null) {
      ByteBuffer byteBuffer2 = allocateDirectBuffer(8);
      byteBuffer2.putInt(0, 8);
      byteBuffer2.putInt(4, ((Flags)paramCreateOptions.mFlags).mFlags);
      ByteBuffer byteBuffer1 = byteBuffer2;
    } else {
      paramCreateOptions = null;
    } 
    ResultAnd resultAnd = nativeCreateSharedBuffer((ByteBuffer)paramCreateOptions, paramLong);
    if (resultAnd.mMojoResult == 0)
      return new SharedBufferHandleImpl(this, ((Integer)resultAnd.mValue).intValue()); 
    throw new MojoException(resultAnd.mMojoResult);
  }
  
  public final Watcher getWatcher() {
    return new WatcherImpl();
  }
  
  native int nativeClose(int paramInt);
  
  native ResultAnd nativeMap(int paramInt1, long paramLong1, long paramLong2, int paramInt2);
  
  native ResultAnd nativeReadMessage(int paramInt1, int paramInt2);
  
  native int nativeWriteMessage(int paramInt1, ByteBuffer paramByteBuffer1, int paramInt2, ByteBuffer paramByteBuffer2, int paramInt3);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\CoreImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */