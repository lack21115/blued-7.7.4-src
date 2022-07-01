package com.google.android.gms.common.internal.safeparcel;

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
  public static BigDecimal createBigDecimal(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    int j = paramParcel.readInt();
    paramParcel.setDataPosition(i + paramInt);
    return new BigDecimal(new BigInteger(arrayOfByte), j);
  }
  
  public static BigDecimal[] createBigDecimalArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    BigDecimal[] arrayOfBigDecimal = new BigDecimal[k];
    for (paramInt = 0; paramInt < k; paramInt++) {
      byte[] arrayOfByte = paramParcel.createByteArray();
      int m = paramParcel.readInt();
      arrayOfBigDecimal[paramInt] = new BigDecimal(new BigInteger(arrayOfByte), m);
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigDecimal;
  }
  
  public static BigInteger createBigInteger(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + paramInt);
    return new BigInteger(arrayOfByte);
  }
  
  public static BigInteger[] createBigIntegerArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    BigInteger[] arrayOfBigInteger = new BigInteger[k];
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayOfBigInteger[paramInt] = new BigInteger(paramParcel.createByteArray()); 
    paramParcel.setDataPosition(j + i);
    return arrayOfBigInteger;
  }
  
  public static boolean[] createBooleanArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    boolean[] arrayOfBoolean = paramParcel.createBooleanArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfBoolean;
  }
  
  public static ArrayList<Boolean> createBooleanList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Boolean> arrayList = new ArrayList();
    int k = paramParcel.readInt();
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
    Bundle bundle = paramParcel.readBundle();
    paramParcel.setDataPosition(i + paramInt);
    return bundle;
  }
  
  public static byte[] createByteArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    byte[] arrayOfByte = paramParcel.createByteArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfByte;
  }
  
  public static byte[][] createByteArrayArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
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
    int k = paramParcel.readInt();
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
      return null; 
    char[] arrayOfChar = paramParcel.createCharArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfChar;
  }
  
  public static double[] createDoubleArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    double[] arrayOfDouble = paramParcel.createDoubleArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfDouble;
  }
  
  public static ArrayList<Double> createDoubleList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Double> arrayList = new ArrayList();
    int k = paramParcel.readInt();
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
    SparseArray<Double> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Double.valueOf(paramParcel.readDouble())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static float[] createFloatArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    float[] arrayOfFloat = paramParcel.createFloatArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfFloat;
  }
  
  public static ArrayList<Float> createFloatList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Float> arrayList = new ArrayList();
    int k = paramParcel.readInt();
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
    SparseArray<Float> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), Float.valueOf(paramParcel.readFloat())); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static IBinder[] createIBinderArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    IBinder[] arrayOfIBinder = paramParcel.createBinderArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfIBinder;
  }
  
  public static ArrayList<IBinder> createIBinderList(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ArrayList<IBinder> arrayList = paramParcel.createBinderArrayList();
    paramParcel.setDataPosition(i + paramInt);
    return arrayList;
  }
  
  public static SparseArray<IBinder> createIBinderSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
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
      return null; 
    int[] arrayOfInt = paramParcel.createIntArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfInt;
  }
  
  public static ArrayList<Integer> createIntegerList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Integer> arrayList = new ArrayList();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      arrayList.add(Integer.valueOf(paramParcel.readInt())); 
    paramParcel.setDataPosition(j + i);
    return arrayList;
  }
  
  public static long[] createLongArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    long[] arrayOfLong = paramParcel.createLongArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfLong;
  }
  
  public static ArrayList<Long> createLongList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    ArrayList<Long> arrayList = new ArrayList();
    int k = paramParcel.readInt();
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
    Parcel parcel = Parcel.obtain();
    parcel.appendFrom(paramParcel, i, paramInt);
    paramParcel.setDataPosition(i + paramInt);
    return parcel;
  }
  
  public static Parcel[] createParcelArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    Parcel[] arrayOfParcel = new Parcel[k];
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      if (m != 0) {
        int n = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayOfParcel[paramInt] = parcel;
        paramParcel.setDataPosition(n + m);
      } else {
        arrayOfParcel[paramInt] = null;
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return arrayOfParcel;
  }
  
  public static ArrayList<Parcel> createParcelList(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    ArrayList<Parcel> arrayList = new ArrayList();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      if (m != 0) {
        int n = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, n, m);
        arrayList.add(parcel);
        paramParcel.setDataPosition(n + m);
      } else {
        arrayList.add(null);
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
    int k = paramParcel.readInt();
    SparseArray<Parcel> sparseArray = new SparseArray();
    for (paramInt = 0; paramInt < k; paramInt++) {
      int m = paramParcel.readInt();
      int n = paramParcel.readInt();
      if (n != 0) {
        int i1 = paramParcel.dataPosition();
        Parcel parcel = Parcel.obtain();
        parcel.appendFrom(paramParcel, i1, n);
        sparseArray.append(m, parcel);
        paramParcel.setDataPosition(i1 + n);
      } else {
        sparseArray.append(m, null);
      } 
    } 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static <T extends Parcelable> T createParcelable(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Parcelable parcelable = (Parcelable)paramCreator.createFromParcel(paramParcel);
    paramParcel.setDataPosition(i + paramInt);
    return (T)parcelable;
  }
  
  public static SparseBooleanArray createSparseBooleanArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    SparseBooleanArray sparseBooleanArray = paramParcel.readSparseBooleanArray();
    paramParcel.setDataPosition(i + paramInt);
    return sparseBooleanArray;
  }
  
  public static SparseIntArray createSparseIntArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseIntArray sparseIntArray = new SparseIntArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseIntArray.append(paramParcel.readInt(), paramParcel.readInt()); 
    paramParcel.setDataPosition(j + i);
    return sparseIntArray;
  }
  
  public static SparseLongArray createSparseLongArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseLongArray sparseLongArray = new SparseLongArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseLongArray.append(paramParcel.readInt(), paramParcel.readLong()); 
    paramParcel.setDataPosition(j + i);
    return sparseLongArray;
  }
  
  public static String createString(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    String str = paramParcel.readString();
    paramParcel.setDataPosition(i + paramInt);
    return str;
  }
  
  public static String[] createStringArray(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    String[] arrayOfString = paramParcel.createStringArray();
    paramParcel.setDataPosition(i + paramInt);
    return arrayOfString;
  }
  
  public static ArrayList<String> createStringList(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ArrayList<String> arrayList = paramParcel.createStringArrayList();
    paramParcel.setDataPosition(i + paramInt);
    return arrayList;
  }
  
  public static SparseArray<String> createStringSparseArray(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    SparseArray<String> sparseArray = new SparseArray();
    int k = paramParcel.readInt();
    for (paramInt = 0; paramInt < k; paramInt++)
      sparseArray.append(paramParcel.readInt(), paramParcel.readString()); 
    paramParcel.setDataPosition(j + i);
    return sparseArray;
  }
  
  public static <T> T[] createTypedArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    Object[] arrayOfObject = paramParcel.createTypedArray(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return (T[])arrayOfObject;
  }
  
  public static <T> ArrayList<T> createTypedList(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return null; 
    ArrayList<T> arrayList = paramParcel.createTypedArrayList(paramCreator);
    paramParcel.setDataPosition(i + paramInt);
    return arrayList;
  }
  
  public static <T> SparseArray<T> createTypedSparseArray(Parcel paramParcel, int paramInt, Parcelable.Creator<T> paramCreator) {
    int i = readSize(paramParcel, paramInt);
    int j = paramParcel.dataPosition();
    if (i == 0)
      return null; 
    int k = paramParcel.readInt();
    SparseArray<T> sparseArray = new SparseArray();
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
  
  public static void ensureAtEnd(Parcel paramParcel, int paramInt) {
    if (paramParcel.dataPosition() == paramInt)
      return; 
    StringBuilder stringBuilder = new StringBuilder(37);
    stringBuilder.append("Overread allowed size end=");
    stringBuilder.append(paramInt);
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static int getFieldId(int paramInt) {
    return paramInt & 0xFFFF;
  }
  
  public static boolean readBoolean(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return (paramParcel.readInt() != 0);
  }
  
  public static Boolean readBooleanObject(Parcel paramParcel, int paramInt) {
    boolean bool;
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    } 
    return Boolean.valueOf(bool);
  }
  
  public static byte readByte(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return (byte)paramParcel.readInt();
  }
  
  public static char readChar(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return (char)paramParcel.readInt();
  }
  
  public static double readDouble(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readDouble();
  }
  
  public static Double readDoubleObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 8);
    return Double.valueOf(paramParcel.readDouble());
  }
  
  public static float readFloat(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readFloat();
  }
  
  public static Float readFloatObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
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
    IBinder iBinder = paramParcel.readStrongBinder();
    paramParcel.setDataPosition(i + paramInt);
    return iBinder;
  }
  
  public static int readInt(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return paramParcel.readInt();
  }
  
  public static Integer readIntegerObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 4);
    return Integer.valueOf(paramParcel.readInt());
  }
  
  public static void readList(Parcel paramParcel, int paramInt, List paramList, ClassLoader paramClassLoader) {
    paramInt = readSize(paramParcel, paramInt);
    int i = paramParcel.dataPosition();
    if (paramInt == 0)
      return; 
    paramParcel.readList(paramList, paramClassLoader);
    paramParcel.setDataPosition(i + paramInt);
  }
  
  public static long readLong(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 8);
    return paramParcel.readLong();
  }
  
  public static Long readLongObject(Parcel paramParcel, int paramInt) {
    int i = readSize(paramParcel, paramInt);
    if (i == 0)
      return null; 
    zza(paramParcel, paramInt, i, 8);
    return Long.valueOf(paramParcel.readLong());
  }
  
  public static short readShort(Parcel paramParcel, int paramInt) {
    zza(paramParcel, paramInt, 4);
    return (short)paramParcel.readInt();
  }
  
  public static int readSize(Parcel paramParcel, int paramInt) {
    return ((paramInt & 0xFFFF0000) != -65536) ? (paramInt >> 16 & 0xFFFF) : paramParcel.readInt();
  }
  
  public static void skipUnknownField(Parcel paramParcel, int paramInt) {
    paramInt = readSize(paramParcel, paramInt);
    paramParcel.setDataPosition(paramParcel.dataPosition() + paramInt);
  }
  
  public static int validateObjectHeader(Parcel paramParcel) {
    int j = readHeader(paramParcel);
    int k = readSize(paramParcel, j);
    int i = paramParcel.dataPosition();
    if (getFieldId(j) != 20293) {
      String str = String.valueOf(Integer.toHexString(j));
      if (str.length() != 0) {
        str = "Expected object header. Got 0x".concat(str);
      } else {
        str = new String("Expected object header. Got 0x");
      } 
      throw new ParseException(str, paramParcel);
    } 
    j = k + i;
    if (j >= i && j <= paramParcel.dataSize())
      return j; 
    StringBuilder stringBuilder = new StringBuilder(54);
    stringBuilder.append("Size read is invalid start=");
    stringBuilder.append(i);
    stringBuilder.append(" end=");
    stringBuilder.append(j);
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2) {
    paramInt1 = readSize(paramParcel, paramInt1);
    if (paramInt1 == paramInt2)
      return; 
    String str = Integer.toHexString(paramInt1);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  private static void zza(Parcel paramParcel, int paramInt1, int paramInt2, int paramInt3) {
    if (paramInt2 == paramInt3)
      return; 
    String str = Integer.toHexString(paramInt2);
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 46);
    stringBuilder.append("Expected size ");
    stringBuilder.append(paramInt3);
    stringBuilder.append(" got ");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" (0x");
    stringBuilder.append(str);
    stringBuilder.append(")");
    throw new ParseException(stringBuilder.toString(), paramParcel);
  }
  
  public static class ParseException extends RuntimeException {
    public ParseException(String param1String, Parcel param1Parcel) {
      super(stringBuilder.toString());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\safeparcel\SafeParcelReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */