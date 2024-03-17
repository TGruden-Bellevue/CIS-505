public class TestFanApp {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8, "blue");

        System.out.println("Fan 1: " + fan1);
        System.out.println("Fan 2: " + fan2);
    }
}
