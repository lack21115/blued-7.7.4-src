package org.chromium.midi;

import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import java.nio.ByteBuffer;
import java.util.Map;

final class UsbMidiDeviceAndroid$1 extends Thread {
  public final void run() {
    while (true) {
      UsbRequest usbRequest = UsbMidiDeviceAndroid.access$000(UsbMidiDeviceAndroid.this).requestWait();
      if (usbRequest != null) {
        UsbEndpoint usbEndpoint = usbRequest.getEndpoint();
        if (usbEndpoint.getDirection() == 128) {
          ByteBuffer byteBuffer = (ByteBuffer)bufferForEndpoints.get(usbEndpoint);
          int i = UsbMidiDeviceAndroid.access$100(byteBuffer);
          if (i > 0) {
            byteBuffer.rewind();
            byte[] arrayOfByte = new byte[i];
            byteBuffer.get(arrayOfByte, 0, i);
            UsbMidiDeviceAndroid.access$200(UsbMidiDeviceAndroid.this, usbEndpoint.getEndpointNumber(), arrayOfByte);
          } 
          byteBuffer.rewind();
          usbRequest.queue(byteBuffer, byteBuffer.capacity());
        } 
        continue;
      } 
      break;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\UsbMidiDeviceAndroid$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */