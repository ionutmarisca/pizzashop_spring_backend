package web.converter;

import core.model.BaseEntity;
import web.dto.BaseDto;

/**
 * Created by Ionut on 19/6/2017.
 */
public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> extends ConverterGeneric<Model, Dto> {
}
