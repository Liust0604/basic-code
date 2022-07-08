package com.mori.course02.demoannotation;

import com.mori.course02.demoannotation.domain.AnnoDemo;
import org.junit.Test;

/**
 * 注解Javadoc演示
 *
 * @author ErYue_i
 * @version 1.0
 * @since 1.5
 */

public class AnnotationDemo {
    @Test
    public void Test01() {
        AnnoDemo anno = new AnnoDemo();
        anno.show1();
        anno.show2();
    }
}
