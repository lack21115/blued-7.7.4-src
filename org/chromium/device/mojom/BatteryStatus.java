package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Struct;

public final class BatteryStatus extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public boolean charging = true;
  
  public double chargingTime = 0.0D;
  
  public double dischargingTime = Double.POSITIVE_INFINITY;
  
  public double level = 1.0D;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(40, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BatteryStatus() {
    super(40);
  }
  
  public BatteryStatus(byte paramByte) {
    this();
  }
  
  public static BatteryStatus decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BatteryStatus batteryStatus = new BatteryStatus();
      batteryStatus.charging = paramDecoder.readBoolean(8, 0);
      batteryStatus.chargingTime = paramDecoder.readDouble(16);
      batteryStatus.dischargingTime = paramDecoder.readDouble(24);
      batteryStatus.level = paramDecoder.readDouble(32);
      return batteryStatus;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder = paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
    paramEncoder.encode(this.charging, 8, 0);
    paramEncoder.encode(this.chargingTime, 16);
    paramEncoder.encode(this.dischargingTime, 24);
    paramEncoder.encode(this.level, 32);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */