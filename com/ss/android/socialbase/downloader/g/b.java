package com.ss.android.socialbase.downloader.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class b implements Parcelable {
  public static final Parcelable.Creator<b> CREATOR;
  
  private static final String a = b.class.getSimpleName();
  
  private int b;
  
  private long c;
  
  private AtomicLong d;
  
  private long e;
  
  private long f;
  
  private int g;
  
  private AtomicInteger h;
  
  private long i;
  
  private List<b> j;
  
  private b k;
  
  private int l;
  
  private boolean m;
  
  private AtomicBoolean n;
  
  private com.ss.android.socialbase.downloader.l.b o;
  
  static {
    CREATOR = new Parcelable.Creator<b>() {
        public b a(Parcel param1Parcel) {
          return new b(param1Parcel);
        }
        
        public b[] a(int param1Int) {
          return new b[param1Int];
        }
      };
  }
  
  public b(Cursor paramCursor) {
    if (paramCursor == null)
      return; 
    this.b = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    this.g = paramCursor.getInt(paramCursor.getColumnIndex("chunkIndex"));
    this.c = paramCursor.getLong(paramCursor.getColumnIndex("startOffset"));
    int i = paramCursor.getColumnIndex("curOffset");
    if (i != -1) {
      this.d = new AtomicLong(paramCursor.getLong(i));
    } else {
      this.d = new AtomicLong(0L);
    } 
    this.e = paramCursor.getLong(paramCursor.getColumnIndex("endOffset"));
    i = paramCursor.getColumnIndex("hostChunkIndex");
    if (i != -1) {
      this.h = new AtomicInteger(paramCursor.getInt(i));
    } else {
      this.h = new AtomicInteger(-1);
    } 
    i = paramCursor.getColumnIndex("chunkContentLen");
    if (i != -1)
      this.f = paramCursor.getLong(i); 
    this.n = new AtomicBoolean(false);
  }
  
  protected b(Parcel paramParcel) {
    this.b = paramParcel.readInt();
    this.c = paramParcel.readLong();
    this.d = new AtomicLong(paramParcel.readLong());
    this.e = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.g = paramParcel.readInt();
    this.h = new AtomicInteger(paramParcel.readInt());
  }
  
  private b(a parama) {
    if (parama == null)
      return; 
    this.b = a.a(parama);
    this.c = a.b(parama);
    this.d = new AtomicLong(a.c(parama));
    this.e = a.d(parama);
    this.f = a.e(parama);
    this.g = a.f(parama);
    this.i = a.g(parama);
    this.h = new AtomicInteger(-1);
    a(a.h(parama));
    this.n = new AtomicBoolean(false);
  }
  
  public ContentValues a() {
    ContentValues contentValues = new ContentValues();
    contentValues.put("_id", Integer.valueOf(this.b));
    contentValues.put("chunkIndex", Integer.valueOf(this.g));
    contentValues.put("startOffset", Long.valueOf(this.c));
    contentValues.put("curOffset", Long.valueOf(n()));
    contentValues.put("endOffset", Long.valueOf(this.e));
    contentValues.put("chunkContentLen", Long.valueOf(this.f));
    contentValues.put("hostChunkIndex", Integer.valueOf(b()));
    return contentValues;
  }
  
  public List<b> a(int paramInt, long paramLong) {
    if (!d() || f())
      return null; 
    ArrayList<b> arrayList = new ArrayList();
    long l1 = m();
    long l2 = c(true);
    long l3 = l2 / paramInt;
    String str = a;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("retainLen:");
    stringBuilder.append(l2);
    stringBuilder.append(" divideChunkForReuse chunkSize:");
    stringBuilder.append(l3);
    stringBuilder.append(" current host downloadChunk index:");
    stringBuilder.append(this.g);
    com.ss.android.socialbase.downloader.f.a.b(str, stringBuilder.toString());
    int i = 0;
    while (true) {
      if (i < paramInt) {
        if (i == 0) {
          long l = l();
          l4 = l1 + l3 - 1L;
        } else {
          long l7;
          long l8;
          int j = paramInt - 1;
          if (i == j) {
            l8 = p();
            if (l8 > l1) {
              l7 = 1L + l8 - l1;
            } else {
              l7 = l2 - j * l3;
            } 
            l4 = l7;
            l7 = l1;
          } else {
            l4 = l1 + l3 - 1L;
            l7 = l1;
            long l = l3;
            l8 = l4;
            l4 = l;
          } 
          b b2 = (new a(this.b)).a(-i - 1).a(l7).b(l1).e(l1).c(l8).d(l4).a(this).a();
          String str1 = a;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("divide sub chunk : ");
          stringBuilder1.append(i);
          stringBuilder1.append(" startOffset:");
          stringBuilder1.append(l7);
          stringBuilder1.append(" curOffset:");
          stringBuilder1.append(l1);
          stringBuilder1.append(" endOffset:");
          stringBuilder1.append(l8);
          stringBuilder1.append(" contentLen:");
          stringBuilder1.append(l4);
          com.ss.android.socialbase.downloader.f.a.b(str1, stringBuilder1.toString());
          arrayList.add(b2);
          l1 += l3;
          i++;
          continue;
        } 
      } else {
        break;
      } 
      long l5 = l3;
      long l6 = l4;
      long l4 = l5;
    } 
    paramInt = arrayList.size() - 1;
    for (l1 = 0L; paramInt > 0; l1 = l) {
      b b2 = arrayList.get(paramInt);
      long l = l1;
      if (b2 != null)
        l = l1 + b2.q(); 
      paramInt--;
    } 
    str = a;
    stringBuilder = new StringBuilder();
    stringBuilder.append("reuseChunkContentLen:");
    stringBuilder.append(l1);
    com.ss.android.socialbase.downloader.f.a.b(str, stringBuilder.toString());
    b b1 = arrayList.get(0);
    if (b1 != null) {
      if (p() == 0L) {
        paramLong -= l();
      } else {
        paramLong = p() - l() + 1L;
      } 
      b1.a(paramLong - l1);
      b1.c(this.g);
      com.ss.android.socialbase.downloader.l.b b2 = this.o;
      if (b2 != null)
        b2.a(b1.p(), q() - l1); 
    } 
    a(arrayList);
    return arrayList;
  }
  
  public void a(int paramInt) {
    AtomicInteger atomicInteger = this.h;
    if (atomicInteger == null) {
      this.h = new AtomicInteger(paramInt);
      return;
    } 
    atomicInteger.set(paramInt);
  }
  
  public void a(long paramLong) {
    this.f = paramLong;
  }
  
  public void a(SQLiteStatement paramSQLiteStatement) {
    if (paramSQLiteStatement == null)
      return; 
    this.l = 0;
    paramSQLiteStatement.clearBindings();
    int i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, this.b);
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, this.g);
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, this.c);
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, n());
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, this.e);
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, this.f);
    i = this.l + 1;
    this.l = i;
    paramSQLiteStatement.bindLong(i, b());
  }
  
  public void a(b paramb) {
    this.k = paramb;
    paramb = this.k;
    if (paramb != null)
      a(paramb.s()); 
  }
  
  public void a(com.ss.android.socialbase.downloader.l.b paramb) {
    this.o = paramb;
    r();
  }
  
  public void a(List<b> paramList) {
    this.j = paramList;
  }
  
  public void a(boolean paramBoolean) {
    AtomicBoolean atomicBoolean = this.n;
    if (atomicBoolean == null) {
      this.n = new AtomicBoolean(paramBoolean);
    } else {
      atomicBoolean.set(paramBoolean);
    } 
    this.o = null;
  }
  
  public int b() {
    AtomicInteger atomicInteger = this.h;
    return (atomicInteger == null) ? -1 : atomicInteger.get();
  }
  
  public void b(int paramInt) {
    this.b = paramInt;
  }
  
  public void b(long paramLong) {
    AtomicLong atomicLong = this.d;
    if (atomicLong != null) {
      atomicLong.set(paramLong);
      return;
    } 
    this.d = new AtomicLong(paramLong);
  }
  
  public void b(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public long c(boolean paramBoolean) {
    long l3 = n();
    long l4 = this.f;
    long l5 = this.i;
    long l2 = l4 - l3 - l5;
    long l1 = l2;
    if (!paramBoolean) {
      l1 = l2;
      if (l3 == l5)
        l1 = l4 - l3 - this.c; 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("contentLength:");
    stringBuilder.append(this.f);
    stringBuilder.append(" curOffset:");
    stringBuilder.append(n());
    stringBuilder.append(" oldOffset:");
    stringBuilder.append(this.i);
    stringBuilder.append(" retainLen:");
    stringBuilder.append(l1);
    com.ss.android.socialbase.downloader.f.a.b("DownloadChunk", stringBuilder.toString());
    return (l1 < 0L) ? 0L : l1;
  }
  
  public void c(int paramInt) {
    this.g = paramInt;
  }
  
  public boolean c() {
    AtomicBoolean atomicBoolean = this.n;
    return (atomicBoolean == null) ? false : atomicBoolean.get();
  }
  
  public boolean d() {
    return (b() == -1);
  }
  
  public int describeContents() {
    return 0;
  }
  
  public b e() {
    b b1;
    if (!d()) {
      b1 = this.k;
    } else {
      b1 = this;
    } 
    return (b1 == null || !b1.f()) ? null : b1.g().get(0);
  }
  
  public boolean f() {
    List<b> list = this.j;
    return (list != null && list.size() > 0);
  }
  
  public List<b> g() {
    return this.j;
  }
  
  public boolean h() {
    b b1 = this.k;
    if (b1 == null)
      return true; 
    if (!b1.f())
      return false; 
    for (int i = 0; i < this.k.g().size(); i++) {
      b1 = this.k.g().get(i);
      if (b1 != null) {
        int j = this.k.g().indexOf(this);
        if (j > i && !b1.i())
          return false; 
        if (j == i)
          return true; 
      } 
    } 
    return false;
  }
  
  public boolean i() {
    long l2 = this.c;
    long l1 = l2;
    if (d()) {
      long l = this.i;
      l1 = l2;
      if (l > this.c)
        l1 = l; 
    } 
    return (n() - l1 >= this.f);
  }
  
  public long j() {
    b b1 = this.k;
    if (b1 != null) {
      if (b1.g() == null)
        return -1L; 
      int j = this.k.g().indexOf(this);
      int i = 0;
      for (boolean bool = false; i < this.k.g().size(); bool = bool1) {
        b1 = this.k.g().get(i);
        boolean bool1 = bool;
        if (b1 != null) {
          if (bool)
            return b1.n(); 
          bool1 = bool;
          if (j == i)
            bool1 = true; 
        } 
        i++;
      } 
    } 
    return -1L;
  }
  
  public int k() {
    return this.b;
  }
  
  public long l() {
    return this.c;
  }
  
  public long m() {
    AtomicLong atomicLong = this.d;
    return (atomicLong != null) ? atomicLong.get() : 0L;
  }
  
  public long n() {
    if (d() && f()) {
      long l = 0L;
      int i = 0;
      while (i < this.j.size()) {
        b b1 = this.j.get(i);
        long l1 = l;
        if (b1 != null) {
          if (!b1.i())
            return b1.m(); 
          l1 = l;
          if (l < b1.m())
            l1 = b1.m(); 
        } 
        i++;
        l = l1;
      } 
      return l;
    } 
    return m();
  }
  
  public long o() {
    long l = n() - this.c;
    if (f()) {
      long l1 = 0L;
      int i = 0;
      while (true) {
        l = l1;
        if (i < this.j.size()) {
          b b1 = this.j.get(i);
          l = l1;
          if (b1 != null)
            l = l1 + b1.n() - b1.l(); 
          i++;
          l1 = l;
          continue;
        } 
        break;
      } 
    } 
    return l;
  }
  
  public long p() {
    return this.e;
  }
  
  public long q() {
    return this.f;
  }
  
  public void r() {
    this.i = n();
  }
  
  public int s() {
    return this.g;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    long l;
    paramParcel.writeInt(this.b);
    paramParcel.writeLong(this.c);
    AtomicLong atomicLong = this.d;
    if (atomicLong != null) {
      l = atomicLong.get();
    } else {
      l = 0L;
    } 
    paramParcel.writeLong(l);
    paramParcel.writeLong(this.e);
    paramParcel.writeLong(this.f);
    paramParcel.writeInt(this.g);
    paramInt = -1;
    AtomicInteger atomicInteger = this.h;
    if (atomicInteger != null)
      paramInt = atomicInteger.get(); 
    paramParcel.writeInt(paramInt);
  }
  
  public static class a {
    private int a;
    
    private long b;
    
    private long c;
    
    private long d;
    
    private long e;
    
    private int f;
    
    private long g;
    
    private b h;
    
    public a(int param1Int) {
      this.a = param1Int;
    }
    
    public a a(int param1Int) {
      this.f = param1Int;
      return this;
    }
    
    public a a(long param1Long) {
      this.b = param1Long;
      return this;
    }
    
    public a a(b param1b) {
      this.h = param1b;
      return this;
    }
    
    public b a() {
      return new b(this);
    }
    
    public a b(long param1Long) {
      this.c = param1Long;
      return this;
    }
    
    public a c(long param1Long) {
      this.d = param1Long;
      return this;
    }
    
    public a d(long param1Long) {
      this.e = param1Long;
      return this;
    }
    
    public a e(long param1Long) {
      this.g = param1Long;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */