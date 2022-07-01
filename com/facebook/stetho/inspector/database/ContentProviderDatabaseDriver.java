package com.facebook.stetho.inspector.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContentProviderDatabaseDriver extends DatabaseDriver2<ContentProviderDatabaseDriver.ContentProviderDatabaseDescriptor> {
  private static final String sDatabaseName = "content-providers";
  
  private final ContentProviderSchema[] mContentProviderSchemas;
  
  private List<String> mTableNames;
  
  public ContentProviderDatabaseDriver(Context paramContext, ContentProviderSchema... paramVarArgs) {
    super(paramContext);
    this.mContentProviderSchemas = paramVarArgs;
  }
  
  private String fetchTableName(String paramString) {
    for (String str : this.mTableNames) {
      if (paramString.contains(str))
        return str; 
    } 
    return "";
  }
  
  public Database.ExecuteSQLResponse executeSQL(ContentProviderDatabaseDescriptor paramContentProviderDatabaseDescriptor, String paramString, BaseDatabaseDriver.ExecuteResultHandler<Database.ExecuteSQLResponse> paramExecuteResultHandler) throws SQLiteException {
    String str = fetchTableName(paramString);
    int i = this.mTableNames.indexOf(str);
    ContentProviderSchema contentProviderSchema = this.mContentProviderSchemas[i];
    Cursor cursor = this.mContext.getContentResolver().query(contentProviderSchema.getUri(), contentProviderSchema.getProjection(), null, null, null);
    try {
      return (Database.ExecuteSQLResponse)paramExecuteResultHandler.handleSelect(cursor);
    } finally {
      cursor.close();
    } 
  }
  
  public List<ContentProviderDatabaseDescriptor> getDatabaseNames() {
    return Collections.singletonList(new ContentProviderDatabaseDescriptor());
  }
  
  public List<String> getTableNames(ContentProviderDatabaseDescriptor paramContentProviderDatabaseDescriptor) {
    if (this.mTableNames == null) {
      this.mTableNames = new ArrayList<String>();
      for (ContentProviderSchema contentProviderSchema : this.mContentProviderSchemas)
        this.mTableNames.add(contentProviderSchema.getTableName()); 
    } 
    return this.mTableNames;
  }
  
  static class ContentProviderDatabaseDescriptor implements DatabaseDescriptor {
    public String name() {
      return "content-providers";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\ContentProviderDatabaseDriver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */