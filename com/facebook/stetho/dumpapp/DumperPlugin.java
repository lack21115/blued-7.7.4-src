package com.facebook.stetho.dumpapp;

public interface DumperPlugin {
  void dump(DumperContext paramDumperContext) throws DumpException;
  
  String getName();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\dumpapp\DumperPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */