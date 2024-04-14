package ro.ccar;

public record Employee(String firstName, String lastName, int yearsEmployed) {

    private static String privateProp = "S";
}
