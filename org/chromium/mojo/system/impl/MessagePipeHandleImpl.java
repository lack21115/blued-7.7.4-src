package org.chromium.mojo.system.impl;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.chromium.mojo.system.Flags;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.MojoException;
import org.chromium.mojo.system.ResultAnd;

final class MessagePipeHandleImpl extends HandleBase implements MessagePipeHandle {
  MessagePipeHandleImpl(CoreImpl paramCoreImpl, int paramInt) {
    super(paramCoreImpl, paramInt);
  }
  
  MessagePipeHandleImpl(HandleBase paramHandleBase) {
    super(paramHandleBase);
  }
  
  public final MessagePipeHandle pass() {
    return new MessagePipeHandleImpl(this);
  }
  
  public final ResultAnd readMessage(MessagePipeHandle.ReadFlags paramReadFlags) {
    CoreImpl coreImpl = this.mCore;
    ResultAnd resultAnd = coreImpl.nativeReadMessage(this.mMojoHandle, ((Flags)paramReadFlags).mFlags);
    if (resultAnd.mMojoResult == 0 || resultAnd.mMojoResult == 17) {
      MessagePipeHandle.ReadMessageResult readMessageResult = (MessagePipeHandle.ReadMessageResult)resultAnd.mValue;
      int[] arrayOfInt = readMessageResult.mRawHandles;
      int i = 0;
      if (arrayOfInt != null && arrayOfInt.length != 0) {
        readMessageResult.mHandles = new ArrayList(arrayOfInt.length);
        int j = arrayOfInt.length;
        while (i < j) {
          int k = arrayOfInt[i];
          readMessageResult.mHandles.add(new UntypedHandleImpl(coreImpl, k));
          i++;
        } 
      } else {
        readMessageResult.mHandles = new ArrayList(0);
      } 
      return resultAnd;
    } 
    throw new MojoException(resultAnd.mMojoResult);
  }
  
  public final void writeMessage(ByteBuffer paramByteBuffer, List paramList, MessagePipeHandle.WriteFlags paramWriteFlags) {
    ByteBuffer byteBuffer;
    CoreImpl coreImpl = this.mCore;
    if (paramList != null && !paramList.isEmpty()) {
      byteBuffer = coreImpl.allocateDirectBuffer(paramList.size() << 2);
      for (Handle handle : paramList) {
        if (handle.isValid()) {
          i = ((HandleBase)handle).mMojoHandle;
        } else {
          i = 0;
        } 
        byteBuffer.putInt(i);
      } 
      byteBuffer.position(0);
    } else {
      byteBuffer = null;
    } 
    int j = this.mMojoHandle;
    if (paramByteBuffer == null) {
      i = 0;
    } else {
      i = paramByteBuffer.limit();
    } 
    int i = coreImpl.nativeWriteMessage(j, paramByteBuffer, i, byteBuffer, ((Flags)paramWriteFlags).mFlags);
    if (i == 0) {
      if (paramList != null)
        for (Handle handle : paramList) {
          if (handle.isValid())
            ((HandleBase)handle).mMojoHandle = 0; 
        }  
      return;
    } 
    throw new MojoException(i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\impl\MessagePipeHandleImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */