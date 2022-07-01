package org.chromium.net;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.IOException;
import java.net.Socket;
import org.chromium.base.ApplicationStatus;

final class NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate {
  final ConnectivityManager mConnectivityManager = null;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate() {}
  
  NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate(Context paramContext) {}
  
  private NetworkInfo getNetworkInfo(Network paramNetwork) {
    try {
      return this.mConnectivityManager.getNetworkInfo(paramNetwork);
    } catch (NullPointerException nullPointerException) {
      try {
        return this.mConnectivityManager.getNetworkInfo(paramNetwork);
      } catch (NullPointerException nullPointerException1) {
        return null;
      } 
    } 
  }
  
  @TargetApi(21)
  static NetworkInfo processActiveNetworkInfo(NetworkInfo paramNetworkInfo) {
    return (paramNetworkInfo == null) ? null : (paramNetworkInfo.isConnected() ? paramNetworkInfo : ((Build.VERSION.SDK_INT < 21) ? null : ((paramNetworkInfo.getDetailedState() != NetworkInfo.DetailedState.BLOCKED) ? null : ((ApplicationStatus.getStateForApplication() != 1) ? null : paramNetworkInfo))));
  }
  
  @TargetApi(21)
  protected static boolean vpnAccessible(Network paramNetwork) {
    Socket socket = new Socket();
    try {
      paramNetwork.bindSocket(socket);
      return true;
    } catch (IOException iOException) {
      return false;
    } finally {
      try {
        socket.close();
      } catch (IOException iOException) {}
    } 
  }
  
  @TargetApi(21)
  final int getConnectionType(Network paramNetwork) {
    NetworkInfo networkInfo2 = getNetworkInfo(paramNetwork);
    NetworkInfo networkInfo1 = networkInfo2;
    if (networkInfo2 != null) {
      networkInfo1 = networkInfo2;
      if (networkInfo2.getType() == 17)
        networkInfo1 = this.mConnectivityManager.getActiveNetworkInfo(); 
    } 
    return (networkInfo1 != null && networkInfo1.isConnected()) ? NetworkChangeNotifierAutoDetect.access$000(networkInfo1.getType(), networkInfo1.getSubtype()) : 6;
  }
  
  @TargetApi(21)
  final Network getDefaultNetwork() {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #23
    //   5: if_icmplt -> 28
    //   8: aload_0
    //   9: getfield mConnectivityManager : Landroid/net/ConnectivityManager;
    //   12: invokevirtual getActiveNetwork : ()Landroid/net/Network;
    //   15: astore #4
    //   17: aload #4
    //   19: astore_3
    //   20: aload #4
    //   22: ifnull -> 30
    //   25: aload #4
    //   27: areturn
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_0
    //   31: getfield mConnectivityManager : Landroid/net/ConnectivityManager;
    //   34: invokevirtual getActiveNetworkInfo : ()Landroid/net/NetworkInfo;
    //   37: astore #6
    //   39: aload #6
    //   41: ifnonnull -> 46
    //   44: aconst_null
    //   45: areturn
    //   46: aload_0
    //   47: aconst_null
    //   48: invokestatic access$100 : (Lorg/chromium/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate;Landroid/net/Network;)[Landroid/net/Network;
    //   51: astore #7
    //   53: aload #7
    //   55: arraylength
    //   56: istore_2
    //   57: iconst_0
    //   58: istore_1
    //   59: iload_1
    //   60: iload_2
    //   61: if_icmpge -> 147
    //   64: aload #7
    //   66: iload_1
    //   67: aaload
    //   68: astore #5
    //   70: aload_0
    //   71: aload #5
    //   73: invokespecial getNetworkInfo : (Landroid/net/Network;)Landroid/net/NetworkInfo;
    //   76: astore #8
    //   78: aload_3
    //   79: astore #4
    //   81: aload #8
    //   83: ifnull -> 137
    //   86: aload #8
    //   88: invokevirtual getType : ()I
    //   91: aload #6
    //   93: invokevirtual getType : ()I
    //   96: if_icmpeq -> 112
    //   99: aload_3
    //   100: astore #4
    //   102: aload #8
    //   104: invokevirtual getType : ()I
    //   107: bipush #17
    //   109: if_icmpne -> 137
    //   112: getstatic org/chromium/net/NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.$assertionsDisabled : Z
    //   115: ifne -> 133
    //   118: aload_3
    //   119: ifnonnull -> 125
    //   122: goto -> 133
    //   125: new java/lang/AssertionError
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: athrow
    //   133: aload #5
    //   135: astore #4
    //   137: iload_1
    //   138: iconst_1
    //   139: iadd
    //   140: istore_1
    //   141: aload #4
    //   143: astore_3
    //   144: goto -> 59
    //   147: aload_3
    //   148: areturn
  }
  
  @TargetApi(21)
  protected final NetworkCapabilities getNetworkCapabilities(Network paramNetwork) {
    return this.mConnectivityManager.getNetworkCapabilities(paramNetwork);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\NetworkChangeNotifierAutoDetect$ConnectivityManagerDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */