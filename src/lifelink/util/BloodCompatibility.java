package lifelink.util;

import java.util.*;

public class BloodCompatibility {

    private static final Map<String, List<String>> compatibilityMap =
            new HashMap<>();

    static {

        compatibilityMap.put("O-", Arrays.asList("O-"));

        compatibilityMap.put("O+", Arrays.asList(
                "O-", "O+"
        ));

        compatibilityMap.put("A-", Arrays.asList(
                "O-", "A-"
        ));

        compatibilityMap.put("A+", Arrays.asList(
                "O-", "O+", "A-", "A+"
        ));

        compatibilityMap.put("B-", Arrays.asList(
                "O-", "B-"
        ));

        compatibilityMap.put("B+", Arrays.asList(
                "O-", "O+", "B-", "B+"
        ));

        compatibilityMap.put("AB-", Arrays.asList(
                "O-", "A-", "B-", "AB-"
        ));

        compatibilityMap.put("AB+", Arrays.asList(
                "O-", "O+", "A-", "A+",
                "B-", "B+", "AB-", "AB+"
        ));
    }

    // Get compatible donor blood groups
    public static List<String> getCompatibleGroups(String recipientGroup) {

        recipientGroup = recipientGroup.toUpperCase();

        return compatibilityMap.getOrDefault(
                recipientGroup, new ArrayList<>()
        );
    }

    // Check whether donor blood is compatible with recipient
    public static boolean isCompatible(
            String donorGroup, String recipientGroup) {

        return getCompatibleGroups(recipientGroup)
                .contains(donorGroup.toUpperCase());
    }
}
