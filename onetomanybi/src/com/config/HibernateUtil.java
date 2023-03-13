package com.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Department;
import com.model.Employee;




public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory()
	{
		try
		{
		Map<String , Object> settings = new HashMap<String , Object>();
		//config prop
		settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		settings.put(Environment.URL, "jdbc:mysql://localhost:3306/onetomanymanytoonebi");
		settings.put(Environment.USER, "root");
		settings.put(Environment.PASS, "root");
		//hibernate prop
		settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQLDialect");
		settings.put(Environment.HBM2DDL_AUTO, "create");
		settings.put(Environment.SHOW_SQL, true);
		settings.put(Environment.FORMAT_SQL,true);
		
		registry = new StandardServiceRegistryBuilder().applySettings(settings).build();
		
		MetadataSources mds = new MetadataSources(registry);
		
	
		mds.addAnnotatedClass(Department.class);
		mds.addAnnotatedClass(Employee.class);
		
		Metadata md = mds.getMetadataBuilder().build();
		sf = md.getSessionFactoryBuilder().build();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return sf;
	}
}
