
package com.vpomo.queueshop.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p> Integration test using the jpa profile. 
 * @see AbstractQueueShopServiceServiceTestsAbstractQueueShopServiceServiceTests for more details. </p>
 *
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 */

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueueShopServiceJpaTests extends AbstractQueueShopServiceTests {

}