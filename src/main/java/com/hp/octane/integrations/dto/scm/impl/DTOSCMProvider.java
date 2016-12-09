package com.hp.octane.integrations.dto.scm.impl;

import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.hp.octane.integrations.dto.DTOBase;
import com.hp.octane.integrations.dto.DTOInternalProviderBase;
import com.hp.octane.integrations.dto.scm.SCMChange;
import com.hp.octane.integrations.dto.scm.SCMCommit;
import com.hp.octane.integrations.dto.scm.SCMData;
import com.hp.octane.integrations.dto.scm.SCMRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by gullery on 10/02/2016.
 *
 * SCM related DTOs definitions provider
 */

public final class DTOSCMProvider extends DTOInternalProviderBase {
	private final Map<Class<? extends DTOBase>, Class> dtoPairs = new HashMap<>();

	public DTOSCMProvider() {
		dtoPairs.put(SCMChange.class, SCMChangeImpl.class);
		dtoPairs.put(SCMCommit.class, SCMCommitImpl.class);
		dtoPairs.put(SCMRepository.class, SCMRepositoryImpl.class);
		dtoPairs.put(SCMData.class, SCMDataImpl.class);
	}

	@Override
	protected void provideImplResolvingMap(SimpleAbstractTypeResolver dtoImplResolver) {
		dtoImplResolver.addMapping(SCMChange.class, SCMChangeImpl.class);
		dtoImplResolver.addMapping(SCMCommit.class, SCMCommitImpl.class);
		dtoImplResolver.addMapping(SCMRepository.class, SCMRepositoryImpl.class);
		dtoImplResolver.addMapping(SCMData.class, SCMDataImpl.class);
	}

	@Override
	protected Set<Class<? extends DTOBase>> getJSONAbleDTOs() {
		return dtoPairs.keySet();
	}

	protected <T extends DTOBase> T instantiateDTO(Class<T> targetType) throws InstantiationException, IllegalAccessException {
		T result = null;
		if (dtoPairs.containsKey(targetType)) {
			result = (T) dtoPairs.get(targetType).newInstance();
		}
		return result;
	}
}
