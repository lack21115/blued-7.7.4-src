package com.facebook.stetho.inspector.database;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class DefaultDatabaseFilesProvider implements DatabaseFilesProvider {
  private final Context mContext;
  
  public DefaultDatabaseFilesProvider(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public List<File> getDatabaseFiles() {
    ArrayList<File> arrayList = new ArrayList();
    for (String str : this.mContext.databaseList())
      arrayList.add(this.mContext.getDatabasePath(str)); 
    return arrayList;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\DefaultDatabaseFilesProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */