package ru.mephi.kaf46.teleleukemia.domain.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

/**
 * @author Yury Zorin <yuri.zorin@bostongene.com>
 */
//@Entity
//@Table(name = "patient")
@JsonAutoDetect(fieldVisibility = ANY)
public class Patient {
    //your code
}
