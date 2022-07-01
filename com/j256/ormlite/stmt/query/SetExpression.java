package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

public class SetExpression extends BaseComparison {
  public SetExpression(String paramString1, FieldType paramFieldType, String paramString2) throws SQLException {
    super(paramString1, paramFieldType, paramString2, true);
  }
  
  protected void appendArgOrValue(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, Object paramObject) {
    paramStringBuilder.append(paramObject);
    paramStringBuilder.append(' ');
  }
  
  public void appendOperation(StringBuilder paramStringBuilder) {
    paramStringBuilder.append("= ");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\SetExpression.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */