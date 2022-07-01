package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;
import org.chromium.mojo_base.mojom.UnguessableToken;

public final class AndroidOverlayConfig extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public boolean powerEfficient;
  
  public Rect rect;
  
  public UnguessableToken routingToken;
  
  public boolean secure;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(32, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlayConfig() {
    super(32);
  }
  
  public static AndroidOverlayConfig decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      AndroidOverlayConfig androidOverlayConfig = new AndroidOverlayConfig();
      androidOverlayConfig.routingToken = UnguessableToken.decode(paramDecoder.readPointer(8, false));
      androidOverlayConfig.rect = Rect.decode(paramDecoder.readPointer(16, false));
      androidOverlayConfig.secure = paramDecoder.readBoolean(24, 0);
      androidOverlayConfig.powerEfficient = paramDecoder.readBoolean(24, 1);
      return androidOverlayConfig;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode((Struct)this.routingToken, 8, false);
    paramEncoder.encode((Struct)this.rect, 16, false);
    paramEncoder.encode(this.secure, 24, 0);
    paramEncoder.encode(this.powerEfficient, 24, 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlayConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */