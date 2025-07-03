package utils;

import java.util.List;
import java.util.stream.Collectors;
import org.testng.Assert;

public class AssertUtils {

    public static void assertListsEqualTrimmedIgnoreCase(List<String> expected, List<String> actual) {
        List<String> expectedNormalized = expected.stream()
                .map(s -> s.toLowerCase().trim())
                .collect(Collectors.toList());

        List<String> actualNormalized = actual.stream()
                .map(s -> s.toLowerCase().trim())
                .collect(Collectors.toList());

        // Verificar si hay elementos de expected que faltan en actual
        List<String> missingItems = expectedNormalized.stream()
                .filter(item -> !actualNormalized.contains(item))
                .collect(Collectors.toList());

        if (!missingItems.isEmpty()) {
            Assert.fail("Faltan elementos en la lista actual: " + missingItems);
        }

        // Verificar si las listas completas son iguales (opcional)
        Assert.assertEquals(actualNormalized, expectedNormalized,
                "Las listas no coinciden exactamente (ignorando mayúsculas y espacios)");
    }
}
