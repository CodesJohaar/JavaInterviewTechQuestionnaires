package com.java_interview_tech_questionnaires.util;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

/**
 * @author RavikantS on Sept 02, 2025
 */
public class Util {
	protected <K, V> void validateParamInMap(Map<K, V> param, K key) {
		if (!param.containsKey(key)) {
			throw new RuntimeException("Field required");
		}
	}
	
	@SafeVarargs
	protected final <K, V> void validateParamsInMap(Map<K, V> param, K... keys) {
		Boolean isAllParamAvailable = Arrays.stream(keys).allMatch(param::containsKey);
		if (Boolean.FALSE.equals(isAllParamAvailable)) {
			throw new RuntimeException("Field required");
		}
	}
	
	/**
	 * Builds query and countQuery objects based on provided filter mappings and parameters.
	 * This method dynamically adds filtering criteria to the given query and countQuery objects.
	 * It iterates over the `params` map, matches its keys with the keys in the `filterMap`,
	 * and applies corresponding filtering criteria to both queries using the mapped values.
	 *
	 * @param query      the query object to which filtering criteria will be added
	 * @param countQuery the count query object to which filtering criteria will be added
	 * @param filterMap  a map that associates parameter keys with the corresponding database field names
	 *                   (e.g., {"name": "fullName", "fullName": "full_name", "email": "emailAddress"})
	 * @param params     a map containing the filter parameters provided by the user
	 *                   (e.g., {"name": "John", "email": "john@example.com"})
	 * Example Usage:
	 * - Given filterMap: {"name": "fullName", "email": "emailAddress"}
	 * - Given params: {"name": "John", "email": "john@example.com"}
	 * - This method adds the following criteria:
	 *     - query: fullName = "John", emailAddress = "john@example.com"
	 *     - countQuery: fullName = "John", emailAddress = "john@example.com"
	 * Assumptions:
	 * - The `filterMap` must have a one-to-one mapping between parameter keys and database field names.
	 * - Only the keys present in both `params` and `filterMap` are processed.
	 * Note:
	 * - The `computeIfPresent` method ensures that only entries existing in the `filterMap`
	 *   are processed, avoiding null values or unmapped keys.
	 */
	protected void mongoQueryBuilder(Query query, Query countQuery, Map<String, String> filterMap, Map<String, Object> params) {
		Optional.ofNullable(params).ifPresent(req -> req.forEach((requestedKey, requestedValue) ->
				filterMap.computeIfPresent(requestedKey, (key, columnName) -> {
					if ("searchKey".equalsIgnoreCase(requestedKey)) {
						Criteria criteriaObj = new Criteria().orOperator(Arrays.stream(columnName.split(","))
								.map(col -> {
									if (requestedValue instanceof Number num) {
										return Criteria.where(col).is(num);
									} else {
										return Criteria.where(col).regex(requestedValue.toString(), "i");
									}
								}).toList());
						query.addCriteria(criteriaObj);
						Optional.ofNullable(countQuery).ifPresent(appendQuery -> appendQuery.addCriteria(criteriaObj));
					} else {
						query.addCriteria(Criteria.where(columnName).is(requestedValue));
						Optional.ofNullable(countQuery).ifPresent(appendQuery ->
								appendQuery.addCriteria(Criteria.where(columnName).is(requestedValue)));
					}
					return columnName;
				})
		));
	}
}
