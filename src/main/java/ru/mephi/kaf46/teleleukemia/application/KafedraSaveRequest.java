package ru.mephi.kaf46.teleleukemia.application;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Value;
import ru.mephi.kaf46.teleleukemia.domain.model.kafedra.Kafedra;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Yury Zorin
 */
@Value
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class KafedraSaveRequest {

    @NotNull(message = "Должно быть задано")
    Integer number;

    @NotBlank(message = "Должно быть задано")
    String zavKaf; //у колонки должно быть zav_kaf

    @NotBlank(message = "Должно быть задано")
    String zamZavkaf;

    @NotNull(message = "Должно быть задано")
    Integer yearOfEstablishment;

    public KafedraSaveRequest(Integer number, String zavKaf, String zamZavkaf, Integer yearOfEstablishment) {
        this.number = number;
        this.zavKaf = zavKaf;
        this.zamZavkaf = zamZavkaf;
        this.yearOfEstablishment = yearOfEstablishment;
    }

    public Kafedra toDomain() {
        return new Kafedra(this.zavKaf, this.zamZavkaf, this.yearOfEstablishment, this.number);
    }
}
