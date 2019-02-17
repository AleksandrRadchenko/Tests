package p190205_overriding_equals;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
    @EqualsAndHashCode.Exclude
    private int counter;
}
