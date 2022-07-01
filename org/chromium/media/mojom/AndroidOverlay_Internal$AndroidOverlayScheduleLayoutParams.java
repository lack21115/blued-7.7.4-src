package org.chromium.media.mojom;

import org.chromium.gfx.mojom.Rect;
import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public Rect rect;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams() {
    super(16);
  }
  
  public AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams(byte paramByte) {
    this();
  }
  
  private static AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams androidOverlay_Internal$AndroidOverlayScheduleLayoutParams = new AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams();
      androidOverlay_Internal$AndroidOverlayScheduleLayoutParams.rect = Rect.decode(paramDecoder.readPointer(8, false));
      return androidOverlay_Internal$AndroidOverlayScheduleLayoutParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode((Struct)this.rect, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\mojom\AndroidOverlay_Internal$AndroidOverlayScheduleLayoutParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */