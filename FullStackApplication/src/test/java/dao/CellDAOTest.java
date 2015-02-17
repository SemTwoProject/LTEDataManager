package dao;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.inject.Inject;

import jpa.CellDAOImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;

import entities.CellHier;

@RunWith(Arquillian.class)
public class CellDAOTest {
	
	@Deployment
	public static WebArchive createDeployment(){
		WebArchive web = ShrinkWrap.create(WebArchive.class)
				.addClass(CellDAOImpl.class)
				.addAsManifestResource(EmptyAsset.INSTANCE,"beans.xml");
		System.out.println(web.toString());
		return web;
	}
	
	@Inject
	CellDAOImpl dummyCellDAO;

	@Test
	public void testGetCell() {
		dummyCellDAO.createCellHier(1929399L, 2983882L, 8839921L, 8297283L);
		assertEquals(Collection.class,dummyCellDAO.getCell());
	}

}
