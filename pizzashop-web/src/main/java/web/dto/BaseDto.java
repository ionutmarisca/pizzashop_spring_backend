package web.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Ionut on 19/6/2017.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BaseDto implements Serializable {
    private Long id;
}