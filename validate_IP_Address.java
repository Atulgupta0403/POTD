// You are given a string str in the form of an IPv4 Address. Your task is to validate an IPv4 Address, if it is valid return true otherwise return false.

// IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots, e.g., 172.16.254.1

// A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255. Thus, we can write the generalized form of an IPv4 address as (0-255).(0-255).(0-255).(0-255)

// Note: Here we are considering numbers only from 0 to 255 and any additional leading zeroes will be considered invalid.



/**
 * validate_IP_Address
 */
public class validate_IP_Address {

    public static void main(String[] args) {
        String str = "172.16.254.1"; // Change this to test different IP addresses
        System.out.println(isValidIPv4(str));
    }

    public static boolean isValidIPv4(String str) {
        // Split the string by the dot (.)
        String[] parts = str.split("\\.");

        // There must be exactly 4 parts
        if (parts.length != 4) {
            return false;
        }

        // Check each part
        for (String part : parts) {
            // Check if the part is a number and within the range 0-255
            if (!isValidPart(part)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidPart(String part) {
        // Check if the part is empty
        if (part.isEmpty()) {
            return false;
        }

        // Check if the part has leading zeros
        if (part.length() > 1 && part.startsWith("0")) {
            return false;
        }

        try {
            int value = Integer.parseInt(part);
            // Check if the part is within the range 0-255
            return value >= 0 && value <= 255;
        } catch (NumberFormatException e) {
            // The part is not a valid number
            return false;
        }
    }
}