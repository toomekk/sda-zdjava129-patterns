package pl.sdacademy.java.external;

import java.lang.reflect.Field;
import java.util.Optional;

public class ToStringGenerator {

    private ToStringGenerator() {
        throw new UnsupportedOperationException();
    }

    public static String shallowToString(Object object) {
        final Class<?> objectClass = object.getClass();
        final Field[] fields = objectClass.getDeclaredFields();
        final StringBuilder stringBuilder = new StringBuilder()
                .append(objectClass.getName())
                .append(" { \n");

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                final String value = Optional.ofNullable(field.get(object))
                        .map(Object::toString)
                        .orElse(null);

                stringBuilder
                        .append("\t")
                        .append(field.getName())
                        .append(" = ")
                        .append(value)
                        .append("\n");

            }
            catch (IllegalAccessException iae) {
                throw new RuntimeException(iae);
            }
        }

        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}
