package org.chromium.mojo.system;

public final class MojoException extends RuntimeException {
  private final int mCode;
  
  public MojoException(int paramInt) {
    this.mCode = paramInt;
  }
  
  public final String toString() {
    StringBuilder stringBuilder = new StringBuilder("MojoResult(");
    stringBuilder.append(this.mCode);
    stringBuilder.append("): ");
    switch (this.mCode) {
      default:
        str = "UNKNOWN";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 17:
        str = "SHOULD_WAIT";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 16:
        str = "BUSY";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 15:
        str = "DATA_LOSS";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 14:
        str = "UNAVAILABLE";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 13:
        str = "INTERNAL";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 12:
        str = "UNIMPLEMENTED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 11:
        str = "OUT_OF_RANGE";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 10:
        str = "ABORTED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 9:
        str = "FAILED_PRECONDITION";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 8:
        str = "RESOURCE_EXHAUSTED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 7:
        str = "PERMISSION_DENIED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 6:
        str = "ALREADY_EXISTS";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 5:
        str = "NOT_FOUND";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 4:
        str = "DEADLINE_EXCEEDED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 3:
        str = "INVALID_ARGUMENT";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 2:
        str = "UNKNOWN";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 1:
        str = "CANCELLED";
        stringBuilder.append(str);
        return stringBuilder.toString();
      case 0:
        break;
    } 
    String str = "OK";
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\mojo\system\MojoException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */