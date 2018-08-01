package web.converter;

import core.model.BaseEntity;
import web.dto.BaseDto;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Ionut on 19/6/2017.
 */
public abstract class BaseConverter<Model extends BaseEntity<Long>, Dto extends BaseDto>
        extends BaseConverterGeneric<Model, Dto> implements Converter<Model, Dto> {

    public Set<Long> convertModelsToIDs(Set<Model> models) {
        return models.stream()
                .map(model -> model.getId())
                .collect(Collectors.toSet());
    }

    public Set<Long> convertDTOsToIDs(Set<Dto> dtos) {
        return dtos.stream()
                .map(dto -> dto.getId())
                .collect(Collectors.toSet());
    }
}