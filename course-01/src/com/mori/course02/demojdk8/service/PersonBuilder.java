package com.mori.course02.demojdk8.service;

import com.mori.course02.demojdk8.domain.Person;

@FunctionalInterface
public interface PersonBuilder {
    Person buildPerson(String name);
}
