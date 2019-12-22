import net.sf.cglib.proxy.Enhancer
import net.sf.cglib.proxy.MethodInterceptor
import net.sf.cglib.proxy.MethodProxy

import java.lang.reflect.Method

/**
 * @author SouthLight-Lin on 2019/12/22
 */
object Test {

    @JvmStatic
    fun main(args: Array<String>) {
        Enhancer().setCallback(MethodInterceptor { o, method, objects, methodProxy -> null })
    }

}

