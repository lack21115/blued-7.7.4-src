package org.chromium.mojo.bindings;

import java.nio.ByteOrder;
import org.chromium.mojo.system.DataPipe;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.InvalidHandle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.mojo.system.UntypedHandle;

public final class Decoder {
  private final int mBaseOffset;
  
  private final Message mMessage;
  
  private final Decoder$Validator mValidator;
  
  public Decoder(Message paramMessage) {
    this(paramMessage, new Decoder$Validator(paramMessage.mBuffer.limit(), paramMessage.mHandles.size()), 0);
  }
  
  private Decoder(Message paramMessage, Decoder$Validator paramDecoder$Validator, int paramInt) {
    this.mMessage = paramMessage;
    this.mMessage.mBuffer.order(ByteOrder.LITTLE_ENDIAN);
    this.mBaseOffset = paramInt;
    this.mValidator = paramDecoder$Validator;
  }
  
  private DataHeader readDataHeaderAtOffset(int paramInt, boolean paramBoolean) {
    int i = readInt(paramInt);
    paramInt = readInt(paramInt + 4);
    if (i >= 0) {
      if (paramInt >= 0 || (paramBoolean && paramInt == -1))
        return new DataHeader(i, paramInt); 
      throw new DeserializationException("Negative elements or version. Unsigned integers are not valid for java.");
    } 
    throw new DeserializationException("Negative size. Unsigned integers are not valid for java.");
  }
  
  private void validateBufferSize(int paramInt1, int paramInt2) {
    if (this.mMessage.mBuffer.limit() >= paramInt1 + paramInt2)
      return; 
    throw new DeserializationException("Buffer is smaller than expected.");
  }
  
  public final void decreaseStackDepth() {
    Decoder$Validator decoder$Validator = this.mValidator;
    decoder$Validator.mStackDepth--;
  }
  
  public final void increaseStackDepth() {
    Decoder$Validator decoder$Validator = this.mValidator;
    decoder$Validator.mStackDepth++;
    if (decoder$Validator.mStackDepth < 100L)
      return; 
    throw new DeserializationException("Recursion depth limit exceeded.");
  }
  
  public final DataHeader readAndValidateDataHeader(DataHeader[] paramArrayOfDataHeader) {
    DataHeader dataHeader = readDataHeader();
    int i = paramArrayOfDataHeader.length - 1;
    if (dataHeader.elementsOrVersion <= (paramArrayOfDataHeader[i]).elementsOrVersion) {
      DataHeader dataHeader1;
      DataHeader dataHeader2 = null;
      while (true) {
        dataHeader1 = dataHeader2;
        if (i >= 0) {
          dataHeader1 = paramArrayOfDataHeader[i];
          if (dataHeader.elementsOrVersion >= dataHeader1.elementsOrVersion)
            break; 
          i--;
          continue;
        } 
        break;
      } 
      if (dataHeader1 != null && dataHeader1.size == dataHeader.size)
        return dataHeader; 
      throw new DeserializationException("Header doesn't correspond to any known version.");
    } 
    if (dataHeader.size >= (paramArrayOfDataHeader[i]).size)
      return dataHeader; 
    throw new DeserializationException("Message newer than the last known version cannot be shorter than required by the last known version.");
  }
  
  public final boolean readBoolean(int paramInt1, int paramInt2) {
    validateBufferSize(paramInt1, 1);
    validateBufferSize(paramInt1, 1);
    return ((this.mMessage.mBuffer.get(this.mBaseOffset + paramInt1) & 1 << paramInt2) != 0);
  }
  
  public final byte[] readBytes(int paramInt1, int paramInt2, int paramInt3) {
    Decoder decoder = readPointer(paramInt1, BindingsHelper.isArrayNullable(paramInt2));
    if (decoder == null)
      return null; 
    byte[] arrayOfByte = new byte[(decoder.readDataHeaderForArray(1L, paramInt3)).elementsOrVersion];
    decoder.mMessage.mBuffer.position(decoder.mBaseOffset + 8);
    decoder.mMessage.mBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  public final DataHeader readDataHeader() {
    this.mValidator.claimMemory(this.mBaseOffset, (this.mBaseOffset + 8));
    DataHeader dataHeader = readDataHeaderAtOffset(0, false);
    this.mValidator.claimMemory((this.mBaseOffset + 8), (this.mBaseOffset + dataHeader.size));
    return dataHeader;
  }
  
  public final DataHeader readDataHeaderForArray(long paramLong, int paramInt) {
    DataHeader dataHeader = readDataHeader();
    if (dataHeader.size >= paramLong * dataHeader.elementsOrVersion + 8L) {
      if (paramInt != -1) {
        if (dataHeader.elementsOrVersion == paramInt)
          return dataHeader; 
        StringBuilder stringBuilder = new StringBuilder("Incorrect array length. Expected: ");
        stringBuilder.append(paramInt);
        stringBuilder.append(", but got: ");
        stringBuilder.append(dataHeader.elementsOrVersion);
        stringBuilder.append(".");
        throw new DeserializationException(stringBuilder.toString());
      } 
      return dataHeader;
    } 
    throw new DeserializationException("Array header is incorrect.");
  }
  
  public final DataHeader readDataHeaderForPointerArray(int paramInt) {
    return readDataHeaderForArray(8L, paramInt);
  }
  
  public final DataHeader readDataHeaderForUnion(int paramInt) {
    DataHeader dataHeader = readDataHeaderAtOffset(paramInt, true);
    if (dataHeader.size == 0) {
      if (dataHeader.elementsOrVersion == 0)
        return dataHeader; 
      StringBuilder stringBuilder = new StringBuilder("Unexpected version tag for a null union. Expecting 0, found: ");
      stringBuilder.append(dataHeader.elementsOrVersion);
      throw new DeserializationException(stringBuilder.toString());
    } 
    if (dataHeader.size == 16)
      return dataHeader; 
    throw new DeserializationException("Unexpected size of an union. The size must be 0 for a null union, or 16 for a non-null union.");
  }
  
  public final double readDouble(int paramInt) {
    validateBufferSize(paramInt, 8);
    return this.mMessage.mBuffer.getDouble(this.mBaseOffset + paramInt);
  }
  
  public final float readFloat(int paramInt) {
    validateBufferSize(paramInt, 4);
    return this.mMessage.mBuffer.getFloat(this.mBaseOffset + paramInt);
  }
  
  public final int readInt(int paramInt) {
    validateBufferSize(paramInt, 4);
    return this.mMessage.mBuffer.getInt(this.mBaseOffset + paramInt);
  }
  
  public final InterfaceRequest readInterfaceRequest(int paramInt, boolean paramBoolean) {
    MessagePipeHandle messagePipeHandle = readMessagePipeHandle(paramInt, paramBoolean);
    return (messagePipeHandle == null) ? null : new InterfaceRequest(messagePipeHandle);
  }
  
  public final int[] readInts(int paramInt1, int paramInt2, int paramInt3) {
    Decoder decoder = readPointer(paramInt1, BindingsHelper.isArrayNullable(paramInt2));
    if (decoder == null)
      return null; 
    int[] arrayOfInt = new int[(decoder.readDataHeaderForArray(4L, paramInt3)).elementsOrVersion];
    decoder.mMessage.mBuffer.position(decoder.mBaseOffset + 8);
    decoder.mMessage.mBuffer.asIntBuffer().get(arrayOfInt);
    return arrayOfInt;
  }
  
  public final long readLong(int paramInt) {
    validateBufferSize(paramInt, 8);
    return this.mMessage.mBuffer.getLong(this.mBaseOffset + paramInt);
  }
  
  public final MessagePipeHandle readMessagePipeHandle(int paramInt, boolean paramBoolean) {
    return readUntypedHandle(paramInt, paramBoolean).toMessagePipeHandle();
  }
  
  public final Decoder readPointer(int paramInt, boolean paramBoolean) {
    int i = this.mBaseOffset;
    long l = readLong(paramInt);
    if (l == 0L) {
      if (paramBoolean)
        return null; 
      throw new DeserializationException("Trying to decode null pointer for a non-nullable type.");
    } 
    paramInt = (int)((i + paramInt) + l);
    return new Decoder(this.mMessage, this.mValidator, paramInt);
  }
  
  public final DataPipe.ProducerHandle readProducerHandle(int paramInt, boolean paramBoolean) {
    return readUntypedHandle(paramInt, paramBoolean).toDataPipeProducerHandle();
  }
  
  public final Interface$Proxy readServiceInterface(int paramInt, boolean paramBoolean, Interface$Manager paramInterface$Manager) {
    MessagePipeHandle messagePipeHandle = readMessagePipeHandle(paramInt, paramBoolean);
    return !messagePipeHandle.isValid() ? null : paramInterface$Manager.attachProxy(messagePipeHandle, readInt(paramInt + 4));
  }
  
  public final String readString(int paramInt, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final UntypedHandle readUntypedHandle(int paramInt, boolean paramBoolean) {
    Handle handle;
    paramInt = readInt(paramInt);
    if (paramInt == -1) {
      if (paramBoolean) {
        InvalidHandle invalidHandle = InvalidHandle.INSTANCE;
      } else {
        throw new DeserializationException("Trying to decode an invalid handle for a non-nullable type.");
      } 
    } else {
      Decoder$Validator decoder$Validator = this.mValidator;
      if (paramInt >= decoder$Validator.mMinNextClaimedHandle) {
        if (paramInt < decoder$Validator.mNumberOfHandles) {
          decoder$Validator.mMinNextClaimedHandle = paramInt + 1;
          handle = this.mMessage.mHandles.get(paramInt);
          return handle.toUntypedHandle();
        } 
        throw new DeserializationException("Trying to access non present handle.");
      } 
      throw new DeserializationException("Trying to access handle out of order.");
    } 
    return handle.toUntypedHandle();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\bindings\Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */