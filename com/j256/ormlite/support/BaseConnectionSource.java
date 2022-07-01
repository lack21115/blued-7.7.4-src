package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

public abstract class BaseConnectionSource implements ConnectionSource {
  private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<NestedConnection>();
  
  protected boolean clearSpecial(DatabaseConnection paramDatabaseConnection, Logger paramLogger) {
    NestedConnection nestedConnection = this.specialConnection.get();
    if (paramDatabaseConnection != null)
      if (nestedConnection == null) {
        paramLogger.error("no connection has been saved when clear() called");
      } else {
        if (nestedConnection.connection == paramDatabaseConnection) {
          if (nestedConnection.decrementAndGet() == 0)
            this.specialConnection.set(null); 
          return true;
        } 
        paramLogger.error("connection saved {} is not the one being cleared {}", nestedConnection.connection, paramDatabaseConnection);
      }  
    return false;
  }
  
  protected DatabaseConnection getSavedConnection() {
    NestedConnection nestedConnection = this.specialConnection.get();
    return (nestedConnection == null) ? null : nestedConnection.connection;
  }
  
  public DatabaseConnection getSpecialConnection() {
    NestedConnection nestedConnection = this.specialConnection.get();
    return (nestedConnection == null) ? null : nestedConnection.connection;
  }
  
  protected boolean isSavedConnection(DatabaseConnection paramDatabaseConnection) {
    NestedConnection nestedConnection = this.specialConnection.get();
    return (nestedConnection == null) ? false : ((nestedConnection.connection == paramDatabaseConnection));
  }
  
  protected boolean saveSpecial(DatabaseConnection paramDatabaseConnection) throws SQLException {
    NestedConnection nestedConnection = this.specialConnection.get();
    if (nestedConnection == null) {
      this.specialConnection.set(new NestedConnection(paramDatabaseConnection));
      return true;
    } 
    if (nestedConnection.connection == paramDatabaseConnection) {
      nestedConnection.increment();
      return false;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("trying to save connection ");
    stringBuilder.append(paramDatabaseConnection);
    stringBuilder.append(" but already have saved connection ");
    stringBuilder.append(nestedConnection.connection);
    throw new SQLException(stringBuilder.toString());
  }
  
  static class NestedConnection {
    public final DatabaseConnection connection;
    
    private int nestedC;
    
    public NestedConnection(DatabaseConnection param1DatabaseConnection) {
      this.connection = param1DatabaseConnection;
      this.nestedC = 1;
    }
    
    public int decrementAndGet() {
      this.nestedC--;
      return this.nestedC;
    }
    
    public void increment() {
      this.nestedC++;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\support\BaseConnectionSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */