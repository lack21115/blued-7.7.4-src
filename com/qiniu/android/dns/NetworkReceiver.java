package com.qiniu.android.dns;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

public final class NetworkReceiver extends BroadcastReceiver {
  private static final Uri PREFERRED_APN_URI = Uri.parse("content://telephony/carriers/preferapn");
  
  private static DnsManager mdnsManager;
  
  public static NetworkInfo createNetInfo(NetworkInfo paramNetworkInfo, Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull -> 8
    //   4: getstatic com/qiniu/android/dns/NetworkInfo.noNetwork : Lcom/qiniu/android/dns/NetworkInfo;
    //   7: areturn
    //   8: aload_0
    //   9: invokevirtual getType : ()I
    //   12: istore #4
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore_2
    //   18: iload #4
    //   20: iconst_1
    //   21: if_icmpne -> 33
    //   24: getstatic com/qiniu/android/dns/NetworkInfo$NetSatus.WIFI : Lcom/qiniu/android/dns/NetworkInfo$NetSatus;
    //   27: astore_1
    //   28: iload_3
    //   29: istore_2
    //   30: goto -> 229
    //   33: getstatic com/qiniu/android/dns/NetworkInfo$NetSatus.MOBILE : Lcom/qiniu/android/dns/NetworkInfo$NetSatus;
    //   36: astore #5
    //   38: aload_1
    //   39: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   42: getstatic com/qiniu/android/dns/NetworkReceiver.PREFERRED_APN_URI : Landroid/net/Uri;
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_1
    //   53: iload_2
    //   54: istore_3
    //   55: aload_1
    //   56: ifnull -> 116
    //   59: aload_1
    //   60: invokeinterface moveToFirst : ()Z
    //   65: pop
    //   66: aload_1
    //   67: aload_1
    //   68: ldc 'user'
    //   70: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   75: invokeinterface getString : (I)Ljava/lang/String;
    //   80: astore #6
    //   82: iload_2
    //   83: istore_3
    //   84: aload #6
    //   86: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   89: ifne -> 116
    //   92: aload #6
    //   94: ldc 'ctwap'
    //   96: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   99: ifne -> 114
    //   102: iload_2
    //   103: istore_3
    //   104: aload #6
    //   106: ldc 'ctnet'
    //   108: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   111: ifeq -> 116
    //   114: iconst_1
    //   115: istore_3
    //   116: aload_1
    //   117: invokeinterface close : ()V
    //   122: aload #5
    //   124: astore_1
    //   125: iload_3
    //   126: istore_2
    //   127: iload_3
    //   128: iconst_1
    //   129: if_icmpeq -> 229
    //   132: aload_0
    //   133: invokevirtual getExtraInfo : ()Ljava/lang/String;
    //   136: astore_0
    //   137: aload #5
    //   139: astore_1
    //   140: iload_3
    //   141: istore_2
    //   142: aload_0
    //   143: ifnull -> 229
    //   146: aload_0
    //   147: invokestatic getDefault : ()Ljava/util/Locale;
    //   150: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   153: astore_0
    //   154: aload_0
    //   155: ldc 'cmwap'
    //   157: invokevirtual equals : (Ljava/lang/Object;)Z
    //   160: ifne -> 224
    //   163: aload_0
    //   164: ldc 'cmnet'
    //   166: invokevirtual equals : (Ljava/lang/Object;)Z
    //   169: ifeq -> 175
    //   172: goto -> 224
    //   175: aload_0
    //   176: ldc '3gnet'
    //   178: invokevirtual equals : (Ljava/lang/Object;)Z
    //   181: ifne -> 216
    //   184: aload_0
    //   185: ldc 'uninet'
    //   187: invokevirtual equals : (Ljava/lang/Object;)Z
    //   190: ifne -> 216
    //   193: aload_0
    //   194: ldc '3gwap'
    //   196: invokevirtual equals : (Ljava/lang/Object;)Z
    //   199: ifne -> 216
    //   202: aload #5
    //   204: astore_1
    //   205: iload_3
    //   206: istore_2
    //   207: aload_0
    //   208: ldc 'uniwap'
    //   210: invokevirtual equals : (Ljava/lang/Object;)Z
    //   213: ifeq -> 229
    //   216: iconst_2
    //   217: istore_2
    //   218: aload #5
    //   220: astore_1
    //   221: goto -> 229
    //   224: iconst_3
    //   225: istore_2
    //   226: aload #5
    //   228: astore_1
    //   229: new com/qiniu/android/dns/NetworkInfo
    //   232: dup
    //   233: aload_1
    //   234: iload_2
    //   235: invokespecial <init> : (Lcom/qiniu/android/dns/NetworkInfo$NetSatus;I)V
    //   238: areturn
  }
  
  public static void setDnsManager(DnsManager paramDnsManager) {
    mdnsManager = paramDnsManager;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent) {
    if (mdnsManager == null)
      return; 
    NetworkInfo networkInfo = createNetInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo(), paramContext);
    mdnsManager.onNetworkChange(networkInfo);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\NetworkReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */