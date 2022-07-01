package c.t.maploc.lite.tsa;

import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.ArrayList;
import java.util.List;

public final class m extends p {
  public int a = 0;
  
  public int b = 0;
  
  public int c = 0;
  
  public int d = 0;
  
  public int e = 0;
  
  public int f = 0;
  
  private int g = Integer.MAX_VALUE;
  
  private int h = Integer.MAX_VALUE;
  
  private final long i = System.currentTimeMillis();
  
  private List j;
  
  public static m a(TelephonyManager paramTelephonyManager, CellInfo paramCellInfo) {
    if (paramCellInfo == null)
      return null; 
    m m1 = new m();
    try {
    
    } finally {
      paramTelephonyManager = null;
    } 
    byte b = -88;
    m1.f = b;
    return m1;
  }
  
  public static m a(TelephonyManager paramTelephonyManager, CellLocation paramCellLocation, SignalStrength paramSignalStrength) {
    if (paramTelephonyManager == null || paramCellLocation == null)
      return null; 
    m m1 = new m();
    try {
      m1.a(paramTelephonyManager);
      if (paramCellLocation instanceof CdmaCellLocation) {
        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation)paramCellLocation;
        m1.a = 2;
        m1.c = cdmaCellLocation.getSystemId();
        m1.d = cdmaCellLocation.getNetworkId();
        m1.e = cdmaCellLocation.getBaseStationId();
        m1.g = cdmaCellLocation.getBaseStationLatitude();
        m1.h = cdmaCellLocation.getBaseStationLongitude();
        if (paramSignalStrength == null)
          return m1; 
        int j = paramSignalStrength.getCdmaDbm();
        return m1;
      } 
      GsmCellLocation gsmCellLocation = (GsmCellLocation)paramCellLocation;
      m1.a = 1;
      m1.d = gsmCellLocation.getLac();
      m1.e = gsmCellLocation.getCid();
      if (paramSignalStrength == null)
        return m1; 
      int i = paramSignalStrength.getGsmSignalStrength();
      i = i * 2 - 113;
      return m1;
    } finally {
      paramTelephonyManager = null;
    } 
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, boolean paramBoolean1, boolean paramBoolean2) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(TelephonyManager paramTelephonyManager) {
    int[] arrayOfInt = new int[2];
    ab.a(paramTelephonyManager, arrayOfInt);
    if (arrayOfInt[0] > 0 && arrayOfInt[1] >= 0) {
      this.b = arrayOfInt[0];
      this.c = arrayOfInt[1];
    } 
  }
  
  private List b() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield j : Ljava/util/List;
    //   6: ifnonnull -> 16
    //   9: aload_0
    //   10: invokestatic emptyList : ()Ljava/util/List;
    //   13: putfield j : Ljava/util/List;
    //   16: aload_0
    //   17: getfield j : Ljava/util/List;
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	16	25	finally
    //   16	21	25	finally
  }
  
  public final String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.b);
    stringBuilder.append(this.c);
    stringBuilder.append(this.d);
    stringBuilder.append(this.e);
    return stringBuilder.toString();
  }
  
  public final String a(boolean paramBoolean) {
    ArrayList<String> arrayList = new ArrayList();
    if (ab.a(this))
      arrayList.add(a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, paramBoolean, true)); 
    try {
      for (NeighboringCellInfo neighboringCellInfo : b()) {
        int j = neighboringCellInfo.getLac();
        int k = neighboringCellInfo.getCid();
        if (ab.a(this.a, this.b, this.c, j, k))
          arrayList.add(a(this.b, this.c, j, k, (neighboringCellInfo.getRssi() << 1) - 113, 2147483647, 2147483647, false, false)); 
      } 
    } finally {
      Exception exception;
    } 
    StringBuilder stringBuilder = new StringBuilder("[");
    for (int i = 0; i < arrayList.size(); i++) {
      if (i > 0)
        stringBuilder.append(","); 
      stringBuilder.append(arrayList.get(i));
    } 
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public final void a(List<?> paramList) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull -> 19
    //   6: aload_1
    //   7: invokestatic unmodifiableList : (Ljava/util/List;)Ljava/util/List;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: putfield j : Ljava/util/List;
    //   16: goto -> 26
    //   19: invokestatic emptyList : ()Ljava/util/List;
    //   22: astore_1
    //   23: goto -> 11
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: monitorexit
    //   32: aload_1
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   6	11	29	finally
    //   11	16	29	finally
    //   19	23	29	finally
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("TxCellInfo [PhoneType=");
    stringBuilder.append(this.a);
    stringBuilder.append(", MCC=");
    stringBuilder.append(this.b);
    stringBuilder.append(", MNC=");
    stringBuilder.append(this.c);
    stringBuilder.append(", LAC=");
    stringBuilder.append(this.d);
    stringBuilder.append(", CID=");
    stringBuilder.append(this.e);
    stringBuilder.append(", RSSI=");
    stringBuilder.append(this.f);
    stringBuilder.append(", LAT=");
    stringBuilder.append(this.g);
    stringBuilder.append(", LNG=");
    stringBuilder.append(this.h);
    stringBuilder.append(", mTime=");
    stringBuilder.append(this.i);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */