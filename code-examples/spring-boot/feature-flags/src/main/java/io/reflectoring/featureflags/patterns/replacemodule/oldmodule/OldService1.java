package io.reflectoring.featureflags.patterns.replacemodule.oldmodule;

import io.reflectoring.featureflags.patterns.replacemodule.Service1;
import org.springframework.stereotype.Component;

@Component
public class OldService1 implements Service1 {
    @Override
    public int doSomething() {
        return 1;
    }
}
