package com.squareup.okhttp.internal.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import okio.Okio;
import okio.Sink;
import okio.Source;

public interface FileSystem {
  public static final FileSystem SYSTEM = new FileSystem() {
      public Sink appendingSink(File param1File) throws FileNotFoundException {
        try {
          return Okio.appendingSink(param1File);
        } catch (FileNotFoundException fileNotFoundException) {
          param1File.getParentFile().mkdirs();
          return Okio.appendingSink(param1File);
        } 
      }
      
      public void delete(File param1File) throws IOException {
        if (!param1File.delete()) {
          if (!param1File.exists())
            return; 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("failed to delete ");
          stringBuilder.append(param1File);
          throw new IOException(stringBuilder.toString());
        } 
      }
      
      public void deleteContents(File param1File) throws IOException {
        File[] arrayOfFile = param1File.listFiles();
        if (arrayOfFile != null) {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j) {
            param1File = arrayOfFile[i];
            if (param1File.isDirectory())
              deleteContents(param1File); 
            if (param1File.delete()) {
              i++;
              continue;
            } 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("failed to delete ");
            stringBuilder1.append(param1File);
            throw new IOException(stringBuilder1.toString());
          } 
          return;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("not a readable directory: ");
        stringBuilder.append(param1File);
        throw new IOException(stringBuilder.toString());
      }
      
      public boolean exists(File param1File) throws IOException {
        return param1File.exists();
      }
      
      public void rename(File param1File1, File param1File2) throws IOException {
        delete(param1File2);
        if (param1File1.renameTo(param1File2))
          return; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to rename ");
        stringBuilder.append(param1File1);
        stringBuilder.append(" to ");
        stringBuilder.append(param1File2);
        throw new IOException(stringBuilder.toString());
      }
      
      public Sink sink(File param1File) throws FileNotFoundException {
        try {
          return Okio.sink(param1File);
        } catch (FileNotFoundException fileNotFoundException) {
          param1File.getParentFile().mkdirs();
          return Okio.sink(param1File);
        } 
      }
      
      public long size(File param1File) {
        return param1File.length();
      }
      
      public Source source(File param1File) throws FileNotFoundException {
        return Okio.source(param1File);
      }
    };
  
  Sink appendingSink(File paramFile) throws FileNotFoundException;
  
  void delete(File paramFile) throws IOException;
  
  void deleteContents(File paramFile) throws IOException;
  
  boolean exists(File paramFile) throws IOException;
  
  void rename(File paramFile1, File paramFile2) throws IOException;
  
  Sink sink(File paramFile) throws FileNotFoundException;
  
  long size(File paramFile);
  
  Source source(File paramFile) throws FileNotFoundException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\internal\io\FileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */