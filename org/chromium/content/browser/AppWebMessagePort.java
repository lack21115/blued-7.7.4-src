package org.chromium.content.browser;

import android.os.Handler;
import android.os.Looper;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.blink.mojom.CloneableMessage;
import org.chromium.blink.mojom.TransferableMessage;
import org.chromium.content_public.browser.MessagePort;
import org.chromium.mojo.bindings.Connector;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.MessageHeader;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Pair;
import org.chromium.mojo.system.SharedBufferHandle;
import org.chromium.mojo.system.impl.CoreImpl;
import org.chromium.mojo_base.mojom.BigBuffer;
import org.chromium.mojo_base.mojom.BigBufferSharedMemoryRegion;

public class AppWebMessagePort implements MessagePort {
  private static final MessageHeader MESSAGE_HEADER = new MessageHeader(0);
  
  private boolean mClosed;
  
  private Connector mConnector;
  
  private Core mMojoCore;
  
  private boolean mStarted;
  
  private boolean mTransferred;
  
  private boolean mWatching;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AppWebMessagePort(MessagePipeHandle paramMessagePipeHandle) {
    this.mMojoCore = paramMessagePipeHandle.getCore();
    this.mConnector = new Connector(paramMessagePipeHandle);
  }
  
  public static AppWebMessagePort[] createPair() {
    Pair pair = CoreImpl.getInstance().createMessagePipe(new MessagePipeHandle.CreateOptions());
    return new AppWebMessagePort[] { new AppWebMessagePort((MessagePipeHandle)pair.first), new AppWebMessagePort((MessagePipeHandle)pair.second) };
  }
  
  private static native String nativeDecodeStringMessage(byte[] paramArrayOfbyte);
  
  private static native byte[] nativeEncodeStringMessage(String paramString);
  
  private MessagePipeHandle passHandle() {
    this.mTransferred = true;
    MessagePipeHandle messagePipeHandle = this.mConnector.passHandle();
    this.mConnector = null;
    return messagePipeHandle;
  }
  
  @CalledByNative
  private int releaseNativeHandle() {
    return passHandle().releaseNativeHandle();
  }
  
  public final void close() {
    if (!this.mTransferred) {
      if (this.mClosed)
        return; 
      this.mClosed = true;
      this.mConnector.close();
      this.mConnector = null;
      return;
    } 
    throw new IllegalStateException("Port is already transferred");
  }
  
  public final boolean isClosed() {
    return this.mClosed;
  }
  
  public final boolean isStarted() {
    return this.mStarted;
  }
  
  public final boolean isTransferred() {
    return this.mTransferred;
  }
  
  public final void postMessage(String paramString, MessagePort[] paramArrayOfMessagePort) {
    if (!this.mClosed && !this.mTransferred) {
      int i;
      if (paramArrayOfMessagePort == null) {
        i = 0;
      } else {
        i = paramArrayOfMessagePort.length;
      } 
      MessagePipeHandle[] arrayOfMessagePipeHandle = new MessagePipeHandle[i];
      if (paramArrayOfMessagePort != null) {
        int j = paramArrayOfMessagePort.length;
        i = 0;
        while (i < j) {
          MessagePort messagePort = paramArrayOfMessagePort[i];
          if (!messagePort.equals(this)) {
            if (!messagePort.isClosed() && !messagePort.isTransferred()) {
              if (!messagePort.isStarted()) {
                i++;
                continue;
              } 
              throw new IllegalStateException("Port is already started");
            } 
            throw new IllegalStateException("Port is already closed or transferred");
          } 
          throw new IllegalStateException("Source port cannot be transferred");
        } 
        for (i = 0; i < paramArrayOfMessagePort.length; i++)
          arrayOfMessagePipeHandle[i] = ((AppWebMessagePort)paramArrayOfMessagePort[i]).passHandle(); 
      } 
      this.mStarted = true;
      TransferableMessage transferableMessage = new TransferableMessage((byte)0);
      transferableMessage.message = new CloneableMessage((byte)0);
      CloneableMessage cloneableMessage = transferableMessage.message;
      byte[] arrayOfByte = nativeEncodeStringMessage(paramString);
      BigBuffer bigBuffer = new BigBuffer();
      if (arrayOfByte.length <= 65536) {
        bigBuffer.mTag = 0;
        bigBuffer.mBytes = arrayOfByte;
      } else {
        Core core = CoreImpl.getInstance();
        BigBufferSharedMemoryRegion bigBufferSharedMemoryRegion = new BigBufferSharedMemoryRegion((byte)0);
        bigBufferSharedMemoryRegion.bufferHandle = core.createSharedBuffer(new SharedBufferHandle.CreateOptions(), arrayOfByte.length);
        bigBufferSharedMemoryRegion.size = arrayOfByte.length;
        bigBufferSharedMemoryRegion.bufferHandle.map(0L, arrayOfByte.length, SharedBufferHandle.MapFlags.NONE).put(arrayOfByte);
        bigBuffer.mTag = 1;
        bigBuffer.mSharedMemory = bigBufferSharedMemoryRegion;
      } 
      cloneableMessage.encodedMessage = bigBuffer;
      transferableMessage.message.blobs = new org.chromium.blink.mojom.SerializedBlob[0];
      transferableMessage.arrayBufferContentsArray = new org.chromium.blink.mojom.SerializedArrayBufferContents[0];
      transferableMessage.imageBitmapContentsArray = new org.chromium.skia.mojom.Bitmap[0];
      transferableMessage.ports = arrayOfMessagePipeHandle;
      this.mConnector.accept((Message)transferableMessage.serializeWithHeader(this.mMojoCore, MESSAGE_HEADER));
      return;
    } 
    throw new IllegalStateException("Port is already closed or transferred");
  }
  
  public final void setMessageCallback(MessagePort.MessageCallback paramMessageCallback, Handler paramHandler) {
    if (!this.mClosed && !this.mTransferred) {
      this.mStarted = true;
      if (paramMessageCallback == null) {
        this.mConnector.mIncomingMessageReceiver = null;
      } else {
        Looper looper;
        Connector connector = this.mConnector;
        if (paramHandler == null) {
          looper = Looper.getMainLooper();
        } else {
          looper = looper.getLooper();
        } 
        connector.mIncomingMessageReceiver = new AppWebMessagePort$MessageHandler(looper, paramMessageCallback);
      } 
      if (!this.mWatching) {
        this.mConnector.start();
        this.mWatching = true;
      } 
      return;
    } 
    throw new IllegalStateException("Port is already closed or transferred");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\AppWebMessagePort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */