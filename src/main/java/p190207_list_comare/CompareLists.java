package p190207_list_comare;


import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.StringDescription;
import p190205_overriding_equals.User;

import java.util.Arrays;
import java.util.List;

public class CompareLists {
    public static void main(String[] args) {
        List<User> list1 = Arrays.asList(
                User.builder().name("user1").age(1).counter(11).build(),
                User.builder().name("user2").age(2).counter(12).build(),
                User.builder().name("user3").age(3).counter(13).build()
        );
        List<User> list2 = Arrays.asList(
                User.builder().name("user1").age(1).counter(12).build(),
                User.builder().name("user2").age(2).counter(12).build(),
                User.builder().name("user3").age(3).counter(13).build()
        );
        compareLists(list1, list2);
    }

    private static void compareLists(List<User> list1, List<User> list2) {
        CompareLists.assertThat(list1.get(0), Matchers.samePropertyValuesAs(list2.get(0)));
        CompareLists.assertThat(list1.get(1), Matchers.samePropertyValuesAs(list2.get(1)));
        System.out.println("End");
    }

    private static <T> void assertThat(T actual, Matcher<? super T> matcher) {
        if (!matcher.matches(actual)) {
            Description description = new StringDescription();
            description.appendText("\nExpected: ")
                       .appendDescriptionOf(matcher)
                       .appendText("\n     but: ");
            matcher.describeMismatch(actual, description);

            System.out.println(description.toString());
        }
    }

}
