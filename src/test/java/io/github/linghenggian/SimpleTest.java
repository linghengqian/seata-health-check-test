package io.github.linghenggian;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.seata.config.ConfigurationFactory;
import org.apache.seata.core.rpc.netty.RmNettyRemotingClient;
import org.apache.seata.core.rpc.netty.TmNettyRemotingClient;
import org.apache.seata.rm.RMClient;
import org.apache.seata.rm.datasource.DataSourceProxy;
import org.apache.seata.tm.TMClient;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;

import javax.sql.DataSource;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class SimpleTest {

    @Test
    void test() {
        assertThat(System.getProperty("service.default.grouplist"), is(nullValue()));
        this.testWithSeataClient("apache/seata-server:2.4.0");
    }

    private void testWithSeataClient(String imageName) {
        GenericContainer<?> seataContainer = new GenericContainer<>(imageName);
        seataContainer.withExposedPorts(7091, 8091).waitingFor(
                Wait.forHttp("/health").forPort(7091).forStatusCode(200).forResponsePredicate("ok"::equals)
        );
        seataContainer.start();
        System.setProperty("service.default.grouplist", seataContainer.getHost() + ":" + seataContainer.getMappedPort(8091));
        TMClient.init("test-first", "default_tx_group");
        RMClient.init("test-first", "default_tx_group");
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.testcontainers.jdbc.ContainerDatabaseDriver");
        config.setJdbcUrl("jdbc:tc:postgresql:17.6-trixie:///demo_ds_0?TC_INITSCRIPT=init.sql");
        DataSource hikariDataSource = new HikariDataSource(config);
        DataSource seataDataSource = new DataSourceProxy(hikariDataSource);
        Awaitility.await().atMost(Duration.ofSeconds(15L)).ignoreExceptions().until(() -> {
            seataDataSource.getConnection().close();
            return true;
        });
        System.clearProperty("service.default.grouplist");
        TmNettyRemotingClient.getInstance().destroy();
        RmNettyRemotingClient.getInstance().destroy();
        ConfigurationFactory.reload();
        seataContainer.close();
    }
}