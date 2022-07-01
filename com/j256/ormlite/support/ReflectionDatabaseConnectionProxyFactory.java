package com.j256.ormlite.support;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.lang.reflect.Constructor;
import java.sql.SQLException;

public class ReflectionDatabaseConnectionProxyFactory implements DatabaseConnectionProxyFactory {
  private final Constructor<? extends DatabaseConnection> constructor;
  
  private final Class<? extends DatabaseConnection> proxyClass;
  
  public ReflectionDatabaseConnectionProxyFactory(Class<? extends DatabaseConnection> paramClass) throws IllegalArgumentException {
    this.proxyClass = paramClass;
    try {
      this.constructor = paramClass.getConstructor(new Class[] { DatabaseConnection.class });
      return;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not find constructor with DatabaseConnection argument in ");
      stringBuilder.append(paramClass);
      throw new IllegalArgumentException(stringBuilder.toString());
    } 
  }
  
  public DatabaseConnection createProxy(DatabaseConnection paramDatabaseConnection) throws SQLException {
    try {
      return this.constructor.newInstance(new Object[] { paramDatabaseConnection });
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Could not create a new instance of ");
      stringBuilder.append(this.proxyClass);
      throw SqlExceptionUtil.create(stringBuilder.toString(), exception);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\ReflectionDatabaseConnectionProxyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */