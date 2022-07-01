package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class DiskCacheStrategy {
  public static final DiskCacheStrategy a = new DiskCacheStrategy() {
      public boolean a() {
        return true;
      }
      
      public boolean a(DataSource param1DataSource) {
        return (param1DataSource == DataSource.b);
      }
      
      public boolean a(boolean param1Boolean, DataSource param1DataSource, EncodeStrategy param1EncodeStrategy) {
        return (param1DataSource != DataSource.d && param1DataSource != DataSource.e);
      }
      
      public boolean b() {
        return true;
      }
    };
  
  public static final DiskCacheStrategy b = new DiskCacheStrategy() {
      public boolean a() {
        return false;
      }
      
      public boolean a(DataSource param1DataSource) {
        return false;
      }
      
      public boolean a(boolean param1Boolean, DataSource param1DataSource, EncodeStrategy param1EncodeStrategy) {
        return false;
      }
      
      public boolean b() {
        return false;
      }
    };
  
  public static final DiskCacheStrategy c = new DiskCacheStrategy() {
      public boolean a() {
        return false;
      }
      
      public boolean a(DataSource param1DataSource) {
        return (param1DataSource != DataSource.c && param1DataSource != DataSource.e);
      }
      
      public boolean a(boolean param1Boolean, DataSource param1DataSource, EncodeStrategy param1EncodeStrategy) {
        return false;
      }
      
      public boolean b() {
        return true;
      }
    };
  
  public static final DiskCacheStrategy d = new DiskCacheStrategy() {
      public boolean a() {
        return true;
      }
      
      public boolean a(DataSource param1DataSource) {
        return false;
      }
      
      public boolean a(boolean param1Boolean, DataSource param1DataSource, EncodeStrategy param1EncodeStrategy) {
        return (param1DataSource != DataSource.d && param1DataSource != DataSource.e);
      }
      
      public boolean b() {
        return false;
      }
    };
  
  public static final DiskCacheStrategy e = new DiskCacheStrategy() {
      public boolean a() {
        return true;
      }
      
      public boolean a(DataSource param1DataSource) {
        return (param1DataSource == DataSource.b);
      }
      
      public boolean a(boolean param1Boolean, DataSource param1DataSource, EncodeStrategy param1EncodeStrategy) {
        return (((param1Boolean && param1DataSource == DataSource.c) || param1DataSource == DataSource.a) && param1EncodeStrategy == EncodeStrategy.b);
      }
      
      public boolean b() {
        return true;
      }
    };
  
  public abstract boolean a();
  
  public abstract boolean a(DataSource paramDataSource);
  
  public abstract boolean a(boolean paramBoolean, DataSource paramDataSource, EncodeStrategy paramEncodeStrategy);
  
  public abstract boolean b();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\load\engine\DiskCacheStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */