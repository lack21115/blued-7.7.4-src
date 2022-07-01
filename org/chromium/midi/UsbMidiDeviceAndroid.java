package org.chromium.midi;

import android.annotation.TargetApi;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.hardware.usb.UsbRequest;
import android.os.Handler;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.chromium.base.annotations.CalledByNative;

class UsbMidiDeviceAndroid {
  private final UsbDeviceConnection mConnection;
  
  private final SparseArray mEndpointMap;
  
  private final Handler mHandler;
  
  private boolean mHasInputThread;
  
  boolean mIsClosed;
  
  private long mNativePointer;
  
  private final Map mRequestMap;
  
  UsbDevice mUsbDevice;
  
  UsbMidiDeviceAndroid(UsbManager paramUsbManager, UsbDevice paramUsbDevice) {
    this.mConnection = paramUsbManager.openDevice(paramUsbDevice);
    this.mEndpointMap = new SparseArray();
    this.mRequestMap = new HashMap<Object, Object>();
    this.mHandler = new Handler();
    this.mUsbDevice = paramUsbDevice;
    this.mIsClosed = false;
    this.mHasInputThread = false;
    this.mNativePointer = 0L;
    for (int i = 0; i < paramUsbDevice.getInterfaceCount(); i++) {
      UsbInterface usbInterface = paramUsbDevice.getInterface(i);
      if (usbInterface.getInterfaceClass() == 1 && usbInterface.getInterfaceSubclass() == 3) {
        this.mConnection.claimInterface(usbInterface, true);
        int j;
        for (j = 0; j < usbInterface.getEndpointCount(); j++) {
          UsbEndpoint usbEndpoint = usbInterface.getEndpoint(j);
          if (usbEndpoint.getDirection() == 0)
            this.mEndpointMap.put(usbEndpoint.getEndpointNumber(), usbEndpoint); 
        } 
      } 
    } 
    startListen(paramUsbDevice);
  }
  
  private static native void nativeOnData(long paramLong, int paramInt, byte[] paramArrayOfbyte);
  
  private void startListen(UsbDevice paramUsbDevice) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    for (int i = 0; i < paramUsbDevice.getInterfaceCount(); i++) {
      UsbInterface usbInterface = paramUsbDevice.getInterface(i);
      if (usbInterface.getInterfaceClass() == 1 && usbInterface.getInterfaceSubclass() == 3)
        for (int j = 0; j < usbInterface.getEndpointCount(); j++) {
          UsbEndpoint usbEndpoint = usbInterface.getEndpoint(j);
          if (usbEndpoint.getDirection() == 128) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(usbEndpoint.getMaxPacketSize());
            UsbRequest usbRequest = new UsbRequest();
            usbRequest.initialize(this.mConnection, usbEndpoint);
            usbRequest.queue(byteBuffer, byteBuffer.remaining());
            hashMap.put(usbEndpoint, byteBuffer);
          } 
        }  
    } 
    if (hashMap.isEmpty())
      return; 
    this.mHasInputThread = true;
    (new UsbMidiDeviceAndroid$1(this, hashMap)).start();
  }
  
  @CalledByNative
  void close() {
    this.mEndpointMap.clear();
    Iterator<UsbRequest> iterator = this.mRequestMap.values().iterator();
    while (iterator.hasNext())
      ((UsbRequest)iterator.next()).close(); 
    this.mRequestMap.clear();
    this.mConnection.close();
    this.mNativePointer = 0L;
    this.mIsClosed = true;
  }
  
  @CalledByNative
  byte[] getDescriptors() {
    return (this.mConnection == null) ? new byte[0] : this.mConnection.getRawDescriptors();
  }
  
  @CalledByNative
  byte[] getStringDescriptor(int paramInt) {
    if (this.mConnection == null)
      return new byte[0]; 
    byte[] arrayOfByte = new byte[255];
    paramInt = this.mConnection.controlTransfer(128, 6, paramInt | 0x300, 0, arrayOfByte, 255, 0);
    return (paramInt < 0) ? new byte[0] : Arrays.copyOf(arrayOfByte, paramInt);
  }
  
  @CalledByNative
  void registerSelf(long paramLong) {
    this.mNativePointer = paramLong;
  }
  
  @TargetApi(18)
  @CalledByNative
  void send(int paramInt, byte[] paramArrayOfbyte) {
    if (this.mIsClosed)
      return; 
    UsbEndpoint usbEndpoint = (UsbEndpoint)this.mEndpointMap.get(paramInt);
    if (usbEndpoint == null)
      return; 
    if (this.mHasInputThread) {
      this.mConnection.bulkTransfer(usbEndpoint, paramArrayOfbyte, paramArrayOfbyte.length, 100);
      return;
    } 
    UsbRequest usbRequest2 = (UsbRequest)this.mRequestMap.get(usbEndpoint);
    UsbRequest usbRequest1 = usbRequest2;
    if (usbRequest2 == null) {
      usbRequest1 = new UsbRequest();
      usbRequest1.initialize(this.mConnection, usbEndpoint);
      this.mRequestMap.put(usbEndpoint, usbRequest1);
    } 
    usbRequest1.queue(ByteBuffer.wrap(paramArrayOfbyte), paramArrayOfbyte.length);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\midi\UsbMidiDeviceAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */