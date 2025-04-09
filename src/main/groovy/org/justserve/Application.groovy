package org.justserve

import org.slf4j.bridge.SLF4JBridgeHandler
import io.micronaut.runtime.Micronaut
import groovy.transform.CompileStatic

@CompileStatic
class Application {

    static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger()
        SLF4JBridgeHandler.install()
        Micronaut.run(Application, args)
    }
}
