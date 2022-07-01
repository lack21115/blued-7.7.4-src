package com.j256.ormlite.dao;

import java.sql.SQLException;

public interface RawRowMapper<T> {
  T mapRow(String[] paramArrayOfString1, String[] paramArrayOfString2) throws SQLException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\dao\RawRowMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */