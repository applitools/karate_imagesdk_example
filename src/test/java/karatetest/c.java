package karatetest;

import com.intuit.karate.junit5.Karate;

class SampleTest2 {

    @Karate.Test
    Karate testSample() {
        return Karate.run("sample").relativeTo(getClass());
    }
}