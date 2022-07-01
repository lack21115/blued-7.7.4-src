package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class NfcPushOptions extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public boolean ignoreRead;
  
  public int target;
  
  public double timeout;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcPushOptions() {
    super(24);
  }
  
  public static NfcPushOptions decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcPushOptions nfcPushOptions = new NfcPushOptions();
      nfcPushOptions.target = paramDecoder.readInt(8);
      NfcPushTarget.validate(nfcPushOptions.target);
      nfcPushOptions.ignoreRead = paramDecoder.readBoolean(12, 0);
      nfcPushOptions.timeout = paramDecoder.readDouble(16);
      return nfcPushOptions;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.target, 8);
    paramEncoder.encode(this.ignoreRead, 12, 0);
    paramEncoder.encode(this.timeout, 16);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcPushOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */