package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Nfc_Internal$NfcPushParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public NfcMessage message;
  
  public NfcPushOptions options;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Nfc_Internal$NfcPushParams() {
    super(24);
  }
  
  public Nfc_Internal$NfcPushParams(byte paramByte) {
    this();
  }
  
  private static Nfc_Internal$NfcPushParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Nfc_Internal$NfcPushParams nfc_Internal$NfcPushParams = new Nfc_Internal$NfcPushParams();
      nfc_Internal$NfcPushParams.message = NfcMessage.decode(paramDecoder.readPointer(8, false));
      nfc_Internal$NfcPushParams.options = NfcPushOptions.decode(paramDecoder.readPointer(16, true));
      return nfc_Internal$NfcPushParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Nfc_Internal$NfcPushParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.message, 8, false);
    paramEncoder.encode(this.options, 16, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcPushParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */