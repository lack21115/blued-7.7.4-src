package org.chromium.mojo.bindings;

import org.chromium.mojo.system.Core;

public abstract class Struct {
  private final int mEncodedBaseSize;
  
  public Struct(int paramInt) {
    this.mEncodedBaseSize = paramInt;
  }
  
  public abstract void encode(Encoder paramEncoder);
  
  public final ServiceMessage serializeWithHeader(Core paramCore, MessageHeader paramMessageHeader) {
    Encoder encoder = new Encoder(paramCore, this.mEncodedBaseSize + paramMessageHeader.mDataHeader.size);
    encoder.encode(paramMessageHeader.mDataHeader);
    encoder.encode(0, 8);
    encoder.encode(paramMessageHeader.mType, 12);
    encoder.encode(paramMessageHeader.mFlags, 16);
    if (MessageHeader.mustHaveRequestId(paramMessageHeader.mFlags))
      encoder.encode(paramMessageHeader.getRequestId(), 24); 
    encode(encoder);
    encoder.mEncoderState.byteBuffer.position(0);
    encoder.mEncoderState.byteBuffer.limit(encoder.mEncoderState.dataEnd);
    return new ServiceMessage(new Message(encoder.mEncoderState.byteBuffer, encoder.mEncoderState.handles), paramMessageHeader);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Struct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */