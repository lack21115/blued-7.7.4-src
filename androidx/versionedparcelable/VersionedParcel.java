package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class VersionedParcel {
  protected final ArrayMap<String, Method> a;
  
  protected final ArrayMap<String, Method> b;
  
  protected final ArrayMap<String, Class> c;
  
  public VersionedParcel(ArrayMap<String, Method> paramArrayMap1, ArrayMap<String, Method> paramArrayMap2, ArrayMap<String, Class> paramArrayMap) {
    this.a = paramArrayMap1;
    this.b = paramArrayMap2;
    this.c = paramArrayMap;
  }
  
  private <T> int a(T paramT) {
    if (paramT instanceof String)
      return 4; 
    if (paramT instanceof Parcelable)
      return 2; 
    if (paramT instanceof VersionedParcelable)
      return 1; 
    if (paramT instanceof Serializable)
      return 3; 
    if (paramT instanceof IBinder)
      return 5; 
    if (paramT instanceof Integer)
      return 7; 
    if (paramT instanceof Float)
      return 8; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramT.getClass().getName());
    stringBuilder.append(" cannot be VersionedParcelled");
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  private Exception a(int paramInt, String paramString) {
    return b(paramInt, paramString);
  }
  
  private Method a(Class<? extends VersionedParcelable> paramClass) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
    Method method2 = (Method)this.b.get(paramClass.getName());
    Method method1 = method2;
    if (method2 == null) {
      Class clazz = b(paramClass);
      System.currentTimeMillis();
      method1 = clazz.getDeclaredMethod("write", new Class[] { paramClass, VersionedParcel.class });
      this.b.put(paramClass.getName(), method1);
    } 
    return method1;
  }
  
  private Method a(String paramString) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
    Method method2 = (Method)this.a.get(paramString);
    Method method1 = method2;
    if (method2 == null) {
      System.currentTimeMillis();
      method1 = Class.forName(paramString, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[] { VersionedParcel.class });
      this.a.put(paramString, method1);
    } 
    return method1;
  }
  
  private void a(Serializable paramSerializable) {
    if (paramSerializable == null) {
      writeString(null);
      return;
    } 
    String str = paramSerializable.getClass().getName();
    writeString(str);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    try {
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
      objectOutputStream.writeObject(paramSerializable);
      objectOutputStream.close();
      writeByteArray(byteArrayOutputStream.toByteArray());
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VersionedParcelable encountered IOException writing serializable object (name = ");
      stringBuilder.append(str);
      stringBuilder.append(")");
      throw new RuntimeException(stringBuilder.toString(), iOException);
    } 
  }
  
  private <T> void a(Collection<T> paramCollection) {
    if (paramCollection == null) {
      writeInt(-1);
      return;
    } 
    int i = paramCollection.size();
    writeInt(i);
    if (i > 0) {
      i = a(paramCollection.iterator().next());
      writeInt(i);
      switch (i) {
        default:
          return;
        case 8:
          iterator = paramCollection.iterator();
          while (iterator.hasNext())
            writeFloat(((Float)iterator.next()).floatValue()); 
          return;
        case 7:
          iterator = iterator.iterator();
          while (iterator.hasNext())
            writeInt(((Integer)iterator.next()).intValue()); 
          return;
        case 5:
          iterator = iterator.iterator();
          while (iterator.hasNext())
            writeStrongBinder((IBinder)iterator.next()); 
          return;
        case 4:
          iterator = iterator.iterator();
          while (iterator.hasNext())
            writeString((String)iterator.next()); 
          return;
        case 3:
          iterator = iterator.iterator();
          while (iterator.hasNext())
            a((Serializable)iterator.next()); 
          return;
        case 2:
          iterator = iterator.iterator();
          while (iterator.hasNext())
            writeParcelable((Parcelable)iterator.next()); 
          return;
        case 1:
          break;
      } 
      Iterator<T> iterator = iterator.iterator();
      while (iterator.hasNext())
        a((VersionedParcelable)iterator.next()); 
    } 
  }
  
  private <T> void a(Collection<T> paramCollection, int paramInt) {
    setOutputField(paramInt);
    a(paramCollection);
  }
  
  private Class b(Class<? extends VersionedParcelable> paramClass) throws ClassNotFoundException {
    Class<?> clazz2 = (Class)this.c.get(paramClass.getName());
    Class<?> clazz1 = clazz2;
    if (clazz2 == null) {
      clazz1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      this.c.put(paramClass.getName(), clazz1);
    } 
    return clazz1;
  }
  
  private Exception b(int paramInt, String paramString) {
    StringBuilder stringBuilder;
    switch (paramInt) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unknown exception code: ");
        stringBuilder.append(paramInt);
        stringBuilder.append(" msg ");
        stringBuilder.append(paramString);
        return new RuntimeException(stringBuilder.toString());
      case -1:
        return new SecurityException(paramString);
      case -2:
        return (Exception)new BadParcelableException(paramString);
      case -3:
        return new IllegalArgumentException(paramString);
      case -4:
        return new NullPointerException(paramString);
      case -5:
        return new IllegalStateException(paramString);
      case -6:
        return (Exception)new NetworkOnMainThreadException();
      case -7:
        return new UnsupportedOperationException(paramString);
      case -9:
        break;
    } 
    return readParcelable();
  }
  
  private <T, S extends Collection<T>> S b(S paramS) {
    int i = readInt();
    if (i < 0)
      return null; 
    if (i != 0) {
      int k = readInt();
      if (i < 0)
        return null; 
      int j = i;
      if (k != 1) {
        j = i;
        if (k != 2) {
          j = i;
          if (k != 3) {
            j = i;
            if (k != 4) {
              if (k != 5)
                return paramS; 
              while (i > 0) {
                paramS.add(readStrongBinder());
                i--;
              } 
            } else {
              while (j > 0) {
                paramS.add(readString());
                j--;
              } 
            } 
          } else {
            while (j > 0) {
              paramS.add(j());
              j--;
            } 
          } 
        } else {
          while (j > 0) {
            paramS.add(readParcelable());
            j--;
          } 
        } 
      } else {
        while (j > 0) {
          paramS.add(i());
          j--;
        } 
      } 
    } 
    return paramS;
  }
  
  private void b(VersionedParcelable paramVersionedParcelable) {
    try {
      Class clazz = b((Class)paramVersionedParcelable.getClass());
      writeString(clazz.getName());
      return;
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramVersionedParcelable.getClass().getSimpleName());
      stringBuilder.append(" does not have a Parcelizer");
      throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
    } 
  }
  
  private int k() {
    return readInt();
  }
  
  protected abstract VersionedParcel a();
  
  protected <T extends VersionedParcelable> T a(String paramString, VersionedParcel paramVersionedParcel) {
    try {
      return (T)a(paramString).invoke(null, new Object[] { paramVersionedParcel });
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      if (invocationTargetException.getCause() instanceof RuntimeException)
        throw (RuntimeException)invocationTargetException.getCause(); 
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
    } 
  }
  
  protected void a(VersionedParcelable paramVersionedParcelable) {
    if (paramVersionedParcelable == null) {
      writeString(null);
      return;
    } 
    b(paramVersionedParcelable);
    VersionedParcel versionedParcel = a();
    a(paramVersionedParcelable, versionedParcel);
    versionedParcel.closeField();
  }
  
  protected <T extends VersionedParcelable> void a(T paramT, VersionedParcel paramVersionedParcel) {
    try {
      a(paramT.getClass()).invoke(null, new Object[] { paramT, paramVersionedParcel });
      return;
    } catch (IllegalAccessException illegalAccessException) {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", illegalAccessException);
    } catch (InvocationTargetException invocationTargetException) {
      if (invocationTargetException.getCause() instanceof RuntimeException)
        throw (RuntimeException)invocationTargetException.getCause(); 
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", invocationTargetException);
    } catch (NoSuchMethodException noSuchMethodException) {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", noSuchMethodException);
    } catch (ClassNotFoundException classNotFoundException) {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", classNotFoundException);
    } 
  }
  
  protected abstract void a(CharSequence paramCharSequence);
  
  protected void a(double[] paramArrayOfdouble) {
    if (paramArrayOfdouble != null) {
      int j = paramArrayOfdouble.length;
      writeInt(j);
      for (int i = 0; i < j; i++)
        writeDouble(paramArrayOfdouble[i]); 
    } else {
      writeInt(-1);
    } 
  }
  
  protected void a(float[] paramArrayOffloat) {
    if (paramArrayOffloat != null) {
      int j = paramArrayOffloat.length;
      writeInt(j);
      for (int i = 0; i < j; i++)
        writeFloat(paramArrayOffloat[i]); 
    } else {
      writeInt(-1);
    } 
  }
  
  protected void a(int[] paramArrayOfint) {
    if (paramArrayOfint != null) {
      int j = paramArrayOfint.length;
      writeInt(j);
      for (int i = 0; i < j; i++)
        writeInt(paramArrayOfint[i]); 
    } else {
      writeInt(-1);
    } 
  }
  
  protected void a(long[] paramArrayOflong) {
    if (paramArrayOflong != null) {
      int j = paramArrayOflong.length;
      writeInt(j);
      for (int i = 0; i < j; i++)
        writeLong(paramArrayOflong[i]); 
    } else {
      writeInt(-1);
    } 
  }
  
  protected <T> void a(T[] paramArrayOfT) {
    if (paramArrayOfT == null) {
      writeInt(-1);
      return;
    } 
    int i = paramArrayOfT.length;
    writeInt(i);
    if (i > 0) {
      byte b2 = 0;
      byte b3 = 0;
      byte b4 = 0;
      int j = 0;
      byte b1 = 0;
      int k = a(paramArrayOfT[0]);
      writeInt(k);
      if (k != 1) {
        j = b4;
        if (k != 2) {
          j = b3;
          if (k != 3) {
            j = b2;
            if (k != 4) {
              j = b1;
              if (k != 5)
                return; 
              while (j < i) {
                writeStrongBinder((IBinder)paramArrayOfT[j]);
                j++;
              } 
            } else {
              while (j < i) {
                writeString((String)paramArrayOfT[j]);
                j++;
              } 
            } 
          } else {
            while (j < i) {
              a((Serializable)paramArrayOfT[j]);
              j++;
            } 
          } 
        } else {
          while (j < i) {
            writeParcelable((Parcelable)paramArrayOfT[j]);
            j++;
          } 
        } 
      } else {
        while (j < i) {
          a((VersionedParcelable)paramArrayOfT[j]);
          j++;
        } 
      } 
    } 
  }
  
  protected void a(boolean[] paramArrayOfboolean) {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e2expr(TypeTransformer.java:553)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:716)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  protected abstract CharSequence b();
  
  protected <T> T[] b(T[] paramArrayOfT) {
    int i = readInt();
    if (i < 0)
      return null; 
    ArrayList<IBinder> arrayList = new ArrayList(i);
    if (i != 0) {
      int k = readInt();
      if (i < 0)
        return null; 
      int j = i;
      if (k != 1) {
        j = i;
        if (k != 2) {
          j = i;
          if (k != 3) {
            j = i;
            if (k != 4) {
              if (k == 5)
                while (i > 0) {
                  arrayList.add(readStrongBinder());
                  i--;
                }  
            } else {
              while (j > 0) {
                arrayList.add(readString());
                j--;
              } 
            } 
          } else {
            while (j > 0) {
              arrayList.add(j());
              j--;
            } 
          } 
        } else {
          while (j > 0) {
            arrayList.add(readParcelable());
            j--;
          } 
        } 
      } else {
        while (j > 0) {
          arrayList.add(i());
          j--;
        } 
      } 
    } 
    return arrayList.toArray(paramArrayOfT);
  }
  
  protected boolean[] c() {
    int j = readInt();
    if (j < 0)
      return null; 
    boolean[] arrayOfBoolean = new boolean[j];
    for (int i = 0; i < j; i++) {
      boolean bool;
      if (readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      } 
      arrayOfBoolean[i] = bool;
    } 
    return arrayOfBoolean;
  }
  
  protected abstract void closeField();
  
  protected int[] d() {
    int j = readInt();
    if (j < 0)
      return null; 
    int[] arrayOfInt = new int[j];
    for (int i = 0; i < j; i++)
      arrayOfInt[i] = readInt(); 
    return arrayOfInt;
  }
  
  protected long[] e() {
    int j = readInt();
    if (j < 0)
      return null; 
    long[] arrayOfLong = new long[j];
    for (int i = 0; i < j; i++)
      arrayOfLong[i] = readLong(); 
    return arrayOfLong;
  }
  
  protected float[] f() {
    int j = readInt();
    if (j < 0)
      return null; 
    float[] arrayOfFloat = new float[j];
    for (int i = 0; i < j; i++)
      arrayOfFloat[i] = readFloat(); 
    return arrayOfFloat;
  }
  
  protected double[] g() {
    int j = readInt();
    if (j < 0)
      return null; 
    double[] arrayOfDouble = new double[j];
    for (int i = 0; i < j; i++)
      arrayOfDouble[i] = readDouble(); 
    return arrayOfDouble;
  }
  
  protected void h() {
    writeInt(0);
  }
  
  protected <T extends VersionedParcelable> T i() {
    String str = readString();
    return (str == null) ? null : a(str, a());
  }
  
  public boolean isStream() {
    return false;
  }
  
  protected Serializable j() {
    String str = readString();
    if (str == null)
      return null; 
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readByteArray());
    try {
      return (Serializable)(new ObjectInputStream(this, byteArrayInputStream) {
          protected Class<?> resolveClass(ObjectStreamClass param1ObjectStreamClass) throws IOException, ClassNotFoundException {
            Class<?> clazz = Class.forName(param1ObjectStreamClass.getName(), false, getClass().getClassLoader());
            return (clazz != null) ? clazz : super.resolveClass(param1ObjectStreamClass);
          }
        }).readObject();
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VersionedParcelable encountered IOException reading a Serializable object (name = ");
      stringBuilder.append(str);
      stringBuilder.append(")");
      throw new RuntimeException(stringBuilder.toString(), iOException);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = ");
      stringBuilder.append(str);
      stringBuilder.append(")");
      throw new RuntimeException(stringBuilder.toString(), classNotFoundException);
    } 
  }
  
  public <T> T[] readArray(T[] paramArrayOfT, int paramInt) {
    return !readField(paramInt) ? paramArrayOfT : b(paramArrayOfT);
  }
  
  protected abstract boolean readBoolean();
  
  public boolean readBoolean(boolean paramBoolean, int paramInt) {
    return !readField(paramInt) ? paramBoolean : readBoolean();
  }
  
  public boolean[] readBooleanArray(boolean[] paramArrayOfboolean, int paramInt) {
    return !readField(paramInt) ? paramArrayOfboolean : c();
  }
  
  protected abstract Bundle readBundle();
  
  public Bundle readBundle(Bundle paramBundle, int paramInt) {
    return !readField(paramInt) ? paramBundle : readBundle();
  }
  
  public byte readByte(byte paramByte, int paramInt) {
    return !readField(paramInt) ? paramByte : (byte)(readInt() & 0xFF);
  }
  
  protected abstract byte[] readByteArray();
  
  public byte[] readByteArray(byte[] paramArrayOfbyte, int paramInt) {
    return !readField(paramInt) ? paramArrayOfbyte : readByteArray();
  }
  
  public char[] readCharArray(char[] paramArrayOfchar, int paramInt) {
    if (!readField(paramInt))
      return paramArrayOfchar; 
    int i = readInt();
    if (i < 0)
      return null; 
    paramArrayOfchar = new char[i];
    for (paramInt = 0; paramInt < i; paramInt++)
      paramArrayOfchar[paramInt] = (char)readInt(); 
    return paramArrayOfchar;
  }
  
  public CharSequence readCharSequence(CharSequence paramCharSequence, int paramInt) {
    return !readField(paramInt) ? paramCharSequence : b();
  }
  
  protected abstract double readDouble();
  
  public double readDouble(double paramDouble, int paramInt) {
    return !readField(paramInt) ? paramDouble : readDouble();
  }
  
  public double[] readDoubleArray(double[] paramArrayOfdouble, int paramInt) {
    return !readField(paramInt) ? paramArrayOfdouble : g();
  }
  
  public Exception readException(Exception paramException, int paramInt) {
    if (!readField(paramInt))
      return paramException; 
    paramInt = k();
    if (paramInt != 0)
      paramException = a(paramInt, readString()); 
    return paramException;
  }
  
  protected abstract boolean readField(int paramInt);
  
  protected abstract float readFloat();
  
  public float readFloat(float paramFloat, int paramInt) {
    return !readField(paramInt) ? paramFloat : readFloat();
  }
  
  public float[] readFloatArray(float[] paramArrayOffloat, int paramInt) {
    return !readField(paramInt) ? paramArrayOffloat : f();
  }
  
  protected abstract int readInt();
  
  public int readInt(int paramInt1, int paramInt2) {
    return !readField(paramInt2) ? paramInt1 : readInt();
  }
  
  public int[] readIntArray(int[] paramArrayOfint, int paramInt) {
    return !readField(paramInt) ? paramArrayOfint : d();
  }
  
  public <T> List<T> readList(List<T> paramList, int paramInt) {
    return !readField(paramInt) ? paramList : b(new ArrayList<T>());
  }
  
  protected abstract long readLong();
  
  public long readLong(long paramLong, int paramInt) {
    return !readField(paramInt) ? paramLong : readLong();
  }
  
  public long[] readLongArray(long[] paramArrayOflong, int paramInt) {
    return !readField(paramInt) ? paramArrayOflong : e();
  }
  
  public <K, V> Map<K, V> readMap(Map<K, V> paramMap, int paramInt) {
    if (!readField(paramInt))
      return paramMap; 
    int i = readInt();
    if (i < 0)
      return null; 
    ArrayMap arrayMap = new ArrayMap();
    if (i == 0)
      return (Map<K, V>)arrayMap; 
    ArrayList arrayList1 = new ArrayList();
    ArrayList arrayList2 = new ArrayList();
    b(arrayList1);
    b(arrayList2);
    for (paramInt = 0; paramInt < i; paramInt++)
      arrayMap.put(arrayList1.get(paramInt), arrayList2.get(paramInt)); 
    return (Map<K, V>)arrayMap;
  }
  
  protected abstract <T extends Parcelable> T readParcelable();
  
  public <T extends Parcelable> T readParcelable(T paramT, int paramInt) {
    return !readField(paramInt) ? paramT : readParcelable();
  }
  
  public <T> Set<T> readSet(Set<T> paramSet, int paramInt) {
    return !readField(paramInt) ? paramSet : (Set<T>)b(new ArraySet());
  }
  
  public Size readSize(Size paramSize, int paramInt) {
    return !readField(paramInt) ? paramSize : (readBoolean() ? new Size(readInt(), readInt()) : null);
  }
  
  public SizeF readSizeF(SizeF paramSizeF, int paramInt) {
    return !readField(paramInt) ? paramSizeF : (readBoolean() ? new SizeF(readFloat(), readFloat()) : null);
  }
  
  public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray paramSparseBooleanArray, int paramInt) {
    if (!readField(paramInt))
      return paramSparseBooleanArray; 
    int i = readInt();
    if (i < 0)
      return null; 
    paramSparseBooleanArray = new SparseBooleanArray(i);
    for (paramInt = 0; paramInt < i; paramInt++)
      paramSparseBooleanArray.put(readInt(), readBoolean()); 
    return paramSparseBooleanArray;
  }
  
  protected abstract String readString();
  
  public String readString(String paramString, int paramInt) {
    return !readField(paramInt) ? paramString : readString();
  }
  
  protected abstract IBinder readStrongBinder();
  
  public IBinder readStrongBinder(IBinder paramIBinder, int paramInt) {
    return !readField(paramInt) ? paramIBinder : readStrongBinder();
  }
  
  public <T extends VersionedParcelable> T readVersionedParcelable(T paramT, int paramInt) {
    return !readField(paramInt) ? paramT : i();
  }
  
  protected abstract void setOutputField(int paramInt);
  
  public void setSerializationFlags(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public <T> void writeArray(T[] paramArrayOfT, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOfT);
  }
  
  protected abstract void writeBoolean(boolean paramBoolean);
  
  public void writeBoolean(boolean paramBoolean, int paramInt) {
    setOutputField(paramInt);
    writeBoolean(paramBoolean);
  }
  
  public void writeBooleanArray(boolean[] paramArrayOfboolean, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOfboolean);
  }
  
  protected abstract void writeBundle(Bundle paramBundle);
  
  public void writeBundle(Bundle paramBundle, int paramInt) {
    setOutputField(paramInt);
    writeBundle(paramBundle);
  }
  
  public void writeByte(byte paramByte, int paramInt) {
    setOutputField(paramInt);
    writeInt(paramByte);
  }
  
  protected abstract void writeByteArray(byte[] paramArrayOfbyte);
  
  public void writeByteArray(byte[] paramArrayOfbyte, int paramInt) {
    setOutputField(paramInt);
    writeByteArray(paramArrayOfbyte);
  }
  
  protected abstract void writeByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2);
  
  public void writeByteArray(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, int paramInt3) {
    setOutputField(paramInt3);
    writeByteArray(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public void writeCharArray(char[] paramArrayOfchar, int paramInt) {
    setOutputField(paramInt);
    if (paramArrayOfchar != null) {
      int i = paramArrayOfchar.length;
      writeInt(i);
      for (paramInt = 0; paramInt < i; paramInt++)
        writeInt(paramArrayOfchar[paramInt]); 
    } else {
      writeInt(-1);
    } 
  }
  
  public void writeCharSequence(CharSequence paramCharSequence, int paramInt) {
    setOutputField(paramInt);
    a(paramCharSequence);
  }
  
  protected abstract void writeDouble(double paramDouble);
  
  public void writeDouble(double paramDouble, int paramInt) {
    setOutputField(paramInt);
    writeDouble(paramDouble);
  }
  
  public void writeDoubleArray(double[] paramArrayOfdouble, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOfdouble);
  }
  
  public void writeException(Exception paramException, int paramInt) {
    setOutputField(paramInt);
    if (paramException == null) {
      h();
      return;
    } 
    paramInt = 0;
    if (paramException instanceof Parcelable && paramException.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
      paramInt = -9;
    } else if (paramException instanceof SecurityException) {
      paramInt = -1;
    } else if (paramException instanceof BadParcelableException) {
      paramInt = -2;
    } else if (paramException instanceof IllegalArgumentException) {
      paramInt = -3;
    } else if (paramException instanceof NullPointerException) {
      paramInt = -4;
    } else if (paramException instanceof IllegalStateException) {
      paramInt = -5;
    } else if (paramException instanceof NetworkOnMainThreadException) {
      paramInt = -6;
    } else if (paramException instanceof UnsupportedOperationException) {
      paramInt = -7;
    } 
    writeInt(paramInt);
    if (paramInt == 0) {
      if (paramException instanceof RuntimeException)
        throw (RuntimeException)paramException; 
      throw new RuntimeException(paramException);
    } 
    writeString(paramException.getMessage());
    if (paramInt != -9)
      return; 
    writeParcelable((Parcelable)paramException);
  }
  
  protected abstract void writeFloat(float paramFloat);
  
  public void writeFloat(float paramFloat, int paramInt) {
    setOutputField(paramInt);
    writeFloat(paramFloat);
  }
  
  public void writeFloatArray(float[] paramArrayOffloat, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOffloat);
  }
  
  protected abstract void writeInt(int paramInt);
  
  public void writeInt(int paramInt1, int paramInt2) {
    setOutputField(paramInt2);
    writeInt(paramInt1);
  }
  
  public void writeIntArray(int[] paramArrayOfint, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOfint);
  }
  
  public <T> void writeList(List<T> paramList, int paramInt) {
    a(paramList, paramInt);
  }
  
  protected abstract void writeLong(long paramLong);
  
  public void writeLong(long paramLong, int paramInt) {
    setOutputField(paramInt);
    writeLong(paramLong);
  }
  
  public void writeLongArray(long[] paramArrayOflong, int paramInt) {
    setOutputField(paramInt);
    a(paramArrayOflong);
  }
  
  public <K, V> void writeMap(Map<K, V> paramMap, int paramInt) {
    setOutputField(paramInt);
    if (paramMap == null) {
      writeInt(-1);
      return;
    } 
    paramInt = paramMap.size();
    writeInt(paramInt);
    if (paramInt == 0)
      return; 
    ArrayList<?> arrayList1 = new ArrayList();
    ArrayList<?> arrayList2 = new ArrayList();
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      arrayList1.add(entry.getKey());
      arrayList2.add(entry.getValue());
    } 
    a(arrayList1);
    a(arrayList2);
  }
  
  protected abstract void writeParcelable(Parcelable paramParcelable);
  
  public void writeParcelable(Parcelable paramParcelable, int paramInt) {
    setOutputField(paramInt);
    writeParcelable(paramParcelable);
  }
  
  public void writeSerializable(Serializable paramSerializable, int paramInt) {
    setOutputField(paramInt);
    a(paramSerializable);
  }
  
  public <T> void writeSet(Set<T> paramSet, int paramInt) {
    a(paramSet, paramInt);
  }
  
  public void writeSize(Size paramSize, int paramInt) {
    boolean bool;
    setOutputField(paramInt);
    if (paramSize != null) {
      bool = true;
    } else {
      bool = false;
    } 
    writeBoolean(bool);
    if (paramSize != null) {
      writeInt(paramSize.getWidth());
      writeInt(paramSize.getHeight());
    } 
  }
  
  public void writeSizeF(SizeF paramSizeF, int paramInt) {
    boolean bool;
    setOutputField(paramInt);
    if (paramSizeF != null) {
      bool = true;
    } else {
      bool = false;
    } 
    writeBoolean(bool);
    if (paramSizeF != null) {
      writeFloat(paramSizeF.getWidth());
      writeFloat(paramSizeF.getHeight());
    } 
  }
  
  public void writeSparseBooleanArray(SparseBooleanArray paramSparseBooleanArray, int paramInt) {
    setOutputField(paramInt);
    if (paramSparseBooleanArray == null) {
      writeInt(-1);
      return;
    } 
    int i = paramSparseBooleanArray.size();
    writeInt(i);
    for (paramInt = 0; paramInt < i; paramInt++) {
      writeInt(paramSparseBooleanArray.keyAt(paramInt));
      writeBoolean(paramSparseBooleanArray.valueAt(paramInt));
    } 
  }
  
  protected abstract void writeString(String paramString);
  
  public void writeString(String paramString, int paramInt) {
    setOutputField(paramInt);
    writeString(paramString);
  }
  
  protected abstract void writeStrongBinder(IBinder paramIBinder);
  
  public void writeStrongBinder(IBinder paramIBinder, int paramInt) {
    setOutputField(paramInt);
    writeStrongBinder(paramIBinder);
  }
  
  protected abstract void writeStrongInterface(IInterface paramIInterface);
  
  public void writeStrongInterface(IInterface paramIInterface, int paramInt) {
    setOutputField(paramInt);
    writeStrongInterface(paramIInterface);
  }
  
  public void writeVersionedParcelable(VersionedParcelable paramVersionedParcelable, int paramInt) {
    setOutputField(paramInt);
    a(paramVersionedParcelable);
  }
  
  public static class ParcelException extends RuntimeException {
    public ParcelException(Throwable param1Throwable) {
      super(param1Throwable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\versionedparcelable\VersionedParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */