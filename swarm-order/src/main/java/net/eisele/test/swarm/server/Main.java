package net.eisele.test.swarm.server;

import net.eisele.test.swarm.jpa.Order;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.ClassLoaderAsset;
import org.wildfly.swarm.container.Container;
import org.wildfly.swarm.datasources.DatasourcesFraction;
import org.wildfly.swarm.jaxrs.JAXRSArchive;
import org.wildfly.swarm.jpa.JPAFraction;

/**
 *
 * @author meisele
 */
public class Main {

    public static void main(String[] args) throws Exception {

        Container container = new Container();

        container.fraction(new DatasourcesFraction()
                .jdbcDriver("com.mysql", (d) -> {
                    d.driverDatasourceClassName("com.mysql.jdbc.Driver");
                    d.xaDatasourceClass("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
                    d.driverModuleName("com.mysql");
                })
                .dataSource("OrderDS", (ds) -> {
                    ds.driverName("com.mysql");
                    ds.connectionUrl("jdbc:mysql://mysql-order:3306/order?createDatabaseIfNotExist=true");
                    ds.userName("root");
                    ds.password("root");
                })
        );

        // Prevent JPA Fraction from installing it's default datasource fraction
        container.fraction(new JPAFraction()
                .inhibitDefaultDatasource()
                .defaultDatasource("jboss/datasources/OrderDS")
        );

        container.start();

        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        deployment.addClasses(Order.class);
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/persistence.xml", Main.class.getClassLoader()), "classes/META-INF/persistence.xml");
        deployment.addAsWebInfResource(new ClassLoaderAsset("META-INF/load.sql", Main.class.getClassLoader()), "classes/META-INF/load.sql");
        deployment.addPackage("net.eisele.test.swarm.jpa");
        deployment.addPackage("net.eisele.test.swarm.sample");
        deployment.addAllDependencies();

        container.deploy(deployment);
    }
}
