package com.alibaba.fastjson.asm;

public class MethodWriter implements MethodVisitor {
  private int access;
  
  private ByteVector code = new ByteVector();
  
  final ClassWriter cw;
  
  private final int desc;
  
  int exceptionCount;
  
  int[] exceptions;
  
  private int maxLocals;
  
  private int maxStack;
  
  private final int name;
  
  MethodWriter next;
  
  public MethodWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString) {
    if (paramClassWriter.firstMethod == null) {
      paramClassWriter.firstMethod = this;
    } else {
      paramClassWriter.lastMethod.next = this;
    } 
    paramClassWriter.lastMethod = this;
    this.cw = paramClassWriter;
    this.access = paramInt;
    this.name = paramClassWriter.newUTF8(paramString1);
    this.desc = paramClassWriter.newUTF8(paramString2);
    if (paramArrayOfString != null && paramArrayOfString.length > 0) {
      this.exceptionCount = paramArrayOfString.length;
      this.exceptions = new int[this.exceptionCount];
      for (paramInt = 0; paramInt < this.exceptionCount; paramInt++)
        this.exceptions[paramInt] = (paramClassWriter.newClassItem(paramArrayOfString[paramInt])).index; 
    } 
  }
  
  final int getSize() {
    byte b;
    if (this.code.length > 0) {
      this.cw.newUTF8("Code");
      b = this.code.length + 18 + 0 + 8;
    } else {
      b = 8;
    } 
    int i = b;
    if (this.exceptionCount > 0) {
      this.cw.newUTF8("Exceptions");
      i = b + this.exceptionCount * 2 + 8;
    } 
    return i;
  }
  
  final void put(ByteVector paramByteVector) {
    paramByteVector.putShort(this.access & 0xFFF9FFFF).putShort(this.name).putShort(this.desc);
    int i = this.code.length;
    boolean bool = false;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = i;
    if (this.exceptionCount > 0)
      j = i + 1; 
    paramByteVector.putShort(j);
    if (this.code.length > 0) {
      i = this.code.length;
      paramByteVector.putShort(this.cw.newUTF8("Code")).putInt(i + 12 + 0);
      paramByteVector.putShort(this.maxStack).putShort(this.maxLocals);
      paramByteVector.putInt(this.code.length).putByteArray(this.code.data, 0, this.code.length);
      paramByteVector.putShort(0);
      paramByteVector.putShort(0);
    } 
    if (this.exceptionCount > 0) {
      paramByteVector.putShort(this.cw.newUTF8("Exceptions")).putInt(this.exceptionCount * 2 + 2);
      paramByteVector.putShort(this.exceptionCount);
      for (i = bool; i < this.exceptionCount; i++)
        paramByteVector.putShort(this.exceptions[i]); 
    } 
  }
  
  public void visitEnd() {}
  
  public void visitFieldInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
    Item item = this.cw.newFieldItem(paramString1, paramString2, paramString3);
    this.code.put12(paramInt, item.index);
  }
  
  public void visitIincInsn(int paramInt1, int paramInt2) {
    this.code.putByte(132).put11(paramInt1, paramInt2);
  }
  
  public void visitInsn(int paramInt) {
    this.code.putByte(paramInt);
  }
  
  public void visitIntInsn(int paramInt1, int paramInt2) {
    this.code.put11(paramInt1, paramInt2);
  }
  
  public void visitJumpInsn(int paramInt, Label paramLabel) {
    if ((paramLabel.status & 0x2) == 0 || paramLabel.position - this.code.length >= -32768) {
      this.code.putByte(paramInt);
      ByteVector byteVector = this.code;
      paramLabel.put(this, byteVector, byteVector.length - 1);
      return;
    } 
    throw new UnsupportedOperationException();
  }
  
  public void visitLabel(Label paramLabel) {
    paramLabel.resolve(this, this.code.length, this.code.data);
  }
  
  public void visitLdcInsn(Object paramObject) {
    paramObject = this.cw.newConstItem(paramObject);
    int i = ((Item)paramObject).index;
    if (((Item)paramObject).type == 5 || ((Item)paramObject).type == 6) {
      this.code.put12(20, i);
      return;
    } 
    if (i >= 256) {
      this.code.put12(19, i);
      return;
    } 
    this.code.put11(18, i);
  }
  
  public void visitMaxs(int paramInt1, int paramInt2) {
    this.maxStack = paramInt1;
    this.maxLocals = paramInt2;
  }
  
  public void visitMethodInsn(int paramInt, String paramString1, String paramString2, String paramString3) {
    boolean bool;
    if (paramInt == 185) {
      bool = true;
    } else {
      bool = false;
    } 
    Item item = this.cw.newMethodItem(paramString1, paramString2, paramString3, bool);
    int i = item.intVal;
    if (bool) {
      paramInt = i;
      if (i == 0) {
        paramInt = Type.getArgumentsAndReturnSizes(paramString3);
        item.intVal = paramInt;
      } 
      this.code.put12(185, item.index).put11(paramInt >> 2, 0);
      return;
    } 
    this.code.put12(paramInt, item.index);
  }
  
  public void visitTypeInsn(int paramInt, String paramString) {
    Item item = this.cw.newClassItem(paramString);
    this.code.put12(paramInt, item.index);
  }
  
  public void visitVarInsn(int paramInt1, int paramInt2) {
    if (paramInt2 < 4 && paramInt1 != 169) {
      if (paramInt1 < 54) {
        paramInt1 = (paramInt1 - 21 << 2) + 26;
      } else {
        paramInt1 = (paramInt1 - 54 << 2) + 59;
      } 
      this.code.putByte(paramInt1 + paramInt2);
      return;
    } 
    if (paramInt2 >= 256) {
      this.code.putByte(196).put12(paramInt1, paramInt2);
      return;
    } 
    this.code.put11(paramInt1, paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\asm\MethodWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */