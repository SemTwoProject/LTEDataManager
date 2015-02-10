package main;

import persistence.PersistenceUtil;
import entity.Failure;

public class FailureDAO {

	public FailureDAO() {
		//createCapability();
	}

	public void createFailure(int id, String description) {
		Failure fail = new Failure(id, description);
		PersistenceUtil.persist(fail);
		System.out.println("Capability added");
	}

}
