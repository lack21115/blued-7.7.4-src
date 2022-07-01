package com.baidu.aip.face;

import android.content.Context;
import android.media.Image;
import com.baidu.aip.face.camera.Camera1Control;
import com.baidu.aip.face.camera.ICameraControl;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CameraImageSource extends ImageSource {
  private ArgbPool argbPool = new ArgbPool();
  
  private ICameraControl cameraControl;
  
  private int cameraFaceType = 1;
  
  private Context context;
  
  public CameraImageSource(Context paramContext) {
    this.context = paramContext;
    this.cameraControl = (ICameraControl)new Camera1Control(getContext());
    this.cameraControl.setCameraFacing(this.cameraFaceType);
    this.cameraControl.setOnFrameListener(new ICameraControl.OnFrameListener<byte[]>() {
          public void onPreviewFrame(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2, int param1Int3) {
            // Byte code:
            //   0: aload_0
            //   1: getfield this$0 : Lcom/baidu/aip/face/CameraImageSource;
            //   4: invokestatic access$000 : (Lcom/baidu/aip/face/CameraImageSource;)Lcom/baidu/aip/face/ArgbPool;
            //   7: iload_3
            //   8: iload #4
            //   10: invokevirtual acquire : (II)[I
            //   13: astore #8
            //   15: aload #8
            //   17: ifnull -> 34
            //   20: aload #8
            //   22: astore #7
            //   24: aload #8
            //   26: arraylength
            //   27: iload_3
            //   28: iload #4
            //   30: imul
            //   31: if_icmpeq -> 42
            //   34: iload_3
            //   35: iload #4
            //   37: imul
            //   38: newarray int
            //   40: astore #7
            //   42: iload_2
            //   43: istore #5
            //   45: iload_2
            //   46: ifge -> 56
            //   49: iload_2
            //   50: sipush #360
            //   53: iadd
            //   54: istore #5
            //   56: aload_1
            //   57: iload_3
            //   58: iload #4
            //   60: aload #7
            //   62: iload #5
            //   64: iconst_0
            //   65: invokestatic yuvToARGB : ([BII[III)V
            //   68: iload_3
            //   69: istore #6
            //   71: iload #4
            //   73: istore_2
            //   74: iload #5
            //   76: sipush #180
            //   79: irem
            //   80: bipush #90
            //   82: if_icmpne -> 91
            //   85: iload_3
            //   86: istore_2
            //   87: iload #4
            //   89: istore #6
            //   91: new com/baidu/aip/ImageFrame
            //   94: dup
            //   95: invokespecial <init> : ()V
            //   98: astore_1
            //   99: aload_1
            //   100: aload #7
            //   102: invokevirtual setArgb : ([I)V
            //   105: aload_1
            //   106: iload #6
            //   108: invokevirtual setWidth : (I)V
            //   111: aload_1
            //   112: iload_2
            //   113: invokevirtual setHeight : (I)V
            //   116: aload_1
            //   117: aload_0
            //   118: getfield this$0 : Lcom/baidu/aip/face/CameraImageSource;
            //   121: invokestatic access$000 : (Lcom/baidu/aip/face/CameraImageSource;)Lcom/baidu/aip/face/ArgbPool;
            //   124: invokevirtual setPool : (Lcom/baidu/aip/face/ArgbPool;)V
            //   127: aload_0
            //   128: getfield this$0 : Lcom/baidu/aip/face/CameraImageSource;
            //   131: invokevirtual getListeners : ()Ljava/util/ArrayList;
            //   134: invokevirtual iterator : ()Ljava/util/Iterator;
            //   137: astore #7
            //   139: aload #7
            //   141: invokeinterface hasNext : ()Z
            //   146: ifeq -> 168
            //   149: aload #7
            //   151: invokeinterface next : ()Ljava/lang/Object;
            //   156: checkcast com/baidu/aip/face/OnFrameAvailableListener
            //   159: aload_1
            //   160: invokeinterface onFrameAvailable : (Lcom/baidu/aip/ImageFrame;)V
            //   165: goto -> 139
            //   168: return
          }
        });
  }
  
  private Context getContext() {
    return this.context;
  }
  
  private byte[] imageToByteArray(Image paramImage) {
    ByteBuffer byteBuffer2 = paramImage.getPlanes()[0].getBuffer();
    ByteBuffer byteBuffer3 = paramImage.getPlanes()[2].getBuffer();
    ByteBuffer byteBuffer1 = paramImage.getPlanes()[1].getBuffer();
    int i = byteBuffer2.remaining();
    int j = byteBuffer3.remaining();
    int k = byteBuffer1.remaining();
    byte[] arrayOfByte = new byte[i + j + k];
    byteBuffer2.get(arrayOfByte, 0, i);
    byteBuffer3.get(arrayOfByte, i, k);
    byteBuffer1.get(arrayOfByte, i + k, j);
    return arrayOfByte;
  }
  
  private int[] toIntArray(byte[] paramArrayOfbyte) {
    ByteBuffer byteBuffer = ByteBuffer.wrap(paramArrayOfbyte).order(ByteOrder.LITTLE_ENDIAN);
    int[] arrayOfInt = new int[paramArrayOfbyte.length / 4];
    byteBuffer.asIntBuffer().put(arrayOfInt);
    return arrayOfInt;
  }
  
  public ICameraControl getCameraControl() {
    return this.cameraControl;
  }
  
  public void setCameraFacing(int paramInt) {
    this.cameraFaceType = paramInt;
  }
  
  public void setPreviewView(PreviewView paramPreviewView) {
    this.cameraControl.setPreviewView(paramPreviewView);
  }
  
  public void start() {
    super.start();
    this.cameraControl.start();
  }
  
  public void stop() {
    super.stop();
    this.cameraControl.stop();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\CameraImageSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */