package JUnit.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.entity.MarketOperator;

public class MarketOperatorTest {
	
	MarketOperator market1;
	MarketOperator marketSame;
	MarketOperator marketEmpty;
	
	@Before
	public void setUp() throws Exception {
		market1 = new MarketOperator();
		marketSame = new MarketOperator();
		marketEmpty = new MarketOperator();
	}

	@Test
	public void testEquals_Symetric() {
		assertEquals(market1.equals(marketSame),marketSame.equals(market1));
		assertEquals(market1.hashCode(),marketSame.hashCode());
	}

	@Test
	public void testMarketOperator() {
		assertEquals(marketEmpty.getClass(),MarketOperator.class);
	}

	@Test
	public void testGetandSetMncId() {
		int mncId = 13;
		int val;
		marketEmpty.setMncId(mncId);
		val = marketEmpty.getMncId();
		assertEquals(mncId, val);
	}

	@Test
	public void testGetandSetMccId() {
		int mccId = 657;
		int val;
		marketEmpty.setMccId(mccId);
		val = marketEmpty.getMccId();
		assertEquals(mccId, val);
	}
}
