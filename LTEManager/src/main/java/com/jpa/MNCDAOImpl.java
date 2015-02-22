package com.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.MCCDAO;
import com.dao.MNCDAO;
import com.entity.MNC;

@Stateless
@Local
@SuppressWarnings("unchecked")
public class MNCDAOImpl implements MNCDAO {

	@PersistenceContext
	private EntityManager em;

	public void createMNCs(){
		MCCDAO mcc = new MCCDAOImpl();
		ArrayList<MNC> mncs = new ArrayList<MNC>();
		mncs.add(new MNC(1,"TDC-DK",mcc.getByMCC(238)));
		mncs.add(new MNC(2,"Sonofon DK",mcc.getByMCC(238)));
		mncs.add(new MNC(3,"MIGway A/S DK",mcc.getByMCC(238)));
		mncs.add(new MNC(1,"Telia Sonera-SE",mcc.getByMCC(240)));
		mncs.add(new MNC(2,"H3G-SE",mcc.getByMCC(240)));
		mncs.add(new MNC(3,"AINMT Sverige AB SE",mcc.getByMCC(240)));
		mncs.add(new MNC(20,"iMEZ AB SE ",mcc.getByMCC(240)));
		mncs.add(new MNC(21,"Banverket SE ",mcc.getByMCC(240)));
		mncs.add(new MNC(36,"Clearnet CA ",mcc.getByMCC(302)));
		mncs.add(new MNC(37,"Microcell CA ",mcc.getByMCC(302)));
		mncs.add(new MNC(62,"Ice Wireless CA ",mcc.getByMCC(302)));
		mncs.add(new MNC(63,"Aliant Mobility CA ",mcc.getByMCC(302)));
		mncs.add(new MNC(10,"Verizon Wireless",mcc.getByMCC(310)));
		mncs.add(new MNC(12,"Verizon Wireless",mcc.getByMCC(310)));
		mncs.add(new MNC(13,"Verizon Wireless",mcc.getByMCC(310)));
		mncs.add(new MNC(540,"Oklahoma Western Telephone Company US ",mcc.getByMCC(310)));
		mncs.add(new MNC(550,"Wireless Solutions International US ",mcc.getByMCC(310)));
		mncs.add(new MNC(560,"AT&T Mobility",mcc.getByMCC(310)));
		mncs.add(new MNC(570,"MTPCS LLC US ",mcc.getByMCC(310)));
		mncs.add(new MNC(580,"Inland Cellular Telephone Company US ",mcc.getByMCC((310))));
		mncs.add(new MNC(590,"Verizon Wireless",mcc.getByMCC(310)));
		mncs.add(new MNC(1,"Orange-Caraibe",mcc.getByMCC(340)));
		mncs.add(new MNC(2,"Outremer Telecom GP",mcc.getByMCC(340))); 
		mncs.add(new MNC(3,"Saint Martin et Saint Barthelemy Telcell Sarl GP ",mcc.getByMCC(340)));
		mncs.add(new MNC(30,"APUA PCS AG ",mcc.getByMCC(344)));
		mncs.add(new MNC(920,"Cable & Wireless-Antigua AG ",mcc.getByMCC(344)));
		mncs.add(new MNC(930,"AT&T Wireless-Antigua AG ",mcc.getByMCC(344)));
		mncs.add(new MNC(0,"Shyam Telelink Ltd-Rajasthan IN ",mcc.getByMCC(405)));
		mncs.add(new MNC(1,"Reliance Infocomm-IN",mcc.getByMCC(405)));
		mncs.add(new MNC(3,"Reliance Infocomm-IN",mcc.getByMCC(405)));
		mncs.add(new MNC(4,"Reliance Infocomm-IN",mcc.getByMCC(405)));
		mncs.add(new MNC(5,"Reliance Infocomm-IN",mcc.getByMCC(405)));
		mncs.add(new MNC(9,"NTT DoCoMo",mcc.getByMCC(440)));
		mncs.add(new MNC(10,"NTT DoCoMo",mcc.getByMCC(440)));
		mncs.add(new MNC(11,"NTT DoCoMo",mcc.getByMCC(440)));
		mncs.add(new MNC(62,"NBNCo Ltd AU",mcc.getByMCC(505)));
		mncs.add(new MNC(68,"NBNCo Ltd AU ",mcc.getByMCC(505)));
		mncs.add(new MNC(71,"Telstra",mcc.getByMCC(505)));
		mncs.add(new MNC(72,"Telstra",mcc.getByMCC(505)));
		mncs.add(new MNC(88,"Localstar Holding Pty. Ltd. AU ",mcc.getByMCC(505)));
		mncs.add(new MNC(90,"Optus Ltd. AU ",mcc.getByMCC(505)));
		for(MNC mnc: mncs){
			if(!getMNC().contains(mnc)){
				em.persist(mnc);
			}
		}
	}

	public Collection<MNC> getMNC() {
		Query q = em.createQuery("select m from MNC m");
		return q.getResultList();
	}

	public MNC getByMNC(Integer mnc) {
		Query q = em.createQuery("select m from MNC m where m.mnc = '" + mnc+"'",
				MNC.class);
		List<MNC> mncs = q.getResultList();
		return mncs.get(0);
	}
}