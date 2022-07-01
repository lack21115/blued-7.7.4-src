package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class NfcClient_Internal$NfcClientOnWatchParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public NfcMessage message;
  
  public int[] watchIds;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private NfcClient_Internal$NfcClientOnWatchParams() {
    super(24);
  }
  
  public NfcClient_Internal$NfcClientOnWatchParams(byte paramByte) {
    this();
  }
  
  private static NfcClient_Internal$NfcClientOnWatchParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      NfcClient_Internal$NfcClientOnWatchParams nfcClient_Internal$NfcClientOnWatchParams = new NfcClient_Internal$NfcClientOnWatchParams();
      nfcClient_Internal$NfcClientOnWatchParams.watchIds = paramDecoder.readInts(8, 0, -1);
      nfcClient_Internal$NfcClientOnWatchParams.message = NfcMessage.decode(paramDecoder.readPointer(16, false));
      return nfcClient_Internal$NfcClientOnWatchParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static NfcClient_Internal$NfcClientOnWatchParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.watchIds, 8, 0, -1);
    paramEncoder.encode(this.message, 16, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\NfcClient_Internal$NfcClientOnWatchParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */