import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

public class Main {
   public static void main(String[] args) {
       SymbolLookup stdlib = Linker.nativeLinker().defaultLookup();
       MethodHandle strlen = Linker.nativeLinker().downcallHandle(stdlib.find("strlen").orElseThrow(),
               FunctionDescriptor.of(JAVA_LONG, ADDRESS));

       try (Arena offHeap = Arena.ofConfined()) {
           MemorySegment str = offHeap.allocateUtf8String("Java 21 is the issh");
           long len = (long) strlen.invoke(str);
           System.out.println("len = " + len);
       } catch (Throwable e) {
           throw new RuntimeException(e);
       }
   }
}
