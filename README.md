# seata-health-check-test

- Verified unit test under Ubuntu 22.04.4 LTS with `SDKMAN!` and `Docker CE`.

```shell
sdk install java 24.0.2-graalce
sdk use java 24.0.2-graalce

git clone git@github.com:linghengqian/seata-health-check-test.git
cd ./seata-health-check-test/
./mvnw -T 1C clean test
```

- The log is as follows.

```shell
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::staticFieldBase has been called by com.google.inject.internal.aop.HiddenClassDefiner (file:/C:/Users/lingh/.m2/wrapper/dists/apache-maven-3.9.11/d6d3cbd4012d4c1d840e93277aca316c/lib/guice-5.1.0-classes.jar)
WARNING: Please consider reporting this to the maintainers of class com.google.inject.internal.aop.HiddenClassDefiner
WARNING: sun.misc.Unsafe::staticFieldBase will be removed in a future release
[INFO] Scanning for projects...
[INFO] 
[INFO] Using the MultiThreadedBuilder implementation with a thread count of 16
[INFO] 
[INFO] -----------< io.github.linghengian:seata-health-check-test >------------
[INFO] Building seata-health-check-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ seata-health-check-test ---
[INFO] Deleting D:\TwinklingLiftWorks\git\public\seata-health-check-test\target
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ seata-health-check-test ---
[INFO] skip non existing resourceDirectory D:\TwinklingLiftWorks\git\public\seata-health-check-test\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ seata-health-check-test ---
[INFO] No sources to compile
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ seata-health-check-test ---
[INFO] Copying 4 resources from src\test\resources to target\test-classes
[INFO] 
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ seata-health-check-test ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug release 24] to target\test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ seata-health-check-test ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running io.github.linghenggian.SimpleTest
[ERROR] 2025-08-16 09:52:02.442 [main] o.a.s.config.ConfigurationFactory - failed to load non-spring configuration :not found service provider for : org.apache.seata.config.ConfigurationProvider
org.apache.seata.common.loader.EnhancedServiceNotFoundException: not found service provider for : org.apache.seata.config.ConfigurationProvider
WARNING: A terminally deprecated method in sun.misc.Unsafe has been called
WARNING: sun.misc.Unsafe::objectFieldOffset has been called by io.netty.util.internal.PlatformDependent0$4 (file:/C:/Users/lingh/.m2/repository/io/netty/netty-common/4.1.101.Final/netty-common-4.1.101.Final.jar)
WARNING: Please consider reporting this to the maintainers of class io.netty.util.internal.PlatformDependent0$4
WARNING: sun.misc.Unsafe::objectFieldOffset will be removed in a future release
[ERROR] 2025-08-16 09:52:14.500 [main] o.a.s.config.ConfigurationFactory - failed to load non-spring configuration :not found service provider for : org.apache.seata.config.ConfigurationProvider
org.apache.seata.common.loader.EnhancedServiceNotFoundException: not found service provider for : org.apache.seata.config.ConfigurationProvider
[ERROR] 2025-08-16 09:52:18.556 [main] o.a.s.config.ConfigurationFactory - failed to load non-spring configuration :not found service provider for : org.apache.seata.config.ConfigurationProvider
org.apache.seata.common.loader.EnhancedServiceNotFoundException: not found service provider for : org.apache.seata.config.ConfigurationProvider
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 22.28 s -- in io.github.linghenggian.SimpleTest
[INFO] 
[INFO] Results:
[INFO]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  25.690 s (Wall Clock)
[INFO] Finished at: 2025-08-16T09:52:19+08:00
[INFO] ------------------------------------------------------------------------
```
