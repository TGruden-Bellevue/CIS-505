public class TestFanApp {
    public static void main(String[] args) {
        // Creating instances of Fan class
        Fan defaultFan = new Fan();
        Fan customFan = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

      // Displaying fan objects
      System.out.println(defaultFan); // No need to specify "Default fan:"
      System.out.println(customFan); // No need to specify "Custom fan:"
  }
}
