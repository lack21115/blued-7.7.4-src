package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Nfc_Internal$NfcCancelAllWatchesResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public NfcError error;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Nfc_Internal$NfcCancelAllWatchesResponseParams() {
    super(16);
  }
  
  public Nfc_Internal$NfcCancelAllWatchesResponseParams(byte paramByte) {
    this();
  }
  
  private static Nfc_Internal$NfcCancelAllWatchesResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Nfc_Internal$NfcCancelAllWatchesResponseParams nfc_Internal$NfcCancelAllWatchesResponseParams = new Nfc_Internal$NfcCancelAllWatchesResponseParams();
      nfc_Internal$NfcCancelAllWatchesResponseParams.error = NfcError.decode(paramDecoder.readPointer(8, true));
      return nfc_Internal$NfcCancelAllWatchesResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Nfc_Internal$NfcCancelAllWatchesResponseParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.error, 8, true);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcCancelAllWatchesResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */