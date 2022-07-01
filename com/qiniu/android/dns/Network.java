package com.qiniu.android.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

public final class Network {
  private static String previousIp = "";
  
  public static String getIp() {
    try {
      DatagramSocket datagramSocket = new DatagramSocket();
      datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
      InetAddress inetAddress = datagramSocket.getLocalAddress();
      datagramSocket.close();
      return inetAddress.getHostAddress();
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return "";
    } 
  }
  
  public static boolean isNetworkChanged() {
    // Byte code:
    //   0: ldc com/qiniu/android/dns/Network
    //   2: monitorenter
    //   3: invokestatic getIp : ()Ljava/lang/String;
    //   6: astore_1
    //   7: aload_1
    //   8: getstatic com/qiniu/android/dns/Network.previousIp : Ljava/lang/String;
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: istore_0
    //   15: iload_0
    //   16: ifeq -> 24
    //   19: ldc com/qiniu/android/dns/Network
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_1
    //   25: putstatic com/qiniu/android/dns/Network.previousIp : Ljava/lang/String;
    //   28: ldc com/qiniu/android/dns/Network
    //   30: monitorexit
    //   31: iconst_1
    //   32: ireturn
    //   33: astore_1
    //   34: ldc com/qiniu/android/dns/Network
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Exception table:
    //   from	to	target	type
    //   3	15	33	finally
    //   24	28	33	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\Network.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */