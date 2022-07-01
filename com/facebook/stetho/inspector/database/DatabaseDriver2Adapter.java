package com.facebook.stetho.inspector.database;

import android.database.sqlite.SQLiteException;
import com.facebook.stetho.inspector.protocol.module.BaseDatabaseDriver;
import com.facebook.stetho.inspector.protocol.module.Database;
import com.facebook.stetho.inspector.protocol.module.DatabaseDescriptor;
import com.facebook.stetho.inspector.protocol.module.DatabaseDriver2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public class DatabaseDriver2Adapter extends DatabaseDriver2<DatabaseDriver2Adapter.StringDatabaseDescriptor> {
  private final Database.DatabaseDriver mLegacy;
  
  public DatabaseDriver2Adapter(Database.DatabaseDriver paramDatabaseDriver) {
    super(paramDatabaseDriver.getContext());
    this.mLegacy = paramDatabaseDriver;
  }
  
  public Database.ExecuteSQLResponse executeSQL(StringDatabaseDescriptor paramStringDatabaseDescriptor, String paramString, BaseDatabaseDriver.ExecuteResultHandler paramExecuteResultHandler) throws SQLiteException {
    return this.mLegacy.executeSQL(paramStringDatabaseDescriptor.name, paramString, paramExecuteResultHandler);
  }
  
  public List<StringDatabaseDescriptor> getDatabaseNames() {
    List list = this.mLegacy.getDatabaseNames();
    ArrayList<StringDatabaseDescriptor> arrayList = new ArrayList(list.size());
    Iterator<E> iterator = list.iterator();
    while (iterator.hasNext())
      arrayList.add(new StringDatabaseDescriptor(iterator.next().toString())); 
    return arrayList;
  }
  
  public List<String> getTableNames(StringDatabaseDescriptor paramStringDatabaseDescriptor) {
    return this.mLegacy.getTableNames(paramStringDatabaseDescriptor.name);
  }
  
  static class StringDatabaseDescriptor implements DatabaseDescriptor {
    public final String name;
    
    public StringDatabaseDescriptor(String param1String) {
      this.name = param1String;
    }
    
    public String name() {
      return this.name;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\DatabaseDriver2Adapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */