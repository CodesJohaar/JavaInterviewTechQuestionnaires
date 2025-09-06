package com.java_interview_tech_questionnaires.hacker_rank;

import com.java_interview_tech_questionnaires.AbstractClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author RavikantS on Sept 05, 2025
 */
public class TransactionCountPerUser extends AbstractClass {
//	QUE: You are require to calculate the number of transactions per user out of provided input.
//	SCENARIO: You'll be provided an List containing string containing 3 different numbers separated by space (1 2 1200) where,
//	          the 1st number represents sender id, 2nd number represents receiver id and 3rd number represents amount of the transaction.
//	          The transaction count needs to be carried out in following manner:
//	            1. Every transaction created will have maximum 2 counts (1 for sender and 1 for receiver).
//	            2. If the sender and receiver are same user then the transaction count will be considered 1.
//	EXAMPLE: For condition 1:
//	         Input : ["1 2 1200", "2 1 1000", "2 3 300"]
//	                            UserId  TxnCount
//	         Expected Output :    1         2    (Since involved in 2 transactions)
//	                              2         3    (Since involved in 3 transactions)
//	                              3         1    (Since involved in 1 transactions)
//	EXAMPLE: For condition 2:
//	         Input : ["1 2 1200", "2 1 1000", "2 3 300", "2 3 600", "4 4 10000"]
//	                            UserId  TxnCount
//	         Expected Output :    1         2    (Since involved in 2 transactions)
//	                              2         4    (Since involved in 3 transactions)
//	                              3         2    (Since involved in 1 transactions)
//	                           ** 4         1    (Since involved in 1 transactions where sender and receiver are same)
	
	public static void main(String[] args) {
		try (Scanner scn = new Scanner(System.in)) {
			// NOTE: Read number of transactions first
			int txnCount = scn.nextInt();
			scn.nextLine();
			List<String> txnList = new ArrayList<>();
//			while (txnCount-- > 0) {
			while (txnList.size() < txnCount) {
				txnList.add(scn.nextLine());
			}
			print("Inputs", txnList);
			Map<String, Integer> process = process(txnList);
			print("Result", process);
		}
	}
	
	private static Map<String, Integer> process(List<String> txnList) {
		Map<String, Integer> userTxnCount = new HashMap<>();
		txnList.forEach(txnDtl -> {
			String[] split = txnDtl.split(" ");
			if (split[0].equals(split[1])) {
				processIfPresent(userTxnCount, split[0]);
				processIfAbsent(userTxnCount, split[0]);
			} else {
				processIfPresent(userTxnCount, split[0]);
				processIfPresent(userTxnCount, split[1]);
				processIfAbsent(userTxnCount, split[0]);
				processIfAbsent(userTxnCount, split[1]);
			}
		});
		return userTxnCount;
	}
	
	private static void processIfPresent(Map<String, Integer> map, String key) {
		map.computeIfPresent(key, (k, v) -> ++v);
	}
	
	private static void processIfAbsent(Map<String, Integer> map, String key) {
		map.putIfAbsent(key, 1);
	}
}
