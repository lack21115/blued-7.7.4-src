package com.j256.ormlite.support;

import java.sql.SQLException;

public interface DatabaseConnectionProxyFactory {
  DatabaseConnection createProxy(DatabaseConnection paramDatabaseConnection) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\DatabaseConnectionProxyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */