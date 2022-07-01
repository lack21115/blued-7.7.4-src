package com.j256.ormlite.misc;

import java.sql.SQLException;

public class SqlExceptionUtil {
  public static SQLException create(String paramString, Throwable paramThrowable) {
    SQLException sQLException = new SQLException(paramString);
    sQLException.initCause(paramThrowable);
    return sQLException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\misc\SqlExceptionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */