package com.mockproject.freetutsproject.util;

import java.util.List;

import com.mockproject.freetutsproject.dto.AbstractDTO;

import org.springframework.stereotype.Component;

@Component
public class CountUtil<T extends AbstractDTO<T>> {
    public long countAvailable(List<T> list) {
        return list.stream().filter(x -> x.isAvailable()).count();
    }
}
