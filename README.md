# java-native-interface-JNI


# Compile the C program
$ export JAVA_HOME=/your/java/installed/dir
$ echo $JAVA_HOME
$ gcc -fPIC -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/linux" -shared -o libhello.so fileName.c