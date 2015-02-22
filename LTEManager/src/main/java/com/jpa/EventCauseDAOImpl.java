package com.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dao.EventCauseDAO;
import com.entity.EventCause;
import com.entity.EventId;
import com.entity.Fault;

@Stateful
@Local
@SuppressWarnings("unchecked")
public class EventCauseDAOImpl implements EventCauseDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void createEventCauses(){
		ArrayList<EventCause> causes = new ArrayList<EventCause>();

		causes.add(new EventCause(0,"RRC CONN SETUP-SUCCESS", new EventId(4097)));
		causes.add(new EventCause(1,"RRC CONN SETUP-UNSPECIFIED",new EventId(4097)));
		causes.add(new EventCause(2,"RRC CONN SETUP-FAILURE IN RADIO PROCEDURE",new EventId(4097)));	
		causes.add(new EventCause(3,"RRC CONN SETUP-EUTRAN GENERATED REASON",new EventId(4097)));
		causes.add(new EventCause(4,"RRC CONN SETUP-CELL UNAVAILABLE",new EventId(4097)));
		causes.add(new EventCause(5,"RRC CONN SETUP-LACK OF RESOURCES", new EventId(4097)));
		causes.add(new EventCause(6,"RRC CONN SETUP-ACTIVE USER LICENSE EXCEEDED",new EventId(4097)));	
		causes.add(new EventCause(7,"RRC CONN SETUP-UNKNOWN ENBS1APID",new EventId(4097)));
		causes.add(new EventCause(8,"RRC CONN SETUP-UE CAPABILITY ENQUIRY TIMEOUT",new EventId(4097)));	
		causes.add(new EventCause(9,"RRC CONN SETUP-S1 INTERFACE DOWN",new EventId(4097)));
		causes.add(new EventCause(10,"RRC CONN SETUP-INTRA LTE HANDOVER LICENSE REJECT",new EventId(4097)));	
		causes.add(new EventCause(11,"RRC CONN SETUP-REJECT DUE TO REATTEMPT",new EventId(4097)));
		causes.add(new EventCause(12,"RRC CONN SETUP-REJECT DUE TO OVERLOAD",new EventId(4097)));
		causes.add(new EventCause(13,"RRC CONN SETUP-UE BEARERS REJECTED DUE TO ARP ADM REJ",new EventId(4097)));
		causes.add(new EventCause(14,"RRC CONN SETUP-UE BEARERS REJECTED DUE TO LICENSES MISSING",new EventId(4097)));	
		causes.add(new EventCause(15,"RRC CONN SETUP-UE BEARERS REJECTED DUE TO ARP ADM REJ AND LICENSES MISSING",new EventId(4097)));
		causes.add(new EventCause(16,"RRC CONN SETUP-DSP RESTART",new EventId(4097)));
		causes.add(new EventCause(0,"S1 SIG CONN SETUP-SUCCESS",new EventId(4098)));
		causes.add(new EventCause(1,"S1 SIG CONN SETUP-S1 INTERFACE DOWN",new EventId(4098)));
		causes.add(new EventCause(2,"S1 SIG CONN SETUP-TIME OUT",new EventId(4098)));
		causes.add(new EventCause(3,"S1 SIG CONN SETUP-DSP RESTART",new EventId(4098)));
		causes.add(new EventCause(0,"UE CTXT RELEASE-UNSPECIFIED",new EventId(4125)));
		causes.add(new EventCause(1,"UE CTXT RELEASE-NORMAL RELEASE",new EventId(4125)));
		causes.add(new EventCause(2,"UE CTXT RELEASE-AUTHENTICATION FAILURE",new EventId(4125)));
		causes.add(new EventCause(3,"UE CTXT RELEASE-DETACH",new EventId(4125)));
		causes.add(new EventCause(4,"UE CTXT RELEASE-LOAD BALANCING TAU REQUIRED",new EventId(4125)));
		causes.add(new EventCause(5,"UE CTXT RELEASE-CS FALLBACK TRIGGERED",new EventId(4125)));
		causes.add(new EventCause(6,"UE CTXT RELEASE-UE NOT AVAILABLE FOR PS SERVICES",new EventId(4125)));
		causes.add(new EventCause(7,"UE CTXT RELEASE-HANDOVER CANCELLED",new EventId(4125)));
		causes.add(new EventCause(8,	"UE CTXT RELEASE-SUCCESSFUL HANDOVER",new EventId(4125)));
		causes.add(new EventCause(9	,"UE CTXT RELEASE-RELEASE DUE TO EUTRAN GENERATED REASON",new EventId(4125)));
		causes.add(new EventCause(10	,"UE CTXT RELEASE-USER INACTIVITY",new EventId(4125)));
		causes.add(new EventCause(11	,"UE CTXT RELEASE-RADIO CONNECTION WITH UE LOST",new EventId(4125)));
		causes.add(new EventCause(12	,"UE CTXT RELEASE-RADIO RESOURCES NOT AVAILABLE",new EventId(4125)));
		causes.add(new EventCause(13	,"UE CTXT RELEASE-FAILURE IN THE RADIO INTERFACE PROCEDURE",new EventId(4125)));
		causes.add(new EventCause(14	,"UE CTXT RELEASE-TRANSPORT RESOURCES UNAVAILABLE",new EventId(4125)));
		causes.add(new EventCause(15	,"UE CTXT RELEASE-HANDOVER TRIGGERED",new EventId(4125)));
		causes.add(new EventCause(16	,"UE CTXT RELEASE-PARTIAL HANDOVER",new EventId(4125)));
		causes.add(new EventCause(17	,"UE CTXT RELEASE-HANDOVER FAILURE IN TARGET EPC ENB OR TARGET SYSTEM",new EventId(4125)));
		causes.add(new EventCause(18	,"UE CTXT RELEASE-HANDOVER TARGET NOT ALLOWED",new EventId(4125)));
		causes.add(new EventCause(19	,"UE CTXT RELEASE-TS1RELOC OVERALL EXPIRY",new EventId(4125)));
		causes.add(new EventCause(20	,"UE CTXT RELEASE-TS1RELOC PREP EXPIRY",new EventId(4125)));
		causes.add(new EventCause(21	,"UE CTXT RELEASE-UNKNOWN TARGET ID",new EventId(4125)));
		causes.add(new EventCause(22	,"UE CTXT RELEASE-NO RADIO RESOURCES AVAILABLE IN TARGET CELL",new EventId(4125)));
		causes.add(new EventCause(23	,"UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED MME UE S1AP ID",new EventId(4125)));
		causes.add(new EventCause(24	,"UE CTXT RELEASE-UNKNOWN OR ALREADY ALLOCATED ENB UE S1AP ID",new EventId(4125)));
		causes.add(new EventCause(25	,"UE CTXT RELEASE-UNKNOWN OR INCONSISTENT PAIR OF UE S1AP ID",new EventId(4125)));
		causes.add(new EventCause(26	,"UE CTXT RELEASE-HANDOVER DESIRABLE FOR RADIO REASONS",new EventId(4125)));
		causes.add(new EventCause(27	,"UE CTXT RELEASE-TIME CRITICAL HANDOVER",new EventId(4125)));
		causes.add(new EventCause(28	,"UE CTXT RELEASE-RESOURCE OPTIMISATION HANDOVER",new EventId(4125)));
		causes.add(new EventCause(29	,"UE CTXT RELEASE-REDUCE LOAD IN SERVING CELL",new EventId(4125)));
		causes.add(new EventCause(30	,"UE CTXT RELEASE-TX2RELOC OVERALL EXPIRY",new EventId(4125)));
		causes.add(new EventCause(31	,"UE CTXT RELEASE-CELL NOT AVAILABLE",new EventId(4125)));
		causes.add(new EventCause(32	,"UE CTXT RELEASE-REDIRECTION TOWARDS 1XRTT",new EventId(4125)));
		causes.add(new EventCause(33	,"UE CTXT RELEASE-ENCRYPTION AND OR INTEGRITY ALGORITHMS NOT SUPPORTED",new EventId(4125)));
		causes.add(new EventCause(0	,"INITIAL CTXT SETUP-SUCCESS",new EventId(4106)));
		causes.add(new EventCause(1,"INITIAL CTXT SETUP-UNSPECIFIED",new EventId(4106)));
		causes.add(new EventCause(2	,"INITIAL CTXT SETUP-FAILURE IN RADIO PROCEDURE",new EventId(4106)));
		causes.add(new EventCause(3	,"INITIAL CTXT SETUP-EUTRAN GENERATED REASON",new EventId(4106)));
		causes.add(new EventCause(4	,"INITIAL CTXT SETUP-CELL UNAVAILABLE",new EventId(4106)));
		causes.add(new EventCause(5	,"INITIAL CTXT SETUP-LACK OF RESOURCES",new EventId(4106)));
		causes.add(new EventCause(6	,"INITIAL CTXT SETUP-ACTIVE USER LICENSE EXCEEDED",new EventId(4106)));
		causes.add(new EventCause(7	,"INITIAL CTXT SETUP-UNKNOWN ENBS1APID",new EventId(4106)));
		causes.add(new EventCause(8	,"INITIAL CTXT SETUP-UE CAPABILITY ENQUIRY TIMEOUT",new EventId(4106)));
		causes.add(new EventCause(9	,"INITIAL CTXT SETUP-MULTIPLE ERAB LICENSE EXCEEDED",new EventId(4106)));
		causes.add(new EventCause(10	,"INITIAL CTXT SETUP-ONGOING HANDOVER",new EventId(4106)));
		causes.add(new EventCause(11	,"INITIAL CTXT SETUP-TRANSPORT REJECT",new EventId(4106)));
		causes.add(new EventCause(12	,"INITIAL CTXT SETUP-DRB SETUP REJECT",new EventId(4106)));
		causes.add(new EventCause(13	,"INITIAL CTXT SETUP-S1 INTERFACE DOWN",new EventId(4106)));
		causes.add(new EventCause(14	,"INITIAL CTXT SETUP-ALLOCATION RETENTION REJECT",new EventId(4106)));
		causes.add(new EventCause(15	,"INITIAL CTXT SETUP-TO SECURITY SETUP",new EventId(4106)));
		causes.add(new EventCause(16	,"INITIAL CTXT SETUP-FAILED SECURITY SETUP",new EventId(4106)));
		causes.add(new EventCause(17	,"INITIAL CTXT SETUP-SRB2 SETUP FAILURE",new EventId(4106)));
		causes.add(new EventCause(18	,"INITIAL CTXT SETUP-RLCUM LICENSE MISSING",new EventId(4106)));
		causes.add(new EventCause(19	,"INITIAL CTXT SETUP-RLCUM CHANGE REJECT",new EventId(4106)));
		causes.add(new EventCause(20	,"INITIAL CTXT SETUP-LSM EMERGENCY CALL LICENSE MISSING",new EventId(4106)));
		causes.add(new EventCause(21	,"INITIAL CTXT SETUP-CIPHERING INTEGRITY ALG MISMATCH",new EventId(4106)));
		causes.add(new EventCause(22	,"INITIAL CTXT SETUP-CSFB LICENSE MISSING",new EventId(4106)));
		causes.add(new EventCause(23	,"INITIAL CTXT SETUP-DSP RESTART",new EventId(4106)));
		causes.add(new EventCause(24	,"INITIAL CTXT SETUP-CSFB UNDEFINED MOB FREQ REL",new EventId(4106)));
		for(EventCause cause: causes){
			if(!getEventCause().contains(cause))
				em.persist(cause);
		}
	}

	public Collection<EventCause> getEventCause() {
		Query q = em.createQuery("select ec from EventCause ec");
		return q.getResultList();
	}
	public EventCause getByEventCause(Integer event){
		Query q = em.createQuery("select e from EventCause e where e.event = '"+event+"'", EventCause.class);
		List<EventCause> causes = q.getResultList();
		return causes.get(0);
	}
	
	public List<Object> getEventCauseByFault(Fault fault){
		Query q = em.createQuery("select e from EventCause e where e.eventId = '"+fault.getEventId()+"'", EventCause.class);
		List<Object> causes = q.getResultList();
		return causes;
	}
}