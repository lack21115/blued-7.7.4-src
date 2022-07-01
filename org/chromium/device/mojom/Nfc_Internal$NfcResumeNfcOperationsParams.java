package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class Nfc_Internal$NfcResumeNfcOperationsParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(8, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Nfc_Internal$NfcResumeNfcOperationsParams() {
    super(8);
  }
  
  public Nfc_Internal$NfcResumeNfcOperationsParams(byte paramByte) {
    this();
  }
  
  private static Nfc_Internal$NfcResumeNfcOperationsParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      return new Nfc_Internal$NfcResumeNfcOperationsParams();
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static Nfc_Internal$NfcResumeNfcOperationsParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\Nfc_Internal$NfcResumeNfcOperationsParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */