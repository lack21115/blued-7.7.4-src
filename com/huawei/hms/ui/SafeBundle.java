package com.huawei.hms.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import com.huawei.hms.base.ui.a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

public class SafeBundle {
  private final Bundle a;
  
  public SafeBundle() {
    this(new Bundle());
  }
  
  public SafeBundle(Bundle paramBundle) {
    if (paramBundle == null)
      paramBundle = new Bundle(); 
    this.a = paramBundle;
  }
  
  public void clear() {
    try {
      this.a.clear();
      return;
    } catch (Exception exception) {
      a.a("SafeBundle", "clear exception.");
      return;
    } 
  }
  
  public boolean containsKey(String paramString) {
    try {
      return this.a.containsKey(paramString);
    } catch (Exception exception) {
      a.a("SafeBundle", "containsKey exception. key:");
      return false;
    } 
  }
  
  public Object get(String paramString) {
    try {
      return this.a.get(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public IBinder getBinder(String paramString) {
    try {
      return (Build.VERSION.SDK_INT >= 18) ? this.a.getBinder(paramString) : null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBinder exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public boolean getBoolean(String paramString) {
    return getBoolean(paramString, false);
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean) {
    try {
      return this.a.getBoolean(paramString, paramBoolean);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBoolean exception : ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramBoolean;
    } 
  }
  
  public boolean[] getBooleanArray(String paramString) {
    try {
      return this.a.getBooleanArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBooleanArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new boolean[0];
    } 
  }
  
  public boolean[] getBooleanArrayReturnNotNull(String paramString) {
    try {
      boolean[] arrayOfBoolean2 = this.a.getBooleanArray(paramString);
      boolean[] arrayOfBoolean1 = arrayOfBoolean2;
      if (arrayOfBoolean2 == null)
        arrayOfBoolean1 = new boolean[0]; 
      return arrayOfBoolean1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBooleanArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new boolean[0];
    } 
  }
  
  public Bundle getBundle() {
    return this.a;
  }
  
  public Bundle getBundle(String paramString) {
    try {
      return this.a.getBundle(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBundle exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public Bundle getBundleReturnNotNull(String paramString) {
    try {
      Bundle bundle2 = this.a.getBundle(paramString);
      Bundle bundle1 = bundle2;
      if (bundle2 == null)
        bundle1 = new Bundle(); 
      return bundle1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getBundle exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new Bundle();
    } 
  }
  
  public byte getByte(String paramString) {
    try {
      return this.a.getByte(paramString);
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public byte getByte(String paramString, byte paramByte) {
    try {
      return this.a.getByte(paramString, paramByte).byteValue();
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getByte exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramByte;
    } 
  }
  
  public byte[] getByteArray(String paramString) {
    try {
      return this.a.getByteArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getByteArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new byte[0];
    } 
  }
  
  public byte[] getByteArrayReturnNotNull(String paramString) {
    try {
      byte[] arrayOfByte2 = this.a.getByteArray(paramString);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null)
        arrayOfByte1 = new byte[0]; 
      return arrayOfByte1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getByteArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new byte[0];
    } 
  }
  
  public char getChar(String paramString) {
    try {
      return this.a.getChar(paramString);
    } catch (Exception exception) {
      return Character.MIN_VALUE;
    } 
  }
  
  public char getChar(String paramString, char paramChar) {
    try {
      return this.a.getChar(paramString, paramChar);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getChar exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramChar;
    } 
  }
  
  public char[] getCharArray(String paramString) {
    try {
      return this.a.getCharArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new char[0];
    } 
  }
  
  public char[] getCharArrayReturnNotNull(String paramString) {
    try {
      char[] arrayOfChar2 = this.a.getCharArray(paramString);
      char[] arrayOfChar1 = arrayOfChar2;
      if (arrayOfChar2 == null)
        arrayOfChar1 = new char[0]; 
      return arrayOfChar1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new char[0];
    } 
  }
  
  public CharSequence getCharSequence(String paramString) {
    try {
      return this.a.getCharSequence(paramString);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public CharSequence getCharSequence(String paramString, CharSequence paramCharSequence) {
    try {
      return this.a.getCharSequence(paramString, paramCharSequence);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequence exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramCharSequence;
    } 
  }
  
  public CharSequence[] getCharSequenceArray(String paramString) {
    try {
      return this.a.getCharSequenceArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequenceArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new CharSequence[0];
    } 
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayList(String paramString) {
    try {
      return this.a.getCharSequenceArrayList(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequenceArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<CharSequence>();
    } 
  }
  
  public ArrayList<CharSequence> getCharSequenceArrayListReturnNotNull(String paramString) {
    try {
      ArrayList<CharSequence> arrayList2 = this.a.getCharSequenceArrayList(paramString);
      ArrayList<CharSequence> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequenceArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<CharSequence>();
    } 
  }
  
  public CharSequence[] getCharSequenceArrayReturnNotNull(String paramString) {
    try {
      CharSequence[] arrayOfCharSequence2 = this.a.getCharSequenceArray(paramString);
      CharSequence[] arrayOfCharSequence1 = arrayOfCharSequence2;
      if (arrayOfCharSequence2 == null)
        arrayOfCharSequence1 = new CharSequence[0]; 
      return arrayOfCharSequence1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequenceArrayReturnNotNull exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new CharSequence[0];
    } 
  }
  
  public CharSequence getCharSequenceReturnNotNull(String paramString) {
    CharSequence charSequence;
    try {
      charSequence = this.a.getCharSequence(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequenceReturnNotNull exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      charSequence = "";
    } 
    return TextUtils.isEmpty(charSequence) ? "" : charSequence;
  }
  
  public CharSequence getCharSequenceReturnNotNull(String paramString, CharSequence paramCharSequence) {
    try {
      CharSequence charSequence2 = this.a.getCharSequence(paramString, paramCharSequence);
      CharSequence charSequence1 = charSequence2;
      if (charSequence2 == null)
        charSequence1 = ""; 
      return charSequence1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getCharSequence exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramCharSequence;
    } 
  }
  
  public double getDouble(String paramString) {
    return getDouble(paramString, 0.0D);
  }
  
  public double getDouble(String paramString, double paramDouble) {
    try {
      return this.a.getDouble(paramString, paramDouble);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getDouble exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramDouble;
    } 
  }
  
  public double[] getDoubleArray(String paramString) {
    try {
      return this.a.getDoubleArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getDoubleArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new double[0];
    } 
  }
  
  public double[] getDoubleArrayReturnNotNull(String paramString) {
    try {
      double[] arrayOfDouble2 = this.a.getDoubleArray(paramString);
      double[] arrayOfDouble1 = arrayOfDouble2;
      if (arrayOfDouble2 == null)
        arrayOfDouble1 = new double[0]; 
      return arrayOfDouble1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getDoubleArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new double[0];
    } 
  }
  
  public float getFloat(String paramString) {
    return getFloat(paramString, 0.0F);
  }
  
  public float getFloat(String paramString, float paramFloat) {
    try {
      return this.a.getFloat(paramString, paramFloat);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getFloat exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramFloat;
    } 
  }
  
  public float[] getFloatArray(String paramString) {
    try {
      return this.a.getFloatArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getFloatArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new float[0];
    } 
  }
  
  public float[] getFloatArrayReturnNotNull(String paramString) {
    try {
      float[] arrayOfFloat2 = this.a.getFloatArray(paramString);
      float[] arrayOfFloat1 = arrayOfFloat2;
      if (arrayOfFloat2 == null)
        arrayOfFloat1 = new float[0]; 
      return arrayOfFloat1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getFloatArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new float[0];
    } 
  }
  
  public int getInt(String paramString) {
    return getInt(paramString, 0);
  }
  
  public int getInt(String paramString, int paramInt) {
    try {
      return this.a.getInt(paramString, paramInt);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getInt exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramInt;
    } 
  }
  
  public int[] getIntArray(String paramString) {
    try {
      return this.a.getIntArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getIntArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new int[0];
    } 
  }
  
  public int[] getIntArrayReturnNotNull(String paramString) {
    try {
      int[] arrayOfInt2 = this.a.getIntArray(paramString);
      int[] arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null)
        arrayOfInt1 = new int[0]; 
      return arrayOfInt1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getIntArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new int[0];
    } 
  }
  
  public ArrayList<Integer> getIntegerArrayList(String paramString) {
    try {
      return this.a.getIntegerArrayList(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getIntegerArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<Integer>();
    } 
  }
  
  public ArrayList<Integer> getIntegerArrayListReturnNotNull(String paramString) {
    try {
      ArrayList<Integer> arrayList2 = this.a.getIntegerArrayList(paramString);
      ArrayList<Integer> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getIntegerArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<Integer>();
    } 
  }
  
  public long getLong(String paramString) {
    return getLong(paramString, 0L);
  }
  
  public long getLong(String paramString, long paramLong) {
    try {
      return this.a.getLong(paramString, paramLong);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getLong exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramLong;
    } 
  }
  
  public long[] getLongArray(String paramString) {
    try {
      return this.a.getLongArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getLongArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new long[0];
    } 
  }
  
  public long[] getLongArrayReturnNotNull(String paramString) {
    try {
      long[] arrayOfLong2 = this.a.getLongArray(paramString);
      long[] arrayOfLong1 = arrayOfLong2;
      if (arrayOfLong2 == null)
        arrayOfLong1 = new long[0]; 
      return arrayOfLong1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getLongArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new long[0];
    } 
  }
  
  public <T extends Parcelable> T getParcelable(String paramString) {
    try {
      return (T)this.a.getParcelable(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getParcelable exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public Parcelable[] getParcelableArray(String paramString) {
    try {
      return this.a.getParcelableArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getParcelableArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new Parcelable[0];
    } 
  }
  
  public <T extends Parcelable> ArrayList<T> getParcelableArrayList(String paramString) {
    try {
      return this.a.getParcelableArrayList(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getParcelableArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public Parcelable[] getParcelableArrayReturnNotNull(String paramString) {
    try {
      Parcelable[] arrayOfParcelable2 = this.a.getParcelableArray(paramString);
      Parcelable[] arrayOfParcelable1 = arrayOfParcelable2;
      if (arrayOfParcelable2 == null)
        arrayOfParcelable1 = new Parcelable[0]; 
      return arrayOfParcelable1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getParcelableArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new Parcelable[0];
    } 
  }
  
  public Object getReturnNotNull(String paramString) {
    try {
      Object object2 = this.a.get(paramString);
      Object object1 = object2;
      if (object2 == null)
        object1 = new Object(); 
      return object1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("get exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new Object();
    } 
  }
  
  public Serializable getSerializable(String paramString) {
    try {
      return this.a.getSerializable(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSerializable exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public short getShort(String paramString) {
    try {
      return this.a.getShort(paramString);
    } catch (Exception exception) {
      return 0;
    } 
  }
  
  public short getShort(String paramString, short paramShort) {
    try {
      return this.a.getShort(paramString, paramShort);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getShort exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramShort;
    } 
  }
  
  public short[] getShortArray(String paramString) {
    try {
      return this.a.getShortArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getShortArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new short[0];
    } 
  }
  
  public short[] getShortArrayReturnNotNull(String paramString) {
    try {
      short[] arrayOfShort2 = this.a.getShortArray(paramString);
      short[] arrayOfShort1 = arrayOfShort2;
      if (arrayOfShort2 == null)
        arrayOfShort1 = new short[0]; 
      return arrayOfShort1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getShortArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new short[0];
    } 
  }
  
  public Size getSize(String paramString) {
    try {
      return (Build.VERSION.SDK_INT >= 21) ? this.a.getSize(paramString) : null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSize exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public SizeF getSizeF(String paramString) {
    try {
      return (Build.VERSION.SDK_INT >= 21) ? this.a.getSizeF(paramString) : null;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSizeF exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public <T extends Parcelable> SparseArray<T> getSparseParcelableArray(String paramString) {
    try {
      return this.a.getSparseParcelableArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getSparseParcelableArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return null;
    } 
  }
  
  public String getString(String paramString) {
    try {
      return this.a.getString(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return "";
    } 
  }
  
  public String getString(String paramString1, String paramString2) {
    try {
      return this.a.getString(paramString1, paramString2);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramString2;
    } 
  }
  
  public String[] getStringArray(String paramString) {
    try {
      return this.a.getStringArray(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getStringArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new String[0];
    } 
  }
  
  public ArrayList<String> getStringArrayList(String paramString) {
    try {
      return this.a.getStringArrayList(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getStringArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<String>();
    } 
  }
  
  public ArrayList<String> getStringArrayListReturnNotNull(String paramString) {
    try {
      ArrayList<String> arrayList2 = this.a.getStringArrayList(paramString);
      ArrayList<String> arrayList1 = arrayList2;
      if (arrayList2 == null)
        arrayList1 = new ArrayList(); 
      return arrayList1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getStringArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new ArrayList<String>();
    } 
  }
  
  public String[] getStringArrayReturnNotNull(String paramString) {
    try {
      String[] arrayOfString2 = this.a.getStringArray(paramString);
      String[] arrayOfString1 = arrayOfString2;
      if (arrayOfString2 == null)
        arrayOfString1 = new String[0]; 
      return arrayOfString1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getStringArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return new String[0];
    } 
  }
  
  public String getStringReturnNotNull(String paramString) {
    String str;
    try {
      paramString = this.a.getString(paramString);
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      str = "";
    } 
    return TextUtils.isEmpty(str) ? "" : str;
  }
  
  public String getStringReturnNotNull(String paramString1, String paramString2) {
    try {
      paramString1 = this.a.getString(paramString1, paramString2);
      return (paramString1 == null) ? paramString2 : paramString1;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("getString exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return paramString2;
    } 
  }
  
  public boolean isEmpty() {
    try {
      return this.a.isEmpty();
    } catch (Exception exception) {
      a.a("SafeBundle", "isEmpty exception");
      return true;
    } 
  }
  
  public Set<String> keySet() {
    try {
      return this.a.keySet();
    } catch (Exception exception) {
      a.a("SafeBundle", "keySet exception.");
      return null;
    } 
  }
  
  public SafeBundle putAll(Bundle paramBundle) {
    if (paramBundle != null)
      try {
        this.a.putAll(paramBundle);
        return this;
      } catch (Exception exception) {
        a.a("SafeBundle", "putAll exception");
      }  
    return this;
  }
  
  public SafeBundle putBinder(String paramString, IBinder paramIBinder) {
    try {
      if (Build.VERSION.SDK_INT >= 18) {
        this.a.putBinder(paramString, paramIBinder);
        return this;
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putBundle exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
    } 
    return this;
  }
  
  public SafeBundle putBoolean(String paramString, boolean paramBoolean) {
    try {
      this.a.putBoolean(paramString, paramBoolean);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putBoolean exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putBooleanArray(String paramString, boolean[] paramArrayOfboolean) {
    try {
      this.a.putBooleanArray(paramString, paramArrayOfboolean);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putBooleanArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putBundle(String paramString, Bundle paramBundle) {
    try {
      this.a.putBundle(paramString, paramBundle);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putBundle exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putByte(String paramString, byte paramByte) {
    try {
      this.a.putByte(paramString, paramByte);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putByte exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putByteArray(String paramString, byte[] paramArrayOfbyte) {
    try {
      this.a.putByteArray(paramString, paramArrayOfbyte);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putByteArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putChar(String paramString, char paramChar) {
    try {
      this.a.putChar(paramString, paramChar);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putChar exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putCharArray(String paramString, char[] paramArrayOfchar) {
    try {
      this.a.putCharArray(paramString, paramArrayOfchar);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putCharArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putCharSequence(String paramString, CharSequence paramCharSequence) {
    try {
      this.a.putCharSequence(paramString, paramCharSequence);
      return this;
    } catch (Exception exception) {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append("putCharSequence exception: ");
      paramCharSequence.append(exception.getMessage());
      a.a("SafeBundle", paramCharSequence.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putCharSequenceArray(String paramString, CharSequence[] paramArrayOfCharSequence) {
    try {
      this.a.putCharSequenceArray(paramString, paramArrayOfCharSequence);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putCharSequenceArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putCharSequenceArrayList(String paramString, ArrayList<CharSequence> paramArrayList) {
    try {
      this.a.putCharSequenceArrayList(paramString, paramArrayList);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putCharSequenceArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putDouble(String paramString, double paramDouble) {
    try {
      this.a.putDouble(paramString, paramDouble);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putLong exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putDoubleArray(String paramString, double[] paramArrayOfdouble) {
    try {
      this.a.putDoubleArray(paramString, paramArrayOfdouble);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putDoubleArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putFloat(String paramString, float paramFloat) {
    try {
      this.a.putFloat(paramString, paramFloat);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putFloat exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putFloatArray(String paramString, float[] paramArrayOffloat) {
    try {
      this.a.putFloatArray(paramString, paramArrayOffloat);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putFloatArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putInt(String paramString, int paramInt) {
    try {
      this.a.putInt(paramString, paramInt);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putInt exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putIntArray(String paramString, int[] paramArrayOfint) {
    try {
      this.a.putIntArray(paramString, paramArrayOfint);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putIntArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putIntegerArrayList(String paramString, ArrayList<Integer> paramArrayList) {
    try {
      this.a.putIntegerArrayList(paramString, paramArrayList);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putIntegerArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putLong(String paramString, long paramLong) {
    try {
      this.a.putLong(paramString, paramLong);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putLong exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putLongArray(String paramString, long[] paramArrayOflong) {
    try {
      this.a.putLongArray(paramString, paramArrayOflong);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putLongArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putParcelable(String paramString, Parcelable paramParcelable) {
    try {
      this.a.putParcelable(paramString, paramParcelable);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putParcelable exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putParcelableArray(String paramString, Parcelable[] paramArrayOfParcelable) {
    try {
      this.a.putParcelableArray(paramString, paramArrayOfParcelable);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putParcelableArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putParcelableArrayList(String paramString, ArrayList<? extends Parcelable> paramArrayList) {
    try {
      this.a.putParcelableArrayList(paramString, paramArrayList);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putParcelableArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putSerializable(String paramString, Serializable paramSerializable) {
    try {
      this.a.putSerializable(paramString, paramSerializable);
      return this;
    } catch (Exception exception) {
      paramSerializable = new StringBuilder();
      paramSerializable.append("putSerializable exception: ");
      paramSerializable.append(exception.getMessage());
      a.a("SafeBundle", paramSerializable.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putShort(String paramString, short paramShort) {
    try {
      this.a.putShort(paramString, paramShort);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putShort exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putShortArray(String paramString, short[] paramArrayOfshort) {
    try {
      this.a.putShortArray(paramString, paramArrayOfshort);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putShortArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putSize(String paramString, Size paramSize) {
    try {
      this.a.putSize(paramString, paramSize);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putSize exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putSizeF(String paramString, SizeF paramSizeF) {
    try {
      this.a.putSizeF(paramString, paramSizeF);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putSizeF exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putSparseParcelableArray(String paramString, SparseArray<? extends Parcelable> paramSparseArray) {
    try {
      this.a.putSparseParcelableArray(paramString, paramSparseArray);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putSparseParcelableArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putString(String paramString1, String paramString2) {
    try {
      this.a.putString(paramString1, paramString2);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putLong exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putStringArray(String paramString, String[] paramArrayOfString) {
    try {
      this.a.putStringArray(paramString, paramArrayOfString);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putStringArray exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public SafeBundle putStringArrayList(String paramString, ArrayList<String> paramArrayList) {
    try {
      this.a.putStringArrayList(paramString, paramArrayList);
      return this;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("putStringArrayList exception: ");
      stringBuilder.append(exception.getMessage());
      a.a("SafeBundle", stringBuilder.toString(), true);
      return this;
    } 
  }
  
  public void remove(String paramString) {
    try {
      this.a.remove(paramString);
      return;
    } catch (Exception exception) {
      a.a("SafeBundle", "remove exception. key:");
      return;
    } 
  }
  
  public int size() {
    try {
      return this.a.size();
    } catch (Exception exception) {
      a.a("SafeBundle", "size exception");
      return 0;
    } 
  }
  
  public String toString() {
    return this.a.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hm\\ui\SafeBundle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */