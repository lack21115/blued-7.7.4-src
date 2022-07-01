package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.BindingsHelper;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo.system.Handle;
import org.chromium.mojo.system.MessagePipeHandle;
import org.chromium.skia.mojom.Bitmap;

public final class TransferableMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public SerializedArrayBufferContents[] arrayBufferContentsArray;
  
  private boolean hasUserGesture;
  
  public Bitmap[] imageBitmapContentsArray;
  
  public CloneableMessage message;
  
  public MessagePipeHandle[] ports;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(48, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private TransferableMessage() {
    super(48);
  }
  
  public TransferableMessage(byte paramByte) {
    this();
  }
  
  private static TransferableMessage decode(Decoder paramDecoder) {
    null = null;
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      TransferableMessage transferableMessage = new TransferableMessage();
      transferableMessage.message = CloneableMessage.decode(paramDecoder.readPointer(8, false));
      Decoder decoder2 = paramDecoder.readPointer(16, BindingsHelper.isArrayNullable(0));
      if (decoder2 != null) {
        null = new MessagePipeHandle[(decoder2.readDataHeaderForArray(4L, -1)).elementsOrVersion];
        for (int j = 0; j < null.length; j++)
          null[j] = decoder2.readMessagePipeHandle(j * 4 + 8, BindingsHelper.isElementNullable(0)); 
      } 
      transferableMessage.ports = null;
      Decoder decoder1 = paramDecoder.readPointer(24, false);
      DataHeader dataHeader = decoder1.readDataHeaderForPointerArray(-1);
      transferableMessage.arrayBufferContentsArray = new SerializedArrayBufferContents[dataHeader.elementsOrVersion];
      int i;
      for (i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder = decoder1.readPointer((i << 3) + 8, false);
        transferableMessage.arrayBufferContentsArray[i] = SerializedArrayBufferContents.decode(decoder);
      } 
      decoder1 = paramDecoder.readPointer(32, false);
      dataHeader = decoder1.readDataHeaderForPointerArray(-1);
      transferableMessage.imageBitmapContentsArray = new Bitmap[dataHeader.elementsOrVersion];
      for (i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder = decoder1.readPointer((i << 3) + 8, false);
        transferableMessage.imageBitmapContentsArray[i] = Bitmap.decode(decoder);
      } 
      transferableMessage.hasUserGesture = paramDecoder.readBoolean(40, 0);
      return transferableMessage;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static TransferableMessage deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.message, 8, false);
    MessagePipeHandle[] arrayOfMessagePipeHandle = this.ports;
    if (arrayOfMessagePipeHandle == null) {
      paramEncoder.encodeNullPointer(16, BindingsHelper.isArrayNullable(0));
    } else {
      Encoder encoder = paramEncoder.encoderForArray(4, arrayOfMessagePipeHandle.length, 16, -1);
      for (int i = 0; i < arrayOfMessagePipeHandle.length; i++)
        encoder.encode((Handle)arrayOfMessagePipeHandle[i], i * 4 + 8, BindingsHelper.isElementNullable(0)); 
    } 
    if (this.arrayBufferContentsArray == null) {
      paramEncoder.encodeNullPointer(24, false);
    } else {
      Encoder encoder = paramEncoder.encodePointerArray(this.arrayBufferContentsArray.length, 24, -1);
      for (int i = 0; i < this.arrayBufferContentsArray.length; i++)
        encoder.encode(this.arrayBufferContentsArray[i], (i << 3) + 8, false); 
    } 
    if (this.imageBitmapContentsArray == null) {
      paramEncoder.encodeNullPointer(32, false);
    } else {
      Encoder encoder = paramEncoder.encodePointerArray(this.imageBitmapContentsArray.length, 32, -1);
      for (int i = 0; i < this.imageBitmapContentsArray.length; i++)
        encoder.encode((Struct)this.imageBitmapContentsArray[i], (i << 3) + 8, false); 
    } 
    paramEncoder.encode(this.hasUserGesture, 40, 0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\blink\mojom\TransferableMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */