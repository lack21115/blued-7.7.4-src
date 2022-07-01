package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.NullArgHolder;
import java.sql.SQLException;
import java.util.List;

public class SetValue extends BaseComparison {
  private static final ArgumentHolder nullValue = (ArgumentHolder)new NullArgHolder();
  
  public SetValue(String paramString, FieldType paramFieldType, Object paramObject) throws SQLException {
    super(paramString, paramFieldType, object, false);
  }
  
  public void appendOperation(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("= ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\SetValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */