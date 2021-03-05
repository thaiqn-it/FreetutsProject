package com.mockproject.freetutsproject.util;

import java.util.ArrayList;
import java.util.List;

public class PagingUtil<T> {
	public List<T> paging(List<T> fullList, int limit, int page, int totalItems) {
		List<T> pagedList = new ArrayList<T>();
		int offset = (page - 1) * limit;
		for (int i = offset; (i < offset + limit) && (i < totalItems); i++) {
			pagedList.add(fullList.get(i));
		}
		return pagedList;
	}
}