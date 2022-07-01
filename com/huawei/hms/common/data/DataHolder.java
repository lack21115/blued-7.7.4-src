package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
  public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
  
  private static final String TAG = "DataHolder";
  
  public static final String TYPE_BOOLEAN = "type_boolean";
  
  public static final String TYPE_BYTE_ARRAY = "type_byte_array";
  
  public static final String TYPE_DOUBLE = "type_double";
  
  public static final String TYPE_FLOAT = "type_float";
  
  public static final String TYPE_INT = "type_int";
  
  public static final String TYPE_LONG = "type_long";
  
  public static final String TYPE_STRING = "type_string";
  
  private static final Builder builder = new DataHolderBuilderCreator(new String[0], null);
  
  private String[] columns;
  
  private Bundle columnsBundle;
  
  private CursorWindow[] cursorWindows;
  
  private int dataCount;
  
  private boolean isInstance;
  
  private boolean mClosed;
  
  private Bundle metadata;
  
  private int[] perCursorCounts;
  
  private int statusCode;
  
  private int version;
  
  DataHolder(int paramInt1, String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt2, Bundle paramBundle) {
    this.mClosed = false;
    this.isInstance = true;
    this.version = paramInt1;
    this.columns = paramArrayOfString;
    this.cursorWindows = paramArrayOfCursorWindow;
    this.statusCode = paramInt2;
    this.metadata = paramBundle;
    collectColumsAndCount();
  }
  
  public DataHolder(Cursor paramCursor, int paramInt, Bundle paramBundle) {
    this(new HMSCursorWrapper(paramCursor), paramInt, paramBundle);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt, Bundle paramBundle) {
    this(paramBuilder.builderColumns, getCursorWindows(paramBuilder, -1), paramInt, (Bundle)null);
  }
  
  private DataHolder(Builder paramBuilder, int paramInt1, Bundle paramBundle, int paramInt2) {
    this(paramBuilder.builderColumns, getCursorWindows(paramBuilder, -1), paramInt1, paramBundle);
  }
  
  private DataHolder(HMSCursorWrapper paramHMSCursorWrapper, int paramInt, Bundle paramBundle) {
    this(paramHMSCursorWrapper.getColumnNames(), getCursorWindows(paramHMSCursorWrapper), paramInt, paramBundle);
  }
  
  public DataHolder(String[] paramArrayOfString, CursorWindow[] paramArrayOfCursorWindow, int paramInt, Bundle paramBundle) {
    Preconditions.checkNotNull(paramArrayOfString, "columnsP cannot be null");
    Preconditions.checkNotNull(paramArrayOfString, "cursorWindowP cannot be null");
    this.mClosed = false;
    this.isInstance = true;
    this.version = 1;
    this.columns = paramArrayOfString;
    this.cursorWindows = paramArrayOfCursorWindow;
    this.statusCode = paramInt;
    this.metadata = paramBundle;
    collectColumsAndCount();
  }
  
  public static Builder builder(String[] paramArrayOfString) {
    return new Builder(paramArrayOfString, null);
  }
  
  private void checkAvailable(String paramString, int paramInt) {
    Bundle bundle = this.columnsBundle;
    if (bundle == null || !bundle.containsKey(paramString)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("cannot find column: ");
      stringBuilder.append(paramString);
      paramString = stringBuilder.toString();
    } else if (isClosed()) {
      paramString = "buffer has been closed";
    } else if (paramInt < 0 || paramInt >= this.dataCount) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("row is out of index:");
      stringBuilder.append(paramInt);
      String str = stringBuilder.toString();
    } else {
      paramString = "";
    } 
    Preconditions.checkArgument(paramString.isEmpty(), paramString);
  }
  
  public static DataHolder empty(int paramInt) {
    return new DataHolder(builder, paramInt, null);
  }
  
  private static CursorWindow[] getCursorWindows(Builder paramBuilder, int paramInt) {
    if (paramBuilder.builderColumns.length == 0)
      return new CursorWindow[0]; 
    if (paramInt >= 0) {
      int j = paramInt;
      if (paramInt >= paramBuilder.dataCollectionList.size()) {
        j = paramBuilder.dataCollectionList.size();
        arrayList = iterCursorWindow(paramBuilder, j, paramBuilder.dataCollectionList.subList(0, j));
        return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
      } 
      arrayList = iterCursorWindow((Builder)arrayList, j, ((Builder)arrayList).dataCollectionList.subList(0, j));
      return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
    } 
    int i = ((Builder)arrayList).dataCollectionList.size();
    ArrayList<CursorWindow> arrayList = iterCursorWindow((Builder)arrayList, i, ((Builder)arrayList).dataCollectionList.subList(0, i));
    return arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
  }
  
  private static CursorWindow[] getCursorWindows(HMSCursorWrapper paramHMSCursorWrapper) {
    int i;
    ArrayList<CursorWindow> arrayList = new ArrayList();
    try {
      i = paramHMSCursorWrapper.getCount();
      CursorWindow cursorWindow = paramHMSCursorWrapper.getWindow();
    } finally {
      arrayList = null;
    } 
    boolean bool = false;
    arrayList.addAll(iterCursorWrapper(paramHMSCursorWrapper, bool, i));
    CursorWindow[] arrayOfCursorWindow = arrayList.<CursorWindow>toArray(new CursorWindow[arrayList.size()]);
    paramHMSCursorWrapper.close();
    return arrayOfCursorWindow;
  }
  
  private static ArrayList<CursorWindow> iterCursorWindow(Builder paramBuilder, int paramInt, List<HashMap> paramList) {
    ArrayList<CursorWindow> arrayList = new ArrayList();
    CursorWindow cursorWindow = new CursorWindow(null);
    cursorWindow.setNumColumns(paramBuilder.builderColumns.length);
    arrayList.add(cursorWindow);
    int i = 0;
    label30: while (true) {
      if (i < paramInt) {
        try {
          boolean bool = cursorWindow.allocRow();
          if (!bool) {
            HMSLog.d("DataHolder", "Failed to allocate a row");
            cursorWindow = new CursorWindow(null);
            cursorWindow.setStartPosition(i);
            cursorWindow.setNumColumns(paramBuilder.builderColumns.length);
            if (!cursorWindow.allocRow()) {
              HMSLog.e("DataHolder", "Failed to retry to allocate a row");
              return arrayList;
            } 
            arrayList.add(cursorWindow);
          } 
          HashMap hashMap = paramList.get(i);
          int j = 0;
          bool = true;
          while (true) {
            if (j < paramBuilder.builderColumns.length) {
              bool = putValue(cursorWindow, hashMap.get(paramBuilder.builderColumns[j]), i, j);
              if (bool) {
                j++;
                continue;
              } 
            } 
            if (!bool) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("fail to put data for row ");
              stringBuilder.append(i);
              HMSLog.d("DataHolder", stringBuilder.toString());
              cursorWindow.freeLastRow();
              CursorWindow cursorWindow1 = new CursorWindow(null);
              cursorWindow1.setStartPosition(i);
              cursorWindow1.setNumColumns(paramBuilder.builderColumns.length);
              arrayList.add(cursorWindow1);
              return arrayList;
            } 
            i++;
            continue label30;
          } 
        } catch (RuntimeException runtimeException) {
          Iterator<CursorWindow> iterator = arrayList.iterator();
          while (iterator.hasNext())
            ((CursorWindow)iterator.next()).close(); 
          throw runtimeException;
        } 
        break;
      } 
      return arrayList;
    } 
  }
  
  private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper paramHMSCursorWrapper, int paramInt1, int paramInt2) {
    ArrayList<CursorWindow> arrayList = new ArrayList();
    while (paramInt1 < paramInt2 && paramHMSCursorWrapper.moveToPosition(paramInt1)) {
      CursorWindow cursorWindow = paramHMSCursorWrapper.getWindow();
      if (cursorWindow == null) {
        cursorWindow = new CursorWindow(null);
        cursorWindow.setStartPosition(paramInt1);
        paramHMSCursorWrapper.fillWindow(paramInt1, cursorWindow);
      } else {
        cursorWindow.acquireReference();
        paramHMSCursorWrapper.setWindow(null);
      } 
      if (cursorWindow.getNumRows() == 0)
        return arrayList; 
      arrayList.add(cursorWindow);
      paramInt1 = cursorWindow.getNumRows() + cursorWindow.getStartPosition();
    } 
    return arrayList;
  }
  
  private static boolean putValue(CursorWindow paramCursorWindow, Object paramObject, int paramInt1, int paramInt2) throws IllegalArgumentException {
    if (paramObject == null)
      return paramCursorWindow.putNull(paramInt1, paramInt2); 
    if (paramObject instanceof Boolean) {
      long l;
      if (((Boolean)paramObject).booleanValue()) {
        l = 1L;
      } else {
        l = 0L;
      } 
      return paramCursorWindow.putLong(l, paramInt1, paramInt2);
    } 
    if (paramObject instanceof Integer)
      return paramCursorWindow.putLong(((Integer)paramObject).intValue(), paramInt1, paramInt2); 
    if (paramObject instanceof Long)
      return paramCursorWindow.putLong(((Long)paramObject).longValue(), paramInt1, paramInt2); 
    if (paramObject instanceof Float)
      return paramCursorWindow.putDouble(((Float)paramObject).floatValue(), paramInt1, paramInt2); 
    if (paramObject instanceof Double)
      return paramCursorWindow.putDouble(((Double)paramObject).doubleValue(), paramInt1, paramInt2); 
    if (paramObject instanceof String)
      return paramCursorWindow.putString((String)paramObject, paramInt1, paramInt2); 
    if (paramObject instanceof byte[])
      return paramCursorWindow.putBlob((byte[])paramObject, paramInt1, paramInt2); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unsupported type for column: ");
    stringBuilder.append(paramObject);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public final void close() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
    //   6: ifne -> 42
    //   9: aload_0
    //   10: getfield cursorWindows : [Landroid/database/CursorWindow;
    //   13: astore_3
    //   14: aload_3
    //   15: arraylength
    //   16: istore_2
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_1
    //   20: iload_2
    //   21: if_icmpge -> 37
    //   24: aload_3
    //   25: iload_1
    //   26: aaload
    //   27: invokevirtual close : ()V
    //   30: iload_1
    //   31: iconst_1
    //   32: iadd
    //   33: istore_1
    //   34: goto -> 19
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield mClosed : Z
    //   42: aload_0
    //   43: monitorexit
    //   44: return
    //   45: astore_3
    //   46: aload_0
    //   47: monitorexit
    //   48: aload_3
    //   49: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	45	finally
    //   24	30	45	finally
    //   37	42	45	finally
  }
  
  public final void collectColumsAndCount() {
    this.columnsBundle = new Bundle();
    boolean bool = false;
    int i = 0;
    while (true) {
      String[] arrayOfString = this.columns;
      if (i < arrayOfString.length) {
        this.columnsBundle.putInt(arrayOfString[i], i);
        i++;
        continue;
      } 
      this.perCursorCounts = new int[this.cursorWindows.length];
      int j = 0;
      i = bool;
      while (true) {
        CursorWindow[] arrayOfCursorWindow = this.cursorWindows;
        if (i < arrayOfCursorWindow.length) {
          this.perCursorCounts[i] = j;
          j = arrayOfCursorWindow[i].getStartPosition() + this.cursorWindows[i].getNumRows();
          i++;
          continue;
        } 
        this.dataCount = j;
        return;
      } 
      break;
    } 
  }
  
  public final void copyToBuffer(String paramString, int paramInt1, int paramInt2, CharArrayBuffer paramCharArrayBuffer) {
    checkAvailable(paramString, paramInt1);
    this.cursorWindows[paramInt2].copyStringToBuffer(paramInt1, this.columnsBundle.getInt(paramString), paramCharArrayBuffer);
  }
  
  protected final void finalize() throws Throwable {
    if (this.isInstance && this.cursorWindows.length > 0 && !isClosed())
      close(); 
    super.finalize();
  }
  
  public final int getCount() {
    return this.dataCount;
  }
  
  public final Bundle getMetadata() {
    return this.metadata;
  }
  
  public final int getStatusCode() {
    return this.statusCode;
  }
  
  public final Object getValue(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    int i = paramString2.hashCode();
    boolean bool = true;
    switch (i) {
      default:
        i = -1;
        break;
      case 1300508295:
        if (paramString2.equals("type_byte_array")) {
          i = 6;
          break;
        } 
      case 878975158:
        if (paramString2.equals("type_string")) {
          i = 2;
          break;
        } 
      case 519136353:
        if (paramString2.equals("type_long")) {
          i = 1;
          break;
        } 
      case 445002870:
        if (paramString2.equals("type_double")) {
          i = 5;
          break;
        } 
      case -675993238:
        if (paramString2.equals("type_int")) {
          i = 0;
          break;
        } 
      case -870070237:
        if (paramString2.equals("type_boolean")) {
          i = 3;
          break;
        } 
      case -1092271849:
        if (paramString2.equals("type_float")) {
          i = 4;
          break;
        } 
    } 
    switch (i) {
      default:
        return null;
      case 6:
        checkAvailable(paramString1, paramInt1);
        return this.cursorWindows[paramInt2].getBlob(paramInt1, this.columnsBundle.getInt(paramString1));
      case 5:
        checkAvailable(paramString1, paramInt1);
        return Double.valueOf(this.cursorWindows[paramInt2].getDouble(paramInt1, this.columnsBundle.getInt(paramString1)));
      case 4:
        checkAvailable(paramString1, paramInt1);
        return Float.valueOf(this.cursorWindows[paramInt2].getFloat(paramInt1, this.columnsBundle.getInt(paramString1)));
      case 3:
        checkAvailable(paramString1, paramInt1);
        if (this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)) != 1L)
          bool = false; 
        return Boolean.valueOf(bool);
      case 2:
        checkAvailable(paramString1, paramInt1);
        return this.cursorWindows[paramInt2].getString(paramInt1, this.columnsBundle.getInt(paramString1));
      case 1:
        checkAvailable(paramString1, paramInt1);
        return Long.valueOf(this.cursorWindows[paramInt2].getLong(paramInt1, this.columnsBundle.getInt(paramString1)));
      case 0:
        break;
    } 
    checkAvailable(paramString1, paramInt1);
    return Integer.valueOf(this.cursorWindows[paramInt2].getInt(paramInt1, this.columnsBundle.getInt(paramString1)));
  }
  
  public final int getWindowIndex(int paramInt) {
    int i;
    boolean bool;
    int j = 0;
    if (paramInt >= 0 || paramInt < this.dataCount) {
      bool = true;
    } else {
      bool = false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("rowIndex is out of index:");
    stringBuilder.append(paramInt);
    Preconditions.checkArgument(bool, stringBuilder.toString());
    while (true) {
      int[] arrayOfInt = this.perCursorCounts;
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
    if (i == this.perCursorCounts.length)
      paramInt = i - 1; 
    return paramInt;
  }
  
  public final boolean hasColumn(String paramString) {
    return this.columnsBundle.containsKey(paramString);
  }
  
  public final boolean hasNull(String paramString, int paramInt1, int paramInt2) {
    checkAvailable(paramString, paramInt1);
    return (this.cursorWindows[paramInt2].getType(paramInt1, this.columnsBundle.getInt(paramString)) == 0);
  }
  
  public final boolean isClosed() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mClosed : Z
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
    //   2	7	11	finally
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt) {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeStringArray(paramParcel, 1, this.columns, false);
    SafeParcelWriter.writeTypedArray(paramParcel, 2, (Parcelable[])this.cursorWindows, paramInt, false);
    SafeParcelWriter.writeInt(paramParcel, 3, getStatusCode());
    SafeParcelWriter.writeBundle(paramParcel, 4, getMetadata(), false);
    SafeParcelWriter.writeInt(paramParcel, 1000, this.version);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
    if ((paramInt & 0x1) != 0)
      close(); 
  }
  
  public static class Builder {
    private String[] builderColumns;
    
    private final ArrayList<HashMap<String, Object>> dataCollectionList;
    
    private final String type;
    
    private final HashMap<Object, Integer> typeAndDataCollectionCountMapping;
    
    private Builder(String[] param1ArrayOfString, String param1String) {
      Preconditions.checkNotNull(param1ArrayOfString, "builderColumnsP cannot be null");
      this.builderColumns = param1ArrayOfString;
      this.dataCollectionList = new ArrayList<HashMap<String, Object>>();
      this.type = param1String;
      this.typeAndDataCollectionCountMapping = new HashMap<Object, Integer>();
    }
    
    Builder(String[] param1ArrayOfString, String param1String, DataHolderBuilderCreator param1DataHolderBuilderCreator) {
      this(param1ArrayOfString, null);
    }
    
    public DataHolder build(int param1Int) {
      return new DataHolder(this, param1Int, null);
    }
    
    public DataHolder build(int param1Int, Bundle param1Bundle) {
      return new DataHolder(this, param1Int, param1Bundle, -1);
    }
    
    public Builder setDataForContentValuesHashMap(HashMap<String, Object> param1HashMap) {
      Preconditions.checkNotNull(param1HashMap, "contentValuesHashMap cannot be null");
      String str = this.type;
      int i = 0;
      if (str != null) {
        str = (String)param1HashMap.get(str);
        if (str != null) {
          boolean bool1;
          Integer integer = this.typeAndDataCollectionCountMapping.get(str);
          if (integer != null) {
            i = integer.intValue();
            bool1 = true;
          } else {
            this.typeAndDataCollectionCountMapping.put(str, Integer.valueOf(this.dataCollectionList.size()));
            bool1 = false;
          } 
          if (bool1) {
            this.dataCollectionList.remove(i);
            this.dataCollectionList.add(i, param1HashMap);
            return this;
          } 
          this.dataCollectionList.add(param1HashMap);
          return this;
        } 
      } 
      boolean bool = false;
    }
    
    public Builder withRow(ContentValues param1ContentValues) {
      Preconditions.checkNotNull(param1ContentValues, "contentValues cannot be null");
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>(param1ContentValues.size());
      for (Map.Entry entry : param1ContentValues.valueSet())
        hashMap.put(entry.getKey(), entry.getValue()); 
      return setDataForContentValuesHashMap((HashMap)hashMap);
    }
  }
  
  public static class DataHolderException extends RuntimeException {
    public DataHolderException(String param1String) {
      super(param1String);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */