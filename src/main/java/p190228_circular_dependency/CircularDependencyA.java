package p190228_circular_dependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class CircularDependencyA {
    @Autowired
    private CircularDependencyB circularDependencyB;

//    public CircularDependencyA(CircularDependencyB circularDependencyB) {
//        this.circularDependencyB = circularDependencyB;
//    }
}
