package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.sqlite.CursorWrapper;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
  public static final Parcelable.Creator<DataHolder> CREATOR = new zac();
  
  private static final Builder zak = new zab(new String[0], null);
  
  private final int zaa;
  
  private final String[] zab;
  
  private Bundle zac;
  
  private final CursorWindow[] zad;
  
  private final int zae;
  
  private final Bundle zaf;
  
  private int[] zag;
  
  private int zah;
  
  private boolean zai = false;
  
  private boolean zaj = true;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle) {
    this.zaa = paramInt1;
    this.zab = paramArrayOfString;
    this.zad = paramArrayOfCursorWindow;
    this.zae = paramInt2;
    this.zaf = paramBundle;
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle) {
    this(new CursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle) {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt, (Bundle)null);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2) {
    this(Builder.zaa(paramBuilder), zaa(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(CursorWrapper paramCursorWrapper, int paramInt, Bundle paramBundle) {
    this(paramCursorWrapper.getColumnNames(), zaa(paramCursorWrapper), paramInt, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle) {
    this.zaa = 1;
    this.zab = (String[])Preconditions.checkNotNull(paramArrayOfString);
    this.zad = (CursorWindow[])Preconditions.checkNotNull(paramArrayOfCursorWindow);
    this.zae = paramInt;
    this.zaf = paramBundle;
    zaa();
  }
  
  public static Builder builder(String[] paramArrayOfString) {
    return new Builder(paramArrayOfString, null, null);
  }
  
  public static DataHolder empty(int paramInt) {
    return new DataHolder(zak, paramInt, null);
  }
  
  private final void zaa(String paramString, int paramInt) {
    Bundle bundle = this.zac;
    if (bundle == null || !bundle.containsKey(paramString)) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "No such column: ".concat(paramString);
      } else {
        paramString = new String("No such column: ");
      } 
      throw new IllegalArgumentException(paramString);
    } 
    if (!isClosed()) {
      if (paramInt >= 0 && paramInt < this.zah)
        return; 
      throw new CursorIndexOutOfBoundsException(paramInt, this.zah);
    } 
    throw new IllegalArgumentException("Buffer is closed.");
  }
  
  private static CursorWindow[] zaa(Builder paramBuilder, int paramInt) {
    List<Map> list;
    int i = (Builder.zaa(paramBuilder)).length;
    boolean bool = false;
    if (i == 0)
      return new CursorWindow[0]; 
    if (paramInt < 0 || paramInt >= Builder.zab(paramBuilder).size()) {
      list = Builder.zab(paramBuilder);
    } else {
      list = Builder.zab(paramBuilder).subList(0, paramInt);
    } 
    int j = list.size();
    CursorWindow cursorWindow = new CursorWindow(false);
    ArrayList<CursorWindow> arrayList = new ArrayList();
    arrayList.add(cursorWindow);
    cursorWindow.setNumColumns((Builder.zaa(paramBuilder)).length);
    paramInt = 0;
    i = 0;
    label71: while (true) {
      if (paramInt < j) {
        try {
          CursorWindow cursorWindow1;
          boolean bool1 = cursorWindow.allocRow();
          if (!bool1) {
            StringBuilder stringBuilder = new StringBuilder(72);
            stringBuilder.append("Allocating additional cursor window for large data set (row ");
            stringBuilder.append(paramInt);
            stringBuilder.append(")");
            Log.d("DataHolder", stringBuilder.toString());
            CursorWindow cursorWindow2 = new CursorWindow(false);
            cursorWindow2.setStartPosition(paramInt);
            cursorWindow2.setNumColumns((Builder.zaa(paramBuilder)).length);
            arrayList.add(cursorWindow2);
            cursorWindow1 = cursorWindow2;
            if (!cursorWindow2.allocRow()) {
              Log.e("DataHolder", "Unable to allocate row to hold data.");
              arrayList.remove(cursorWindow2);
              return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
            } 
          } 
          Map map = list.get(paramInt);
          int k = 0;
          bool1 = true;
          while (true) {
            String str;
            StringBuilder stringBuilder;
            if (k < (Builder.zaa(paramBuilder)).length && bool1) {
              String str1 = Builder.zaa(paramBuilder)[k];
              Object object = map.get(str1);
              if (object == null) {
                bool1 = cursorWindow1.putNull(paramInt, k);
              } else if (object instanceof String) {
                bool1 = cursorWindow1.putString((String)object, paramInt, k);
              } else if (object instanceof Long) {
                bool1 = cursorWindow1.putLong(((Long)object).longValue(), paramInt, k);
              } else if (object instanceof Integer) {
                bool1 = cursorWindow1.putLong(((Integer)object).intValue(), paramInt, k);
              } else if (object instanceof Boolean) {
                long l;
                if (((Boolean)object).booleanValue()) {
                  l = 1L;
                } else {
                  l = 0L;
                } 
                bool1 = cursorWindow1.putLong(l, paramInt, k);
              } else if (object instanceof byte[]) {
                bool1 = cursorWindow1.putBlob((byte[])object, paramInt, k);
              } else if (object instanceof Double) {
                bool1 = cursorWindow1.putDouble(((Double)object).doubleValue(), paramInt, k);
              } else if (object instanceof Float) {
                bool1 = cursorWindow1.putDouble(((Float)object).floatValue(), paramInt, k);
              } else {
                str = String.valueOf(object);
                stringBuilder = new StringBuilder(String.valueOf(str1).length() + 32 + String.valueOf(str).length());
                stringBuilder.append("Unsupported object for column ");
                stringBuilder.append(str1);
                stringBuilder.append(": ");
                stringBuilder.append(str);
                throw new IllegalArgumentException(stringBuilder.toString());
              } 
            } else {
              if (!bool1) {
                if (i == 0) {
                  StringBuilder stringBuilder1 = new StringBuilder(74);
                  stringBuilder1.append("Couldn't populate window data for row ");
                  stringBuilder1.append(paramInt);
                  stringBuilder1.append(" - allocating new window.");
                  Log.d("DataHolder", stringBuilder1.toString());
                  stringBuilder.freeLastRow();
                  CursorWindow cursorWindow2 = new CursorWindow(false);
                  cursorWindow2.setStartPosition(paramInt);
                  cursorWindow2.setNumColumns((Builder.zaa((Builder)str)).length);
                  arrayList.add(cursorWindow2);
                  paramInt--;
                  i = 1;
                } else {
                  throw new zaa("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } 
              } else {
                i = 0;
              } 
              paramInt++;
              continue label71;
            } 
            k++;
          } 
        } catch (RuntimeException runtimeException) {
          i = arrayList.size();
          for (paramInt = bool; paramInt < i; paramInt++)
            ((CursorWindow)arrayList.get(paramInt)).close(); 
          throw runtimeException;
        } 
        break;
      } 
      return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
    } 
  }
  
  private static CursorWindow[] zaa(CursorWrapper paramCursorWrapper) {
    ArrayList<CursorWindow> arrayList = new ArrayList();
    try {
      int i;
      int j = paramCursorWrapper.getCount();
      CursorWindow cursorWindow = paramCursorWrapper.getWindow();
      if (cursorWindow != null && cursorWindow.getStartPosition() == 0) {
        cursorWindow.acquireReference();
        paramCursorWrapper.setWindow(null);
        arrayList.add(cursorWindow);
        i = cursorWindow.getNumRows();
      } else {
        i = 0;
      } 
      while (i < j && paramCursorWrapper.moveToPosition(i)) {
        cursorWindow = paramCursorWrapper.getWindow();
        if (cursorWindow != null) {
          cursorWindow.acquireReference();
          paramCursorWrapper.setWindow(null);
        } else {
          cursorWindow = new CursorWindow(false);
          cursorWindow.setStartPosition(i);
          paramCursorWrapper.fillWindow(i, cursorWindow);
        } 
        if (cursorWindow.getNumRows() != 0) {
          arrayList.add(cursorWindow);
          i = cursorWindow.getStartPosition();
          int k = cursorWindow.getNumRows();
          i += k;
        } 
      } 
      return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
    } finally {
      paramCursorWrapper.close();
    } 
  }
  
  public final void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zai : Z
    //   6: ifne -> 41
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield zai : Z
    //   14: iconst_0
    //   15: istore_1
    //   16: iload_1
    //   17: aload_0
    //   18: getfield zad : [Landroid/database/CursorWindow;
    //   21: arraylength
    //   22: if_icmpge -> 41
    //   25: aload_0
    //   26: getfield zad : [Landroid/database/CursorWindow;
    //   29: iload_1
    //   30: aaload
    //   31: invokevirtual close : ()V
    //   34: iload_1
    //   35: iconst_1
    //   36: iadd
    //   37: istore_1
    //   38: goto -> 16
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Exception table:
    //   from	to	target	type
    //   2	14	44	finally
    //   16	34	44	finally
    //   41	43	44	finally
    //   45	47	44	finally
  }
  
  protected final void finalize() throws Throwable {
    try {
      if (this.zaj && this.zad.length > 0 && !isClosed()) {
        close();
        String str = toString();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 178);
        stringBuilder.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
        stringBuilder.append(str);
        stringBuilder.append(")");
        Log.e("DataBuffer", stringBuilder.toString());
      } 
      return;
    } finally {
      super.finalize();
    } 
  }
  
  public final boolean getBoolean(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return (Long.valueOf(this.zad[paramInt2].getLong(paramInt1, this.zac.getInt(paramString))).longValue() == 1L);
  }
  
  public final byte[] getByteArray(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getBlob(paramInt1, this.zac.getInt(paramString));
  }
  
  public final int getCount() {
    return this.zah;
  }
  
  public final int getInteger(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getInt(paramInt1, this.zac.getInt(paramString));
  }
  
  public final long getLong(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getLong(paramInt1, this.zac.getInt(paramString));
  }
  
  public final Bundle getMetadata() {
    return this.zaf;
  }
  
  public final int getStatusCode() {
    return this.zae;
  }
  
  public final String getString(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getString(paramInt1, this.zac.getInt(paramString));
  }
  
  public final int getWindowIndex(int paramInt) {
    int i;
    boolean bool;
    int j = 0;
    if (paramInt >= 0 && paramInt < this.zah) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkState(bool);
    while (true) {
      int[] arrayOfInt = this.zag;
      i = j;
      if (j < arrayOfInt.length) {
        if (paramInt < arrayOfInt[j]) {
          i = j - 1;
          break;
        } 
        j++;
        continue;
      } 
      break;
    } 
    paramInt = i;
    if (i == this.zag.length)
      paramInt = i - 1; 
    return paramInt;
  }
  
  public final boolean hasColumn(String paramString) {
    return this.zac.containsKey(paramString);
  }
  
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].isNull(paramInt1, this.zac.getInt(paramString));
  }
  
  public final boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield zai : Z
    //   6: istore_1
    //   7: aload_0
    //   8: monitorexit
    //   9: iload_1
    //   10: ireturn
    //   11: astore_2
    //   12: aload_0
    //   13: monitorexit
    //   14: aload_2
    //   15: athrow
    // Exception table:
    //   from	to	target	type
    //   2	9	11	finally
    //   12	14	11	finally
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.zab, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.zad, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.zaa);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0)
      close(); 
  }
  
  public final float zaa(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getFloat(paramInt1, this.zac.getInt(paramString));
  }
  
  public final void zaa() {
    this.zac = new Bundle();
    int j = 0;
    int i = 0;
    while (true) {
      String[] arrayOfString = this.zab;
      if (i < arrayOfString.length) {
        this.zac.putInt(arrayOfString[i], i);
        i++;
        continue;
      } 
      this.zag = new int[this.zad.length];
      int k = 0;
      i = j;
      while (true) {
        CursorWindow[] arrayOfCursorWindow = this.zad;
        if (i < arrayOfCursorWindow.length) {
          this.zag[i] = k;
          j = arrayOfCursorWindow[i].getStartPosition();
          k += this.zad[i].getNumRows() - k - j;
          i++;
          continue;
        } 
        this.zah = k;
        return;
      } 
      break;
    } 
  }
  
  public final void zaa(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer) {
    zaa(paramString, paramInt1);
    this.zad[paramInt2].copyStringToBuffer(paramInt1, this.zac.getInt(paramString), paramCharArrayBuffer);
  }
  
  public final double zab(String paramString, int paramInt1, int paramInt2) {
    zaa(paramString, paramInt1);
    return this.zad[paramInt2].getDouble(paramInt1, this.zac.getInt(paramString));
  }
  
  public static class Builder {
    private final String[] zaa;
    
    private final ArrayList<HashMap<String, Object>> zab;
    
    private final String zac;
    
    private final HashMap<Object, Integer> zad;
    
    private boolean zae;
    
    private String zaf;
    
    private Builder(String[] param1ArrayOfString, String param1String) {
      this.zaa = (String[])Preconditions.checkNotNull(param1ArrayOfString);
      this.zab = new ArrayList<HashMap<String, Object>>();
      this.zac = param1String;
      this.zad = new HashMap<Object, Integer>();
      this.zae = false;
      this.zaf = null;
    }
    
    public DataHolder build(int param1Int) {
      return new DataHolder(this, param1Int, null, null);
    }
    
    public DataHolder build(int param1Int, Bundle param1Bundle) {
      return new DataHolder(this, param1Int, param1Bundle, -1, null);
    }
    
    public Builder withRow(ContentValues param1ContentValues) {
      Asserts.checkNotNull(param1ContentValues);
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(param1ContentValues.size());
      for (Map.Entry entry : param1ContentValues.valueSet())
        hashMap.put(entry.getKey(), entry.getValue()); 
      return zaa((HashMap)hashMap);
    }
    
    public Builder zaa(HashMap<String, Object> param1HashMap) {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic checkNotNull : (Ljava/lang/Object;)V
      //   4: aload_0
      //   5: getfield zac : Ljava/lang/String;
      //   8: astore_3
      //   9: aload_3
      //   10: ifnonnull -> 18
      //   13: iconst_m1
      //   14: istore_2
      //   15: goto -> 77
      //   18: aload_1
      //   19: aload_3
      //   20: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   23: astore_3
      //   24: aload_3
      //   25: ifnonnull -> 31
      //   28: goto -> 13
      //   31: aload_0
      //   32: getfield zad : Ljava/util/HashMap;
      //   35: aload_3
      //   36: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   39: checkcast java/lang/Integer
      //   42: astore #4
      //   44: aload #4
      //   46: ifnonnull -> 71
      //   49: aload_0
      //   50: getfield zad : Ljava/util/HashMap;
      //   53: aload_3
      //   54: aload_0
      //   55: getfield zab : Ljava/util/ArrayList;
      //   58: invokevirtual size : ()I
      //   61: invokestatic valueOf : (I)Ljava/lang/Integer;
      //   64: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   67: pop
      //   68: goto -> 13
      //   71: aload #4
      //   73: invokevirtual intValue : ()I
      //   76: istore_2
      //   77: iload_2
      //   78: iconst_m1
      //   79: if_icmpne -> 94
      //   82: aload_0
      //   83: getfield zab : Ljava/util/ArrayList;
      //   86: aload_1
      //   87: invokevirtual add : (Ljava/lang/Object;)Z
      //   90: pop
      //   91: goto -> 112
      //   94: aload_0
      //   95: getfield zab : Ljava/util/ArrayList;
      //   98: iload_2
      //   99: invokevirtual remove : (I)Ljava/lang/Object;
      //   102: pop
      //   103: aload_0
      //   104: getfield zab : Ljava/util/ArrayList;
      //   107: iload_2
      //   108: aload_1
      //   109: invokevirtual add : (ILjava/lang/Object;)V
      //   112: aload_0
      //   113: iconst_0
      //   114: putfield zae : Z
      //   117: aload_0
      //   118: areturn
    }
  }
  
  public static final class zaa extends RuntimeException {
    public zaa(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\data\DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */