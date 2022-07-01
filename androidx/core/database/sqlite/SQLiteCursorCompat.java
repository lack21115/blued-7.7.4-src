package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;

public final class SQLiteCursorCompat {
  public static void setFillWindowForwardOnly(SQLiteCursor paramSQLiteCursor, boolean paramBoolean) {
    if (Build.VERSION.SDK_INT >= 28)
      paramSQLiteCursor.setFillWindowForwardOnly(paramBoolean); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\database\sqlite\SQLiteCursorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */