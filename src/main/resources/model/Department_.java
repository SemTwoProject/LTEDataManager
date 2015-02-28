package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-02-12T13:05:52.259+0000")
@StaticMetamodel(Department.class)
public class Department_ {
	public static volatile SingularAttribute<Department, Integer> id;
	public static volatile SingularAttribute<Department, String> name;
	public static volatile SingularAttribute<Department, User> user;
}
