package c.t.maploc.lite.tsa;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ab extends t {
  public static boolean a = false;
  
  private TelephonyManager b = null;
  
  private int c = 0;
  
  private CellLocation d = null;
  
  private SignalStrength e = null;
  
  private ServiceState f = null;
  
  private boolean i = false;
  
  private Handler j = null;
  
  private long k = 0L;
  
  private PhoneStateListener l = new ac(this);
  
  public ab(j paramj, l paraml) {
    super(paramj, paraml);
    this.b = this.g.e;
  }
  
  public static CellLocation a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'phone'
    //   3: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast android/telephony/TelephonyManager
    //   9: astore #5
    //   11: aload #5
    //   13: ifnull -> 130
    //   16: aload #5
    //   18: invokevirtual getCellLocation : ()Landroid/telephony/CellLocation;
    //   21: astore #6
    //   23: aload #5
    //   25: invokevirtual getSimState : ()I
    //   28: istore_1
    //   29: iconst_0
    //   30: istore #4
    //   32: iload_1
    //   33: iconst_5
    //   34: if_icmpne -> 42
    //   37: iconst_1
    //   38: istore_1
    //   39: goto -> 44
    //   42: iconst_0
    //   43: istore_1
    //   44: aload #5
    //   46: invokevirtual getSubscriberId : ()Ljava/lang/String;
    //   49: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   52: istore_3
    //   53: iload_3
    //   54: ifne -> 60
    //   57: goto -> 65
    //   60: iconst_0
    //   61: istore_2
    //   62: goto -> 67
    //   65: iconst_1
    //   66: istore_2
    //   67: aload #6
    //   69: astore #5
    //   71: iload_1
    //   72: ifeq -> 135
    //   75: aload #6
    //   77: astore #5
    //   79: iload_2
    //   80: ifeq -> 135
    //   83: aload #6
    //   85: ifnull -> 107
    //   88: aload #6
    //   90: invokestatic c : (Landroid/telephony/CellLocation;)Z
    //   93: ifne -> 107
    //   96: iload #4
    //   98: istore_3
    //   99: aload #6
    //   101: invokestatic b : (Landroid/telephony/CellLocation;)I
    //   104: ifge -> 119
    //   107: iload #4
    //   109: istore_3
    //   110: aload_0
    //   111: invokestatic c : (Landroid/content/Context;)Z
    //   114: ifne -> 119
    //   117: iconst_1
    //   118: istore_3
    //   119: iload_3
    //   120: putstatic c/t/maploc/lite/tsa/ab.a : Z
    //   123: aload #6
    //   125: areturn
    //   126: iconst_1
    //   127: putstatic c/t/maploc/lite/tsa/ab.a : Z
    //   130: invokestatic getEmpty : ()Landroid/telephony/CellLocation;
    //   133: astore #5
    //   135: aload #5
    //   137: areturn
    //   138: astore_0
    //   139: goto -> 126
    //   142: astore #5
    //   144: goto -> 65
    // Exception table:
    //   from	to	target	type
    //   16	29	138	finally
    //   44	53	142	finally
    //   88	96	138	finally
    //   99	107	138	finally
    //   110	117	138	finally
    //   119	123	138	finally
  }
  
  public static List a(TelephonyManager paramTelephonyManager) {
    ArrayList<m> arrayList2 = null;
    ArrayList<m> arrayList1 = arrayList2;
    if (paramTelephonyManager != null)
      try {
        List list = paramTelephonyManager.getAllCellInfo();
        arrayList1 = arrayList2;
        return arrayList1;
      } finally {
        paramTelephonyManager = null;
      }  
    return arrayList1;
  }
  
  private void a(int paramInt) {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  public static void a(ServiceState paramServiceState, t paramt) {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: ifnull -> 31
    //   6: aload_0
    //   7: invokevirtual getState : ()I
    //   10: ifne -> 18
    //   13: iconst_1
    //   14: istore_2
    //   15: goto -> 33
    //   18: aload_0
    //   19: invokevirtual getState : ()I
    //   22: iconst_1
    //   23: if_icmpne -> 31
    //   26: iconst_0
    //   27: istore_2
    //   28: goto -> 33
    //   31: iconst_m1
    //   32: istore_2
    //   33: aload_1
    //   34: invokevirtual e : ()Lc/t/maploc/lite/tsa/j;
    //   37: astore_0
    //   38: aload_0
    //   39: getfield a : Landroid/content/Context;
    //   42: invokestatic c : (Landroid/content/Context;)Z
    //   45: istore #5
    //   47: aload_0
    //   48: invokevirtual a : ()Z
    //   51: ifeq -> 72
    //   54: aload_0
    //   55: getfield e : Landroid/telephony/TelephonyManager;
    //   58: invokevirtual getSimState : ()I
    //   61: istore #4
    //   63: iload #4
    //   65: iconst_5
    //   66: if_icmpne -> 72
    //   69: goto -> 74
    //   72: iconst_0
    //   73: istore_3
    //   74: iload #5
    //   76: ifne -> 83
    //   79: iload_3
    //   80: ifne -> 85
    //   83: iconst_0
    //   84: istore_2
    //   85: aload_1
    //   86: iconst_2
    //   87: iload_2
    //   88: invokevirtual a : (II)V
    //   91: return
    //   92: astore_0
    //   93: goto -> 72
    // Exception table:
    //   from	to	target	type
    //   47	63	92	finally
  }
  
  public static void a(TelephonyManager paramTelephonyManager, int[] paramArrayOfint) {
    String str;
    if (paramTelephonyManager == null) {
      paramTelephonyManager = null;
    } else {
      str = paramTelephonyManager.getNetworkOperator();
    } 
    if (str != null && str.length() >= 5)
      try {
        paramArrayOfint[0] = Integer.parseInt(str.substring(0, 3));
        paramArrayOfint[1] = Integer.parseInt(str.substring(3, 5));
        return;
      } finally {} 
    paramArrayOfint[0] = 460;
    paramArrayOfint[1] = 0;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    boolean bool = false;
    if (paramInt1 == 2) {
      boolean bool1 = bool;
      if (paramInt2 >= 0) {
        bool1 = bool;
        if (paramInt3 >= 0) {
          bool1 = bool;
          if (paramInt4 >= 0) {
            bool1 = bool;
            if (paramInt4 <= 65535) {
              bool1 = bool;
              if (paramInt5 > 0) {
                bool1 = bool;
                if (paramInt5 <= 65535) {
                  if (paramInt3 == 0 && paramInt4 == 0 && paramInt5 == 0)
                    return false; 
                } else {
                  return bool1;
                } 
              } else {
                return bool1;
              } 
            } else {
              return bool1;
            } 
          } else {
            return bool1;
          } 
        } else {
          return bool1;
        } 
      } else {
        return bool1;
      } 
    } else {
      boolean bool1 = bool;
      if (paramInt2 >= 0) {
        bool1 = bool;
        if (paramInt3 >= 0) {
          bool1 = bool;
          if (paramInt4 > 0) {
            if (paramInt4 >= 65535)
              return false; 
            bool1 = bool;
            if (paramInt5 != 268435455) {
              bool1 = bool;
              if (paramInt5 != Integer.MAX_VALUE) {
                bool1 = bool;
                if (paramInt5 != 50594049) {
                  bool1 = bool;
                  if (paramInt5 != 65535) {
                    if (paramInt5 <= 0)
                      return false; 
                    bool1 = bool;
                    if (paramInt5 != 65535) {
                      if (paramInt5 <= 0)
                        return false; 
                    } else {
                      return bool1;
                    } 
                  } else {
                    return bool1;
                  } 
                } else {
                  return bool1;
                } 
              } else {
                return bool1;
              } 
            } else {
              return bool1;
            } 
          } else {
            return bool1;
          } 
        } else {
          return bool1;
        } 
      } else {
        return bool1;
      } 
    } 
    return true;
  }
  
  public static boolean a(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2) {
    null = false;
    if (paramSignalStrength1 != null && paramSignalStrength2 != null) {
      int i = Math.abs(b(paramInt, paramSignalStrength1, paramSignalStrength2));
      if (paramInt == 1) {
        if (i <= 3)
          return false; 
      } else if (paramInt == 2) {
        if (i <= 6)
          return false; 
      } else {
        return null;
      } 
    } 
    return true;
  }
  
  private boolean a(CellLocation paramCellLocation) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #4
    //   3: aload_1
    //   4: ifnonnull -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_1
    //   10: instanceof android/telephony/gsm/GsmCellLocation
    //   13: ifeq -> 42
    //   16: aload_1
    //   17: checkcast android/telephony/gsm/GsmCellLocation
    //   20: astore #5
    //   22: aload #5
    //   24: invokevirtual getCid : ()I
    //   27: ifgt -> 42
    //   30: aload #5
    //   32: invokevirtual getLac : ()I
    //   35: istore_2
    //   36: iload_2
    //   37: ifgt -> 42
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_1
    //   43: invokestatic b : (Landroid/telephony/CellLocation;)I
    //   46: ifgt -> 51
    //   49: iconst_0
    //   50: ireturn
    //   51: aload_0
    //   52: getfield d : Landroid/telephony/CellLocation;
    //   55: astore #5
    //   57: aload #5
    //   59: ifnull -> 157
    //   62: aload_1
    //   63: ifnonnull -> 69
    //   66: goto -> 157
    //   69: aload #5
    //   71: invokevirtual getClass : ()Ljava/lang/Class;
    //   74: aload_1
    //   75: invokevirtual getClass : ()Ljava/lang/Class;
    //   78: if_acmpne -> 157
    //   81: aload #5
    //   83: instanceof android/telephony/gsm/GsmCellLocation
    //   86: ifeq -> 120
    //   89: aload #5
    //   91: checkcast android/telephony/gsm/GsmCellLocation
    //   94: astore #5
    //   96: aload_1
    //   97: checkcast android/telephony/gsm/GsmCellLocation
    //   100: astore #6
    //   102: aload #5
    //   104: invokevirtual getCid : ()I
    //   107: aload #6
    //   109: invokevirtual getCid : ()I
    //   112: if_icmpne -> 157
    //   115: iconst_1
    //   116: istore_2
    //   117: goto -> 159
    //   120: aload #5
    //   122: instanceof android/telephony/cdma/CdmaCellLocation
    //   125: ifeq -> 157
    //   128: aload #5
    //   130: checkcast android/telephony/cdma/CdmaCellLocation
    //   133: astore #5
    //   135: aload_1
    //   136: checkcast android/telephony/cdma/CdmaCellLocation
    //   139: astore #6
    //   141: aload #5
    //   143: invokevirtual getBaseStationId : ()I
    //   146: aload #6
    //   148: invokevirtual getBaseStationId : ()I
    //   151: if_icmpne -> 157
    //   154: goto -> 115
    //   157: iconst_0
    //   158: istore_2
    //   159: iload_2
    //   160: ifeq -> 165
    //   163: iconst_0
    //   164: ireturn
    //   165: aload_0
    //   166: getfield b : Landroid/telephony/TelephonyManager;
    //   169: aload_1
    //   170: aconst_null
    //   171: invokestatic a : (Landroid/telephony/TelephonyManager;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/maploc/lite/tsa/m;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnonnull -> 184
    //   179: iconst_1
    //   180: istore_3
    //   181: goto -> 189
    //   184: aload_1
    //   185: invokestatic a : (Lc/t/maploc/lite/tsa/m;)Z
    //   188: istore_3
    //   189: iload_3
    //   190: ifeq -> 196
    //   193: iconst_1
    //   194: istore #4
    //   196: iload #4
    //   198: ireturn
    //   199: astore #5
    //   201: goto -> 42
    // Exception table:
    //   from	to	target	type
    //   9	36	199	finally
  }
  
  public static boolean a(m paramm) {
    return (paramm == null) ? false : a(paramm.a, paramm.b, paramm.c, paramm.d, paramm.e);
  }
  
  private static int b(int paramInt, SignalStrength paramSignalStrength1, SignalStrength paramSignalStrength2) {
    int i;
    if (paramInt == 1) {
      try {
        paramInt = paramSignalStrength1.getGsmSignalStrength();
        i = paramSignalStrength2.getGsmSignalStrength();
      } finally {
        paramSignalStrength1 = null;
      } 
    } else if (paramInt == 2) {
      paramInt = paramSignalStrength1.getCdmaDbm();
      i = paramSignalStrength2.getCdmaDbm();
    } else {
      return 0;
    } 
    return paramInt - i;
  }
  
  private static int b(CellLocation paramCellLocation) {
    try {
      if (paramCellLocation instanceof CdmaCellLocation)
        return ((CdmaCellLocation)paramCellLocation).getBaseStationId(); 
      if (paramCellLocation instanceof GsmCellLocation)
        return ((GsmCellLocation)paramCellLocation).getCid(); 
    } finally {}
    return -1;
  }
  
  public static List b(Context paramContext) {
    TelephonyManager telephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    if (telephonyManager != null)
      try {
        return telephonyManager.getNeighboringCellInfo();
      } finally {} 
    return Collections.emptyList();
  }
  
  private void b(int paramInt) {
    Handler handler = this.j;
    if (handler != null)
      handler.obtainMessage(paramInt).sendToTarget(); 
  }
  
  private static boolean c(Context paramContext) {
    boolean bool = false;
    try {
      int i = Build.VERSION.SDK_INT;
      return bool;
    } finally {
      paramContext = null;
    } 
  }
  
  private static boolean c(CellLocation paramCellLocation) {
    try {
      GsmCellLocation gsmCellLocation = (GsmCellLocation)paramCellLocation;
      if (gsmCellLocation.getCid() == 0) {
        int i = gsmCellLocation.getLac();
        if (i == 0)
          return true; 
      } 
    } finally {}
    return false;
  }
  
  public final void a() {
    a(0);
    Handler handler = this.j;
    if (handler != null) {
      handler.removeCallbacksAndMessages(null);
      this.j = null;
    } 
    this.d = null;
    this.e = null;
  }
  
  public final void a(Handler paramHandler) {
    this.k = 0L;
    Looper looper = paramHandler.getLooper();
    int i = 0;
    this.j = new ad(this, looper, (byte)0);
    b(1);
    this.i = false;
    a(273);
    try {
      if (this.b != null)
        i = this.b.getPhoneType(); 
      return;
    } finally {
      looper = null;
    } 
  }
  
  public final String b() {
    return "CellPro";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */