package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class In extends BaseComparison {
  private final boolean in;
  
  private Iterable<?> objects;
  
  public In(String paramString, FieldType paramFieldType, Iterable<?> paramIterable, boolean paramBoolean) throws SQLException {
    super(paramString, paramFieldType, null, true);
    this.objects = paramIterable;
    this.in = paramBoolean;
  }
  
  public In(String paramString, FieldType paramFieldType, Object[] paramArrayOfObject, boolean paramBoolean) throws SQLException {
    super(paramString, paramFieldType, null, true);
    this.objects = Arrays.asList(paramArrayOfObject);
    this.in = paramBoolean;
  }
  
  public void appendOperation(StringBuilder paramStringBuilder) {
    if (this.in) {
      paramStringBuilder.append("IN ");
      return;
    } 
    paramStringBuilder.append("NOT IN ");
  }
  
  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) throws SQLException {
    paramStringBuilder.append('(');
    Iterator<?> iterator = this.objects.iterator();
    boolean bool = true;
    while (iterator.hasNext()) {
      Object object = iterator.next();
      if (object != null) {
        if (bool) {
          bool = false;
        } else {
          paramStringBuilder.append(',');
        } 
        appendArgOrValue(paramDatabaseType, this.fieldType, paramStringBuilder, paramList, object);
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("one of the IN values for '");
      stringBuilder.append(this.columnName);
      stringBuilder.append("' is null");
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
    paramStringBuilder.append(") ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\In.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */