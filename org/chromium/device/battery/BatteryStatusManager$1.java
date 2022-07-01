package org.chromium.device.battery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class BatteryStatusManager$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield this$0 : Lorg/chromium/device/battery/BatteryStatusManager;
    //   4: astore_1
    //   5: aload_2
    //   6: invokevirtual getAction : ()Ljava/lang/String;
    //   9: ldc 'android.intent.action.BATTERY_CHANGED'
    //   11: invokevirtual equals : (Ljava/lang/Object;)Z
    //   14: ifne -> 29
    //   17: ldc 'BatteryStatusManager'
    //   19: ldc 'Unexpected intent.'
    //   21: iconst_0
    //   22: anewarray java/lang/Object
    //   25: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   28: return
    //   29: aload_1
    //   30: getfield mIgnoreBatteryPresentState : Z
    //   33: ifeq -> 42
    //   36: iconst_1
    //   37: istore #12
    //   39: goto -> 51
    //   42: aload_2
    //   43: ldc 'present'
    //   45: iconst_0
    //   46: invokevirtual getBooleanExtra : (Ljava/lang/String;Z)Z
    //   49: istore #12
    //   51: aload_2
    //   52: ldc 'plugged'
    //   54: iconst_m1
    //   55: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   58: istore #9
    //   60: iload #12
    //   62: ifeq -> 360
    //   65: iload #9
    //   67: iconst_m1
    //   68: if_icmpne -> 74
    //   71: goto -> 360
    //   74: aload_2
    //   75: ldc 'level'
    //   77: iconst_m1
    //   78: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   81: istore #10
    //   83: aload_2
    //   84: ldc 'scale'
    //   86: iconst_m1
    //   87: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   90: istore #11
    //   92: iload #10
    //   94: i2d
    //   95: iload #11
    //   97: i2d
    //   98: ddiv
    //   99: dstore #5
    //   101: dload #5
    //   103: dconst_0
    //   104: dcmpg
    //   105: iflt -> 118
    //   108: dload #5
    //   110: dstore_3
    //   111: dload #5
    //   113: dconst_1
    //   114: dcmpl
    //   115: ifle -> 120
    //   118: dconst_1
    //   119: dstore_3
    //   120: iload #9
    //   122: ifeq -> 131
    //   125: iconst_1
    //   126: istore #12
    //   128: goto -> 134
    //   131: iconst_0
    //   132: istore #12
    //   134: aload_2
    //   135: ldc 'status'
    //   137: iconst_m1
    //   138: invokevirtual getIntExtra : (Ljava/lang/String;I)I
    //   141: iconst_5
    //   142: if_icmpne -> 151
    //   145: iconst_1
    //   146: istore #9
    //   148: goto -> 154
    //   151: iconst_0
    //   152: istore #9
    //   154: iload #12
    //   156: ifeq -> 170
    //   159: iload #9
    //   161: ifeq -> 170
    //   164: dconst_0
    //   165: dstore #5
    //   167: goto -> 175
    //   170: ldc2_w Infinity
    //   173: dstore #5
    //   175: new org/chromium/device/mojom/BatteryStatus
    //   178: dup
    //   179: iconst_0
    //   180: invokespecial <init> : (B)V
    //   183: astore_2
    //   184: aload_2
    //   185: iload #12
    //   187: putfield charging : Z
    //   190: aload_2
    //   191: dload #5
    //   193: putfield chargingTime : D
    //   196: aload_2
    //   197: ldc2_w Infinity
    //   200: putfield dischargingTime : D
    //   203: aload_2
    //   204: dload_3
    //   205: putfield level : D
    //   208: aload_1
    //   209: getfield mAndroidBatteryManager : Lorg/chromium/device/battery/BatteryStatusManager$AndroidBatteryManagerWrapper;
    //   212: ifnull -> 349
    //   215: getstatic org/chromium/device/battery/BatteryStatusManager.$assertionsDisabled : Z
    //   218: ifne -> 239
    //   221: aload_1
    //   222: getfield mAndroidBatteryManager : Lorg/chromium/device/battery/BatteryStatusManager$AndroidBatteryManagerWrapper;
    //   225: ifnull -> 231
    //   228: goto -> 239
    //   231: new java/lang/AssertionError
    //   234: dup
    //   235: invokespecial <init> : ()V
    //   238: athrow
    //   239: aload_1
    //   240: getfield mAndroidBatteryManager : Lorg/chromium/device/battery/BatteryStatusManager$AndroidBatteryManagerWrapper;
    //   243: iconst_4
    //   244: invokevirtual getIntProperty : (I)I
    //   247: i2d
    //   248: ldc2_w 100.0
    //   251: ddiv
    //   252: dstore_3
    //   253: aload_1
    //   254: getfield mAndroidBatteryManager : Lorg/chromium/device/battery/BatteryStatusManager$AndroidBatteryManagerWrapper;
    //   257: iconst_1
    //   258: invokevirtual getIntProperty : (I)I
    //   261: i2d
    //   262: dstore #5
    //   264: aload_1
    //   265: getfield mAndroidBatteryManager : Lorg/chromium/device/battery/BatteryStatusManager$AndroidBatteryManagerWrapper;
    //   268: iconst_3
    //   269: invokevirtual getIntProperty : (I)I
    //   272: i2d
    //   273: dstore #7
    //   275: aload_2
    //   276: getfield charging : Z
    //   279: ifeq -> 323
    //   282: aload_2
    //   283: getfield chargingTime : D
    //   286: ldc2_w Infinity
    //   289: dcmpl
    //   290: ifne -> 349
    //   293: dload #7
    //   295: dconst_0
    //   296: dcmpl
    //   297: ifle -> 349
    //   300: aload_2
    //   301: dconst_1
    //   302: dload_3
    //   303: dsub
    //   304: dload #5
    //   306: dload #7
    //   308: ddiv
    //   309: dmul
    //   310: ldc2_w 3600.0
    //   313: dmul
    //   314: invokestatic ceil : (D)D
    //   317: putfield chargingTime : D
    //   320: goto -> 349
    //   323: dload #7
    //   325: dconst_0
    //   326: dcmpg
    //   327: ifge -> 349
    //   330: aload_2
    //   331: dload_3
    //   332: dload #5
    //   334: dload #7
    //   336: dneg
    //   337: ddiv
    //   338: dmul
    //   339: ldc2_w 3600.0
    //   342: dmul
    //   343: invokestatic floor : (D)D
    //   346: putfield dischargingTime : D
    //   349: aload_1
    //   350: getfield mCallback : Lorg/chromium/device/battery/BatteryStatusManager$BatteryStatusCallback;
    //   353: aload_2
    //   354: invokeinterface onBatteryStatusChanged : (Lorg/chromium/device/mojom/BatteryStatus;)V
    //   359: return
    //   360: aload_1
    //   361: getfield mCallback : Lorg/chromium/device/battery/BatteryStatusManager$BatteryStatusCallback;
    //   364: new org/chromium/device/mojom/BatteryStatus
    //   367: dup
    //   368: iconst_0
    //   369: invokespecial <init> : (B)V
    //   372: invokeinterface onBatteryStatusChanged : (Lorg/chromium/device/mojom/BatteryStatus;)V
    //   377: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\battery\BatteryStatusManager$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */