public class MainDemoFil {
    public static void main(String[] args) {
        Thread fil = Thread.currentThread();

        // propietats del fil principal
        System.out.println("MainDemoFil.main:");
        System.out.println("Prioritat -> " + fil.getPriority());
        System.out.println("Nom -> " + fil.getName());
        System.out.println("toString() -> " + fil.toString());
    }
}
