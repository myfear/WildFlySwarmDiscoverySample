/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eisele.test.swarm.jpa;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author meisele
 */
@Singleton
@Startup
public class Initializer {

    //https://github.com/iocanel/fabric8-cdi-examples/tree/master/myqsl-datasource-init
    public void initializeDatasource() {

    }
;

}
