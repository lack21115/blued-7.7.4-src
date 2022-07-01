package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class NfcMessage extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public NfcRecord[] data;
  
  public String url;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcMessage() {
    super(24);
  }
  
  public NfcMessage(byte paramByte) {
    this();
  }
  
  public static NfcMessage decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcMessage nfcMessage = new NfcMessage();
      Decoder decoder = paramDecoder.readPointer(8, false);
      DataHeader dataHeader = decoder.readDataHeaderForPointerArray(-1);
      nfcMessage.data = new NfcRecord[dataHeader.elementsOrVersion];
      for (int i = 0; i < dataHeader.elementsOrVersion; i++) {
        Decoder decoder1 = decoder.readPointer((i << 3) + 8, false);
        nfcMessage.data[i] = NfcRecord.decode(decoder1);
      } 
      nfcMessage.url = paramDecoder.readString(16, true);
      return nfcMessage;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    if (this.data == null) {
      paramEncoder.encodeNullPointer(8, false);
    } else {
      Encoder encoder = paramEncoder.encodePointerArray(this.data.length, 8, -1);
      for (int i = 0; i < this.data.length; i++)
        encoder.encode(this.data[i], (i << 3) + 8, false); 
    } 
    paramEncoder.encode(this.url, 16, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */