public class ProcessInfo {

    static {
        System.loadLibrary("ProcessInfo");
    }

    public native int getProcessID();

    public static void main(String[] args) {
        ProcessInfo processInfo = new ProcessInfo();

        int pid = processInfo.getProcessID();

        System.out.println("Current Process ID: " + pid);
    }
}
