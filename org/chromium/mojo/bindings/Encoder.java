package org.chromium.mojo.bindings;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.chromium.mojo.system.Core;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.Pair;

public class Encoder {
  private int mBaseOffset;
  
  final Encoder$EncoderState mEncoderState;
  
  private Encoder(Encoder$EncoderState paramEncoder$EncoderState) {
    this.mEncoderState = paramEncoder$EncoderState;
    this.mBaseOffset = paramEncoder$EncoderState.dataEnd;
  }
  
  public Encoder(Core paramCore, int paramInt) {
    this(new Encoder$EncoderState(paramCore, paramInt, (byte)0));
  }
  
  private void encodeInvalidHandle(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.mEncoderState.byteBuffer.putInt(this.mBaseOffset + paramInt, -1);
      return;
    } 
    throw new SerializationException("Trying to encode an invalid handle for a non-nullable type.");
  }
  
  private void encodePointerToNextUnclaimedData(int paramInt) {
    encode(this.mEncoderState.dataEnd - (this.mBaseOffset + paramInt), paramInt);
  }
  
  private Encoder encoderForArrayByTotalSize(int paramInt1, int paramInt2, int paramInt3) {
    encodePointerToNextUnclaimedData(paramInt3);
    return getEncoderAtDataOffset(new DataHeader(paramInt1 + 8, paramInt2));
  }
  
  public final void encode(double paramDouble, int paramInt) {
    this.mEncoderState.byteBuffer.putDouble(this.mBaseOffset + paramInt, paramDouble);
  }
  
  public final void encode(float paramFloat, int paramInt) {
    this.mEncoderState.byteBuffer.putFloat(this.mBaseOffset + paramInt, paramFloat);
  }
  
  public final void encode(int paramInt1, int paramInt2) {
    this.mEncoderState.byteBuffer.putInt(this.mBaseOffset + paramInt2, paramInt1);
  }
  
  public final void encode(long paramLong, int paramInt) {
    this.mEncoderState.byteBuffer.putLong(this.mBaseOffset + paramInt, paramLong);
  }
  
  public final void encode(String paramString, int paramInt, boolean paramBoolean) {
    boolean bool;
    if (paramString == null) {
      encodeNullPointer(paramInt, paramBoolean);
      return;
    } 
    if (paramBoolean) {
      bool = true;
    } else {
      bool = false;
    } 
    encode(paramString.getBytes(Charset.forName("utf8")), paramInt, bool, -1);
  }
  
  public final void encode(DataHeader paramDataHeader) {
    Encoder$EncoderState encoder$EncoderState = this.mEncoderState;
    int i = BindingsHelper.align(paramDataHeader.size);
    encoder$EncoderState.dataEnd += i;
    if (encoder$EncoderState.byteBuffer.capacity() < encoder$EncoderState.dataEnd) {
      for (i = encoder$EncoderState.byteBuffer.capacity() << 1; i < encoder$EncoderState.dataEnd; i <<= 1);
      ByteBuffer byteBuffer = ByteBuffer.allocateDirect(i);
      byteBuffer.order(ByteOrder.nativeOrder());
      encoder$EncoderState.byteBuffer.position(0);
      encoder$EncoderState.byteBuffer.limit(encoder$EncoderState.byteBuffer.capacity());
      byteBuffer.put(encoder$EncoderState.byteBuffer);
      encoder$EncoderState.byteBuffer = byteBuffer;
    } 
    encode(paramDataHeader.size, 0);
    encode(paramDataHeader.elementsOrVersion, 4);
  }
  
  public final void encode(Interface paramInterface, int paramInt, boolean paramBoolean, Interface$Manager paramInterface$Manager) {
    if (paramInterface == null) {
      encodeInvalidHandle(paramInt, paramBoolean);
      encode(0, paramInt + 4);
      return;
    } 
    if (this.mEncoderState.core != null) {
      Interface$Proxy$Handler interface$Proxy$Handler;
      if (paramInterface instanceof Interface$Proxy) {
        interface$Proxy$Handler = ((Interface$Proxy)paramInterface).getProxyHandler();
        encode((Handle)interface$Proxy$Handler.passHandle(), paramInt, paramBoolean);
        encode(interface$Proxy$Handler.getVersion(), paramInt + 4);
        return;
      } 
      Pair pair = this.mEncoderState.core.createMessagePipe(null);
      paramInterface$Manager.bind((Interface)interface$Proxy$Handler, (MessagePipeHandle)pair.first);
      encode((Handle)pair.second, paramInt, paramBoolean);
      encode(paramInterface$Manager.getVersion(), paramInt + 4);
      return;
    } 
    throw new UnsupportedOperationException("The encoder has been created without a Core. It can't encode an interface.");
  }
  
  public final void encode(InterfaceRequest paramInterfaceRequest, int paramInt, boolean paramBoolean) {
    if (paramInterfaceRequest == null) {
      encodeInvalidHandle(paramInt, paramBoolean);
      return;
    } 
    if (this.mEncoderState.core != null) {
      encode((Handle)paramInterfaceRequest.passHandle(), paramInt, paramBoolean);
      return;
    } 
    throw new UnsupportedOperationException("The encoder has been created without a Core. It can't encode an interface.");
  }
  
  public final void encode(Struct paramStruct, int paramInt, boolean paramBoolean) {
    if (paramStruct == null) {
      encodeNullPointer(paramInt, paramBoolean);
      return;
    } 
    encodePointerToNextUnclaimedData(paramInt);
    paramStruct.encode(this);
  }
  
  public final void encode(Union paramUnion, int paramInt, boolean paramBoolean) {
    if (paramUnion != null || paramBoolean) {
      if (paramUnion == null) {
        encode(0L, paramInt);
        encode(0L, paramInt + 8);
        return;
      } 
      paramUnion.encode(this, paramInt);
      return;
    } 
    throw new SerializationException("Trying to encode a null pointer for a non-nullable type.");
  }
  
  public final void encode(Handle paramHandle, int paramInt, boolean paramBoolean) {
    if (paramHandle == null || !paramHandle.isValid()) {
      encodeInvalidHandle(paramInt, paramBoolean);
      return;
    } 
    encode(this.mEncoderState.handles.size(), paramInt);
    this.mEncoderState.handles.add(paramHandle);
  }
  
  public final void encode(boolean paramBoolean, int paramInt1, int paramInt2) {
    if (paramBoolean) {
      byte b = (byte)(this.mEncoderState.byteBuffer.get(this.mBaseOffset + paramInt1) | (byte)(1 << paramInt2));
      this.mEncoderState.byteBuffer.put(this.mBaseOffset + paramInt1, b);
    } 
  }
  
  public final void encode(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    if (paramArrayOfbyte == null) {
      encodeNullPointer(paramInt1, BindingsHelper.isArrayNullable(paramInt2));
      return;
    } 
    if (paramInt3 == -1 || paramInt3 == paramArrayOfbyte.length) {
      paramInt2 = paramArrayOfbyte.length;
      Encoder encoder = encoderForArrayByTotalSize(paramArrayOfbyte.length, paramInt2, paramInt1);
      encoder.mEncoderState.byteBuffer.position(encoder.mBaseOffset + 8);
      encoder.mEncoderState.byteBuffer.put(paramArrayOfbyte);
      return;
    } 
    throw new SerializationException("Trying to encode a fixed array of incorrect length.");
  }
  
  public final void encode(int[] paramArrayOfint, int paramInt1, int paramInt2, int paramInt3) {
    if (paramArrayOfint == null) {
      encodeNullPointer(paramInt1, BindingsHelper.isArrayNullable(paramInt2));
      return;
    } 
    Encoder encoder = encoderForArray(4, paramArrayOfint.length, paramInt1, paramInt3);
    encoder.mEncoderState.byteBuffer.position(encoder.mBaseOffset + 8);
    encoder.mEncoderState.byteBuffer.asIntBuffer().put(paramArrayOfint);
  }
  
  public final void encodeNullPointer(int paramInt, boolean paramBoolean) {
    if (paramBoolean) {
      this.mEncoderState.byteBuffer.putLong(this.mBaseOffset + paramInt, 0L);
      return;
    } 
    throw new SerializationException("Trying to encode a null pointer for a non-nullable type.");
  }
  
  public final Encoder encodePointerArray(int paramInt1, int paramInt2, int paramInt3) {
    return encoderForArray(8, paramInt1, paramInt2, paramInt3);
  }
  
  public final Encoder encoderForArray(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramInt4 == -1 || paramInt4 == paramInt2)
      return encoderForArrayByTotalSize(paramInt1 * paramInt2, paramInt2, paramInt3); 
    throw new SerializationException("Trying to encode a fixed array of incorrect length.");
  }
  
  public final Encoder getEncoderAtDataOffset(DataHeader paramDataHeader) {
    Encoder encoder = new Encoder(this.mEncoderState);
    encoder.encode(paramDataHeader);
    return encoder;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Encoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */