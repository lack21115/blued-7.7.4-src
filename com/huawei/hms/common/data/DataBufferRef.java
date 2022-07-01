package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

public class DataBufferRef {
  protected final DataHolder mDataHolder;
  
  protected int mDataRow;
  
  private int windowIndex;
  
  public DataBufferRef(DataHolder paramDataHolder, int paramInt) {
    Preconditions.checkNotNull(paramDataHolder, "dataHolder cannot be null");
    this.mDataHolder = paramDataHolder;
    getWindowIndex(paramInt);
  }
  
  protected void copyToBuffer(String paramString, CharArrayBuffer paramCharArrayBuffer) {
    this.mDataHolder.copyToBuffer(paramString, this.mDataRow, this.windowIndex, paramCharArrayBuffer);
  }
  
  public boolean equals(Object paramObject) {
    boolean bool = paramObject instanceof DataBufferRef;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool) {
      paramObject = paramObject;
      bool1 = bool2;
      if (((DataBufferRef)paramObject).mDataRow == this.mDataRow) {
        bool1 = bool2;
        if (((DataBufferRef)paramObject).windowIndex == this.windowIndex) {
          bool1 = bool2;
          if (((DataBufferRef)paramObject).mDataHolder == this.mDataHolder)
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  protected boolean getBoolean(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_boolean");
    return (object != null) ? ((Boolean)object).booleanValue() : false;
  }
  
  protected byte[] getByteArray(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_byte_array");
    return (object != null) ? (byte[])object : null;
  }
  
  protected int getDataRow() {
    return this.mDataRow;
  }
  
  protected double getDouble(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_double");
    return (object != null) ? ((Double)object).doubleValue() : -1.0D;
  }
  
  protected float getFloat(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_float");
    return (object != null) ? ((Float)object).floatValue() : -1.0F;
  }
  
  protected int getInteger(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_int");
    return (object != null) ? ((Integer)object).intValue() : -1;
  }
  
  protected long getLong(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_long");
    return (object != null) ? ((Long)object).longValue() : -1L;
  }
  
  protected String getString(String paramString) {
    Object object = this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_string");
    return (object != null) ? (String)object : "";
  }
  
  protected final void getWindowIndex(int paramInt) {
    boolean bool;
    if (paramInt >= 0 && paramInt < this.mDataHolder.getCount()) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.checkArgument(bool, "rowNum is out of index");
    this.mDataRow = paramInt;
    this.windowIndex = this.mDataHolder.getWindowIndex(this.mDataRow);
  }
  
  public boolean hasColumn(String paramString) {
    return this.mDataHolder.hasColumn(paramString);
  }
  
  protected boolean hasNull(String paramString) {
    return this.mDataHolder.hasNull(paramString, this.mDataRow, this.windowIndex);
  }
  
  public int hashCode() {
    return Objects.hashCode(new Object[] { Integer.valueOf(this.mDataRow), Integer.valueOf(this.windowIndex), this.mDataHolder });
  }
  
  public boolean isDataValid() {
    return this.mDataHolder.isClosed() ^ true;
  }
  
  protected Uri parseUri(String paramString) {
    paramString = (String)this.mDataHolder.getValue(paramString, this.mDataRow, this.windowIndex, "type_string");
    return (paramString == null) ? null : Uri.parse(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataBufferRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */