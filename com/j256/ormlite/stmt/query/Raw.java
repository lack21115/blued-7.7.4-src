package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.util.List;

public class Raw implements Clause {
  private final ArgumentHolder[] args;
  
  private final String statement;
  
  public Raw(String paramString, ArgumentHolder[] paramArrayOfArgumentHolder) {
    this.statement = paramString;
    this.args = paramArrayOfArgumentHolder;
  }
  
  public void appendSql(DatabaseType paramDatabaseType, String paramString, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList) {
    paramStringBuilder.append(this.statement);
    paramStringBuilder.append(' ');
    ArgumentHolder[] arrayOfArgumentHolder = this.args;
    int j = arrayOfArgumentHolder.length;
    int i;
    for (i = 0; i < j; i++)
      paramList.add(arrayOfArgumentHolder[i]); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\query\Raw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */