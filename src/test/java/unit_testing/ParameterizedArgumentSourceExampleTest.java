package unit_testing;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

/**
 * This test class demonstrates using @ArgumentSource functionality of JUnit5
 * for passing parameters to parameterized method.
 */
public class ParameterizedArgumentSourceExampleTest {

    @ParameterizedTest
    @ArgumentsSource(PersonTestDataProvider.class)
    void testAgeIsGreaterThan18(String name, String surname, int age) {
        Person person = new Person(name, surname, age);

        assertTrue(person.getAge() > 18);
    }

    static class PersonTestDataProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("Marta", "Merx", 39),
                    Arguments.of("Regy", "Ricker", 67),
                    Arguments.of("Terry", "Twix", 19));
        }
    }
}