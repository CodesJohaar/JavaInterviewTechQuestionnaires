package com.java_interview_tech_questionnaires.util;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author RavikantS on Sept 02, 2025
 */
public record UpdateHelper(Boolean condition, Runnable updateOperation) {
	public static final BiFunction<Boolean, Runnable, UpdateHelper> update = UpdateHelper::new;
	public static final Function<Stream<UpdateHelper>, Boolean> doUpdate = updateReq ->
			updateReq.map(updateHelper -> {
				if (Boolean.TRUE.equals(updateHelper.condition)) {
					updateHelper.updateOperation.run();
					return true;
				}
				return false;
			}).reduce(false, Boolean::logicalOr);
}
