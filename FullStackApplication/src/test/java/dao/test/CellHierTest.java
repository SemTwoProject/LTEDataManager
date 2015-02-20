package dao.test;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import jpa.CellDAOImpl;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import service.CellServiceEJB;
import service.ExcelService;
import dao.CellDAO;
import dao.ExcelDAO;
import entities.CellHier;
@RunWith(Arquillian.class)
public class CellHierTest {
	
	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap.create(WebArchive.class,"test.war")
				.addPackage(CellDAO.class.getPackage())
				.addPackage(CellHier.class.getPackage())
				.addPackage(CellDAOImpl.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
				
	}
	@EJB
	CellDAO dao;

	@Test
	public void test() {
		assertEquals(dao.getCell().size(), 0);
	}

}
