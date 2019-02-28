package p190228_circular_dependency;

import org.springframework.stereotype.Component;

@Component
public class CircularDependencyB {
    private CircularDependencyA circularDependencyA;

    public CircularDependencyB(CircularDependencyA circularDependencyA) {
        this.circularDependencyA = circularDependencyA;
    }
}
