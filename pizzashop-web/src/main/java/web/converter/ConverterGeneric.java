package web.converter;

/**
 * Created by Ionut on 19/6/2017.
 */
public interface ConverterGeneric<Model, Dto> {
    Model convertDtoToModel(Dto dto);
    Dto convertModelToDto(Model model);
}