package org.chromium.device.mojom;

import org.chromium.mojo.bindings.DataHeader;
import org.chromium.mojo.bindings.Decoder;
import org.chromium.mojo.bindings.Encoder;
import org.chromium.mojo.bindings.Message;
import org.chromium.mojo.bindings.Struct;

final class BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams extends Struct {
  private static final DataHeader DEFAULT_STRUCT_INFO;
  
  private static final DataHeader[] VERSION_ARRAY;
  
  public BatteryStatus status;
  
  static {
    DataHeader[] arrayOfDataHeader = new DataHeader[1];
    arrayOfDataHeader[0] = new DataHeader(16, 0);
    VERSION_ARRAY = arrayOfDataHeader;
    DEFAULT_STRUCT_INFO = arrayOfDataHeader[0];
    throw new VerifyError("bad dex opcode");
  }
  
  private BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams() {
    super(16);
  }
  
  public BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams(byte paramByte) {
    this();
  }
  
  private static BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams decode(Decoder paramDecoder) {
    if (paramDecoder == null)
      return null; 
    paramDecoder.increaseStackDepth();
    try {
      paramDecoder.readAndValidateDataHeader(VERSION_ARRAY);
      BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams batteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams = new BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams();
      batteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams.status = BatteryStatus.decode(paramDecoder.readPointer(8, false));
      return batteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams;
    } finally {
      paramDecoder.decreaseStackDepth();
    } 
  }
  
  public static BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams deserialize(Message paramMessage) {
    return decode(new Decoder(paramMessage));
  }
  
  protected final void encode(Encoder paramEncoder) {
    paramEncoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO).encode(this.status, 8, false);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\mojom\BatteryMonitor_Internal$BatteryMonitorQueryNextStatusResponseParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */