package com.ishumei.l111l1111l1Il;

import com.ishumei.l111l11111lIl.l111l1111llIl;
import com.ishumei.smantifraud.SmAntiFraud;

public class l1111l111111Il {
  private int l1111l111111Il = 1;
  
  private int l111l11111I1l = 60;
  
  private int l111l11111Il = 0;
  
  private int l111l11111lIl = 60;
  
  private String l111l1111l1Il = null;
  
  private byte[] l111l1111lI1l = null;
  
  private boolean l111l1111lIl = false;
  
  private String[] l111l1111llIl = null;
  
  private l1111l111111Il() {
    l11l1111I11l();
  }
  
  public static l1111l111111Il l1111l111111Il(String paramString) {
    boolean bool;
    l1111l111111Il.l1111l111111Il();
    l1111l111111Il l1111l111111Il1 = l1111l111111Il.l1111l111111Il();
    l1111l111111Il l1111l111111Il2 = new l1111l111111Il();
    l1111l111111Il2.l111l1111lIl = l1111l111111Il1.l111l1111lIl;
    l1111l111111Il2.l111l11111lIl = l1111l111111Il1.l111l11111lIl;
    l1111l111111Il2.l111l11111I1l = l1111l111111Il1.l111l11111I1l;
    l1111l111111Il2.l111l1111llIl = l1111l111111Il1.l111l1111llIl;
    l1111l111111Il2.l111l1111lI1l = l1111l111111Il1.l111l1111lI1l;
    l1111l111111Il2.l111l11111Il = l1111l111111Il1.l111l11111Il;
    if (paramString.startsWith("https://")) {
      bool = false;
    } else {
      bool = true;
    } 
    l1111l111111Il2.l1111l111111Il = bool;
    l1111l111111Il2.l111l1111l1Il = paramString;
    return l1111l111111Il2;
  }
  
  public static l1111l111111Il l1111l111111Il(String paramString, byte[] paramArrayOfbyte, boolean paramBoolean) {
    l1111l111111Il l1111l111111Il1 = new l1111l111111Il();
    l1111l111111Il1.l11l1111I11l();
    if (paramString.startsWith("https://")) {
      l1111l111111Il1.l1111l111111Il = 0;
      if (paramArrayOfbyte != null)
        l1111l111111Il1.l111l1111lI1l = paramArrayOfbyte; 
    } else {
      l1111l111111Il1.l1111l111111Il = 1;
    } 
    l1111l111111Il1.l111l1111l1Il = paramString;
    l1111l111111Il1.l111l1111lIl = paramBoolean;
    return l1111l111111Il1;
  }
  
  private void l1111l111111Il(int paramInt) {
    this.l111l11111lIl = paramInt;
  }
  
  public static void l1111l111111Il(SmAntiFraud.SmOption paramSmOption) {
    l1111l111111Il l1111l111111Il1 = l1111l111111Il.l1111l111111Il();
    if (paramSmOption.l111l1111l1Il() != null)
      l1111l111111Il1.l111l1111lI1l = paramSmOption.l111l1111l1Il(); 
    l1111l111111Il1.l111l1111lIl = paramSmOption.l111l11111Il();
  }
  
  private void l1111l111111Il(boolean paramBoolean) {
    this.l111l1111lIl = paramBoolean;
  }
  
  private void l1111l111111Il(byte[] paramArrayOfbyte) {
    this.l111l1111lI1l = paramArrayOfbyte;
  }
  
  private void l1111l111111Il(String[] paramArrayOfString) {
    this.l111l1111llIl = paramArrayOfString;
  }
  
  private void l111l11111I1l(int paramInt) {
    this.l1111l111111Il = paramInt;
  }
  
  private void l111l11111Il(int paramInt) {
    this.l111l11111Il = paramInt;
  }
  
  private void l111l11111lIl(int paramInt) {
    this.l111l11111I1l = paramInt;
  }
  
  private void l111l11111lIl(String paramString) {
    this.l111l1111l1Il = paramString;
  }
  
  private void l11l1111I11l() {
    this.l111l1111llIl = l111l1111llIl.l111l11111Il;
    this.l111l11111lIl = 4;
    this.l111l11111I1l = 30;
    this.l111l11111Il = 0;
    this.l111l1111lI1l = l111l1111llIl.l111l1111l1Il;
  }
  
  private static l1111l111111Il l11l1111I1l() {
    l1111l111111Il l1111l111111Il1 = l1111l111111Il.l1111l111111Il();
    l1111l111111Il l1111l111111Il2 = new l1111l111111Il();
    l1111l111111Il2.l111l1111lIl = l1111l111111Il1.l111l1111lIl;
    l1111l111111Il2.l111l11111lIl = l1111l111111Il1.l111l11111lIl;
    l1111l111111Il2.l111l11111I1l = l1111l111111Il1.l111l11111I1l;
    l1111l111111Il2.l111l1111llIl = l1111l111111Il1.l111l1111llIl;
    l1111l111111Il2.l111l1111lI1l = l1111l111111Il1.l111l1111lI1l;
    l1111l111111Il2.l111l11111Il = l1111l111111Il1.l111l11111Il;
    return l1111l111111Il2;
  }
  
  private static l1111l111111Il l11l1111lIIl() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  public final boolean l1111l111111Il() {
    return this.l111l1111lIl;
  }
  
  public final int l111l11111I1l() {
    return this.l111l11111I1l;
  }
  
  public final int l111l11111Il() {
    return this.l1111l111111Il;
  }
  
  public final int l111l11111lIl() {
    return this.l111l11111lIl;
  }
  
  public final String l111l1111l1Il() {
    return this.l111l1111l1Il;
  }
  
  public final byte[] l111l1111lI1l() {
    return this.l111l1111lI1l;
  }
  
  public final int l111l1111lIl() {
    return this.l111l11111Il;
  }
  
  public final String[] l111l1111llIl() {
    return this.l111l1111llIl;
  }
  
  static final class l1111l111111Il {
    private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l1111l1Il\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */