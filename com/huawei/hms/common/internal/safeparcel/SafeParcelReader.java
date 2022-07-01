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
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {
  private static final int BIT16_MARK = 65535;
  
  private static final int FIELD_ID_CHECKER = 20293;
  
  private static final int MAX_ARRAY_LENGTH = 1024;
  
  private static final int NEGATIVE_MARK = -65536;
  
  private static final int OFFSET16 = 16;
  
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(paramInt + i);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0)
      return new BigDecimal[0]; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    while (paramInt < k) {
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(paramParcel.createByteArray()), paramParcel.readInt());
      paramInt++;
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0)
      return new BigInteger[0]; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    while (paramInt < k) {
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray());
      paramInt++;
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new boolean[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList<Boolean> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++) {
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayList.add(Boolean.valueOf(bool));
    } 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static Bundle createBundle(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    Bundle bundle = paramParcel.readBundle();
    paramParcel.setDataPosition(paramInt + i);
    return bundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new byte[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return (byte[][])null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    byte[][] arrayOfByte = new byte[k][];
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayOfByte[paramInt] = paramParcel.createByteArray(); 
    paramParcel.setDataPosition(j + i);
    return arrayOfByte;
  }
  
  public static SparseArray<byte[]> createByteArraySparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray<byte[]> sparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.createByteArray()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static char[] createCharArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new char[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new double[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList<Double> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Double.valueOf(paramParcel.readDouble())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static SparseArray<Double> createDoubleSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray<Double> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new float[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList<Float> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Float.valueOf(paramParcel.readFloat())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static SparseArray<Float> createFloatSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray<Float> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new IBinder[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    ArrayList<IBinder> arrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return arrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray<IBinder> sparseArray = new SparseArray(k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.readStrongBinder()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static int[] createIntArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new int[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList<Integer> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Integer.valueOf(paramParcel.readInt())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new long[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    ArrayList<Long> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Long.valueOf(paramParcel.readLong())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static Parcel createParcel(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    Parcel parcel = Parcel.obtain();
    parcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(paramInt + i);
    return parcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    paramInt = 0;
    if (i == 0)
      return new Parcel[0]; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    Parcel[] arrayOfParcel = new Parcel[k];
    while (paramInt < k) {
      int m = paramParcel.readInt();
      if (m == 0) {
        arrayOfParcel[paramInt] = null;
      } else {
        int n = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, m, n);
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = parcel;
        paramParcel.setDataPosition(m + n);
      } 
      paramInt++;
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    ArrayList<Parcel> arrayList = new ArrayList();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      if (m == 0) {
        arrayList.add(null);
      } else {
        int n = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, m, n);
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayList.add(parcel);
        paramParcel.setDataPosition(m + n);
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static SparseArray<Parcel> createParcelSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray<Parcel> sparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n == 0) {
        sparseArray.append(m, null);
      } else {
        int i1 = paramParcel.dataPosition();
        ensureDataPositionValid(paramParcel, n, i1);
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, i1, n);
        sparseArray.append(m, parcel);
        paramParcel.setDataPosition(i1 + n);
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static <P extends Parcelable> P createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<P> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    Parcelable parcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(paramInt + i);
    return (P)parcelable;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    SparseBooleanArray sparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(paramInt + i);
    return sparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    SparseIntArray sparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseIntArray.append(paramParcel.readInt(), paramParcel.readInt()); 
    paramParcel.setDataPosition(j + i);
    return sparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    SparseLongArray sparseLongArray = null;
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    if (Build.VERSION.SDK_INT >= 18)
      sparseLongArray = new SparseLongArray(); 
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++) {
      if (Build.VERSION.SDK_INT >= 18)
        sparseLongArray.append(paramParcel.readInt(), paramParcel.readLong()); 
    } 
    paramParcel.setDataPosition(j + i);
    return sparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    String str = paramParcel.readString();
    paramParcel.setDataPosition(paramInt + i);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return new String[0]; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(paramInt + i);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    ArrayList<String> arrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(paramInt + i);
    return arrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    SparseArray<String> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.readString()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static <C> C[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return (C[])paramCreator.newArray(0); 
    ensureDataPositionValid(paramParcel, paramInt, i);
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return (C[])arrayOfObject;
  }
  
  public static <C> ArrayList<C> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    ArrayList<C> arrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(paramInt + i);
    return arrayList;
  }
  
  public static <C> SparseArray<C> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<C> paramCreator) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ensureDataPositionValid(paramParcel, i, j);
    int k = paramParcel.readInt();
    ensureArrayLengthValid(paramParcel, k);
    SparseArray<C> sparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++) {
      Object object;
      int m = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {
        object = paramCreator.createFromParcel(paramParcel);
      } else {
        object = null;
      } 
      sparseArray.append(m, object);
    } 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  private static void ensureArrayLengthValid(Parcel paramParcel, int paramInt) {
    if (paramInt <= 1024)
      return; 
    throw new ParseException("arraySize cannot be beyond 65535", paramParcel);
  }
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt) {
    if (paramParcel.dataPosition() == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Overread allowed size end=");
    stringBuilder.append(paramInt);
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  private static void ensureDataPositionValid(Parcel paramParcel, int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && !isOutOfIntBoundary(paramInt1, paramInt2))
      return; 
    throw new ParseException("dataPosition cannot be beyond integer scope", paramParcel);
  }
  
  public static int getFieldId(int paramInt) {
    return paramInt & 0xFFFF;
  }
  
  private static boolean isOutOfIntBoundary(int paramInt1, int paramInt2) {
    long l = paramInt1 + paramInt2;
    return (l > 2147483647L || l < -2147483648L);
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return (paramParcel.readInt() != 0);
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    boolean bool = false;
    if (i == 0)
      return Boolean.valueOf(false); 
    sizeChecker(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0)
      bool = true; 
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    sizeChecker(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    sizeChecker(paramParcel, paramInt, i, 4);
    return Float.valueOf(paramParcel.readFloat());
  }
  
  public static int readHeader(Parcel paramParcel) {
    return paramParcel.readInt();
  }
  
  public static IBinder readIBinder(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ensureDataPositionValid(paramParcel, paramInt, i);
    IBinder iBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(paramInt + i);
    return iBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    sizeChecker(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt != 0) {
      ensureDataPositionValid(paramParcel, paramInt, i);
      paramParcel.readList(paramList, paramClassLoader);
      paramParcel.setDataPosition(paramInt + i);
    } 
  }
  
  public static long readLong(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    sizeChecker(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static short readShort(Parcel paramParcel, int paramInt) {
    sizeChecker(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(Parcel paramParcel, int paramInt) {
    return ((paramInt & 0xFFFF0000) != -65536) ? (paramInt >> 16 & 0xFFFF) : paramParcel.readInt();
  }
  
  private static void sizeChecker(Parcel paramParcel, int paramInt1, int paramInt2) {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 == paramInt2)
      return; 
    String str = Integer.toHexString(paramInt1);
    StringBuilder stringBuilder = new StringBuilder(str.length() + 46);
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  private static void sizeChecker(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == paramInt3)
      return; 
    String str = Integer.toHexString(paramInt2);
    StringBuilder stringBuilder = new StringBuilder(str.length() + 46);
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    ensureDataPositionValid(paramParcel, paramInt, i);
    paramParcel.setDataPosition(paramInt + i);
  }
  
  public static int validateObjectHeader(Parcel paramParcel) {
    int j = readHeader(paramParcel);
    int k = readSize(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (getFieldId(j) != 20293) {
      String str1 = "Expected object header. Got 0x";
      String str2 = Integer.toHexString(j);
      if (str2.length() != 0)
        str1 = "Expected object header. Got 0x".concat(str2); 
      throw new ParseException(str1, paramParcel);
    } 
    j = k + i;
    if (j >= i && j <= paramParcel.dataSize())
      return j; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("invalid start=");
    stringBuilder.append(i);
    stringBuilder.append(" end=");
    stringBuilder.append(j);
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static class ParseException extends RuntimeException {
    public ParseException(String param1String, Parcel param1Parcel) {
      super(stringBuffer.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\internal\safeparcel\SafeParcelReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */