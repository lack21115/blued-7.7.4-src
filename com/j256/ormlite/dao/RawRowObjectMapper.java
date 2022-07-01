package com.j256.ormlite.dao;

import com.j256.ormlite.field.DataType;
import java.sql.SQLException;

public interface RawRowObjectMapper<T> {
  T mapRow(String[] paramArrayOfString, DataType[] paramArrayOfDataType, Object[] paramArrayOfObject) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\RawRowObjectMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */