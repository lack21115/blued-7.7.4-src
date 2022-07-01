package com.j256.ormlite.stmt;

import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public interface GenericRowMapper<T> {
  T mapRow(DatabaseResults paramDatabaseResults) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\stmt\GenericRowMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */