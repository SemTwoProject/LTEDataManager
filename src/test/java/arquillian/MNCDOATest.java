package arquillian;

import static org.junit.Assert.assertEquals;

import java.io.File;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.dao.MNCDAO;
import com.entity.MNC;

@RunWith(Arquillian.class)
public class MNCDOATest {

	@EJB
	private MNCDAO dao;

	@Deployment
	public WebArchive createDeployment() {

		return ShrinkWrap.create(ZipImporter.class, "test.war")
				.importFrom(new File("target/LTEManager.war"))
				.as(WebArchive.class);

	}

	@Before
	public void setUp() {
	}		

	@Test
	public void MCCListReturned() {
		assertEquals(dao.getMNC().size(), 3);
	}

	@Test
	public void OperatorIsReturnedByMNCValue() {
		int verizon = 1111;
		int three = 2222;
		int o2 = 3333;
		int telephonica = 4444;
		int vodafone = 5555;
		
		
		String verizonStr = new String("Verizon");
		String threeStr = new String("Three");
		String o2Str = new String("O2");
		String telephonicaStr = new String("Telephonica");
		String vodafoneStr = new String("Vodafone");
				
		MNC testVerizon = dao.getByMNC(verizon);
		MNC testThree = dao.getByMNC(three);
		MNC testo2 = dao.getByMNC(o2);
		MNC testTelephonica = dao.getByMNC(telephonica);
		MNC testVodafone = dao.getByMNC(vodafone);
		
		assertEquals(verizonStr, testVerizon.getOperator());
		assertEquals(threeStr, testThree.getOperator());
		assertEquals(o2Str, testo2.getOperator());
		assertEquals(telephonicaStr, testTelephonica.getOperator());
		assertEquals(vodafoneStr, testVodafone.getOperator());
	}

}
