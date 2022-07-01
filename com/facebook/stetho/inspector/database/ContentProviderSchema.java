package com.facebook.stetho.inspector.database;

import android.net.Uri;

public class ContentProviderSchema {
  private final String[] mProjection;
  
  private final String mTableName;
  
  private final Uri mUri;
  
  private ContentProviderSchema(Builder paramBuilder) {
    this.mTableName = paramBuilder.mTable.mTableName;
    this.mUri = paramBuilder.mTable.mUri;
    this.mProjection = paramBuilder.mTable.mProjection;
  }
  
  public String[] getProjection() {
    return this.mProjection;
  }
  
  public String getTableName() {
    return this.mTableName;
  }
  
  public Uri getUri() {
    return this.mUri;
  }
  
  public static class Builder {
    private ContentProviderSchema.Table mTable;
    
    public ContentProviderSchema build() {
      return new ContentProviderSchema(this);
    }
    
    public Builder table(ContentProviderSchema.Table param1Table) {
      this.mTable = param1Table;
      return this;
    }
  }
  
  public static class Table {
    private String[] mProjection;
    
    private String mTableName;
    
    private Uri mUri;
    
    private Table(Builder param1Builder) {
      this.mUri = param1Builder.mUri;
      this.mProjection = param1Builder.mProjection;
      this.mTableName = param1Builder.mTableName;
      if (this.mTableName == null)
        this.mTableName = this.mUri.getLastPathSegment(); 
    }
    
    public static class Builder {
      private String[] mProjection;
      
      private String mTableName;
      
      private Uri mUri;
      
      public ContentProviderSchema.Table build() {
        return new ContentProviderSchema.Table(this);
      }
      
      public Builder name(String param2String) {
        this.mTableName = param2String;
        return this;
      }
      
      public Builder projection(String[] param2ArrayOfString) {
        this.mProjection = param2ArrayOfString;
        return this;
      }
      
      public Builder uri(Uri param2Uri) {
        this.mUri = param2Uri;
        return this;
      }
    }
  }
  
  public static class Builder {
    private String[] mProjection;
    
    private String mTableName;
    
    private Uri mUri;
    
    public ContentProviderSchema.Table build() {
      return new ContentProviderSchema.Table(this);
    }
    
    public Builder name(String param1String) {
      this.mTableName = param1String;
      return this;
    }
    
    public Builder projection(String[] param1ArrayOfString) {
      this.mProjection = param1ArrayOfString;
      return this;
    }
    
    public Builder uri(Uri param1Uri) {
      this.mUri = param1Uri;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\database\ContentProviderSchema.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */