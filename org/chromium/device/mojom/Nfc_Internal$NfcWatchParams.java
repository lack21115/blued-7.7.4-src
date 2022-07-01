package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Nfc_Internal$NfcWatchParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public NfcWatchOptions options;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Nfc_Internal$NfcWatchParams() {
    super(16);
  }
  
  public Nfc_Internal$NfcWatchParams(byte paramByte) {
    this();
  }
  
  private static Nfc_Internal$NfcWatchParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Nfc_Internal$NfcWatchParams nfc_Internal$NfcWatchParams = new Nfc_Internal$NfcWatchParams();
      nfc_Internal$NfcWatchParams.options = NfcWatchOptions.decode(paramDecoder.readPointer(8, false));
      return nfc_Internal$NfcWatchParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Nfc_Internal$NfcWatchParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.options, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcWatchParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */