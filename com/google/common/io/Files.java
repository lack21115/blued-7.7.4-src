package com.google.common.io;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.SuccessorsFunction;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Files {
  private static final TreeTraverser<File> a = new TreeTraverser<File>() {
      public Iterable<File> a(File param1File) {
        return Files.a(param1File);
      }
      
      public String toString() {
        return "Files.fileTreeTraverser()";
      }
    };
  
  private static final SuccessorsFunction<File> b = new SuccessorsFunction<File>() {
      public Iterable<File> a(File param1File) {
        return Files.a(param1File);
      }
    };
  
  private static Iterable<File> b(File paramFile) {
    if (paramFile.isDirectory()) {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
        return Collections.unmodifiableList(Arrays.asList(arrayOfFile)); 
    } 
    return Collections.emptyList();
  }
  
  static final class FileByteSink extends ByteSink {
    private final File a;
    
    private final ImmutableSet<FileWriteMode> b;
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Files.asByteSink(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class FileByteSource extends ByteSource {
    private final File a;
    
    public FileInputStream b() throws IOException {
      return new FileInputStream(this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Files.asByteSource(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  enum FilePredicate implements Predicate<File> {
    a {
      public boolean a(File param2File) {
        return param2File.isDirectory();
      }
      
      public String toString() {
        return "Files.isDirectory()";
      }
    },
    b {
      public boolean a(File param2File) {
        return param2File.isFile();
      }
      
      public String toString() {
        return "Files.isFile()";
      }
    };
  }
  
  enum null {
    public boolean a(File param1File) {
      return param1File.isDirectory();
    }
    
    public String toString() {
      return "Files.isDirectory()";
    }
  }
  
  enum null {
    public boolean a(File param1File) {
      return param1File.isFile();
    }
    
    public String toString() {
      return "Files.isFile()";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\Files.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */