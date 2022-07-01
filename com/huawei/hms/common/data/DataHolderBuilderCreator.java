package com.huawei.hms.common.data;

import android.content.ContentValues;
import java.util.HashMap;

final class DataHolderBuilderCreator extends DataHolder.Builder {
  DataHolderBuilderCreator(String[] paramArrayOfString, String paramString) {
    super(paramArrayOfString, (String)null, (DataHolderBuilderCreator)null);
  }
  
  public final DataHolder.Builder setDataForContentValuesHashMap(HashMap<String, Object> paramHashMap) {
    throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported setDataForContentValuesHashMap");
  }
  
  public final DataHolder.Builder withRow(ContentValues paramContentValues) {
    throw new UnsupportedOperationException("DataHolderBuilderCreator unsupported withRow");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\common\data\DataHolderBuilderCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */