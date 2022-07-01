package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class GeneralAppIdDecoder {
  private final BitArray a;
  
  private final CurrentParsingState b = new CurrentParsingState();
  
  private final StringBuilder c = new StringBuilder();
  
  GeneralAppIdDecoder(BitArray paramBitArray) {
    this.a = paramBitArray;
  }
  
  static int a(BitArray paramBitArray, int paramInt1, int paramInt2) {
    int i = 0;
    int j;
    for (j = 0; i < paramInt2; j = k) {
      int k = j;
      if (paramBitArray.a(paramInt1 + i))
        k = j | 1 << paramInt2 - i - 1; 
      i++;
    } 
    return j;
  }
  
  private DecodedInformation a() throws FormatException {
    int i;
    boolean bool;
    BlockParsedResult blockParsedResult;
    do {
      i = this.b.a();
      if (this.b.b()) {
        blockParsedResult = d();
        bool = blockParsedResult.b();
      } else if (this.b.c()) {
        blockParsedResult = c();
        bool = blockParsedResult.b();
      } else {
        blockParsedResult = b();
        bool = blockParsedResult.b();
      } 
      if (i != this.b.a()) {
        i = 1;
      } else {
        i = 0;
      } 
    } while ((i != 0 || bool) && !bool);
    return blockParsedResult.a();
  }
  
  private boolean a(int paramInt) {
    if (paramInt + 7 > this.a.a())
      return (paramInt + 4 <= this.a.a()); 
    int i = paramInt;
    while (true) {
      int j = paramInt + 3;
      if (i < j) {
        if (this.a.a(i))
          return true; 
        i++;
        continue;
      } 
      return this.a.a(j);
    } 
  }
  
  private BlockParsedResult b() throws FormatException {
    while (a(this.b.a())) {
      DecodedInformation decodedInformation;
      DecodedNumeric decodedNumeric = b(this.b.a());
      this.b.a(decodedNumeric.e());
      if (decodedNumeric.c()) {
        if (decodedNumeric.d()) {
          decodedInformation = new DecodedInformation(this.b.a(), this.c.toString());
        } else {
          decodedInformation = new DecodedInformation(this.b.a(), this.c.toString(), decodedInformation.b());
        } 
        return new BlockParsedResult(decodedInformation, true);
      } 
      this.c.append(decodedInformation.a());
      if (decodedInformation.d())
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true); 
      this.c.append(decodedInformation.b());
    } 
    if (i(this.b.a())) {
      this.b.e();
      this.b.b(4);
    } 
    return new BlockParsedResult(false);
  }
  
  private DecodedNumeric b(int paramInt) throws FormatException {
    int i = paramInt + 7;
    if (i > this.a.a()) {
      paramInt = a(paramInt, 4);
      return (paramInt == 0) ? new DecodedNumeric(this.a.a(), 10, 10) : new DecodedNumeric(this.a.a(), paramInt - 1, 10);
    } 
    paramInt = a(paramInt, 7) - 8;
    return new DecodedNumeric(i, paramInt / 11, paramInt % 11);
  }
  
  private BlockParsedResult c() throws FormatException {
    while (c(this.b.a())) {
      DecodedChar decodedChar = d(this.b.a());
      this.b.a(decodedChar.e());
      if (decodedChar.b())
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true); 
      this.c.append(decodedChar.a());
    } 
    if (h(this.b.a())) {
      this.b.b(3);
      this.b.d();
    } else if (g(this.b.a())) {
      if (this.b.a() + 5 < this.a.a()) {
        this.b.b(5);
      } else {
        this.b.a(this.a.a());
      } 
      this.b.e();
    } 
    return new BlockParsedResult(false);
  }
  
  private boolean c(int paramInt) {
    if (paramInt + 5 > this.a.a())
      return false; 
    int i = a(paramInt, 5);
    if (i >= 5 && i < 16)
      return true; 
    if (paramInt + 7 > this.a.a())
      return false; 
    i = a(paramInt, 7);
    if (i >= 64 && i < 116)
      return true; 
    if (paramInt + 8 > this.a.a())
      return false; 
    paramInt = a(paramInt, 8);
    return (paramInt >= 232 && paramInt < 253);
  }
  
  private BlockParsedResult d() {
    while (e(this.b.a())) {
      DecodedChar decodedChar = f(this.b.a());
      this.b.a(decodedChar.e());
      if (decodedChar.b())
        return new BlockParsedResult(new DecodedInformation(this.b.a(), this.c.toString()), true); 
      this.c.append(decodedChar.a());
    } 
    if (h(this.b.a())) {
      this.b.b(3);
      this.b.d();
    } else if (g(this.b.a())) {
      if (this.b.a() + 5 < this.a.a()) {
        this.b.b(5);
      } else {
        this.b.a(this.a.a());
      } 
      this.b.f();
    } 
    return new BlockParsedResult(false);
  }
  
  private DecodedChar d(int paramInt) throws FormatException {
    int i = a(paramInt, 5);
    if (i == 15)
      return new DecodedChar(paramInt + 5, '$'); 
    if (i >= 5 && i < 15)
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5)); 
    i = a(paramInt, 7);
    if (i >= 64 && i < 90)
      return new DecodedChar(paramInt + 7, (char)(i + 1)); 
    if (i >= 90 && i < 116)
      return new DecodedChar(paramInt + 7, (char)(i + 7)); 
    switch (a(paramInt, 8)) {
      default:
        throw FormatException.a();
      case 252:
        b = 32;
        return new DecodedChar(paramInt + 8, b);
      case 251:
        b = 95;
        return new DecodedChar(paramInt + 8, b);
      case 250:
        b = 63;
        return new DecodedChar(paramInt + 8, b);
      case 249:
        b = 62;
        return new DecodedChar(paramInt + 8, b);
      case 248:
        b = 61;
        return new DecodedChar(paramInt + 8, b);
      case 247:
        b = 60;
        return new DecodedChar(paramInt + 8, b);
      case 246:
        b = 59;
        return new DecodedChar(paramInt + 8, b);
      case 245:
        b = 58;
        return new DecodedChar(paramInt + 8, b);
      case 244:
        b = 47;
        return new DecodedChar(paramInt + 8, b);
      case 243:
        b = 46;
        return new DecodedChar(paramInt + 8, b);
      case 242:
        b = 45;
        return new DecodedChar(paramInt + 8, b);
      case 241:
        b = 44;
        return new DecodedChar(paramInt + 8, b);
      case 240:
        b = 43;
        return new DecodedChar(paramInt + 8, b);
      case 239:
        b = 42;
        return new DecodedChar(paramInt + 8, b);
      case 238:
        b = 41;
        return new DecodedChar(paramInt + 8, b);
      case 237:
        b = 40;
        return new DecodedChar(paramInt + 8, b);
      case 236:
        b = 39;
        return new DecodedChar(paramInt + 8, b);
      case 235:
        b = 38;
        return new DecodedChar(paramInt + 8, b);
      case 234:
        b = 37;
        return new DecodedChar(paramInt + 8, b);
      case 233:
        b = 34;
        return new DecodedChar(paramInt + 8, b);
      case 232:
        break;
    } 
    byte b = 33;
    return new DecodedChar(paramInt + 8, b);
  }
  
  private boolean e(int paramInt) {
    if (paramInt + 5 > this.a.a())
      return false; 
    int i = a(paramInt, 5);
    if (i >= 5 && i < 16)
      return true; 
    if (paramInt + 6 > this.a.a())
      return false; 
    paramInt = a(paramInt, 6);
    return (paramInt >= 16 && paramInt < 63);
  }
  
  private DecodedChar f(int paramInt) {
    int i = a(paramInt, 5);
    if (i == 15)
      return new DecodedChar(paramInt + 5, '$'); 
    if (i >= 5 && i < 15)
      return new DecodedChar(paramInt + 5, (char)(i + 48 - 5)); 
    i = a(paramInt, 6);
    if (i >= 32 && i < 58)
      return new DecodedChar(paramInt + 6, (char)(i + 33)); 
    switch (i) {
      default:
        throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(i)));
      case 62:
        b = 47;
        return new DecodedChar(paramInt + 6, b);
      case 61:
        b = 46;
        return new DecodedChar(paramInt + 6, b);
      case 60:
        b = 45;
        return new DecodedChar(paramInt + 6, b);
      case 59:
        b = 44;
        return new DecodedChar(paramInt + 6, b);
      case 58:
        break;
    } 
    byte b = 42;
    return new DecodedChar(paramInt + 6, b);
  }
  
  private boolean g(int paramInt) {
    if (paramInt + 1 > this.a.a())
      return false; 
    int i = 0;
    while (i < 5) {
      int j = i + paramInt;
      if (j < this.a.a()) {
        if (i == 2) {
          if (!this.a.a(paramInt + 2))
            return false; 
        } else if (this.a.a(j)) {
          return false;
        } 
        i++;
      } 
    } 
    return true;
  }
  
  private boolean h(int paramInt) {
    int i = paramInt + 3;
    if (i > this.a.a())
      return false; 
    while (paramInt < i) {
      if (this.a.a(paramInt))
        return false; 
      paramInt++;
    } 
    return true;
  }
  
  private boolean i(int paramInt) {
    if (paramInt + 1 > this.a.a())
      return false; 
    int i = 0;
    while (i < 4) {
      int j = i + paramInt;
      if (j < this.a.a()) {
        if (this.a.a(j))
          return false; 
        i++;
      } 
    } 
    return true;
  }
  
  int a(int paramInt1, int paramInt2) {
    return a(this.a, paramInt1, paramInt2);
  }
  
  DecodedInformation a(int paramInt, String paramString) throws FormatException {
    this.c.setLength(0);
    if (paramString != null)
      this.c.append(paramString); 
    this.b.a(paramInt);
    DecodedInformation decodedInformation = a();
    return (decodedInformation != null && decodedInformation.b()) ? new DecodedInformation(this.b.a(), this.c.toString(), decodedInformation.c()) : new DecodedInformation(this.b.a(), this.c.toString());
  }
  
  String a(StringBuilder paramStringBuilder, int paramInt) throws NotFoundException, FormatException {
    String str = null;
    while (true) {
      DecodedInformation decodedInformation = a(paramInt, str);
      str = FieldParser.a(decodedInformation.a());
      if (str != null)
        paramStringBuilder.append(str); 
      if (decodedInformation.b()) {
        str = String.valueOf(decodedInformation.c());
      } else {
        str = null;
      } 
      if (paramInt != decodedInformation.e()) {
        paramInt = decodedInformation.e();
        continue;
      } 
      return paramStringBuilder.toString();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\oned\rss\expanded\decoders\GeneralAppIdDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */