package com.java_interview_tech_questionnaires.mongock;

import io.mongock.api.annotations.BeforeExecution;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackBeforeExecution;
import io.mongock.api.annotations.RollbackExecution;

/**
 * @author RavikantS on Sept 09, 2025
 */
@ChangeUnit(id = "initialData", order = "0001", author = "Ravikant S")
public class V0001_InitialDataInserts {
//	@BeforeExecution
//	public void beforeExec(WebUsersRepository usersRepo, WebRoleRepository roleRepo) {
//		roleRepo.deleteAll();
//		usersRepo.deleteAll();
//	}
//
//	@RollbackBeforeExecution
//	public void rollbackBeforeExec() {}
//
//	@Execution
//	public void initialData(WebUsersRepository usersRepo, WebRoleRepository roleRepo) {
//		WebUserRoles.validUserRoles.forEach(role -> roleRepo.save(WebRoleEntity.builder()
//				.roleName(role.getRoleName()).description(role.getDescription()).build())
//		);
//		usersRepo.save(WebUsersEntity.builder().email("ravikants@ideyalabs.com").fullName("Ravikant S")
//				.roleName(WebUserRoles.ADMIN.getRoleName())
//				.password("$2a$10$LIq3s.yC.ExMCAHRrJEmq.fYYoMFxEi3XdBc1tfQ7lzWcImE7FfC2") // Ravi@123
//				.isActive(Boolean.TRUE).build());
//	}
//
//	@RollbackExecution
//	public void rollbackExec(WebUsersRepository usersRepo, WebRoleRepository roleRepo) {
//		roleRepo.deleteAll();
//		usersRepo.deleteAll();
//	}
	
	@BeforeExecution
	public void beforeExec() {
//		NOTE: Write your queries that needs to run (Pre-requisites) before executing the actual migration queries (IF ANY).
	}
	
	@RollbackBeforeExecution
	public void rollBackBeforeExec() {
//		NOTE: Write your queries to rollback the impact of before executing queries above (IF ANY).
	}
	
	@Execution
	public void initialData() {
//		NOTE: Write your actual migration queries.
	}
	
	@RollbackExecution
	public void rollBackInitialData() {
//		NOTE: Write your queries to rollback actual migration queries.
	}
}
