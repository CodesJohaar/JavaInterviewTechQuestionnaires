package com.java_interview_tech_questionnaires;

import jakarta.annotation.PreDestroy;

/**
 * @author RavikantS on Aug 06, 2025
 */
public class Singleton {
	private static Singleton singleton;
	
	Singleton() {
	
	}

//	public static synchronized Singleton getInstance() {
//		if (singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
	
	public static Singleton getSingletonInstance() {
		if (singleton == null) {
			synchronized (Singleton.class) {
				singleton = new Singleton();
			}
		}
		return singleton;
	}
	
	@PreDestroy
	public void destroy() {
		singleton = null;
	}
	
}
