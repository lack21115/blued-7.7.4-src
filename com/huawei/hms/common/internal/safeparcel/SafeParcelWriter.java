package com.huawei.hms.common.internal.safeparcel;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class SafeParcelWriter {
  private static final int BIT16_MARK = 65535;
  
  private static final int FIELD_ID_CHECKER = 20293;
  
  private static final int NEGATIVE_MARK = -65536;
  
  private static final int OFFSET16 = 16;
  
  public static int beginObjectHeader(Parcel paramParcel) {
    return getStartPosition(paramParcel, 20293);
  }
  
  public static void finishObjectHeader(Parcel paramParcel, int paramInt) {
    handleDataOver(paramParcel, paramInt);
  }
  
  private static int getStartPosition(Parcel paramParcel, int paramInt) {
    paramParcel.writeInt(paramInt | 0xFFFF0000);
    paramParcel.writeInt(0);
    return paramParcel.dataPosition();
  }
  
  private static void handleDataOver(Parcel paramParcel, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.setDataPosition(paramInt - 4);
    paramParcel.writeInt(i - paramInt);
    paramParcel.setDataPosition(i);
  }
  
  private static void setHeader(Parcel paramParcel, int paramInt1, int paramInt2) {
    if (paramInt2 >= 65535) {
      paramParcel.writeInt(paramInt1 | 0xFFFF0000);
      paramParcel.writeInt(paramInt2);
      return;
    } 
    paramParcel.writeInt(paramInt1 | paramInt2 << 16);
  }
  
  private static <P extends Parcelable> void setSizeOfData(Parcel paramParcel, P paramP, int paramInt) {
    int i = paramParcel.dataPosition();
    paramParcel.writeInt(1);
    int j = paramParcel.dataPosition();
    paramP.writeToParcel(paramParcel, paramInt);
    paramInt = paramParcel.dataPosition();
    paramParcel.setDataPosition(i);
    paramParcel.writeInt(paramInt - j);
    paramParcel.setDataPosition(paramInt);
  }
  
  public static void writeBigDecimal(Parcel paramParcel, int paramInt, BigDecimal paramBigDecimal, boolean paramBoolean) {
    if (paramBigDecimal != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeByteArray(paramBigDecimal.unscaledValue().toByteArray());
      paramParcel.writeInt(paramBigDecimal.scale());
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeBigDecimalArray(Parcel paramParcel, int paramInt, BigDecimal[] paramArrayOfBigDecimal, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigDecimal != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramArrayOfBigDecimal.length;
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeByteArray(paramArrayOfBigDecimal[paramInt].unscaledValue().toByteArray());
        paramParcel.writeInt(paramArrayOfBigDecimal[paramInt].scale());
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeBigInteger(Parcel paramParcel, int paramInt, BigInteger paramBigInteger, boolean paramBoolean) {
    if (paramBigInteger != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeByteArray(paramBigInteger.toByteArray());
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeBigIntegerArray(Parcel paramParcel, int paramInt, BigInteger[] paramArrayOfBigInteger, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfBigInteger != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramArrayOfBigInteger.length;
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeByteArray(paramArrayOfBigInteger[paramInt].toByteArray()); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeBoolean(Parcel paramParcel, int paramInt, boolean paramBoolean) {
    setHeader(paramParcel, paramInt, 4);
    if (paramBoolean) {
      paramParcel.writeInt(1);
      return;
    } 
    paramParcel.writeInt(0);
  }
  
  public static void writeBooleanArray(Parcel paramParcel, int paramInt, boolean[] paramArrayOfboolean, boolean paramBoolean) {
    if (paramArrayOfboolean != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeBooleanArray(paramArrayOfboolean);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeBooleanList(Parcel paramParcel, int paramInt, List<Boolean> paramList, boolean paramBoolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void writeBooleanObject(Parcel paramParcel, int paramInt, Boolean paramBoolean, boolean paramBoolean1) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void writeBundle(Parcel paramParcel, int paramInt, Bundle paramBundle, boolean paramBoolean) {
    if (paramBundle != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeBundle(paramBundle);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeByte(Parcel paramParcel, int paramInt, byte paramByte) {
    setHeader(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramByte);
  }
  
  public static void writeByteArray(Parcel paramParcel, int paramInt, byte[] paramArrayOfbyte, boolean paramBoolean) {
    if (paramArrayOfbyte != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeByteArray(paramArrayOfbyte);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeByteArrayArray(Parcel paramParcel, int paramInt, byte[][] paramArrayOfbyte, boolean paramBoolean) {
    boolean bool = false;
    if (paramArrayOfbyte != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramArrayOfbyte.length;
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeByteArray(paramArrayOfbyte[paramInt]); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeByteArraySparseArray(Parcel paramParcel, int paramInt, SparseArray<byte[]> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeByteArray((byte[])paramSparseArray.valueAt(paramInt));
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeChar(Parcel paramParcel, int paramInt, char paramChar) {
    setHeader(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramChar);
  }
  
  public static void writeCharArray(Parcel paramParcel, int paramInt, char[] paramArrayOfchar, boolean paramBoolean) {
    if (paramArrayOfchar != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeCharArray(paramArrayOfchar);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeDouble(Parcel paramParcel, int paramInt, double paramDouble) {
    setHeader(paramParcel, paramInt, 8);
    paramParcel.writeDouble(paramDouble);
  }
  
  public static void writeDoubleArray(Parcel paramParcel, int paramInt, double[] paramArrayOfdouble, boolean paramBoolean) {
    if (paramArrayOfdouble != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeDoubleArray(paramArrayOfdouble);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeDoubleList(Parcel paramParcel, int paramInt, List<Double> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeDouble(((Double)paramList.get(paramInt)).doubleValue()); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeDoubleObject(Parcel paramParcel, int paramInt, Double paramDouble, boolean paramBoolean) {
    if (paramDouble != null) {
      setHeader(paramParcel, paramInt, 8);
      paramParcel.writeDouble(paramDouble.doubleValue());
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeDoubleSparseArray(Parcel paramParcel, int paramInt, SparseArray<Double> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeDouble(((Double)paramSparseArray.valueAt(paramInt)).doubleValue());
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeFloat(Parcel paramParcel, int paramInt, float paramFloat) {
    setHeader(paramParcel, paramInt, 4);
    paramParcel.writeFloat(paramFloat);
  }
  
  public static void writeFloatArray(Parcel paramParcel, int paramInt, float[] paramArrayOffloat, boolean paramBoolean) {
    if (paramArrayOffloat != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeFloatArray(paramArrayOffloat);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeFloatList(Parcel paramParcel, int paramInt, List<Float> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeFloat(((Float)paramList.get(paramInt)).floatValue()); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeFloatObject(Parcel paramParcel, int paramInt, Float paramFloat, boolean paramBoolean) {
    if (paramFloat != null) {
      setHeader(paramParcel, paramInt, 4);
      paramParcel.writeFloat(paramFloat.floatValue());
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeFloatSparseArray(Parcel paramParcel, int paramInt, SparseArray<Float> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeFloat(((Float)paramSparseArray.valueAt(paramInt)).floatValue());
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIBinder(Parcel paramParcel, int paramInt, IBinder paramIBinder, boolean paramBoolean) {
    if (paramIBinder != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeStrongBinder(paramIBinder);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIBinderArray(Parcel paramParcel, int paramInt, IBinder[] paramArrayOfIBinder, boolean paramBoolean) {
    if (paramArrayOfIBinder != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeBinderArray(paramArrayOfIBinder);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIBinderList(Parcel paramParcel, int paramInt, List<IBinder> paramList, boolean paramBoolean) {
    if (paramList != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeBinderList(paramList);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIBinderSparseArray(Parcel paramParcel, int paramInt, SparseArray<IBinder> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeStrongBinder((IBinder)paramSparseArray.valueAt(paramInt));
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeInt(Parcel paramParcel, int paramInt1, int paramInt2) {
    setHeader(paramParcel, paramInt1, 4);
    paramParcel.writeInt(paramInt2);
  }
  
  public static void writeIntArray(Parcel paramParcel, int paramInt, int[] paramArrayOfint, boolean paramBoolean) {
    if (paramArrayOfint != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeIntArray(paramArrayOfint);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIntegerList(Parcel paramParcel, int paramInt, List<Integer> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeInt(((Integer)paramList.get(paramInt)).intValue()); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeIntegerObject(Parcel paramParcel, int paramInt, Integer paramInteger, boolean paramBoolean) {
    if (paramInteger != null) {
      setHeader(paramParcel, paramInt, 4);
      paramParcel.writeInt(paramInteger.intValue());
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeList(Parcel paramParcel, int paramInt, List paramList, boolean paramBoolean) {
    if (paramList != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeList(paramList);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeLong(Parcel paramParcel, int paramInt, long paramLong) {
    setHeader(paramParcel, paramInt, 8);
    paramParcel.writeLong(paramLong);
  }
  
  public static void writeLongArray(Parcel paramParcel, int paramInt, long[] paramArrayOflong, boolean paramBoolean) {
    if (paramArrayOflong != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeLongArray(paramArrayOflong);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeLongList(Parcel paramParcel, int paramInt, List<Long> paramList, boolean paramBoolean) {
    boolean bool = false;
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++)
        paramParcel.writeLong(((Long)paramList.get(paramInt)).longValue()); 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeLongObject(Parcel paramParcel, int paramInt, Long paramLong, boolean paramBoolean) {
    if (paramLong != null) {
      setHeader(paramParcel, paramInt, 8);
      paramParcel.writeLong(paramLong.longValue());
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeParcel(Parcel paramParcel1, int paramInt, Parcel paramParcel2, boolean paramBoolean) {
    if (paramParcel2 != null) {
      paramInt = getStartPosition(paramParcel1, paramInt);
      paramParcel1.appendFrom(paramParcel2, 0, paramParcel2.dataSize());
      handleDataOver(paramParcel1, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel1, paramInt, 0); 
  }
  
  public static void writeParcelArray(Parcel paramParcel, int paramInt, Parcel[] paramArrayOfParcel, boolean paramBoolean) {
    if (paramArrayOfParcel != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramArrayOfParcel.length;
      paramParcel.writeInt(j);
      for (paramInt = 0; paramInt < j; paramInt++) {
        if (paramArrayOfParcel[paramInt] == null) {
          paramParcel.writeInt(0);
        } else {
          paramParcel.writeInt(paramArrayOfParcel[paramInt].dataSize());
          paramParcel.appendFrom(paramArrayOfParcel[paramInt], 0, paramArrayOfParcel[paramInt].dataSize());
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeParcelList(Parcel paramParcel, int paramInt, List<Parcel> paramList, boolean paramBoolean) {
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = 0; paramInt < j; paramInt++) {
        Parcel parcel = paramList.get(paramInt);
        if (parcel == null) {
          paramParcel.writeInt(0);
        } else {
          paramParcel.writeInt(parcel.dataSize());
          paramParcel.appendFrom(parcel, 0, parcel.dataSize());
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeParcelSparseArray(Parcel paramParcel, int paramInt, SparseArray<Parcel> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = 0; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        Parcel parcel = (Parcel)paramSparseArray.valueAt(paramInt);
        if (parcel == null) {
          paramParcel.writeInt(0);
        } else {
          paramParcel.writeInt(parcel.dataSize());
          paramParcel.appendFrom(parcel, 0, parcel.dataSize());
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeParcelable(Parcel paramParcel, int paramInt1, Parcelable paramParcelable, int paramInt2, boolean paramBoolean) {
    if (paramParcelable != null) {
      paramInt1 = getStartPosition(paramParcel, paramInt1);
      paramParcelable.writeToParcel(paramParcel, paramInt2);
      handleDataOver(paramParcel, paramInt1);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt1, 0); 
  }
  
  public static void writeShort(Parcel paramParcel, int paramInt, short paramShort) {
    setHeader(paramParcel, paramInt, 4);
    paramParcel.writeInt(paramShort);
  }
  
  public static void writeSparseBooleanArray(Parcel paramParcel, int paramInt, SparseBooleanArray paramSparseBooleanArray, boolean paramBoolean) {
    if (paramSparseBooleanArray != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeSparseBooleanArray(paramSparseBooleanArray);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeSparseIntArray(Parcel paramParcel, int paramInt, SparseIntArray paramSparseIntArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseIntArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseIntArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseIntArray.keyAt(paramInt));
        paramParcel.writeInt(paramSparseIntArray.valueAt(paramInt));
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeSparseLongArray(Parcel paramParcel, int paramInt, SparseLongArray paramSparseLongArray, boolean paramBoolean) {
    int i = 0;
    if (paramSparseLongArray != null) {
      int j = getStartPosition(paramParcel, paramInt);
      if (Build.VERSION.SDK_INT >= 18) {
        paramInt = paramSparseLongArray.size();
      } else {
        paramInt = 0;
      } 
      paramParcel.writeInt(paramInt);
      while (i < paramInt) {
        if (Build.VERSION.SDK_INT >= 18)
          paramParcel.writeInt(paramSparseLongArray.keyAt(i)); 
        if (Build.VERSION.SDK_INT >= 18)
          paramParcel.writeLong(paramSparseLongArray.valueAt(i)); 
        i++;
      } 
      handleDataOver(paramParcel, j);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeString(Parcel paramParcel, int paramInt, String paramString, boolean paramBoolean) {
    if (paramString != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeString(paramString);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeStringArray(Parcel paramParcel, int paramInt, String[] paramArrayOfString, boolean paramBoolean) {
    if (paramArrayOfString != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeStringArray(paramArrayOfString);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeStringList(Parcel paramParcel, int paramInt, List<String> paramList, boolean paramBoolean) {
    if (paramList != null) {
      paramInt = getStartPosition(paramParcel, paramInt);
      paramParcel.writeStringList(paramList);
      handleDataOver(paramParcel, paramInt);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static void writeStringSparseArray(Parcel paramParcel, int paramInt, SparseArray<String> paramSparseArray, boolean paramBoolean) {
    boolean bool = false;
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = bool; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        paramParcel.writeString((String)paramSparseArray.valueAt(paramInt));
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static <P extends Parcelable> void writeTypedArray(Parcel paramParcel, int paramInt1, P[] paramArrayOfP, int paramInt2, boolean paramBoolean) {
    if (paramArrayOfP != null) {
      int i = getStartPosition(paramParcel, paramInt1);
      paramParcel.writeInt(i);
      int j = paramArrayOfP.length;
      for (paramInt1 = 0; paramInt1 < j; paramInt1++) {
        if (paramArrayOfP[paramInt1] != null) {
          setSizeOfData(paramParcel, paramArrayOfP[paramInt1], paramInt2);
        } else {
          paramParcel.writeInt(0);
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt1, 0); 
  }
  
  public static <T extends Parcelable> void writeTypedList(Parcel paramParcel, int paramInt, List<T> paramList, boolean paramBoolean) {
    if (paramList != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramList.size();
      paramParcel.writeInt(j);
      for (paramInt = 0; paramInt < j; paramInt++) {
        Parcelable parcelable = (Parcelable)paramList.get(paramInt);
        if (parcelable != null) {
          setSizeOfData(paramParcel, parcelable, 0);
        } else {
          paramParcel.writeInt(0);
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
  
  public static <T extends Parcelable> void writeTypedSparseArray(Parcel paramParcel, int paramInt, SparseArray<T> paramSparseArray, boolean paramBoolean) {
    if (paramSparseArray != null) {
      int i = getStartPosition(paramParcel, paramInt);
      int j = paramSparseArray.size();
      paramParcel.writeInt(j);
      for (paramInt = 0; paramInt < j; paramInt++) {
        paramParcel.writeInt(paramSparseArray.keyAt(paramInt));
        Parcelable parcelable = (Parcelable)paramSparseArray.valueAt(paramInt);
        if (parcelable != null) {
          setSizeOfData(paramParcel, parcelable, 0);
        } else {
          paramParcel.writeInt(0);
        } 
      } 
      handleDataOver(paramParcel, i);
      return;
    } 
    if (paramBoolean)
      setHeader(paramParcel, paramInt, 0); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\safeparcel\SafeParcelWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */