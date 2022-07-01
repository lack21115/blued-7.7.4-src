package org.chromium.gfx.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class Rect extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public int height;
  
  public int width;
  
  public int x;
  
  public int y;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(24, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private Rect() {
    super(24);
  }
  
  public static Rect decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      Rect rect = new Rect();
      rect.x = paramDecoder.readInt(8);
      rect.y = paramDecoder.readInt(12);
      rect.width = paramDecoder.readInt(16);
      rect.height = paramDecoder.readInt(20);
      return rect;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.x, 8);
    paramEncoder.encode(this.y, 12);
    paramEncoder.encode(this.width, 16);
    paramEncoder.encode(this.height, 20);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\gfx\mojom\Rect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */