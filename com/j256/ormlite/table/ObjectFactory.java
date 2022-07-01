package com.j256.ormlite.table;

import java.lang.reflect.Constructor;
import java.sql.SQLException;

public interface ObjectFactory<T> {
  T createObject(Constructor<T> paramConstructor, Class<T> paramClass) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\ObjectFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */